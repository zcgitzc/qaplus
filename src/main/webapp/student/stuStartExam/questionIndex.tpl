<div id="questionIndexWrap">
	{{#each questions}}
		{{#expr_compare ../endExam "==" "Y" }} 
			<div style="border: 2px solid green; 
						width: 35px; height: 35px; 
						text-align: center; line-height: 35px;
						float: left;margin-left:10px;
						cursor: pointer;" class="choiceQuestion" data-id="{{addOne @index}}">
				{{addOne @index}}</div>
		{{/expr_compare}}
		
		{{#expr_compare ../endExam "==" "N" }} 
			<div style="border: 2px solid #edab4b; 
							width: 35px; height: 35px; 
							text-align: center; line-height: 35px;
							float: left;margin-left:10px;
							cursor: pointer;" class="choiceQuestion" data-id="{{addOne @index}}">
					{{addOne @index}}</div>
		{{/expr_compare}}	
	{{/each}}
</div>


{{#expr_compare endExam "==" "N" }} 
	<div style="border: 2px solid #edab4b; 
					width: 35px; height: 35px; 
					text-align: center; line-height: 35px;
					float: left;margin-left:10px;
					cursor: pointer;font-size: 10px;" class="pull-right">未做</div>
					
	<div style="border: 2px solid green; 
					width: 35px; height: 35px; 
					text-align: center; line-height: 35px;
					float: left;margin-left:10px;
					cursor: pointer;font-size: 10px;" class="pull-right">已做</div>
{{/expr_compare}}

{{#expr_compare endExam "==" "Y" }} 
	<div style="border: 2px solid green; 
					width: 35px; height: 35px; 
					text-align: center; line-height: 35px;
					float: left;margin-left:10px;
					cursor: pointer;font-size: 10px;" class="pull-right">正确</div>
					
	<div style="border: 2px solid red; 
					width: 35px; height: 35px; 
					text-align: center; line-height: 35px;
					float: left;margin-left:10px;
					cursor: pointer;font-size: 10px;" class="pull-right">错误</div>
{{/expr_compare}}
				