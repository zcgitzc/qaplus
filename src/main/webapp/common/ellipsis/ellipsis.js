define(function(require, exports, module) {
    //改造扩展
    var jQuery = require("jQuery");

    //参考 https://github.com/thinhunan/jquery.ellipsis.js

    (function($) {
        function ellipsis($elem, options) {
            var max = options.maxWidth,
                ellipsis_char = options.ellipsisChar;
            if (!max) {
                max = $elem.width();
            }
            max = max * options.maxLine;

            //缩小计算偏差
            if (max>10){
                max -=10;
            }

            var text = $.trim($elem.text()).replace(' ', '　'); //for fix white-space bug　

            $elem.attr("title") || $elem.attr("title", text);
            var $temp_elem = $elem.clone(false)
                .css({
                    "visibility": "hidden",
                    "whiteSpace": "nowrap",
                    "display":"inline",
                    "width": "auto"
                })
                .appendTo(document.body);
            var width = $temp_elem.width();
            if (width > max) {
                var stop = Math.floor(text.length * max / width); // for performance while content exceeding the limit substantially
                var temp_str = text.substring(0, stop) + ellipsis_char;
                width = $temp_elem.text(temp_str).width();
                if (width > max) {
                    while (width > max && stop > 1) {
                        stop--;
                        temp_str = text.substring(0, stop) + ellipsis_char;
                        width = $temp_elem.text(temp_str).width();
                    }
                } else if (width < max) {
                    while (width < max && stop < text.length) {
                        stop++;
                        temp_str = text.substring(0, stop) + ellipsis_char;
                        width = $temp_elem.text(temp_str).width();
                    }
                    if (width > max) {
                        temp_str = text.substring(0, stop - 1) + ellipsis_char;
                    }
                }
                $elem.text(temp_str.replace('　', ' '));
            }
            $temp_elem.remove();
        }


        var defaults = {
            maxWidth: 0,
            maxLine: 1,
            ellipsisChar: '...'
        };

        $.fn.ellipsis = function(options) {
            return this.each(function() {
                var $elem = $(this);
                var opts = $.extend({}, defaults, options);
                ellipsis($elem, opts);
            });
        };

        $.fn.ellipsis.options = defaults;
    })(jQuery);



    //end
});