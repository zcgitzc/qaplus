<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错问列表</title>
</head>
<body>
	<jsp:include page="../../user/top/top.jsp"></jsp:include>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
            <button id="toggle" type="button" class="btn btn-primary pull-right" style="margin-top: -8px;">查看答案</button>
                <h3 class="panel-title">
                    <span id="totalCount"></span>道错题信息如下：
				</h3>
			</div>
			<div class="panel-body">
                <form action="" method="post" id="searchForm">
                    <div class="question_search">
                        <ul>
                            <li><input type="checkbox" id="check2" name="categorys"
                                value="J2SE" /> <label for="check2">J2SE</label></li>
                            <li><input type="checkbox" id="check3" name="categorys"
                                value="J2EE" /> <label for="check3">J2EE</label></li>
                            <li><input type="checkbox" id="check4" name="categorys"
                                value="JAVASCRIPT" /> <label for="check4">JAVASCRIPT</label></li>
                            <li><input type="checkbox" id="check5" name="categorys"
                                value="JQUERY" /> <label for="check5">JQUERY</label></li>
                            <li><input type="checkbox" id="check6" name="categorys"
                                value="FRONT" /> <label for="check6">前端</label></li>
                            <li><input type="checkbox" id="check7" name="categorys"
                                value="DEV_TOOL" /> <label for="check7">开发工具</label></li>
                        </ul>
                    </div>
                </form>
				<div id="errorQuestions" style="clear: both;"></div>
			</div>
		</div>
	</div>
</body>
</html>