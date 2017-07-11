define(function(require, exports, module) {
	// 通过 require 引入依赖
	var $ = require("jQuery");
	var Handlebars = require("handlebars");
	var ajax = require("../../common/util/ajax");
	require('../../common/util/ajaxExt');
	var helpers = require("../../common/helpers");
	var Util=require("../../common/util/util")
	Handlebars.registerHelper(helpers);
	require("./stuAnswerHomework.css");
	var tpl = require("./stuAnswerHomework.tpl");
	var template = Handlebars.compile(tpl);
	require("../../common/common_require");
	
	var questionIds = [];
	var attachIds=[];
	var current = 1;
	var homeworkId = Util.getUrlParam("id", null);

	$("#prev").click(function(){
		answerHomework.prev();
	});
	$("#next").click(function(){
		answerHomework.next();
	});
	$("#submitHomework").click(function(){
		answerHomework.commitCurrentQuestion();
	});
	$(".attach").click(function(){
		var id = attachIds[current - 1];
		Util.downloadAttach(id);
	});
	
	var answerHomework = {
		initProcess : function(valuenow, valuemin, valuemax, width) {
			// 初始化进度条
			$("#questionCountProcess .progress .progress-bar").attr("aria-valuenow", valuenow);
			$("#questionCountProcess .progress .progress-bar").attr("aria-valuemin", valuemin);
			$("#questionCountProcess .progress .progress-bar").attr("aria-valuemax", valuemax);
			$("#questionCountProcess .progress .progress-bar").css("width", width);
			$("#questionCountProcess .progress .progress-bar span").html("第" + valuenow + "题，共：" + valuemax + "题");
		},
		initPage : function() {
			ajax({
				url : "/qaplus/q/query_my_homework_q.json",
				data : "id=" + homeworkId,
				success : function(result) {
					if(!result.data[0]){
						layer.msg("查找不到问题信息", {
							icon : 5,
							time : 3000
						},function(){
							window.location.href="/qaplus/user/home/home.jsp";
						});
					}
					$("#questionContent").text(result.data[0].content);
					for (var i = 0; i < result.data.length; i++) {
						questionIds[i] = result.data[i].id;
						attachIds[i]=result.data[i].questionAttachmentId;
					}
					$(".previous").addClass("disabled");
					if (result.data.length == 1) {
						$("#submitHomework").css("display", "");
						$(".next").addClass("disabled");
					}
					answerHomework.initProcess(1, 1, questionIds.length,
							(1 / questionIds.length) * 100 + "%");
					
					//TODO 要把用户的家庭作业的答案也查出来，如果用户曾经提交过，要有回显的功能
				}
			});
			
			//TODO 点击下一页的时候要把文件清除
			Util.uploadAttach($("#file-3"),$("#attachmentId"),{browseLabel:"上传附件&hellip;"});
		},
		prev : function() {
			if (current + 1 != questionIds.length) {
				$("#submitHomework").css("display", "none");
			}
			if (current == 1) {
				return;
			}
			answerHomework.updateHomeworkAnswer(false);
			current--;
			var id = questionIds[current - 1];
			answerHomework.getHomeworkQuestion(id);
			// 要将上一题或者下一题的附件id删除掉
			$("#attachmentId").val("");
			$("#commitContent").text("");
			answerHomework.initProcess(current, 1, questionIds.length,
					(current / questionIds.length) * 100 + "%");
		},
		next : function() {
			// 要将上一题或者下一题的附件id删除掉
			if (current + 1 == questionIds.length) {
				$("#submitHomework").css("display", "");
			}
			if (current == questionIds.length) {
				return;
			}
			answerHomework.updateHomeworkAnswer(false);
			current++;
			var id = questionIds[current - 1];
			answerHomework.getHomeworkQuestion(id);
			// 要将上一题或者下一题的附件id删除掉
			$("#attachmentId").val("");
			$("#commitContent").text("");
			answerHomework.initProcess(current, 1, questionIds.length,
					(current / questionIds.length) * 100 + "%");
		},
		determinNextPrev : function() {
			if (current == 1) {
				$(".previous").addClass("disabled");
			} else {
				$(".previous").removeClass("disabled");
			}
			if (current == questionIds.length) {
				$(".next").addClass("disabled");
			} else {
				$(".next").removeClass("disabled");

			}
		},
		getHomeworkQuestion : function(id) {
			ajax({
				url : "/qaplus/q/query_tea_q.json",
				data : "id=" + id,
				success : function(result) {
					answerHomework.determinNextPrev();
					$("#questionContent").text(result.data[0].content);
				}
			});
		},
		updateHomeworkAnswer : function(isFinsih) {
			var otherParam = "";
			if (isFinsih) {
				otherParam = "&finishHomework=Y";
			}
			$("#homeworkId").val(homeworkId);
			$("#questionId").val(questionIds[current - 1]);
			ajax({
				url : "/qaplus/homework/homework_answer.json",
				dataType : "json",
				type : "post",
				data : $("#answerForm").serialize() + otherParam,
				success : function(result) {
					if (isFinsih) {
						window.location.href = "/qaplus/student/stuHomeworkList/stuHomeworkList.jsp";
					}
				}
			});
		},
		commitCurrentQuestion : function() {
			answerHomework.updateHomeworkAnswer(true);
		}
	};

	// 输出接口，让boot.js启动
	module.exports = {
		init : function() {
			answerHomework.initPage();
		}
	};
});