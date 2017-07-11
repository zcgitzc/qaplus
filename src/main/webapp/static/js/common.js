$(function() {
	common.hoverShowTopNav();

	$.fn.selectRange = function(start, end) {
		return this.each(function() {
			if (this.setSelectionRange) {
				this.focus();
				this.setSelectionRange(start, end);
			} else if (this.createTextRange) {
				var range = this.createTextRange();
				range.collapse(true);
				range.moveEnd('character', end);
				range.moveStart('character', start);
				range.select();
			}
		});
	};
	String.prototype.NoSpace = function() {
		return this.replace(/\s+/g, "");
	}
	String.prototype.replaceAll = function(s1, s2) {
		return this.replace(new RegExp(s1, "gm"), s2);
	}
});

var common = {
	// Unicode 转 ASCII
	unescape : function(str) {
		return str.replace(/&#(x)?([^&]{1,5});?/g, function(a, b, c) {
			return String.fromCharCode(parseInt(c, b ? 16 : 10))
		});
	},
	addDays : function(dateTemp, days) {
		var dateTemp = dateTemp.split("-");
		var nDate = new Date(dateTemp[1] + '-' + dateTemp[2] + '-'
				+ dateTemp[0]); // 转换为MM-DD-YYYY格式
		var millSeconds = Math.abs(nDate) + (days * 24 * 60 * 60 * 1000);
		var rDate = new Date(millSeconds);
		var year = rDate.getFullYear();
		var month = rDate.getMonth() + 1;
		if (month < 10)
			month = "0" + month;
		var date = rDate.getDate();
		if (date < 10)
			date = "0" + date;
		return (year + "-" + month + "-" + date);
	},
	// d-默认值
	getQueryString : function(name, d) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return d;
	},
	getDevice : function() {
		debugger;
		var sUserAgent = navigator.userAgent.toLowerCase();
		var bIsIpad = sUserAgent.match(/ipad/i) == "ipad";
		var bIsIphoneOs = sUserAgent.match(/iphone/i) == "iphone";
		var bIsMidp = sUserAgent.match(/midp/i) == "midp";
		var bIsUc7 = sUserAgent.match(/rv:1.2.3.4/i) == "rv:1.2.3.4";
		var bIsUc = sUserAgent.match(/ucweb/i) == "ucweb";
		var bIsAndroid = sUserAgent.match(/android/i) == "android";
		var bIsCE = sUserAgent.match(/windows ce/i) == "windows ce";
		var bIsWM = sUserAgent.match(/windows mobile/i) == "windows mobile";
		if (bIsAndroid) {
			return "android";
		} else if (bIsIpad || bIsIphoneOs) {
			return "ios";
		} else
			return "pc"
	},
	
	hoverShowTopNav : function() {
		// 关闭click.bs.dropdown.data-api事件，使顶级菜单可点击
		$(document).off('click.bs.dropdown.data-api');
		// 自动展开
		$('.nav .dropdown').mouseenter(function() {
			$(this).addClass('open');
		});
		// 自动关闭
		$('.nav .dropdown').mouseleave(function() {
			$(this).removeClass('open');
		});
	},
	serializeFormToObj : function() {
		// 序列化表单窗体为对象
		var o = {};
		var a = $(form).serializeArray();
		$.each(a, function() {
			if (o[this.name]) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	},
	formateMoney : function(num, digit) {
		var n = digit; // 小数位数
		n = n >= 0 && n <= 20 ? n : 2;
		f = num < 0 ? "-" : ""; // 判断是否为负数
		num = parseFloat((Math.abs(num) + "").replace(/[^\d\.-]/g, ""))
				.toFixed(n)
				+ "";
		var l = num.split(".")[0].split("").reverse(), r = num.split(".")[1];
		t = "";
		for (i = 0; i < l.length; i++) {
			t += l[i] + ((i + 1) % 3 === 0 && (i + 1) != l.length ? "," : "");
		}
		if (n === 0) {
			return f + t.split("").reverse().join("");
		}
		return f + t.split("").reverse().join("") + "." + r.substring(0, n);
	},
	
};