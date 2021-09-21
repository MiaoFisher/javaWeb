<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单管理</title>
    <%--	导入头部的基本信息--%>
    <%@include file="../common/head.jsp" %>
</head>
<body>
<%--book模块菜单--%>
<%@include file="../common/book_menu.jsp" %>

<div id="main">
    <table>
        <tr>
            <td>日期</td>
            <td>金额</td>
            <td>详情</td>
            <td>发货</td>

        </tr>
        <c:forEach items="${requestScope.orders}" var="order">
            <tr>
                <td>${order.createTime}</td>
                <td>${order.price}</td>
                <td><a href="orderServlet?action=queryOrderItems&orderId=${order.orderId}">详情</a></td>
                <td>
                    <c:if test="${order.status == 0}">
                        <a href="orderServlet?action=updateOrderStatus&status=1&orderId=${order.orderId}">点击发货</a>
                    </c:if>
                    <c:if test="${order.status == 1}">
                        <p>已发货</p>
                    </c:if>
                    <c:if test="${order.status == 2}">
                        <p>待签收</p>
                    </c:if>
                </td>
            </tr>
        </c:forEach>


    </table>
</div>

<%@include file="../common/footer.jsp" %>
</body>
</html>