define(function(require, exports, module) {
	// 通过 require 引入依赖
	var $ = require("jQuery");
	var ajax = require("../../common/util/ajax");
	require("../../common/util/ajaxExt");
	var Util = require("../../common/util/util")
	var Handlebars = require("handlebars");
	var helpers = require("../../common/helpers");
	Handlebars.registerHelper(helpers);
	require("./teaAnswerQuestion.css");
	require("../../common/common_require");


	$("#answerBtn").click(function() {
		teacherAnswer.answer(false);
	});

	$("#continueAnswerBtn").click(function() {
		teacherAnswer.answer(true);
	});

	var teacherAnswer = {
		initPage : function() {
			Util.uploadAttach($("#file-3"),$("#attachmentId"),{browseLabel:"上传附件&hellip;"});

			$('#summernote').summernote({
				height : 300,
				minHeight : null,
				placeholder : "老师您辛苦了！！",
				dialogsFade : true,// Add fade effect on dialogs
				dialogsInBody : true,// Dialogs can be placed in body, not in
				disableDragAndDrop : false,// default false You can disable
											// drag
				onImageUpload : function(files) {
					console.log(files);
				},
				maxHeight : null,
				focus : true
			});

			var id = Util.getUrlParam("id", null);
			if (id) {
				$("#questionId").val(id);
				teacherAnswer.queryQuestionContent(id);
			} else {
				teacherAnswer.queryUnSolveQuestionContent();
			}
		},
		queryQuestionContent : function(id) {
			ajax({
				url : "/qaplus/q/query_stu_q.json",
				data : "id=" + id,
				success : function(result) {
					if (result.data[0]) {
						$("#questionContent").html(
								result.data[0].questionContent);
					}
				},
			});
		},
		queryUnSolveQuestionContent : function() {
			ajax({
				url : "/qaplus/q/query_unsolve_q.json",
				success : function(result) {
					$('#summernote').summernote('code','');
					$("#questionContent").html(result.data[0].questionContent);
					$("#questionId").val(result.data[0].id);
				},
			});
		},
		answer : function(isContinue) {
			$("#answerContent").val($('#summernote').summernote('code'));
			ajax({
				url : "/qaplus/q/answer_q.json",
				data : $("#answerForm").serialize(),// 附加参数，json格式
				success : function(result) {
					if (isContinue) {
						teacherAnswer.queryUnSolveQuestionContent();
					} else {
						window.location.href = "/qaplus/teacher/teaQuestionList/teaQuestionList.jsp";
					}
				},
			});
		}
	}

	// 输出接口，让boot.js启动
	module.exports = {
		init : function() {
			teacherAnswer.initPage();
		}
	};
});