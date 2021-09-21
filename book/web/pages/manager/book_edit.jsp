<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑图书</title>
    <%--	导入头部的基本信息--%>
    <%@include file="../common/head.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }

        input {
            text-align: center;
        }
    </style>
</head>
<body>
<%--book模块菜单--%>
<%@include file="../common/book_menu.jsp" %>

<div id="main">
    <%--			将信息提交到bookServlet中--%>
    <form action="manager/bookServlet" method="get">
        <%--设置一个隐藏域用于指定调用Servlet中的方法--%>
        <%--				根据request域中是否有book对象来判断操作类型--%>
        <input type="hidden" name="action" value="${empty requestScope.book?"add":"update"}">
        <%--					更新的时候需要将id传入--%>
        <input type="hidden" name="id" value="${book.id}">
        <%--					将当前页码保存--%>
        <input type="hidden" name="pageNo" value="${param.pageNo}">
		<%--添加数据后的页面（在最后一页显示）--%>
		<input type="hidden" name="addPageNo" value="${param.pageTotal}">
        <table>
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>作者</td>
                <td>销量</td>
                <td>库存</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <td><input name="name" type="text" value="${book.name}"/></td>
                <td><input name="price" type="text" value="${book.price}"></td>
                <td><input name="author" type="text" value="${book.author}"/></td>
                <td><input name="sales" type="text" value="${book.sales}"/></td>
                <td><input name="stock" type="text" value="${book.stock}"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>


</div>

<%@include file="../common/footer.jsp" %>
</body>
</html>