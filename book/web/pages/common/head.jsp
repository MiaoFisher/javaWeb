
<%--
  Created by IntelliJ IDEA.
  User: ycc
  Date: 2021/8/1
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>head部分的信息</title>
    <%--设置每一个界面的基准路径--%>
    <%--为了能在不同的主机去访问我们界面，必须要动态获取本机的ip地址-,否则写死localhost，在别的主机就不能访问了--%>
    <%
        //动态获取base路径
        //getScheme ==>获得协议 http
        //getServerName ==> 获得服务器名称 localhost
        //getServerPort() ==> 获得服务器端口号 8080
        //getContextPath() ==> 获得路径 从book开始
        String basePath = request.getScheme()
                + "://"
                + request.getServerName()
                + ":"
                + request.getServerPort()
                +request.getContextPath()
                +"/";
        request.setAttribute("basePath",basePath);
    %>
    <base href=${basePath}>
    <%--设置导入的css样式--%>
    <link type="text/css" rel="stylesheet" href="static/css/style.css" >
    <%--设置导入的js--%>
    <script type="text/javascript" src="../../static/script/jquery-1.7.2.js"></script>
    <script type="text/javascript" >
        $(function () {
            //alert($("#cartLastItems").text());
            //通过ajax去判断用户名是否重复
            $("#username").blur(function () {
                var username = this.value;
                $.getJSON("http://localhost:8090/book/userServlet","action=ajaxExistUsername&username=" + username,function (data) {
                    console.log(data)
                    if (data.existUser == true	){
                        $("span.errorMsg").text("用户名已存在");
                    }else {
                        $("span.errorMsg").text("用户可以使用");
                    }
                })
            });
            //加入购物车按钮的单击事件
            $("button.addCart_btn").click(function () {
                //获取图书编号
                var id = $(this).attr("bookId");
                //通过修改网页地址,将请求信息发送给addItems
                // location.href = "http://localhost:8090/book/cartServlet?action=addItems&id=" + id;
                //使用ajax请求添加购物车;
                $.getJSON("http://localhost:8090/book/cartServlet","action=ajaxAddItems&id=" + id,function (data) {
                    //alert($("#cartLastItems").text())
                    $("#cartTotalCount").text("您的购物车中有 "+ data.totalCount+" 件商品");
                    $("#cartLastItems").text(data.lastItems);
                });
            })
        })

    </script>
</head>
<body>
</body>
</html>
