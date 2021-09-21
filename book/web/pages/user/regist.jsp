<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<%--	导入头部的基本信息--%>
	<%@include file="../common/head.jsp"%>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
</style>
	<!--先将包导入-->
	<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		//先加载页面
		$(function () {
			// //通过ajax去判断用户名是否重复
			// $("#username").blur(function () {
			// 	var username = this.value;
			// 	$.getJSON("http://localhost:8090/book/userServlet","action=ajaxExistUsername&username=" + username,function (data) {
			// 		console.log(data)
			// 		if (data.existUser == true	){
			// 			$("span.errorMsg").text("用户名已存在");
			// 		}else {
			// 			$("span.errorMsg").text("用户可以使用");
			// 		}
			// 	})
			// })
			
			
			//当注册页面被点击的时候
			$("#sub_btn").click(function () {
				//1 验证用户名字是否合法
				//1.1 先获取用户名
				var username = $("#username").val();
				//1.2 给出验证用户名的正则表达式 (有且只能包含字母，下划线，数字，且加起来在 5 - 12 个字符)
				var patt = /^\w{5,12}$/;
				//1.3 根据正则表达式验证
				if (!patt.test(username)){
					//1.3.1 如果验证失败
					//span框 会显示 用户名不合法
					$("span.errorMsg").text("用户名不合法");
					//失败就不会跳转 返回false
					return false;
				}
				//2 验证密码是否合法
				//2.1 获取密码
				var password = $("#password").val();
				//2.2 给出验证密码的正则表达式 这里和用户名的规则暂时保持一致
				var pattForPassword = /^\w{5,12}$/;
				//2.3 根据正则表达式进行验证
				if (!pattForPassword.test(password)){
					//2.3.1 验证失败
					$("span.errorMsg").text("密码不合法");
					return false;
				}
				//3 验证第二次输入密码是否和第一次输入的一样
				//3.1 获取第二次输入的密码
				var repassword = $("#repwd").val();
				//3.2 验证两次输入的密码是否一致
				if (!(repassword == password)){
					$("span.errorMsg").text("两次输入的密码不同！");
					return false;
				}
				//4 验证邮箱是否合法
				//4.1 先获取邮箱
				var email = $("#email").val();
				//4.2 创建验证邮箱的正则表达式
				var pattForEmail = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
				//4.3 验证是否合法
				if (!pattForEmail.test(email)){
					$("span.errorMsg").text("邮箱格式不合法");
					return false;
				}
				//5 验证验证码是否合法 在这里仅仅验证是否为空
				//5.1 获取验证码
				var code = $("#code").val();
				//5.2 将获取到的内容的空格全部取消
				code = code.trim();
				if (code == null || code == ""){
					$("span.errorMsg").text("验证码为空!");
					return false;
				}
				//6 所有验证完之后清空 span框 里面的内容
				$("span.errorMsg").text("");
			});
			//给验证码的图片绑定单击事件（每次点击都会刷新）
			$("#code_img").click(function () {
				//this是当前响应时间的dom对象
				//后面的参数是为了防止服务器缓存导致无法刷新图片而加上的时间戳
				this.src = "${basePath}kaptch.jpg?d = " + new Date();
			});
		})
	</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>

			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">${ empty requestScope.msg ?"请输入基本信息":requestScope.msg}</span>

							</div>
							<div class="form">
<!--								将提交信息发送给RegisterServlet中去处理 ,并且为了安全，用post的方式去提交-->
								<form action="userServlet" method="post">
<%--									添加一个隐藏域，用于判断请求信息--%>
									<input type="hidden" name="action" value="register">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username" id="username"
										   value="${requestScope.get("username")}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   autocomplete="off" tabindex="1" name="email" id="email"
											value="${requestScope.get("email")}"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" id="code" name="code" width="100px"/>
									<img alt="" src="kaptch.jpg" style="float: right; margin-right: 40px" width="130px" height="40px" id="code_img">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%-- 页脚--%>
		<%@include file="../common/footer.jsp"%>
</body>
</html>