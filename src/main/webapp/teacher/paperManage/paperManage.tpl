<ul class="list-group">
	<li href="#" class="list-group-item" style="background-color: black;color: white;">学生考试情况：</li> 
	<li href="#" class="list-group-item">
		{{#each data}}
			{{addOne @index}}:<a href="/qaplus/teacher/teaRemarkPaper/teaRemarkPaper.jsp?paperId={{../paperId}}&stuId={{id}}"  target="_blank" title="点击查看学生考试试题情况">{{name}}
				[
					{{#_examStatus examStatus}}{{/_examStatus}}
					{{#expr_compare examStatus "==" "EXAMED" }}
						({{score}}分)
					{{/expr_compare}}
				]、</a>
		{{/each}}
	</li>
	{{#expr_compare paperStatus "==" "STARTED" }}
		<li href="#" class="list-group-item">
			<span style="color:green;">
				本次考试平均分：<span style="color:red;">{{avgScore}}分</span>&nbsp;&nbsp;
				考试前三名：<span style="color:red;">{{topThree}}</span>&nbsp;&nbsp;
			</span>
		</li>
	{{/expr_compare}}
</ul>