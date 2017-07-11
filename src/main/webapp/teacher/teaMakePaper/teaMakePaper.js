define(function(require, exports, module) {
	// 通过 require 引入依赖
	var $ = require("jQuery");
	var helpers = require("../../common/helpers");
	var Handlebars = require("handlebars");
	Handlebars.registerHelper(helpers);	
	require("./teaMakePaper.css");
	var tpl = require("./teaMakePaper.tpl");
	var template = Handlebars.compile(tpl);
	var ajax = require("../../common/util/ajax");
	require('../../common/util/ajaxExt');
	require("../../common/common_require");
	var previewQuestionList;
	var current=0;
	
	$("#submit").click(function(){
		teaMakePaper.submit();
	});
	
	$("#prevQuestion").click(function(){
		teaMakePaper.prev();
	});
	
	$("#nextQuestion").click(function(){
		teaMakePaper.next();
	});
	
	$("#choiceClass").click(function(){
		teaMakePaper.choiceClass();
	});
	
	$("#choiceStu").click(function(){
		teaMakePaper.choiceStu();
	});
	
	
	
	var teaMakePaper = {
		initPage : function() {
			$('#rootwizard').bootstrapWizard({'tabClass': 'bwizard-steps'});
			$(".exam_date").datetimepicker({
				language:"zh-CN",
				format : 'yyyy-mm-dd hh:ii:ss'
			});
			
			$('#radioset1 input').each(function() {
				var self = $(this);
				var label = self.next();
				var label_text = label.text();
				label.remove();
				self.iCheck({
					checkboxClass : 'icheckbox_sm-blue',
					radioClass : 'radio_sm-blue',
					insert : label_text
				});
			});
			$('#radioset2 input').each(function() {
				var self = $(this);
				var label = self.next();
				var label_text = label.text();
				label.remove();
				self.iCheck({
					checkboxClass : 'icheckbox_sm-blue',
					radioClass : 'radio_sm-blue',
					insert : label_text
				});
			});
			
			teaMakePaper.getAllTeacher();
		},
		submit:function(){
			ajax({
				url:"/qaplus/paper/makePaper.json",
				data:$("#generateQuestionMethod").serialize()+"&"+$("#paperBasicForm").serialize(),
				success:function(result){
					$("#submit").hide();
					teaMakePaper.preview(result.data[0].id);
				}
			});
		},
		preview:function(paperId){
			ajax({
				url:"/qaplus/paper/preview.json",
				data:"paperId="+paperId,
				success:function(result){
					previewQuestionList=result.data;
					var html=template(previewQuestionList[current]);
					$("#preview").html(html);
					if(previewQuestionList.length==1){
						$("#nextQuestion").addClass("disabled");
						$("#prevQuestion").addClass("disabled");
					}else{
						$("#prevQuestion").addClass("disabled");
					}
				}
			});
		},
		disabledPrev : function() {
			$("#prevQuestion").addClass("disabled");
		},
		disabledNext : function() {
			$("#nextQuestion").addClass("disabled");
		},
		enablePrev:function(){
			$("#prevQuestion").removeClass("disabled");
		},
		enableNext:function(){
			$("#nextQuestion").removeClass("disabled");
		},
		prev:function(){
			//处理翻页
			if(current==1){
				teaMakePaper.disabledPrev();
			}
			if(current<1){
				return ;
			}
			current--;
			$("#preview").html(template(previewQuestionList[current]));
			teaMakePaper.enableNext();
		},
		next:function(){
			//处理翻页
			if (previewQuestionList.length == current+1) {
				return;
			}
			if (previewQuestionList.length-1 == current+1) {
				teaMakePaper.disabledNext();
			};
			current++;
			$("#preview").html(template(previewQuestionList[current]));
		},
		getAllTeacher:function(){
			ajax({
				url:"/qaplus/user/select_all_tea.json",
				success:function(result){
					var options=[];
					for (var i = 0; i < result.data.length; i++) {
						options.push("<option value="+result.data[i].id+">"+result.data[i].name+"</option>");
					}
					$("#invigilatePerson").html(options.join(""));
				}
			});
		},
		choiceClass:function(){
			ajax({
				url:"/qaplus/class/select_all_class.json",
				success:function(result){
					var options=[];
					for (var i = 0; i < result.data.length; i++) {
						options.push("<option value="+result.data[i].id+">"+result.data[i].name+"</option>");
					}
					$("#stuIdsDiv").hide();
					$("#classId").html(options.join(""));
					$("#classIdDiv").show();
				}
			});
		},
		choiceStu:function(){
			$("#classIdDiv").hide();
			$("#stuIdsDiv").show();
			$("#stuIds").select2({
			  ajax: {
			    url: "/qaplus/user/queryAllStusByLike.json",
			    delay: 250,
			    data: function (params) {
			      return {
			        searchKey: params.term,
			        teacherId:$("#currId").val()
			      };
			    },
			    processResults: function (result) {
			      return {
			        results: result.data
			      };
			    },
			    cache: true
			  },
			  multiple:true,
			  width:800,
			  escapeMarkup: function (markup) { return markup; }, 
			  minimumInputLength: 1,
			  formatInputTooShort:function(){
				return "输入学生姓名模糊匹配";  
			  },
//			  templateResult: formatRepo, 
//			  templateSelection: formatRepoSelection 
			});
		},
		
	};
	// 输出接口，让boot.js启动
	module.exports = {
		init : function() {
			teaMakePaper.initPage();
		}
	};
});
