<%--
  Created by IntelliJ IDEA.
  User: ycc
  Date: 2021/7/31
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>uploadTest</title>
</head>
<body>
<%--记得要加name的值，否则提交上去之后request无法获取--%>
<form action="http://localhost:8080/book/uploadServlet" method="post" enctype="multipart/form-data">
    name:<input type="text" name="username" >
    <input type="file" name="file" >
    <input type="submit" value="提交">

</form>
</body>
</html>
