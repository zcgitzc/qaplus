{{#each questions}}
	<h4>第{{convertToChinese @index}}题：</h4>
	<div class="stuQuestion" style="padding: 10px;border-radius: 5px;margin-bottom: 50px;
					{{#expr_compare right "==" "Y" }}
						border: 2px solid green;
				 	{{/expr_compare}}
				 	
				 	{{#expr_compare right "==" "N" }}
						border: 2px solid red;
				 	{{/expr_compare}}
				">
		{{{content}}}
		<p style="color:green">
			{{#expr_compare type "==" "CHECKBOX" }} 
				[多选 &nbsp;<span style="color:red;">{{score}}分</span> &nbsp;  
					{{#expr_compare right "==" "Y" }}
						正确
				 	{{/expr_compare}}
				 	{{#expr_compare right "==" "N" }}
				 		<span style="color:red;">错误</span>
				 	{{/expr_compare}}
				]
			{{/expr_compare}}
			{{#expr_compare type "==" "RADIO" }} 
				[单选  &nbsp;<span style="color:red;">{{score}}分</span> &nbsp;  
					{{#expr_compare right "==" "Y" }}
						正确
				 	{{/expr_compare}}
				 	{{#expr_compare right "==" "N" }}
				 		<span style="color:red;">错误</span>
				 	{{/expr_compare}}
				 ]
			{{/expr_compare}}
			{{#expr_compare canReadNote "==" "Y" }}
				<span style="color:green">NOTE:{{note}}</span>
			{{/expr_compare}}
		</p>
		<ul class="list-group items">
			{{#each items}}
				<!-- 是正确答案绿色，不是正确答案，你还选了，则是红色 -->
				<li class="list-group-item"
						{{#expr_compare ../canReadNote "==" "Y" }}
							{{#expr_compare isRightItem "==" "Y" }} style="border:1px solid green;margin-bottom: 0px;" {{/expr_compare}} 
						{{/expr_compare}}
						>
					<input type="{{../type}}"  disabled="disabled" {{#expr_compare isUserChoice "==" "Y" }}  checked="checked" {{/expr_compare}}/>
						&nbsp;&nbsp;
					{{itemContent}}
				</li>
			{{/each}}
		</ul>
	</div>
{{/each}}