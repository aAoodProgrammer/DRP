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
			window.open('../inventory/client_select.jsp', '请选择分销商', "height=" + height + ", width=" + width + ",top=" + top + ", left= " + left + ", scrollbars=no");
		}

		function selectItem(index) {
			var width = 1000;
			var height = 600;
			var top = Math.round((window.screen.height - height) / 2);
			var left = Math.round((window.screen.width - width) / 2);
			window.open('../inventory/item_select.jsp', '请选择物料', "height=" + height + ", width=" + width + ",top=" + top + ", left= " + left + ", scrollbars=no");
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
			window.self.location = "${ctx}/view/basicData/item_maint.jsp"
		}
	</script>
</head>

<body>
	<div class="daohang">
	</div>
	<div class="admin-biaogelist">
		<div class="listbiaoti am-cf">
			<dl class="am-icon-home" style="float: left;"> 当前位置：基础数据管理>
				<a href="flow_card_maint.html">物料维护</a>>修改
			</dl>
		</div>

		<form id="updateItemForm" class="am-form am-g">
			<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped" name="tblFlowCardDetail" id="tblFlowCardDetail">
				<thead>
					<tr class="am-success">
						<th>物料代码</th>
						<th>物料名称</th>
						<th>规格</th>
						<th>型号</th>
						<th>类别</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" name="code" id="updateItem_code" value="" /></td>
						<td>
							<input type="text" name="name" id="updateItem_name" value="" />
						</td>
						<td>
							<input type="text" name="specification" id="updateItem_specification" value="" /></td>
						<td class="am-hide-sm-only">
							<input type="text" name="modelNum" id="updateItem_modelNum" value="" /></td>
						<td class="am-hide-sm-only">
							<input type="text" name="simplePhoto" id="updateItem_simplePhoto" value="" /></td>
					</tr>

				</tbody>
			</table>

			<div class="am-btn-group am-btn-group-xs">
				<input type="button" id="update_item_btnSave" value="保存">
				<input name="btnBack" type="button" id="btnBack" onClick="goBack()" value="返回">
			</div>

		</form>

	</div>
	<script src="../../js/amazeui.min.js"></script>
	<script type="text/javascript">
		//加载页面前将数据填写到其中
		$(document).ready(function() {
			$("#update_fiscal").attr("itemId", ${sessionScope.item.id});
			var code = "${sessionScope.item.code}";
			var name = "${sessionScope.item.name}";
			var specification = "${sessionScope.item.specification}";
			var modelNum = "${sessionScope.item.modelNum}";
			var simplePhoto = "${sessionScope.item.simplePhoto}";

			$("#updateItem_code")[0].value = code;
			$("#updateItem_name")[0].value = name;
			$("#updateItem_specification")[0].value = specification;
			$("#updateItem_modelNum")[0].value = modelNum;
			$("#updateItem_simplePhoto")[0].value = simplePhoto;

		});
		
		$("#update_item_btnSave").click(function(){
			$.ajax({
				type:"post",
				url:"${ctx}/updateItem.action",
				data:$("#updateItemForm").serialize(),
				success:function(data){
					goBack();
				}
			});
		});
	</script>
</body>

</html>