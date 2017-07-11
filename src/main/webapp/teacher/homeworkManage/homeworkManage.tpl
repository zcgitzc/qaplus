<ul class="list-group">
	<li href="#" class="list-group-item" style="background-color: black;color: white;">作业完成情况：{{commitUsers.length}}已交/ 共：{{calculate commitUsers.length unCommitUsers.length}}人</li> 
	<li href="#" class="list-group-item">已交：
		{{#expr_compare commitUsers.length "<=" "0" }}
			暂无人提交
		{{/expr_compare}}
		{{#each commitUsers}}
			<a href="/qaplus/teacher/teaRemarkHomework/teaRemarkHomework.jsp?stuId={{id}}&homeworkId={{../homeworkId}}" target="_blank" title="点击查看学生做题情况">{{name}}&nbsp;</a>
		{{/each}}
	</li>
	
	<li href="#" class="list-group-item">未交：
		{{#expr_compare unCommitUsers.length "<=" "0" }}
			全部已交
		{{/expr_compare}}
		{{#each unCommitUsers}}
			{{name}}&nbsp;
		{{/each}}
	</li>
	
	<li href="#" class="list-group-item" style="background-color: black;color: white;">作业题目信息：</li>
	{{#each questions}}
		<a href="/qaplus/teacher/teaQuestionBank/teaQuestionBank.jsp?title={{title}}" target="_blank" class="list-group-item">{{addOne @index}}:{{title}}</a>
	{{/each}}
</ul>