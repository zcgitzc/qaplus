{{#expr_compare data.length ">" "0" }}
	{{#each data}}
			<li class="news-item" title="{{content}}" >
				<img src="../../static/img/1.png" width="60" class="img-circle"  title="{{content}}"/>
				{{#expr_compare importantFlag "==" "Y"}}
					<span class="badge" style="background-color:red;" title="{{content}}">重要</span>
				{{/expr_compare}}	
				【结束时间：{{moment "YYYY-MM-DD HH:mm:ss" endTime}}】{{formatStr content 60 "..."}}
			</li>
	{{/each}}
{{/expr_compare}}




