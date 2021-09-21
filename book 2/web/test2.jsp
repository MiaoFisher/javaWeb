<%@ page import="java.util.List" %>
<%@ page import="com.pojo.Customer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: ycc
  Date: 2021/7/30
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>输出游客信息</title>
   <style type="text/css">
       table{
           border: 1px black solid;
       }
       td,th{
           border: 1px red solid;
       }
   </style>
</head>
<body>
<%--        从request中获得数据--%>
        <%
            List<Customer> list = (List<Customer>) request.getAttribute("list");
        %>
        <table>
            <tr>
                <th>id</th>
                <th>姓名</th>
                <th>email</th>
                <th>生日</th>
            </tr>
            <%for (Customer customer:list){%>
            <tr>
                <td><%=customer.getId()%></td>
                <td><%=customer.getName()%></td>
                <td><%=customer.getEmail()%></td>
                <td><%=customer.getBirth()%></td>
            </tr>
            <%}%>
        </table>
</body>
</html>
