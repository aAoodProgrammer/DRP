<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 设置一个项目路径的变量  -->
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<title>登录界面</title>

	<link href="${ctx}/css/styles.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/demo.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${ctx}/css/style.css" rel="stylesheet">

	<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src='${ctx}/js/stopExecutionOnTimeout.js?t=1'></script>
	<script type="text/javascript" src="${ctx}/js/Particleground.js"></script>
	<script type="text/javascript" src="${ctx}/js/Treatment.js"></script>
	<script type="text/javascript">
		$(function() {
					$("#login_btn").click(function() {
						alert("---------login_btn-----------");
						var flag = false;
						var userName = $("#userName").val();
						alert(userName);
						if(!userName.length > 0) {
							flag = true;
							$("#userIdSpan").html("<font color='red'>用户代码不能为空</font>");
						}
						var pwd = $("#password").val();
						alert(pwd);
						if(!pwd.length > 0) {
							flag = true;
							$("#passwordSpan").html("<font color='red'>密码不能为空</font>");
						}
						if(!flag) {
							$("#loginForm").submit();
						}
					});
				}
	</script>
</head>

<body>

	<div class="preloader">
		<div class="spinner">
			<div class="double-bounce1"></div>
			<div class="double-bounce2"></div>
		</div>
	</div>

	<div id="home" class="intro-section">
		<div class="welcome-area">
			<div id="particles-js"></div>

			<div class='login'>
				<div class='login_title'>
					<span>管理员登录</span>
				</div>
				<div class='login_fields'>
					<form action="${ctx}/login.action" id="loginForm" method="post">
						<div class='login_fields__user'>
							<input name="userName" id='userName' maxlength="16" type='text' autocomplete="off" placeholder="账号" />
						</div>
						<div class='login_fields__password'>
							<input type="password" name="password" id="password" placeholder='密码' maxlength="16" type='text' autocomplete="off">
						</div>
						<div class='login_fields__submit'>
							<input type='submit' id="login_btn" value='登录'>
						</div>
					</form>
				</div>
			</div>

			<div class="OverWindows"></div>
			<!--==== plugins js ====-->
			<script src="${ctx}/js/plugins.js"></script>
			<!--==== magnific-popup-options js ====-->
			<script src="${ctx}/js/magnific-popup-options.js"></script>
			<!--==== validator js ====-->
			<script src="${ctx}/js/validator.min.js"></script>
			<!--==== particles js ====-->
			<script src="${ctx}/js/particles.min.js"></script>
			<!--==== app js ====-->
			<script src="${ctx}/js/app.js"></script>
			<!--==== app js ====-->
			<script src="${ctx}/js/wow-1.3.0.min.js"></script>
			<!--==== main js ====-->
			<script src="${ctx}/js/main.js"></script>
		</div>
	</div>
</body>

</html>