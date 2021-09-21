<%--
  Created by IntelliJ IDEA.
  User: ycc
  Date: 2021/8/1
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%--登录成功菜单公共界面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功菜单公共界面</title>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <div>
        <span>欢迎<span class="um_span">${sessionScope.loginUser.username}</span>光临尚硅谷书城</span>
        <a href="orderServlet?action=queryOrders">我的订单</a>
        <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
        <a href="index.jsp">返回</a>
    </div>
</div>
</body>
</html>
