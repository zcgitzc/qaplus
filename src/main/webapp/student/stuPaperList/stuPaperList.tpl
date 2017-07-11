<a href="#" class="list-group-item active">学生试卷列表:</a>
{{#each data}}
	<a href="javascript:void('0')" class="list-group-item">试卷名称:<span style="background-color: black;color: white;">「{{paperTitle}}」&nbsp;</span>
										考试时间:<span style="background-color: black;color: white;">「{{moment 'YYYY-MM-DD HH:mm:ss' examDate }}」&nbsp;</span>
										试卷总分:<span style="background-color: black;color: white;">「{{totalScore}}分」&nbsp;</span>
										难易程度:<span style="background-color: black;color: white;">「{{_paperDiffStage diffStage}}」&nbsp;</span>
										监考老师:<span style="background-color: black;color: white;">「{{invigilateName}}」&nbsp;</span>
										出卷人:<span style="background-color: black;color: white;">「{{paperPersonName}}」&nbsp;</span>
		{{#expr_compare isEffect "==" "N"}}
			<span class="badge startExam" style="background-color:red;" data-id="{{id}}">查看</span>
		{{/expr_compare}}
		{{#expr_compare isEffect "==" "Y"}}
			<span class="badge startExam" style="background-color:#337ab7;" data-id="{{id}}">参与考试</span>
		{{/expr_compare}}
	</a>
{{/each}}
