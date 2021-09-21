<%--
  Created by IntelliJ IDEA.
  User: ycc
  Date: 2021/7/29
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp脚本测试</title>
</head>
<body>
<%--for循环测试--%>
<% for (int i = 0; i < 10; i++) {%>
<table border="1">
    <tr>
        <td>第<%= i + 1 %>行</td>
    </tr>
</table>
<% }%>
<%--if循环测试--%>
<% int i = 13;
    if (i == 12) {
%>
<%="this is 12"%>
<% } else {%>
<%="this is 13"%>
<%}%>
<% pageContext.setAttribute("name", "pageContext");
    request.setAttribute("name", "request");
    session.setAttribute("name", "session");
    application.setAttribute("name", "application");%>
pageContext的值为:<%=pageContext.getAttribute("name")%>
request的值为:<%=pageContext.getAttribute("name")%>
session的值为:<%=pageContext.getAttribute("name")%>
application的值为:<%=pageContext.getAttribute("name")%>
<%--<%request.getRequestDispatcher("/b.jsp").forward(request,response);%>--%>
<%--<% request.getRequestDispatcher("/b.jsp").forward(request,response);%>--%>
</body>
</html>
