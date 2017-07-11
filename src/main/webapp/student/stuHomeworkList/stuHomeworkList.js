define(function(require,exports,module){
	// 通过 require 引入依赖
	var $ = require("jQuery");
	var ajax = require("../../common/util/ajax");
	require('../../common/util/ajaxExt');
	var Handlebars = require("handlebars");
	var helpers = require("../../common/helpers");
	require("../../common/common.css");
	Handlebars.registerHelper(helpers);
	require("./stuHomeworkList.css");
	var tpl = require("./stuHomeworkList.tpl");
	var template = Handlebars.compile(tpl);

	require("../../common/common_require");

	var stuHomework = {
		initPage : function() {
			ajax({
				url : "/qaplus/homework/select_my_homework.json",
				success : function(result) {
					$("#stuHomework").html(template(result));
					$(".confirmDoHomework").click(function(){
						stuHomework.confirmDoHomework($(this).data("id"),$(this).data("isCommit"));
					});
					$(".lookHomeworkAnswer").click(function(){
						window.open("/qaplus/teacher/teaRemarkHomework/teaRemarkHomework.jsp?stuId="+$("#stuHomework").data("curr-user")+"&homeworkId="+$(this).data("id")+"&isStudent=Y", "家庭作业答案", null, null)
					});
				}
			});
		},
		confirmDoHomework : function(id,isCommit) {
			// 询问框
			var index = layer.confirm('确认开始做家庭作业？', {
				btn : [ '确认', '取消' ]
			// 按钮
			}, function() {
				window.location.reload(true);
				window.open("/qaplus/student/stuAnswerHomework/stuAnswerHomework.jsp?id=" + id, "回答家庭作业", null,null);
//				if(isCommit=='Y'){
//					//询问框
//					var i=layer.confirm('这个家庭作业你已经处理过了，确认要修改？', {
//					  btn: [ '确认', '取消' ] //按钮
//					}, function(){
//						window.location.href = "/qaplus/answerHomework/answerHomework.jsp?id="+ id;
//					}, function(){
//					   layer.close(i);
//					});
//				}else{
//					window.location.href = "/qaplus/answerHomework/answerHomework.jsp?id=" + id;
//				}
				
			}, function() {
				layer.close(index);
			});

		}

	};

	// 输出接口，让boot.js启动
	module.exports = {
		init : function() {
			stuHomework.initPage();
		}
	};
});