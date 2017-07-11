/**
 * 支持情况：
 * zepto:JSON,TEXT,SCRIPT 支持
 * jQuery:JSON,TEXT,SCRIPT,JSONP 支持
 * zepto:JSONP 可以使用，但是由于在xhr中拿不到状态，因此永远不会使用localstorage保存,无法起到缓存效果
 * zepto:XML, JQuery:XML 不支持，因为JSON.stringify无法序列化DOCUMENT对象
 */
define(function(require, exports, module) {
    var $ = require("jQuery");
    //为了适配jQuery的ajax(url, options)函数，此处也如此申明
    var ajax = function(url, options) {
        //如果第一参数是object, 则认为是以$.ajax(options)调用
        if (typeof url === "object") {
            options = url;
            url = undefined;
        }
        options = options || {};
        //增加时间戳
        if (options.data) {
            options.data["_t"] = $.now();
        } else {
            options.data = {
                "_t": $.now()
            };
        }

        //克隆options
        var settings = $.extend({}, options);
        for (key in ajax.ajaxSettings) {
            if (settings[key] === undefined) {
                settings[key] = ajax.ajaxSettings[key];
            }
        }
        //如果用户传了url，则将url覆盖到settings
        if (url) {
            settings.url = url;
        }
        /**
         * zepto和jQuery对context的默认定义不一样
         * zepto:不定义时默认为window;
         * jQuery:不定义时默认为传入的options
         *
         * 此处和jQuery保持一致。
         * 注：如果ajax.ajaxSettings定义了默认context，则不定义时为该默认context;
         */
        settings.context = settings.context || options;
        var getStorageKey = function() {
            return settings.url || "@@" || JSON.stringify(settings.data);
        };
        //屏蔽到$.ajax中的ifModified
        var ifModified = false;
        if (settings.ifModified) {
            ifModified = true;
            delete settings.ifModified;
        }
        //覆盖beoreSend
        settings.beforeSend = function(xhr) {
            if (ifModified && localStorage) {
                var storageObj = JSON.parse(localStorage.getItem(getStorageKey()));
                if (storageObj && storageObj.lastModified) {
                    xhr.setRequestHeader("If-Modified-Since", storageObj.lastModified);
                }
                if (storageObj && storageObj.etag) {
                    xhr.setRequestHeader("If-None-Match", storageObj.etag);
                }
            }
            //此处的this是context对象
            ajax.commonBeforeSend.call(options, this, xhr);
        };
        //覆盖success函数
        settings.success = function(data, textStatus, xhr) {
            if (ifModified && localStorage) {
                var key = getStorageKey();
                var lastModified = xhr.getResponseHeader("Last-Modified");
                var etag = xhr.getResponseHeader("etag");
                if (xhr.status == 200 && (lastModified || etag) && !(data == null || data == "")) {
                    var storageObj = {
                        storageData: data
                    };
                    if (lastModified) {
                        storageObj.lastModified = lastModified;
                    }
                    if (etag) {
                        storageObj.etag = etag;
                    }
                    localStorage.setItem(key, JSON.stringify(storageObj));
                } else if (xhr.status == 304 && (data == null || data == "")) {
                    var storageObj = JSON.parse(localStorage.getItem(key));
                    if (storageObj) {
                        data = storageObj.storageData;
                    }
                    try {
                        if (settings.dataType === 'script') {
                            (1, eval)(data);
                        }
                    } catch (e) {
                        ajax.commonError.call(options, this, xhr, "parsererror", e);
                        return;
                    }
                }
            }
            ajax.commonSuccess.call(options, this, data, textStatus, xhr);
        };
        //覆盖error函数
        settings.error = function(xhr, textStatus, err) {
            ajax.commonError.call(options, this, xhr, textStatus, err);
        };
        $.ajax(settings);
    };
    //默认设置，可覆盖
    ajax.ajaxSettings = {
        ifModified: false
    };
    /**
     * 通用BeforeSend函数，可覆盖。
     * 在方法内部，this指向调用ajax时传入的options
     */
    ajax.commonBeforeSend = function(context, xhr) {
        if (typeof this.beforeSend === "function") {
            this.beforeSend.call(context, xhr);
        }
    };
    ajax.commonSuccess = function(context, data, textStatus, xhr) {
        if (typeof this.success === "function") {
            this.success.call(context, data, textStatus, xhr);
        }
    };
    ajax.commonError = function(context, xhr, textStatus, err) {
        if (typeof this.error === "function") {
            this.error.call(context, xhr, textStatus, err);
        }
    };

    module.exports = ajax;
});