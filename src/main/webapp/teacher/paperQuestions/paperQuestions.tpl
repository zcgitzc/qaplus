{{#each questions}}
	<h4>第{{convertToChinese @index}}题：</h4>
	<div class="stuQuestion" style="padding: 10px;border-radius: 5px;margin-bottom: 50px; border: 1px solid;">
		{{{content}}}
		<p style="color:green">
			{{#expr_compare type "==" "CHECKBOX" }} 
				[多选 &nbsp;<span style="color:red;">{{score}}分</span>]
			{{/expr_compare}}
			{{#expr_compare type "==" "RADIO" }} 
				[单选  &nbsp;<span style="color:red;">{{score}}分</span>]
			{{/expr_compare}}
			{{#expr_compare canReadNote "==" "Y" }}
				<span style="color:green">NOTE:{{note}}</span>
			{{/expr_compare}}
		</p>
		<ul class="list-group items">
			{{#each items}}
				<li class="list-group-item"
						{{#expr_compare ../canReadNote "==" "Y" }}
							{{#expr_compare isRightItem "==" "Y" }} style="border:1px solid green;margin: 2px 0px;" {{/expr_compare}} 
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