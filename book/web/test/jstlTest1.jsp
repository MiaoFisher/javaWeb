<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="com.pojo.Customer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.Date" %>
<%@ page import="com.sun.org.apache.regexp.internal.RE" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ycc
  Date: 2021/7/30
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style type="text/css">
    table{
        border: 1px red solid;
    }
    td,th{
        border: 1px red solid;
    }
</style>
<html>
<head>
    <title>jstl库标签测试</title>
</head>
<body>使用jstl库<br/>
<%--        使用<c:set>标签--%>
        <c:set scope="page" var="name" value="pageContext"/>
        page:${name}
<br/>
<%--        使用<c:if>标签库--%>
        <c:if test="${12 == 12}">
            为真
        </c:if>
<%--使用<c:choose>,<c:when>,<c:otherwise>标签--%>
<%--1.这个标签内部不能是用html注释，只能使用jsp注释，
    2.在判断里面加判断的时候记得要从<c:choose>开始写
--%>
        <%request.setAttribute("height",178);%>
        <c:choose>
            <c:when test="${height>190}">
                <h1>身高高于190</h1>
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${height>180}">
                        <h1>身高高于180</h1>
                    </c:when>
                    <c:otherwise>
                        <h1>身高低于180</h1>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
<%--使用<c:forEach>--%>

    <table border="1">
    <c:forEach begin="1" end="10" var="i">
        <tr>
            <td>第${i}行</td>
        </tr>
    </c:forEach>
    </table>
<%--遍历Object数组--%>
<% request.setAttribute("arr",new String[]{"123","234","456"});%>
    <c:forEach var="item" items="${arr}">
        ${item}
    </c:forEach>
<%--遍历Map--%>
<%
    Map<String,String> map = new HashMap<>();
    map.put("key1","value1");
    map.put("key2","values2");
    request.setAttribute("map",map);
%>
<c:forEach var="entry" items="${requestScope.map}">
    ${entry.key} = ${entry.value}<br/>
</c:forEach>
<%--遍历list,list中的存放javabean数据类型--%>
<%
    List<Customer> list = new ArrayList<Customer>();
    for (int i = 1;i<=10;i++){
        list.add(new Customer(i,"name"+i,"email"+1,new Date(1654654265464l+i)));
        request.setAttribute("customers",list);
    }
%>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>email</th>
        <th>birth</th>
    </tr>
    <c:forEach items="${customers}" var="cus" begin="2" end="8" step="2">
        <tr>
            <td>${cus.id}</td>
            <td>${cus.name}</td>
            <td>${cus.email}</td>
            <td>${cus.birth}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
