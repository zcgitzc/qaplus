define(function(require, exports, module) {
	var $ = require("jquery");
	var CommonResource = require('../../i18n/{locale}.js');
	var i18n = {
		resource: {
			'CommonResource': CommonResource
		},
		getLocale: function(){
			return seajs.data.vars.locale;
		},
		loadResource: function(itsResource) {
			this.resource = $.extend(true, this.resource, itsResource);
		},
		getResourceValue: function(param){
			var resource = this.resource[param.type];
			var defaultVal = param.defaultVal || param.key;
			if(typeof resource === "undefined"){
				return defaultVal;
			}
			var value = resource[param.key];
			return value || defaultVal;
		}
	}
	module.exports = i18n;
});