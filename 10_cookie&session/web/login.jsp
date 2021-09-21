<%--
  Created by IntelliJ IDEA.
  User: ycc
  Date: 2021/8/7
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面(cookie保存测试)</title>
</head>
<body>
<%--form表单 中的action要用隐藏域 hidden 去提交--%>
<form action="http://localhost:8080/10_cookie/cookieServlet">
<%--    根据el中的隐含对象cookie去获取cookie中的值--%>
    <input type="hidden" name="action" value="saveUsernameAndPasswordByCookie">
    用户名:<input type="text" name="username" id="" value="${cookie.username.value}">
    密码:<input type="password" name="password" id="" value="${cookie.password.value}">
    <input type="submit" value="提交">
</form>
</body>
</html>
