<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 设置一个项目路径的变量  -->
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>

<head>
	<title>登录页面</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<link href="${ctx}/css/default.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/styles.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/demo.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/loaders.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${ctx}/css/font-awesome.min.css" rel="stylesheet">
	<link href="${ctx}/css/owl.carousel.css" rel="stylesheet">
	<link href="${ctx}/css/magnific-popup.css" rel="stylesheet">
	<link href="${ctx}/css/animate.min.css" rel="stylesheet">
	<link href="${ctx}/css/style.css" rel="stylesheet">
	<link href="${ctx}/css/responsive.css" rel="stylesheet">
	<link href="${ctx}/layui/css/layui.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src='${ctx}/js/stopExecutionOnTimeout.js?t=1'></script>
	<script type="text/javascript" src="${ctx}/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx}/js/Particleground.js"></script>
	<script type="text/javascript" src="${ctx}/js/Treatment.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery.mockjax.js"></script>
	<script type="text/javascript" src="${ctx}/js/plugins.js"></script>
	<script type="text/javascript" src="${ctx}/js/magnific-popup-options.js"></script>
	<script type="text/javascript" src="${ctx}/js/validator.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/particles.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/app.js"></script>
	<script type="text/javascript" src="${ctx}/js/wow-1.3.0.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/main.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery-2.1.4.min.js"></script>
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
				<form action="${ctx}/login.action" id="loginForm" method="post">
					<div class='login_fields'>
						<div class='login_fields__user'>
							<div class='icon'>
								<img alt="" src='${ctx}/images/user_icon_copy.png'>
							</div>
							<input name="userName" id="userName" placeholder='用户名' maxlength="16" type='text' autocomplete="off" />
							<div class='validation'>
								<img alt="" src='${ctx}/images/tick.png'>
							</div>
						</div>
						<div class='login_fields__password'>
							<div class='icon'>
								<img alt="" src='${ctx}/images/lock_icon_copy.png'>
							</div>
							<input name="password" id="password" placeholder='密码' maxlength="16" type='password' autocomplete="off">
							<div class='validation'>
								<img alt="" src='${ctx}/images/tick.png'>
							</div>
						</div>
						<div class='login_fields__submit'>
							<input type='submit' id="login_btn" value='登录'>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>