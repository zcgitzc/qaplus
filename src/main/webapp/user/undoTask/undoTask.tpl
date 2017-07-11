{{#expr_compare data.length ">" "0" }}
	{{#each data}}
		 {{#expr_compare isSolve "==" "N" }}
		 	{{#expr_compare operKey "==" "USER_REGISTER" }}
		 		<li class="list-group-item">
			 		<span class="badge agree" style="cursor: pointer;background-color:#0088CC;" data-id="{{id}}">同意</span>
			 		<span class="badge reject" style="cursor: pointer;background-color:red;" data-id="{{id}}" >拒绝</span>
		 			{{content}}
		 		</li>
		 	{{/expr_compare}}
		 {{/expr_compare}}
		 
		 {{#expr_compare isSolve "==" "N" }}
		 	{{#expr_compare operKey "==" "TEA_SOLVE_QUESTION" }}
		 		<li class="list-group-item">
		 			<span class="badge queryQuestion" style="cursor: pointer;background-color:#0088CC;" data-id="{{id}}" data-title="{{keyword}}">查看</span>
		 		{{content}}
		 		</li>
		 	{{/expr_compare}}
		 {{/expr_compare}}
		 
	{{/each}}
{{/expr_compare}}
{{#expr_compare data.length "<=" "0" }}
	暂时没有任务，好好休息一下
{{/expr_compare}}