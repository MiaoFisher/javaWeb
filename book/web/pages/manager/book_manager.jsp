<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>

    <%--	导入头部的基本信息--%>
    <%@include file="../common/head.jsp" %>
    <%--	script部分要写在导包下面，否则无法解析--%>

</head>
<body>

<%--book模块菜单--%>
<%@include file="../common/book_menu.jsp" %>

<div id="main">
    <table>
<%--		设置一个隐藏域保存当前页面除数据--%>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>
        <%--通过for循环将列表中的数据显示出来--%>
        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
                <td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
            </tr>
        </c:forEach>



        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp?pageTotal=${requestScope.page.pageTotal}">添加图书</a></td>
        </tr>
    </table>
    <%--分页模块--%>
	<%@include file="../common/page_nav.jsp"%>
</div>
<%@include file="../common/footer.jsp" %>
</body>
</html>