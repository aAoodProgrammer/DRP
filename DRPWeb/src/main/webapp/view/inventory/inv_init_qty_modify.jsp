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
		var rowIndex = 0;

		function choiceClient(index) {
			var width = 1000;
			var height = 600;
			var top = Math.round((window.screen.height - height) / 2);
			var left = Math.round((window.screen.width - width) / 2);
			window.open('client_select.jsp?index=' + index, '请选择分销商', "height=" + height + ", width=" + width + ",top=" + top + ", left= " + left + ", scrollbars=no");
		}

		function selectAimClient(index) {
			var width = 1000;
			var height = 600;
			var top = Math.round((window.screen.height - height) / 2);
			var left = Math.round((window.screen.width - width) / 2);
			window.open('aim_client_select.jsp?index=' + index, '请选择需方客户', "height=" + height + ", width=" + width + ",top=" + top + ", left= " + left + ", scrollbars=no");
		}

		function selectItem(index) {
			var width = 1000;
			var height = 600;
			var top = Math.round((window.screen.height - height) / 2);
			var left = Math.round((window.screen.width - width) / 2);
			window.open('item_select.jsp?index=' + index, '请选择物料', "height=" + height + ", width=" + width + ",top=" + top + ", left= " + left + ", scrollbars=no");
		}

		function DeleteRow(rowTag) {
			//alert(rowTag);
			var i = document.getElementById("tblFlowCardDetail").rows(rowTag).rowIndex;
			var j;
			for(j = i; j <= rowIndex; j++) {
				document.getElementById("tblFlowCardDetail").rows(j).cells(0).all("btnSelectAimClient").index--;
				document.getElementById("tblFlowCardDetail").rows(j).cells(2).all("btnSelectItem").index--;
			}
			//alert(i);
			document.getElementById("tblFlowCardDetail").deleteRow(i);
			rowIndex--;
		}

		function goBack() {
			window.self.location = "${ctx}/view/inventory/inv_init_qty_maint.jsp"
		}
	</script>
</head>

<body>
	<div class="daohang">
		<ul>
			<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs"><a href="index.html">首页</a></button>></li>
			<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">帮助中心<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>
			<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">奖金管理<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>
			<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">产品管理<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>
		</ul>
	</div>
	<div class="admin-biaogelist">
		<div class="listbiaoti am-cf">
			<dl class="am-icon-home" style="float: left;"> 当前位置：分销商库存管理>
				<a href="flow_card_maint.html">分销商库存数量初始化</a>>修改
			</dl>
		</div>

		<form class="am-form am-g">
			<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped" name="tblFlowCardDetail" id="tblFlowCardDetail">
				<thead>
					<tr class="am-success">
						<th>*需方客户代码</th>
						<th>需方客户名称</th>
						<th>*物料代码</th>
						<th>物料名称</th>
						<th>规格</th>
						<th>型号</th>
						<th>计量单位</th>
						<th>*操作数量</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input readonly="true" maxLength=6 size=6 name=aimId value="123" /><input type=button value=... name=btnSelectAimClient onclick="selectAimClient(this.index)" /></td>
						<td><input type="text" value="12312" /></td>
						<td><input readonly="true" maxLength=6 size=6 name=aimId value="312" /><input type=button value=... name=btnSelectAimClient onclick="selectItem(this.index)" /></td>
						<td><input type="text" value="12312" /></td>
						<td><input type="text" value="12312" /></td>
						<td><input type="text" value="12312" /></td>
						<td><input type="text" value="12312" /></td>
						<td><input type="text" value="12312" /></td>
					</tr>
				</tbody>
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