define(function(require, exports, module) {
	// 通过 require 引入依赖
	var $ = require("jQuery");
	var helpers = require("../../common/helpers");
	var Handlebars = require("handlebars");
	Handlebars.registerHelper(helpers);	
	require("./board.css");	
	require("../../common/common.css");
	var tpl = require("./board.tpl");
	var template = Handlebars.compile(tpl);
	var ajax = require("../../common/util/ajax");
	require('../../common/util/ajaxExt');
	require("../../common/common_require");
	
	
	var board = {
		initPage : function() {
			ajax({
				url : "/qaplus/board/select_all_my_board.json",
				success : function(result) {
					$(".demo1").html(template(result));
					$(".demo1").bootstrapNews({
			            newsPerPage: 5,
			            autoplay: true,
						pauseOnHover:true,
			            direction: 'down',
			            newsTickerInterval: 1000,
			        });
				}
			});
		}
	};
	// 输出接口，让boot.js启动
	module.exports = {
		init : function() {
			board.initPage();
		}
	};
});
