<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%--	导入头部的基本信息--%>
    <%@include file="../common/head.jsp" %>
	<script type="text/javascript">
		$(function () {
			$("a.deleteBtn").click(function () {
				return confirm("你确定要删除【" +$(this).attr("bookName") +"吗】")
			});
			$("#clearCart").click(function () {
				return confirm("你确定要清空购物车吗?");
			});
			//更新商品数量
			$(".bookCount").change(function () {
				//获取商品名
				var name = $(this).parent().parent().find("td:first").text();
				var id = $(this).attr("bookId");
				//获取商品数量
				var count = this.value;
				if (confirm("你确定要将商品【"+ name+"】数量改为:" + count)) {
					location.href = "${basePath}cartServlet?action=updateCart&count=" + count + "&id=" + id;
				}else {
					this.value = this.defaultValue;
				}

			});
		})
	</script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <%@include file="../common/login_success_menu.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>

        <%--在sessionScope中获取商品信息--%>
        <c:forEach items="${sessionScope.cart.items}" var="entry">
            <tr>
                <td>${entry.value.name}</td>
                <td>
					<input type="text" name="bookCount" class="bookCount" value="${entry.value.count}" bookId = "${entry.value.id}">
				</td>
                <td>${entry.value.price}</td>
                <td>${entry.value.totalPrice}</td>
                <td><a href="cartServlet?action=deleteItems&id=${entry.value.id}" bookName="${entry.value.name}" class="deleteBtn">删除</a></td>
            </tr>
        </c:forEach>
		<%--如果有没有商品则引导顾客购买--%>
		<c:if test="${empty sessionScope.cart.items}">
			<tr >
				<td colspan="5"><a href="index.jsp">亲，购物车还没有商品，快跟小伙伴一起去浏览吧!</a></td>
			</tr>
		</c:if>
    </table>
    <%--如果有商品则展示具体信息--%>
    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span" ><a href="cartServlet?action=clearCart" id="clearCart">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
        </div>
    </c:if>

</div>

<%@include file="../common/footer.jsp" %>
</body>
</html>