<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ycc
  Date: 2021/8/6
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%-- 这里用于分页模块 --%>
<head>
    <title>分页</title>
</head>
<body>
<script type="text/javascript">
    /**
     * 这个方法用于确认是否删除点击对象
     */
    $(function () {

        $("a.deleteClass").click(function () {
            //需要注意，由于下面是for循环输出，所以下面delete标签的id都是一样的，所以不能给标签统一定义id
            return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】吗?");
        });
        //跳转指定页面
        $("#searchPageNoBtn").click(function () {
            //获取输入框的页码
            var pageNo = $("#pn_input").val();
            //判断是否越界
            if (pageNo >${requestScope.page.pageTotal}) {
                pageNo = ${requestScope.page.pageTotal};
            } else if (pageNo < 1) {
                pageNo = 1;
            }

            //修改地址栏信息
            //之前在request域中保存了basePath的路径
            location.href = "${basePath}${requestScope.page.url}&pageNo=" + pageNo;
        });
    })

</script>
<%--分页--%>
<div id="page_nav">
    <c:if test="${requestScope.page.pageNo>1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>

    </c:if>
    <%--页面输出开始 下面是根据各种情况给begin和end赋值--%>
    <c:choose>
        <%--当页面小于等于5的时候--%>
        <c:when test="${requestScope.page.pageTotal<=5}">
            <c:set var="begin" value="1"></c:set>
            <c:set var="end" value="${requestScope.page.pageTotal}"></c:set>
        </c:when>
        <%--当页面大于5的时候--%>
        <c:when test="${requestScope.page.pageTotal>5}">
            <c:choose>
                <%--当前页面小于3的时候--%>
                <c:when test="${requestScope.page.pageNo<=3}">
                    <c:set var="begin" value="1"></c:set>
                    <c:set var="end" value="5"></c:set>
                </c:when>
                <%--当前页面为输最后两个--%>
                <c:when test="${requestScope.page.pageNo+3>requestScope.page.pageTotal}">
                    <c:set var="begin" value="${requestScope.page.pageTotal-4}"></c:set>
                    <c:set var="end" value="${requestScope.page.pageTotal}"></c:set>
                </c:when>
                <%--当前页面处于中间--%>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageNo-2}"></c:set>
                    <c:set var="end" value="${requestScope.page.pageNo+2}"></c:set>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <%--在这里输出--%>
    <c:forEach var="i" begin="${begin}" end="${end}">
        <c:if test="${requestScope.page.pageNo == i}">
            【${i}】
        </c:if>
        <c:if test="${requestScope.page.pageNo != i}">
            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
        </c:if>
    </c:forEach>

    <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
    <input id="searchPageNoBtn" type="button" value="确定">
</div>
</body>
</html>
