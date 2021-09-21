<%--
  Created by IntelliJ IDEA.
  User: ycc
  Date: 2021/7/30
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>九九乘法表</title>
</head>
<body>
        <table border="1">
            <%for (int i = 1 ; i<9 ;i++){%>
            <tr>
                <%for (int j = 1;j<=i;j++){%>
                <td>
                    <%=j +"*" + i +"="+(i*j)%>
                </td>
                <%}
                }%>
            </tr>

        </table>
</body>
</html>
