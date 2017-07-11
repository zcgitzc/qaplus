{{#each questionAndAnswers}}
<div class="panel-body">
	<form class="form-horizontal" role="form" style="margin-top: 40px;">
		<h3>第{{convertToChinese @index}}题：{{{teacherQuestionVo.title}}}</h3>
		<div class="form-group">
			<div class="col-sm-12">
				<div class="teaHomeworkQuestion" style="border: 1px solid #c1c1c1;padding: 10px;border-radius: 5px;">
					题目内容：<br/><br/>
					{{{teacherQuestionVo.content}}}
				</div>
				{{#expr_compare teacherQuestionVo.questionHasAttachment "==" "Y"}}
					<span class="label label-info pull-right questionAttach" style="cursor: pointer;" data-id="{{teacherQuestionVo.questionAttachmentId}}">题目附件</span>
				{{/expr_compare}}
			</div>
		</div>
	
		<div class="form-group">
			<div class="col-sm-12">
				<div class="stuHomeworkAnswer" style="border: 1px solid #c1c1c1;padding: 10px;border-radius: 5px;">
					学生答案：<br/><br/>
					{{{stuHomeworkAnswer.commitContent}}}
				</div>
				{{#expr_compare stuHomeworkAnswer.hasAttachment "==" "Y"}}
					<span class="label label-info pull-right stuAnswerAttach" style="cursor: pointer;" data-id="{{stuHomeworkAnswer.attachmentId}}">学生答案附件</span>
				{{/expr_compare}}
			</div>
		</div>
	
	
		<div class="form-group">
			<div class="col-sm-12">
				<div class="input-group" style="width: 100%;">
					{{#expr_compare ../isStudent "!=" "Y"}}
						<input type="text" class="form-control" placeholder="输入批注：" name="title" value="{{stuHomeworkAnswer.teacherRemark}}"> 
						<span class="input-group-btn">
							<button class="btn btn-primary remarkBtn" type="button" data-id="{{stuHomeworkAnswer.id}}">确认批注</button>
						</span>
					{{/expr_compare}}
					{{#expr_compare ../isStudent "==" "Y"}}
						<input type="text" class="form-control" readonly placeholder="暂无批注信息" name="title" value="老师批注：{{stuHomeworkAnswer.teacherRemark}}"> 
					{{/expr_compare}}
				</div>
			</div>
		</div>
	
		<div class="form-group">
			<div class="col-sm-12">
				<div style="border: 1px solid #c1c1c1;padding: 10px;border-radius: 5px;">
				正确答案：<br/><br/>
				{{{teacherQuestionVo.answer}}}</div>
				{{#expr_compare teacherQuestionVo.answerHasAttachment "==" "Y"}}
					<span class="label label-info pull-right answerAttach" style="cursor: pointer;" data-id="{{teacherQuestionVo.answerAttachmentId}}">正确答案附件</span>
				{{/expr_compare}}
			</div>
		</div>
		<div style="width: 100%; margin-top: 10px; height: 0px; border-bottom: #000000 1px dashed;"></div>
	</form>
</div>
{{/each}}