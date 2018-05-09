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
			<dl class="am-icon-home" style="float: left;"> 当前位置：分销商库存管理>
				<a href="flow_card_maint.html">流向单审核</a>>调整
			</dl>
		</div>

		<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
			<ul>
				<li>流向单号:</li>
				<li>200706260001</li>
				<li style="margin-left: 180px;">供方分销商代码:</li>
				<li>1001</li>
				<li style="margin-left: 200px;">供方分销商名称:</li>
				<li>北京医药有限公司</li>
				<li style="margin-left: 105px;">入库日期:</li>
				<li>2007-06-15</li>
			</ul>
		</div>

		<form class="am-form am-g">
			<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped" name="tblFlowCardDetail" id="tblFlowCardDetail">
				<thead>
					<tr class="am-success">
						<th>需方客户代码</th>
						<th>物料代码</th>
						<th>数量</th>
						<th>调整原因</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<input type="hidden" name="id" id="id" value="${sessionScope.flowCardDto1.id}" />
						<td><input type="text" name="clientCode" id="clientCode" value="${sessionScope.flowCardDto1.clientCode}" /></td>
						<td><input type="text" name="itemCode" id="itemCode" value="${sessionScope.flowCardDto1.itemCode}" /></td>
						<td><input type="text" name="initialNum" id="initialNum" value="${sessionScope.flowCardDto1.initialNum}" /></td>
						<td><input type="text" name="adjustReason" id="adjustReason" value="${sessionScope.flowCardDto1.adjustReason}" /></td>
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
			window.self.location = "${ctx}/view/inventory/flow_card_audit.jsp";
		}

		$('#btnSave').click(function() {
			$.ajax({
				type: "POST",
				url: "${ctx}/flowCard/modify.action",
				data: {
					"id": $('#id').val(),
					"clientCode": $('#clientCode').val(),
					"itemCode": $('#itemCode').val(),
					"initialNum": $('#initialNum').val(),
					"adjustReason": $('#adjustReason').val()
				},
				success: function(data) { //成功
					window.location.href = "${ctx}/view/inventory/flow_card_audit.jsp";
				}
			})
		});
	</script>
</body>

</html>