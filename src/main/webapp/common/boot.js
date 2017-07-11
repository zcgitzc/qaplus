(function() {
	seajs.config({
		// 设置路径，方便跨目录调用
		 paths : {
			 "static" : "../static"
		 },

		// 设置别名，方便调用
		alias : {
			"jQuery" : "jquery/jquery-seajs.min.js",
			"handlebars" : "handlebars/handlebars.seajs.min.js",
			"numeral" : "numeral/numeral.js",
			"underscore" : "underscore/underscore.js",
			"moment" : "moment/moment.js"
		},
		"charset" : "utf-8",
		"timeout" : 2000,
		"preload" : [ "jQuery" ]
	});
	var dotIndex = window.location.href.lastIndexOf(".");
	
	var path = window.location.href.substring(0, dotIndex);
	if(path.indexOf("/qaplus/user/login/login")<0){
		seajs.use("/qaplus/user/top/top.js", function(top) {
			if (top) {
				top.init();
			}
		});
	}
	seajs.use(path, function(page) {
		if (page) {
			page.init();
		}
	});
	
	
	

}).call(this);

/* 毫无意义模板，只为了spm build验证通过，部署 */
define(function(require, exports, module) {

});