{{#each data}}
	{{#expr_compare rangeDays ">" 0}}
		<a href="javascript:void('0');" class="list-group-item"><span class="badge" style="background-color:red;">还剩：{{rangeDays}}</span>{{name}}{{date}}</a>
	{{/expr_compare}}
	{{#expr_compare rangeDays "<=" 0}}
		<a href="javascript:void('0');" class="list-group-item"><span class="badge">已过去</span>{{name}}{{date}}</a>
	{{/expr_compare}}
{{/each}}