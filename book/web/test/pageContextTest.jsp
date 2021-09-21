<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ycc
  Date: 2021/7/30
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext对象测试</title>
</head>
<body>
        <%  //先将request对象保存，便于后期输出,替代了pageContext.getRequest()
            request.setAttribute("req",request);
//            session.setAttribute("session",session);
            request.setAttribute("session",session);
        %>
        1.协议:${req.scheme}<br/>
        2.服务器ip:${req.serverName}<br/>
        3.服务器端口号:${req.serverPort}<br/>
        4.获取工程路径${req.contextPath}<br/>
        5.获取请求方法${req.contextPath}<br/>
        6.获取客户端Ip地址${req.remoteHost}<br/>
        7.获取会话的id编号${session.id}<br/>
        <br/>

</body>
</html>
