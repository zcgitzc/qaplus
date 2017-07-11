define(function(require, exports, module) {
	var moment = require('moment');
	var numeral = require('numeral');
	var N = [ "一", "二", "三", "四", "五", "六", "七", "八", "九" ,"十"];
	module.exports = {
		_examStatus:function(status){
			if(status=='UN_EXAM'){
				return '<span style="color:red;">未考试</span>';
			}else if(status=='EXAMING'){
				return '<span style="color:green;">考试中</span>';
			}else if(status=='STOPING'){
				return '<span style="color:red;">暂停中</span>';
			}else if(status=='EXAMED'){
				return '<span style="color:blue;">已考完</span>';
			}
			return '';
		},
		_paperDiffStage:function(status){
			if(status=='EASY'){
				return '简单';
			}else if(status=='MIDDLE'){
				return '中等';
			}else if(status=='DIFFICULT'){
				return '困难';
			}
			return '';
		},
		formatStr : function(str, maxLength, suffix) {
			if (str && str.length > maxLength) {
				str = str.substring(0, maxLength) + suffix;
			}
			return str;
		},
		newI18n : function(type, key, defaultVal) {
			return i18n.getResourceValue({
				type : type,
				key : key,
				defaultVal : defaultVal
			});
		},
		/**
		 * @param symbolType
		 * @returns {string} $
		 */
		symbol : function(symbolType) {
			var symbol = "￥";
			if (symbolType && symbols.hasOwnProperty(symbolType.toUpperCase())) {
				symbol = symbols[symbolType]
			}
			return symbol;
		},
		convertToChinese : function(num) {
			if (num != undefined) {
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
		/**
		 * @param string
		 * @param symbolType
		 * @param options
		 * @returns {*|string} $1000
		 */
		/**
		 * 对象动态取值
		 * 
		 * @param {Object}
		 *            obj
		 * @param {String}
		 *            filedName
		 */
		getProperty : function(obj, filedName) {
			return obj ? obj[filedName] : undefined;
		},

		/**
		 * 对象动态取值
		 * 
		 * @param {Object}
		 *            obj
		 * @param {String}
		 *            filedName
		 */
		getPropertyByKey : function(obj, key, propertyName) {
			return obj ? (obj[key] ? obj[key][propertyName] : undefined)
					: undefined;
		},
		money : function(string, symbolType, options) {
			var symbol = "￥";
			if (symbolType && symbols.hasOwnProperty(symbolType)) {
				symbol = symbols[symbolType]
			}
			var prefix = symbol, numeric = (+('' + string).replace(/[-,]/g, ''))
					+ '', parts = numeric.split('.'), isNegative = /^-/
					.test(string);
			if (isNegative) {
				prefix = '-' + prefix;
			}
			var result = [ prefix,
					parts[0].split('').reverse().reduce(function(acc, num, i) {
						return num + (i && !(i % 3) ? ',' : '') + acc;
					}), parts[1] ? ('.' + parts[1]) : '' ].join('');
			return result;
		},
		/**
		 * 
		 * @param string
		 * @returns {*|string} 1000
		 */
		moneyWithoutSymbol : function(string) {
			var prefix = "", numeric = (+('' + string).replace(/[-,]/g, ''))
					+ '', parts = numeric.split('.'), isNegative = /^-/
					.test(string);
			if (isNegative) {
				prefix = '-';
			}
			var result = [ prefix,
					parts[0].split('').reverse().reduce(function(acc, num, i) {
						return num + (i && !(i % 3) ? ',' : '') + acc;
					}), parts[1] ? ('.' + parts[1]) : '' ].join('');
			return result;
		},
		compare : function(lvalue, operator, rvalue, options) {
			var operators, result;
			if (arguments.length < 3) {
				throw new Error(
						"Handlerbars Helper 'compare' needs 2 parameters");
			}
			if (options === undefined) {
				options = rvalue;
				rvalue = operator;
				operator = "===";
			}
			operators = {
				'==' : function(l, r) {
					return l == r;
				},
				'===' : function(l, r) {
					return l === r;
				},
				'!=' : function(l, r) {
					return l != r;
				},
				'!==' : function(l, r) {
					return l !== r;
				},
				'<' : function(l, r) {
					return l < r;
				},
				'>' : function(l, r) {
					return l > r;
				},
				'<=' : function(l, r) {
					return l <= r;
				},
				'>=' : function(l, r) {
					return l >= r;
				},
				'typeof' : function(l, r) {
					return typeof l == r;
				}
			};
			if (!operators[operator]) {
				throw new Error(
						"Handlerbars Helper 'compare' doesn't know the operator "
								+ operator);
			}
			result = operators[operator](lvalue, rvalue);
			if (result) {
				return options.fn(this);
			} else {
				return options.inverse(this);
			}
		},
		dateFormat : function(context) {
			var now = new Date(parseInt(context) * 1000);
			return now.toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
		},
		moment : function(format, timestamp, context) {
			if (arguments.length <= 2) {
				return moment().format(format);
			} else {
				if (!timestamp) {
					return "";
				} else {
					return moment(timestamp).format(format);
				}

			}
		},
		compareNow : function(time, operator, options) {
			if (operator == ">") {
				if (time - new Date().getTime() > 0) {
					return options.fn(this);
				} else {
					return options.inverse(this);
				}
			} else if (operator == "<") {
				if (time - new Date().getTime() < 0) {
					return options.fn(this);
				} else {
					return options.inverse(this);
				}
			}
		},
		numeral : function(number, format, context) {

			if (arguments.length <= 2) {
				return numeral(number).format();
			} else {
				return numeral(number).format(format);
			}
		},
		currencyFormat : function(number, currencyCode, flag, context) {
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
		langReplace : function(msg) {
			var arg = arguments;
			if (msg && arg.length >= 2) {
				return msg
						.replace(
								/\{\{(\d+?)\}\}/g,
								function($0, $1) {
									return typeof arg[arguments[1]] != "undefined" ? arg[arguments[1]]
											: arguments[0];
								});
			}
			return msg
		},
		calculate : function(key, expression, context) {
			return eval(key + expression);
		},
		expr_compare : function(lvalue, operator, rvalue, options) {
			// debugger;
			var operators, result;

			if (arguments.length < 3) {
				throw new Error(
						"Handlerbars Helper 'compare' needs 2 parameters");
			}

			if (typeof options === "undefined") {
				var options = rvalue;
				rvalue = operator;
				operator = "===";
			}

			operators = {
				'==' : function(l, r) {
					return l == r;
				},
				'===' : function(l, r) {
					return l === r;
				},
				'!=' : function(l, r) {
					return l != r;
				},
				'!==' : function(l, r) {
					return l !== r;
				},
				'<' : function(l, r) {
					return l < r;
				},
				'>' : function(l, r) {
					return l > r;
				},
				'<=' : function(l, r) {
					return l <= r;
				},
				'>=' : function(l, r) {
					return l >= r;
				},
				'typeof' : function(l, r) {
					return typeof l == r;
				}
			};

			if (!operators[operator]) {
				throw new Error(
						"Handlerbars Helper 'compare' doesn't know the operator "
								+ operator);
			}

			result = operators[operator](lvalue, rvalue);

			if (result) {
				return options.fn(this);
			} else {
				return options.inverse(this);
			}
		},
		expr_true : function(expression, options) {
			return eval(expression) ? options.fn(this) : options.inverse(this);
		},

		expression : function(expression, options) {
			return eval(expression);
		},
		addOne : function(index) {
			return index + 1;
		},
		isEven : function(index, options) {
			return (index % 2 == 0) ? options.fn(this) : options.inverse(this);
		},
		isOdd : function(index, options) {
			return (index % 2 != 0) ? options.fn(this) : options.inverse(this);
		},
		i18n : function(keyValue, defaultVal) {
			return keyValue || defaultVal;
		},
		debug : function(optionalValue) {
			console.log("Current Context");
			console.log("====================");
			console.log(this);
			if (optionalValue) {
				console.log("Value");
				console.log("====================");
				console.log(optionalValue);
			}
		}

	};
});