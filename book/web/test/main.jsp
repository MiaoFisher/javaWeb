<%--
  Created by IntelliJ IDEA.
  User: ycc
  Date: 2021/7/30
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试代码块</title>
</head>
<body>
        头部信息<br/>
        主题信息<br/>
<%--        动态代码块还可以传递参数--%>
        <jsp:include page="foot.jsp">
            <jsp:param name="name" value="footer"/>
        </jsp:include>
<%--使用jsp：forward进行请求转发--%>
        <jsp:forward page="a.jsp"></jsp:forward>
</body>
</html>
