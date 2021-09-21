<%--
  Created by IntelliJ IDEA.
  User: ycc@Miaomiao's fish
  Date: 2021/7/29
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>b.jsp</title>
</head>
<body>
pageContext的值为:<%=pageContext.getAttribute("name")%>
request的值为:<%=request.getAttribute("name")%>
session的值为:<%=session.getAttribute("name")%>
application的值为:<%=application.getAttribute("name")%>





</body>
</html>
