<div class="panel panel-default">
	<div class="panel-heading">
      	 <a href="/qaplus/teacher/examQuestion/examQuestion.jsp?title={{title}}" target="_blank">去考试题库中查看题目详细信息</a>
    </div>
	<div class="panel-body">
		<div>问题：{{{content}}}</div>
		{{#expr_compare note "!=" "" }} 
			<p><span style="color:green">NOTE:{{note}}</span></p>
		{{/expr_compare}}
		<ul class="list-group">
			{{#each items}}
				<li class="list-group-item">
				{{#expr_compare ../type "==" "CHECKBOX" }} 
					<input type="checkbox" name="choiceItem"/>
				{{/expr_compare}}
				{{#expr_compare ../type "==" "RADIO" }} 
					<input type="radio" name="choiceItem"/>
				{{/expr_compare}}
				&nbsp;&nbsp;{{itemContent}}</li>
			{{/each}}
		</ul>
	</div>
</div>


