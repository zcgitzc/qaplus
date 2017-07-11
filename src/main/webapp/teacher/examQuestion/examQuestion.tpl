{{#each data}}
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<span data-toggle="collapse"  class="collapsed" data-parent="#accordion" href="#{{id}}" data-id={{id}} style="cursor: pointer;word-wrap: break-word;"> 
					<b>{{addOne @index}}.{{formatStr title 100 "..."}}</b>
				</span>
				<span class="label label-danger pull-right del" style="margin-right:5px;cursor: pointer;" data-id="{{id}}">删除</span>
			</h4>
		</div>
		<div id="{{id}}" class="panel-collapse collapse in">
		<div class="panel-body" >
			<b>问题内容<span style="color:red">（单击修改，然后点击保存）</span>：  
				<span class="label label-success pull-right updateQuestionContent" id="save" style="margin-right:5px;cursor: pointer;display:none;" data-index="{{@index}}" data-id="{{id}}">保存</span>
			</b>
			<div class="examQuestionContent" style="padding: 10px;">{{{content}}}</div>
			
			<p>
				<b>问题选项<span style="color:red">（单击修改，双击设置正确选项）</span>：  </b>
				<ul class="list-group">
					{{#each items}}
				    	<li class="list-group-item questionItem" {{#expr_compare isRightItem "==" "Y" }} style="background-color: #a4a7a4;color: white;" {{/expr_compare}} data-id="{{id}}" data-right="{{isRightItem}}">
				    		{{itemContent}}
				    	</li>
					    <input type="hidden" class="form-control" placeholder="请输入选项内容" data-id="{{id}}">
				    {{/each}}
				</ul>
			</p>
			<p>
				<input type="text" placeholder="NOTE:" name="note"  class="form-control note" data-id="{{id}}" value="{{note}}" />
			</p>
		</div>
	</div>
</div>
{{/each}}