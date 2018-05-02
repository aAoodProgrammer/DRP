<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 设置一个项目路径的变量  -->
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>

<head>
	<meta charset="UTF-8">
	<title>DRP 分销资源计划</title>
	<link rel="icon" type="image/png" href="../i/favicon.png">
	<link rel="apple-touch-icon-precomposed" href="../i/app-icon72x72@2x.png" type="text/css">
	<link rel="stylesheet" href="../css/amazeui.min.css" />
	<link rel="stylesheet" href="../css/admin.css">
	<script src="../js/jquery.min.js"></script>
	<script src="../js/app.js"></script>

</head>

<body>
	<header class="am-topbar admin-header">
		<div class="am-topbar-brand"><img src="../i/logo.png"></div>

		<div class="am-collapse am-topbar-collapse" id="topbar-collapse">
			<ul class="am-nav am-nav-pills am-topbar-nav admin-header-list">
				<li class="kuanjie">
					<a href="#">欢迎!${sessionScope.userName}</a>
					<a href="systemManager/password_modify.jsp" target="main">修改密码</a>
					<a href="index.jsp" target="_blank">退出</a>
				</li>
			</ul>
		</div>
	</header>
	<script src="../js/amazeui.min.js"></script>
</body>

</html>