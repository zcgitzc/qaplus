<a href="#" class="list-group-item active">家庭作业列表：</a>
{{#each data}}
	<a href="#" class="list-group-item">在{{moment 'YYYY-MM-DD' commitDate }}做完：{{title}}  
		{{#expr_compare isCommit "==" "N"}}
			{{#compareNow commitDate ">"}}
				<span class="badge confirmDoHomework" style="background-color:red;" data-id="{{id}}" data-isCommit={{isCommit}}>未处理</span>
			{{/compareNow}}
		{{/expr_compare}}
		{{#expr_compare isCommit "==" "Y"}}
			<span class="badge" style="background-color:#337ab7;">已处理</span>
		{{/expr_compare}}
		
		{{#compareNow commitDate "<"}}
			<span class="badge lookHomeworkAnswer" data-id="{{id}}" style="background-color:#54bddc;">查看答案</span>
		{{/compareNow}}
	 </a>
{{/each}}

