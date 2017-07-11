<form action="" method="post" id="searchForm">
    <div class="question_search">
        <ul>
            {{#each data}}
            <li>
                <input type="checkbox" id="check{{addOne @index}}" name="{{name}}" 
                    {{#expr_compare checked "==" "Y"}}
                        checked="checked"
                    {{/expr_compare}}
                value="{{code}}" /> 
                <label for="check{{addOne @index}}">{{text}}</label>
            </li>
            {{/each}}
        </ul>
    </div>
</form>