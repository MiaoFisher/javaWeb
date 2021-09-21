<%--
  Created by IntelliJ IDEA.
  User: ycc
  Date: 2021/8/1
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>book模块菜单项</title>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">后台管理系统</span>
    <div>
<%--        注意，这里要加上参数action，以便于知道调用哪一个方法，同时该请求方式为doGet()，在后面doGet()中要转发到doPost()中--%>
        <a href="manager/bookServlet?action=page">图书管理</a>
        <a href="orderServlet?action=queryAllOrders">订单管理</a>
        <a href="index.jsp">返回商城</a>
    </div>
</div>
</body>
</html>
