{{#each data}}
	<h2 id={{id}}>{{convertToChinese @index}}：{{title}}</h2>
	{{#expr_compare hasAttachment "==" "Y"}}
		<span class="label label-info pull-right attach" style="cursor:pointer;" data-id="{{attachmentId}}">附件</span>
	{{/expr_compare}}
	<span class="label label-danger pull-right del" style="margin-right:5px;cursor: pointer;" data-id="{{id}}">删除</span>
	<p>{{{content}}}</p>
{{/each}}
