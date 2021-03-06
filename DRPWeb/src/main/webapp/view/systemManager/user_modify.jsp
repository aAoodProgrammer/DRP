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
	</div>
	<div class="admin-biaogelist">
		<div class="listbiaoti am-cf">
			<dl class="am-icon-home" style="float: left;"> 当前位置：用户管理>
				<a href="flow_card_maint.html">用户维护</a>>修改
			</dl>
		</div>

		<form class="am-form am-g" id="myForm">
			<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped" name="tblFlowCardDetail" id="tblFlowCardDetail">
				<thead>
					<tr class="am-success">
						<th>用户代码</th>
						<th>用户名称</th>
						<th>联系电话</th>
						<th>邮箱</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="hidden" name="uId" value="${sessionScope.userDto.id}" /><input type="text" name="userCode" value="${sessionScope.userDto.userCode}" /></td>
						<td><input type="text" name="userName" value="${sessionScope.userDto.userName}" /></td>
						<td><input type="text" name="userTel" value="${sessionScope.userDto.userTel}" /></td>
						<td><input type="text" name="userEmail" value="${sessionScope.userDto.userEmail}" /></td>
					</tr>
				</tbody>
			</table>

			<div class="am-btn-group am-btn-group-xs">
				<input name="btnSave" type="button" id="btnSave" value="保存">
				<input name="btnBack" type="button" id="btnBack" onClick="goBack()" value="返回">
			</div>

		</form>

	</div>
	<script src="${ctx}/js/amazeui.min.js"></script>
	<script language="javascript">
		function goBack() {
			window.self.location = "${ctx}/view/systemManager/user_maint.jsp"
		}
		$('#btnSave').click(
			function() {
				$.ajax({
					type: "POST",
					url: "${ctx}/update.action",
					data: $("#myForm").serializeArray(),
					success: function(data) { //成功
						window.location.href = "${ctx}/view/systemManager/user_maint.jsp"
					}
				})
			});
	</script>
</body>

</html>