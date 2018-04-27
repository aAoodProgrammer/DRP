<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 设置一个项目路径的变量  -->
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>

<head>
	<meta charset="utf-8">
	<title>DRP 分销资源计划</title>
	<link rel="icon" type="image/png" href="${ctx}/i/favicon.png">
	<link rel="apple-touch-icon-precomposed" href="${ctx}/i/app-icon72x72@2x.png" type="text/css">
	<link rel="stylesheet" href="${ctx}/css/amazeui.min.css" />
	<link rel="stylesheet" href="${ctx}/css/admin.css">
	<script src="${ctx}/js/jquery.min.js"></script>
	<script src="${ctx}/js/app.js"></script>
	
</head>

<body>
	<div class="daohang">
		<ul>
			<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs"><a href="../right.html" target="main">首页</a></button></li>
			<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">帮助中心<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>
			<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">奖金管理<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>
			<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">产品管理<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>
		</ul>
	</div>
	<div class="admin-biaogelist">
		<div class="listbiaoti am-cf">
			<dl class="am-icon-home" style="float: left;"> 当前位置： 用户管理 >用户维护</dl>
		</div>

		<form class="am-form am-g">
			<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
				<thead>
					<tr class="am-success">
						<th class="table-check"><input type="checkbox" /></th>
						<th>用户代码</th>
						<th>用户名称</th>
						<th>联系电话</th>
						<th>email</th>
						<th>创建日期</th>
					</tr>
				</thead>
				<c:forEach items="${requestScope.users}" var="user" varStatus="stat">
					<tbody>
						<tr>
							<td><input type="checkbox" /></td>
							<td>${user.userCode}</td>
							<td>${user.userName}</td>
							<td>${user.userTel}</td>
							<td>${user.userEmail}</td>
							<td>${user.createDate}</td>
						</tr>
					</tbody>
				</c:forEach>
			</table>

			<div class="am-btn-group am-btn-group-xs">
				<button type="button" class="am-btn am-btn-default" onclick="addUser()"><span class="am-icon-plus"></span>新增</button>
				<button type="button" class="am-btn am-btn-default" onclick="delUser()"><span class="am-icon-trash-o"></span>删除</button>
				<button type="button" class="am-btn am-btn-default" onclick="updateUser()"><span class="am-icon-save"></span>修改</button>
			</div>

			<ul class="am-pagination am-fr">
				<li class="am-disabled">
					<a href="#">«</a>
				</li>
				<li class="am-active">
					<a href="#">1</a>
				</li>
				<li>
					<a href="#">2</a>
				</li>
				<li>
					<a href="#">3</a>
				</li>
				<li>
					<a href="#">4</a>
				</li>
				<li>
					<a href="#">5</a>
				</li>
				<li>
					<a href="#">»</a>
				</li>
			</ul>

			<hr />
			<p>注： 共 页 当前第 页</p>
		</form>

	</div>
	<script src="${ctx}/js/amazeui.min.js"></script>
	<script>
		function addUser() {
			window.self.location = "${ctx}/view/systemManager/user_add.jsp";
		}

		function updateUser() {
			
			window.self.location = "${ctx}/view/systemManager/user_modify.jsp";
		}
		
		function updateUser() {
			
		}
	</script>
</body>

</html>