<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的订单</title>
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
            <td>日期</td>
			<td>订单编号</td>
            <td>金额</td>
            <td>状态</td>
            <td>详情</td>
        </tr>
        <c:forEach items="${requestScope.orders}" var="order">
            <tr>
                <td>${order.createTime}</td>
				<td>${order.orderId}</td>
                <td>${order.price}</td>
                <td>
                    <c:choose>
						<c:when test="${order.status == 0}">
							${"未发货"}
						</c:when>
						<c:when test="${order.status == 1}">
							${"已发货"}
						</c:when>
						<c:when test="${order.status == 2}">
							${"已签收"}
						</c:when>
                    </c:choose>
                </td>
                <td><a href="orderServlet?action=queryOrderItems&orderId=${order.orderId}">查看详情</a></td>
            </tr>
        </c:forEach>
    </table>


</div>
<%--页脚部分--%>
<%@include file="../common/footer.jsp" %>
</body>
</html>