{{#each data}}
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<span data-toggle="collapse"  class="collapsed" data-parent="#accordion" href="#{{id}}" data-id={{id}} style="cursor: pointer;word-wrap: break-word;"> 
					<b>{{addOne @index}}.{{title}}</b>
					<span class="pull-right">
						<span class="label" style="color:white">
							{{#expr_compare questionHasAttachment "==" "Y"}}
								<a href="javascript:void(0)" data-id="{{questionAttachmentId}}" class="attach">查看附件</a>
							{{/expr_compare}}
						</span>
					</span>
				</span>
			</h4>
		</div>
		<div id="{{id}}" class="panel-collapse collapse"><div class="panel-body" >
			<b>问题内容：  </b>
			<p style="word-break: break-word;word-wrap:break-word">{{questionContent}}</p>
			<p>
				<b>教师解答：  </b>
				{{#if answerContent}}
					{{{answerContent}}}
				{{/if}}
			</p>
			<span class="label">
				{{#expr_compare answerHasAttachment "==" "Y"}}
					<a href="/qaplus/q/download_a.htm?id={{answerAttachmentId}}">查看附件</a>
				{{/expr_compare}}
			</span>
		</div>
	</div>
</div>
{{/each}}