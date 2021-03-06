<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 设置一个项目路径的变量  -->
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>

<head>
	<meta charset="utf-8">
	<title>DRP 分销资源计划</title>
	<link rel="icon" type="image/png" href="../../i/favicon.png">
	<link rel="apple-touch-icon-precomposed" href="../../i/app-icon72x72@2x.png" type="text/css">
	<link rel="stylesheet" href="../../css/amazeui.min.css" />
	<link rel="stylesheet" href="../../css/admin.css">
	<script src="../../js/jquery.min.js"></script>
	<script src="../../js/app.js"></script>

	<script language="javascript">
		function goBack() {
			window.self.location = "${ctx}/view/systemManager/user_maint.jsp"
		}
	</script>
</head>

<body>
	<div class="daohang">
	</div>
	<div class="admin-biaogelist">
		<div class="listbiaoti am-cf">
			<dl class="am-icon-home" style="float: left;"> 当前位置：用户管理>
				<a href="user_maint.jsp">用户维护</a>>修改密码
			</dl>
		</div>

		<form class="am-form am-g" style="width: 20%;">
			<table width="500px" class="am-table am-table-bordered am-table-radius am-table-striped" name="tblFlowCardDetail" id="tblFlowCardDetail">
				<thead>
					<tr class="am-success">
						<th>原密码</th>
						<td style="width: 50%;"><input type="text" name="id" /></td>
					</tr>
					<tr class="am-success">
						<th>新密码</th>
						<td style="width: 50%;"><input type="text" name="id" /></td>
					</tr>
					<tr class="am-success">
						<th>确认密码</th>
						<td style="width: 50%;"><input type="text" name="id" /></td>
					</tr>
				</thead>
			</table>

			<div class="am-btn-group am-btn-group-xs">
				<input name="btnSave" type="submit" id="btnSave" value="保存">
				<input name="btnBack" type="button" id="btnBack" onClick="goBack()" value="返回">
			</div>

		</form>

	</div>
	<script src="../../js/amazeui.min.js"></script>
</body>

</html>