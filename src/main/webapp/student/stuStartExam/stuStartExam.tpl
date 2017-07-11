<div style="margin-left: 15px;">
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
</div>
<ul class="list-group items">
	{{#each items}}
		<!-- 是正确答案绿色，不是正确答案，你还选了，则是红色 -->
		<li class="list-group-item"
				{{#expr_compare ../canReadNote "==" "Y" }}
					{{#expr_compare isRightItem "==" "Y" }} style="border:1px solid green;margin: 2px 0px;" {{/expr_compare}} 
				{{/expr_compare}}
				>
			{{#expr_compare ../type "==" "CHECKBOX" }} 
				<input type="checkbox" name="choiceItem" data-id="{{id}}" {{#expr_compare ../canReadNote "==" "Y" }} disabled  {{/expr_compare}} {{#expr_compare isUserChoice "==" "Y" }} checked {{/expr_compare}}/>
			{{/expr_compare}}
			{{#expr_compare ../type "==" "RADIO" }} 
				<input type="radio" name="choiceItem" data-id="{{id}}" {{#expr_compare ../canReadNote "==" "Y" }} disabled  {{/expr_compare}}  {{#expr_compare isUserChoice "==" "Y" }} checked {{/expr_compare}}/>
			{{/expr_compare}}
			&nbsp;&nbsp;
			{{itemContent}}
		</li>
	{{/each}}
</ul>


