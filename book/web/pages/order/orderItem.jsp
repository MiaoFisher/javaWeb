<%--
  Created by IntelliJ IDEA.
  User: ycc
  Date: 2021/8/10
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单详情</title>
    <%--	导入头部的基本信息--%>
    <%@include file="../common/head.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>
<%--登录成功后菜单界面	--%>
<%@include file="../common/login_success_menu.jsp" %>

<div id="main">

    <table>
        <tr>
            <td>书名</td>
            <td>订单编号</td>
            <td>金额</td>
            <td>数量</td>
            <td>总金额</td>
        </tr>
        <c:forEach items="${requestScope.orderItems}" var="orderItems">
            <tr>
                <td>${orderItems.name}</td>
                <td>${orderItems.orderId}</td>
                <td>${orderItems.price}</td>
                <td>${orderItems.count}</td>
                <td>${orderItems.totalPrice}</td>
            </tr>
        </c:forEach>
    </table>


</div>
<%--页脚部分--%>
<%@include file="../common/footer.jsp" %>
</body>
</html>