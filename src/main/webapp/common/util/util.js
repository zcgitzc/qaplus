define(function(require, exports, module) {
    var $ = require("jQuery");
    var numeral = require('numeral');
    require("../../static/fileinput/fileinput.js");
    require("../../static/fileinput/fileinput.css");
    var N = ["零", "一", "二", "三", "四", "五", "六", "七", "八", "九"];
    // 限制文本框只能输入正数，负数，小数
    // onkeyup="value=value.replace(/[^\-?\d.]/g,'')"
    //   
    // 限制文本框只能输入正数，小数
    // onkeyup="value=value.replace(/[^\d.]/g,'')"
    // onkeyup="this.value=this.value.replace(/\D/g,'')"
    // onafterpaste="this.value=this.value.replace(/\D/g,'')"
    // 
    // //summernote图片上传   http://www.zhimengzhe.com/Javascriptjiaocheng/49666.html （插入图片的方法）
/*  callbacks:{
        onImageUpload: function(files, editor, $editable) {
            sendFile(files,editor,$editable);
        }
    },*/
    var util = {
        getUrlParam: function(name) {
            // 获取URL参数
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) {
                return decodeURIComponent(r[2]);
            }
            return null;
        },
        parseNull: function(str) {
            if (!str) {
                return "";
            }
            return str;
        },
        getFormatCnNum(num) {
        var result = "";
        if (isNaN(num) || num > Math.pow(10, 12)) return "";
        var cn = "零壹贰叁肆伍陆柒捌玖";
        var unit = new Array("拾百千", "分角");
        var unit1 = new Array("万亿", "");
        var numArray = num.toString().split(".");
        var start = new Array(numArray[0].length - 1, 2);

        function toChinese(num, index) {
            var num = num.replace(/\d/g, function($1) {
                return cn.charAt($1) + unit[index].charAt(start-- % 4 ? start % 4 : -1)
            })
            return num;
        }
        for (var i = 0; i < numArray.length; i++) {
            var tmp = "";
            for (var j = 0; j * 4 < numArray[i].length; j++) {
                var strIndex = numArray[i].length - (j + 1) * 4;
                var str = numArray[i].substring(strIndex, strIndex + 4);
                var start = i ? 2 : str.length - 1;
                var tmp1 = toChinese(str, i);
                tmp1 = tmp1.replace(/(零.)+/g, "零").replace(/零+$/, "");
                tmp1 = tmp1.replace(/^壹拾/, "拾");
                tmp = (tmp1 + unit1[i].charAt(j - 1)) + tmp;
            }
            numArray[i] = tmp;
        }
        numArray[1] = numArray[1] ? numArray[1] : ""
        numArray[0] = numArray[0] ? numArray[0] + "元" : numArray[0], numArray[1] = numArray[1].replace(/^零+/, "");
        numArray[1] = numArray[1].match(/分/) ? numArray[1] : numArray[1] + "整";
        result = numArray[0] + numArray[1];
        return result;
    },
        utf16to8: function(str) {
            var out, i, len, c;
            out = "";
            len = str.length;
            for (i = 0; i < len; i++) {
                c = str.charCodeAt(i);
                if ((c >= 0x0001) && (c <= 0x007F)) {
                    out += str.charAt(i);
                } else if (c > 0x07FF) {
                    out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));
                    out += String.fromCharCode(0x80 | ((c >> 6) & 0x3F));
                    out += String.fromCharCode(0x80 | ((c >> 0) & 0x3F));
                } else {
                    out += String.fromCharCode(0xC0 | ((c >> 6) & 0x1F));
                    out += String.fromCharCode(0x80 | ((c >> 0) & 0x3F));
                }
            }
            return out;
        },
        convertToChinese: function(num) {
            if (num) {
                var str = num.toString();
                var len = num.toString().length;
                var C_Num = [];
                for (var i = 0; i < len; i++) {
                    C_Num.push(N[str.charAt(i)]);
                }
                return C_Num.join('');
            } else {
                return "";
            }
        },
        serializeFormToObj: function(form) {
            // 序列化表单窗体为对象
            var o = {};
            var a = $(form).serializeArray();
            $.each(a, function() {
                if (o[this.name]) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        },
        getCookie: function(name) {
            var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
            if (arr = document.cookie.match(reg)) return unescape(arr[2]);
            else return null;
        },
        delCookie: function() {
            var exp = new Date();
            exp.setTime(exp.getTime() - 1);
            var cval = getCookie(name);
            if (cval != null) document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
        },
        // s20是代表20秒
        // h是指小时，如12小时则是：h12
        // d是天数，30天则：d30
        getSec: function(str) {
            var str1 = str.substring(1, str.length) * 1;
            var str2 = str.substring(0, 1);
            if (str2 == "s") {
                return str1 * 1000;
            } else if (str2 == "h") {
                return str1 * 60 * 60 * 1000;
            } else if (str2 == "d") {
                return str1 * 24 * 60 * 60 * 1000;
            }
        },
        // setCookie("name", "hayden", "s20");
        setCookie: function(name, value, time) {
            var strsec = getSec(time);
            var exp = new Date();
            exp.setTime(exp.getTime() + strsec * 1);
            document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString() + ";path=/";
        },
        subList: function(num, list) {
            var a = list;
            var b = [];
            var result = [];
            var k = 0;
            for (var m = 0; m < a.length; ++m) {
                if (m % num == 0) {
                    b = [];
                    for (var j = 0; j < num; ++j) {
                        if (a[m + j] == undefined) {
                            continue;
                        } else {
                            b[j] = a[m + j];
                        }
                    }
                    result[k] = b;
                    k++;
                }
            }
            return result;
        },
        praseMoney: function(num) {
            if ((num + "").trim() == "") {
                return "";
            }
            num = num.replace(/,/gi, '');
            return num;
        },
        /**
         * 数字格式转换成千分位
         *
         * @paramObjectnum
         */
        commafy: function(num) {
            // 1.先去除空格,判断是否空值和非数
            num = num + "";
            num = num.replace(/[ ]/g, ""); // 去除空格
            if (num == "") {
                return;
            }
            if (isNaN(num)) {
                return;
            }
            // 2.针对是否有小数点，分情况处理
            var index = num.indexOf(".");
            if (index == -1) { // 无小数点
                var reg = /(-?\d+)(\d{3})/;
                while (reg.test(num)) {
                    num = num.replace(reg, "$1,$2");
                }
            } else {
                var intPart = num.substring(0, index);
                var pointPart = num.substring(index + 1, num.length);
                var reg = /(-?\d+)(\d{3})/;
                while (reg.test(intPart)) {
                    intPart = intPart.replace(reg, "$1,$2");
                }
                num = intPart + "." + pointPart;
            }
            return num;
        },
        funFilter: function(data, query) {
            query = query || "";
            var result = [],
                l = query.length;
            if (!l) return data;
            $.each(data, function(index, item) {
                var a, matchKeys = [item.value].concat(item.alias);
                // 匹配 value 和 alias 中的
                while (a = matchKeys.shift()) {
                    if (a.indexOf(query) > -1) {
                        // 匹配和显示相同才有必要高亮
                        if (item.label === a) {
                            item.highlightIndex = stringMatch(a, query);
                        }
                        result.push(item);
                        break;
                    }
                }
            });
            return result;
        },
        cusFilter: function(data, query) {
            function escapeKeyword(str) {
                var keyword = /(\[|\[|\]|\^|\$|\||\(|\)|\{|\}|\+|\*|\?|\\)/g;
                return (str || "").replace(keyword, "\\$1");
            }
            query = query || "";
            var result = [],
                l = query.length,
                reg = new RegExp("^.*" + escapeKeyword(query), "i");
            if (!l) return [];
            $.each(data, function(index, item) {
                var a, matchKeys = [item.value].concat(item.alias);
                // 匹配 value 和 alias 中的
                while (a = matchKeys.shift()) {
                    if (reg.test(a)) {
                        // 匹配和显示相同才有必要高亮
                        if (item.label === a) {
                            item.highlightIndex = [
                                [0, l]
                            ];
                        }
                        result.push(item);
                        break;
                    }
                }
            });
            return result;
        },
        downloadAttach: function(attachmentId) {
            var form = $("<form>"); // 定义一个form表单
            form.attr("style", "display:none");
            form.attr("target", "");
            form.attr("method", "post");
            form.attr("action", "/qaplus/common/download_a.json"); // 请求url
            var input1 = $("<input>");
            input1.attr("type", "hidden");
            input1.attr("name", "id"); // 设置属性的名字
            input1.attr("value", attachmentId); // 设置属性的值
            $("body").append(form); // 将表单放置在web中
            form.append(input1);
            form.submit(); // 表单提交
        },
        downloadExcel: function(url, $sourceForm) {
            var form = $("<form>"); // 定义一个form表单
            form.attr("style", "display:none");
            form.attr("method", "post");
            form.attr("action", url); // 请求url
            var a = $($sourceForm).serializeArray();
            $.each(a, function() {
                var input1 = $("<input>");
                input1.attr("type", "hidden");
                input1.attr("name", this.name); // 设置属性的名字
                input1.attr("value", this.value); // 设置属性的值
                form.append(input1);
            });
            $("body").append(form); // 将表单放置在web中
            form.submit(); // 表单提交
        },
        uploadAttach: function($target, $hiddenInputAttachId, option) {
            var defaultOption = {
                showPreview: false,
                browseClass: "btn btn-primary",
                fileType: "any",
                textEncoding: "gbk", // 解决乱码
                previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
                uploadUrl: "/qaplus/common/upload_a.json", // server upload action
                uploadAsync: true,
                minFileCount: 1,
                maxFileCount: 5,
                ajaxSettings: {
                    success: function(result) {
                        $hiddenInputAttachId.val(result.data[0].id);
                    }
                }
            };
            $target.fileinput($.extend(true, defaultOption, option))
        },
        currencyFormat: function(number, currencyCode, flag) {
            if (flag == true) {
                if (typeof number == "undefined" || String(number) == "") {
                    return "";
                } else {
                    if (currencyCode == "JPY" || currencyCode == "TWD") {
                        return numeral(number).format();
                    } else {
                        return numeral(number).format("0,0.00");
                    }
                }
            } else {
                if (currencyCode == "JPY" || currencyCode == "TWD") {
                    return numeral(number).format();
                } else {
                    return numeral(number).format("0,0.00");
                }
            }
        },
        noSpace: function(str) {
            return str.replace(/\s+/g, "");
        },
        // var a="1231"; a.replaceAll()
        replaceAll: function(str, s1, s2) {
            return str.replace(new RegExp(s1, "gm"), s2);
        },
        i18n: function(keyValue, defaultVal) {
            return keyValue || defaultVal;
        }
    }

    function stringMatch(matchKey, query) {
        var r = [],
            a = matchKey.split("");
        var queryIndex = 0,
            q = query.split("");
        for (var i = 0, l = a.length; i < l; i++) {
            var v = a[i];
            if (v === q[queryIndex]) {
                if (queryIndex === q.length - 1) {
                    r.push([i - q.length + 1, i + 1]);
                    queryIndex = 0;
                    continue;
                }
                queryIndex++;
            } else {
                queryIndex = 0;
            }
        }
        return r;
    }
    module.exports = util;
});