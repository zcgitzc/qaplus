define(function(require, exports, module) {
	// 通过 require 引入依赖
	var $ = require("jQuery");
	var helpers = require("../../common/helpers");
	var Handlebars = require("handlebars");
	Handlebars.registerHelper(helpers);
	require("./stuStartExam.css");
	require("../../common/common.css")
	var tpl = require("./stuStartExam.tpl");
	var questionIndex = require("./questionIndex.tpl");
	var Util = require("../../common/util/util");
	var template = Handlebars.compile(tpl);
	var questionIndexTpl = Handlebars.compile(questionIndex);
	var ajax = require("../../common/util/ajax");
	require('../../common/util/ajaxExt');
	require("../../static/countdown/jquery.countdown.css");
	require("../../static/countdown/jquery.countdown.js");
	require("../../common/common_require");

	var questions;
	var current = 0;
	var cond;

	$("#prev").click(function() {
		stuStartExam.prev();
	});
	$("#next").click(function() {
		stuStartExam.next();
	});
	$("#submit").click(function(){
		stuStartExam.submit(false);
	});
	$("#timeToogle").click(function(){
		if($("#countdown").css("display")=="block"){
			$("#countdown").css("display","none");
			$(this).text("显示时间");
		}else if($("#countdown").css("display")=="none"){
			$("#countdown").css("display","block");
			$(this).text("隐藏时间");
		}
	});
	
	var stuStartExam = {
		initPage : function() {
			stuStartExam.getExamQuestion();
		},
		initCountDown : function(time) {
			$('#countdown').countdown(
					{
						timestamp : new Date().getTime() + time,
						callback : function(days, hours, minutes, seconds) {
							if (days == 0 && hours == 0 && minutes == 0 && seconds == 0) {
								return ;
							}
							if (days == 0 && hours == 0 && minutes == 0 && seconds == 1) {
								stuStartExam.submit(true);
							}
							if(days == 0 && hours == 0 && minutes == 15 && seconds == 0){
								alert("还有15min交卷，如有时间剩余，请检查一遍！！！");
							}
							if(days == 0 && hours == 0 && minutes == 3 && seconds == 0){
								alert("还有3min交卷，没做完的话赶快了（时间到了，系统将会强制交卷）！！！");
							}
						}
					});
		},
		fillQuestion : function(question,storeUserChoice) {
			$("#question").html(template(question));
			if(storeUserChoice){
				stuStartExam.storeUserChoice(question);
			}
		},
		initQuestionIndex : function(questions,endExam) {
			$("#questionIndex").html(questionIndexTpl({
				"questions" : questions,
				"endExam":endExam
			}));
		},
		getExamQuestion : function() {
			ajax({
				url : "/qaplus/paper/startExam.json",
				data : "paperId="+Util.getUrlParam("paperId"),
				success : function(result) {
					cond=result;
					questions = result.data[0].questions;
					if(result.data[0].leftTime==0){
						stuStartExam.endExamFillPage(questions,result.data[0].totalScore);
					}else{
						//定时钟
						stuStartExam.initCountDown(result.data[0].leftTime);
						//问题
						stuStartExam.fillQuestion(result.data[0].questions[0],true);
						//问题下标
						stuStartExam.initQuestionIndex(result.data[0].questions,"N");
						
						if (questions.length == 1) {
							stuStartExam.disabledPrev();
							stuStartExam.disabledNext();
						}
						stuStartExam.disabledPrev();
						stuStartExam.initProcess(0, 0, questions.length,
								(0 / questions.length) * 100 + "%");
						stuStartExam.choiceQuestion(true);
					}
				}
			});
		},
		choiceQuestion:function(storeUserChoice){
			$(".choiceQuestion").click(function(){
				var index=$(this).data("id");
				if(index!=1){
					stuStartExam.enablePrev();
				}else{
					stuStartExam.disabledPrev();
				}
				if(index==questions.length){
					stuStartExam.disabledNext();
				}else{
					stuStartExam.enableNext();
				}
				current=index-1;
				stuStartExam.fillQuestion(questions[current],storeUserChoice);
			});
		},
		disabledPrev : function() {
			$("#prev").addClass("disabled");
		},
		disabledNext : function() {
			$("#next").addClass("disabled");
		},
		enablePrev:function(){
			$("#prev").removeClass("disabled");
		},
		enableNext:function(){
			$("#next").removeClass("disabled");
		},
		prev : function() {
			//处理翻页
			if(current==1){
				stuStartExam.disabledPrev();
			}
			if(current<1){
				return ;
			}
			current--;
			stuStartExam.fillQuestion(questions[current],true);
			stuStartExam.enableNext();
		},
		next : function() {
			//处理翻页
			if (questions.length == current+1) {
				return;
			}
			if (questions.length-1 == current+1) {
				stuStartExam.disabledNext();
			}
			current++;
			stuStartExam.fillQuestion(questions[current],true);
			stuStartExam.enablePrev();
		},
		initProcess : function(valuenow, valuemin, valuemax, width) {
			// 初始化进度条
			$(".progress .progress-bar").attr("aria-valuenow", valuenow);
			$(".progress .progress-bar").attr("aria-valuemin", valuemin);
			$(".progress .progress-bar").attr("aria-valuemax", valuemax);
			$(".progress .progress-bar").css("width", width);
			$(".progress .progress-bar span").html("已回答:"+valuenow+"/" + valuemax + "题");
		},
		storeUserChoice:function(question){
			$(".items input").click(function(){
				//保存用户选择的数据
				$(".items input").each(function(){
					var itemId=$(this).data("id");
					if($(this).is(':checked')){
						for (var i = 0; i < question.items.length; i++) {
							if(question.items[i].id==itemId){
								question.items[i].isUserChoice="Y";
							}
						}
					}else{
						for (var i = 0; i < question.items.length; i++) {
							if(question.items[i].id==itemId){
								question.items[i].isUserChoice="N";
							}
						}
					};
				});
				
				var handleQuestion=stuStartExam.getHandleQuestionCount();
				stuStartExam.initProcess(handleQuestion, 0, questions.length, (handleQuestion / questions.length) * 100 + "%");
			});
		},
		getHandleQuestionCount:function(){
			var handleQuestion=0;
			for (var i = 0; i < questions.length; i++) {
				var count=0;
				for (var j = 0; j < questions[i].items.length; j++) {
					if(questions[i].items[j].isUserChoice=="Y"){
						count++;
					}
				}
				if(count>0){
					$("#questionIndexWrap div").each(function(index,item){
						if(index==i){
							$(this).css("borderColor","green");
						}
					}); 
					handleQuestion++;
				}
			}
			return handleQuestion;
		},
		submit:function(isForce){
			//非强制交卷，友情提醒（如果有题目没有做完）
			if(!isForce){
				var handleQuestion=stuStartExam.getHandleQuestionCount();
				if(handleQuestion!=questions.length){
					var index = layer.confirm('还有题目没有做完，确认提交？', {
						btn : [ '确认', '取消' ]
					// 按钮
					}, function() {
						stuStartExam.endExam();
					}, function() {
						layer.close(index);
					});
				}else{
					stuStartExam.endExam();
				}
			}else{
				alert("强制提交试卷");
				stuStartExam.endExam();
			}
		},
		endExam:function(){
			cond.questions=questions;
			ajax({
				url:"/qaplus/paper/endExam.json",
				contentType:"application/json",
				data:JSON.stringify(cond.data[0]),
				success:function(result){
					questions=result.data[0].questions;
					stuStartExam.endExamFillPage(questions,result.data[0].totalScore);
					//弹框显示分数
					//第三方扩展皮肤
					layer.alert('考试分数：'+result.data[0].totalScore, {
					  icon: 1,
					  skin: 'layer-ext-moon'
					})
				}
			});
		},
		endExamFillPage:function(questions,totalScore){
			//时间隐藏
			$("#showExamTime").remove();
			//定时钟
			stuStartExam.initCountDown(0);
			//
			$("#pagination").remove();
			$(".progress").remove();
			
			$("#scoreShow").show().html(totalScore+"分");
			//处理下面的questionIndex选错的题目
			stuStartExam.fillQuestion(questions[0],false);
			stuStartExam.choiceQuestion(false);
			//问题下标
			stuStartExam.initQuestionIndex(questions,"Y");
			stuStartExam.choiceQuestion(false);
			//修改问题下标的颜色
			stuStartExam.judgeQuestionRight(questions);
		},
		judgeQuestionRight:function(questions){
			$("#questionIndexWrap div").each(function(index,item){
				var questionIndex=$(this).data("id");
				var rightItem="";
				var userChoiceItem="";
				for (var i = 0; i < questions[questionIndex-1].items.length; i++) {
					if(questions[questionIndex-1].items[i].isRightItem=="Y"){
						rightItem+=questions[questionIndex-1].items[i].id;
					}
					if(questions[questionIndex-1].items[i].isUserChoice=="Y"){
						userChoiceItem+=questions[questionIndex-1].items[i].id;
					}
				}
				if(rightItem!=userChoiceItem){
					$(this).css("border","2px solid red");
				}
			});
		},
	};
	// 输出接口，让boot.js启动
	module.exports = {
		init : function() {
			stuStartExam.initPage();
		}
	};
});
