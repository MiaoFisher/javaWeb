<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <%--	导入头部的基本信息--%>
    <%@include file="../../pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            // //加入购物车按钮的单击事件
            // $("button.addCart_btn").click(function () {
            //     //获取图书编号
            //     var id = $(this).attr("bookId");
            //     //通过修改网页地址,将请求信息发送给addItems
            //     // location.href = "http://localhost:8090/book/cartServlet?action=addItems&id=" + id;
            //     //使用ajax请求添加购物车
            //     $.getJSON("http://localhost:8090/book/cartServlet","action=ajaxAddItems&id=" + id,function (data) {
            //         console.log(data.totalCount);
            //         $("#cartTotalCount").text("您的购物车中有 "+ data.totalCount+" 件商品");
            //         $("#cartLastItems").text(data.lastItems);
            //     })
            // })
        })
    </script>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">网上书城</span>
    <div>
        <%--如果session域中没有loginUser对象,那么就显示登录/注册--%>
        <c:if test="${empty sessionScope.loginUser}">
            <a href="pages/user/login.jsp">登录</a> |
            <a href="pages/user/regist.jsp">注册</a>
        </c:if>&nbsp;
        <%--如果session域中又loginUser那么就显示个人信息--%>
        <c:if test="${ not empty sessionScope.loginUser}">
            <span>欢迎<span class="um_span">${sessionScope.loginUser.username}</span>光临尚硅谷书城</span>
            <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
        </c:if>
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="pages/manager/manager.jsp">后台管理</a>
    </div>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <%--这里用于价格查询--%>
            <%-- 设置提交地址--%>
            <form action="client/bookClientServlet" method="get">
                <%-- 设置隐藏域，用于提交调用方法--%>
                <input type="hidden" name="action" value="pageByPrice">
                价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                <input id="max" type="text" name="max" value="${param.max}"> 元
                <input type="submit" value="查询"/>
            </form>
        </div>
        <%--        <div style="text-align: center">--%>
        <%--            &lt;%&ndash;购物车有商品的情况&ndash;%&gt;--%>
        <%--            <c:if test="${not empty sessionScope.cart.items}">--%>
        <%--                <span id="cartTotalCount">您的购物车中有 件商品</span>--%>
        <%--                <div>--%>
        <%--                    您刚刚将<span style="color: red" id="cartLastItems"></span>加入到了购物车中--%>
        <%--                </div>--%>
        <%--            </c:if>--%>

        <%--            &lt;%&ndash;购物车没有有商品的情况&ndash;%&gt;--%>
        <%--            <c:if test="${ empty sessionScope.cart.items}">--%>
        <%--                <span id="cartTotalCount">您的购物车中有 ${sessionScope.cart.totalCount} 件商品</span>--%>
        <%--                <br/>--%>
        <%--                <span id="cartLastItems">您的购物车中还没有商品</span>--%>
        <%--            </c:if>--%>

        <%--        </div>--%>
        <div style="text-align: center">
            <c:if test="${empty sessionScope.cart.items}">
                <%--购物车为空的输出--%>
                <span id="cartTotalCount"> </span>
                <div>
                    <span style="color: red" id="cartLastItems">当前购物车为空</span>
                </div>
            </c:if>
            <c:if test="${not empty sessionScope.cart.items}">
                <%--购物车非空的输出--%>
                <span id="cartTotalCount">您的购物车中有 ${sessionScope.cart.totalCount} 件商品</span>
                <div>
                    您刚刚将<span style="color: red" id="cartLastItems">${sessionScope.lastName}</span>加入到了购
                    物车中
                </div>
            </c:if>
        </div>


        <c:forEach items="${requestScope.page.items}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="static/img/default.jpg"/>
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">￥${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                            <%--在此处获取book的id--%>
                        <button bookId="${book.id}" class="addCart_btn">加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <%--分页模块--%>
    <%@include file="../common/page_nav.jsp" %>

</div>
<%-- 页脚--%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>