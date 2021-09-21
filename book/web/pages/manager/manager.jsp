
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
	<%--	导入头部的基本信息--%>
	<%@include file="../common/head.jsp"%>z
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>

	<%--book模块菜单--%>
	<%@include file="../common/book_menu.jsp"%>
	
	<div id="main">
		<h1>欢迎管理员进入后台管理系统</h1>
	</div>

	<%@include file="../common/footer.jsp"%>
</body>
</html>