~~~~~~~~^^^^^^^^^^^望大神指教^^^^^^^^^^^^^~~~~~~~~~~~~

后端使用技术：springmvc mybatis spring
前端使用技术：bootstrap jquery-ui layer validate seajs handlebars
运行步骤：
1.git check out 或者 下载zip
2.修改resources/jdbc.properties文件
3.进入到项目目录运行命令:mvn tomcat7:run,当然也可以用ide运行

包括的知识：
1.使用velocity的vm来制定邮件内容
2.使用logback记录项目日志(搞了好久)
3.springmvc上传下载，异常统一处理
4.自定义注解记录日志
5.spring-ehcache整合
6.cookie实现单点登录
7.echarts统计报表
{{{{有时间了解一下Hbase}}}}

1.使用mybatis官网提供的mybatis-generator插件
    a).对插件进行扩展，生成分页语句；生成实体类的注释
    b).添加gen.bat文件，使得generatorConfig.xml中的targetProject路径不必要写死，易于维护
    c).maven中添加mybatis-generator-maven-plugin插件，使用mvn mybatis-generator:generate命令生成代码，使得开发与运行隔离
2.前端使用seajs+handlebars架构
    a).使用handlebars解决ajax请求成功之后拼接html，采用handlebars提供的template方法，生成html，便于维护
    b).使用handlebars提供的registerHelper方法 添加helper.js扩展对handlebars的支持
    c).使用seajs使得前端代码更加模块化开发
    


    

~~~~~~~~^^^^^^^^^^^望大神指教^^^^^^^^^^^^^~~~~~~~~~~~~











	/*fixedTableColumn : function(tableObj, leftColumns, rightColumns) {
		var table = tableObj.dataTable({
			"ordering" : false,
			"searching" : false,
			"info" : false,
			"paging" : false,
			"scrollCollapse" : true,
			"scrollX" : true,
			"bAutoWidth" : true
		});

		new $.fn.dataTable.FixedColumns(table, {
			leftColumns : leftColumns,
			rightColumns : rightColumns
		});
	},*/
	
	
	
	




http://www.jq22.com/yanshi8445




