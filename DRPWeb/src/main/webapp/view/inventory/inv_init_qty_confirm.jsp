<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 设置一个项目路径的变量  -->
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html class="no-js">

<head>
	<meta charset="utf-8">
	<title>分销商库存数量初始化确认</title>
	<link rel="icon" type="image/png" href="${ctx}/i/favicon.png">
	<link rel="apple-touch-icon-precomposed" href="${ctx}/i/app-icon72x72@2x.png">
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
			<dl class="am-icon-home" style="float: left;">当前位置： 分销商库存管理 >分销商库存数量初始化确认
			</dl>
		</div>

		<form class="am-form am-g" id="inventoryForm">
			<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
				<thead>
					<tr class="am-success">
						<th class="table-check"><input type="checkbox" id="check_all" /></th>
						<th>分销商代码</th>
						<th>分销商名称</th>
						<th>物料代码</th>
						<th>物料名称</th>
						<th>规格</th>
						<th>型号</th>
						<th>初始数量</th>
						<th>是否确认</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>

			<div class="am-btn-group am-btn-group-xs">
				<button type="button" onclick="updateIsVerify()" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;">确认</button>
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
		</form>
	</div>
	<script src="${ctx}/js/amazeui.min.js"></script>
	<script type="text/javascript">
		//加载数据
		$(document).ready(function() {
			$.ajax({
				type: "get",
				url: "${ctx}/inventory/findAll.action",
				data: {},
				success: function(data) {
					$("#inventoryForm tbody").empty();
					var inventoryDtoList = eval('(' + data + ')');
					$.each(inventoryDtoList.inventoryDtoList, function(index, inventory) {
						var checkBox = $("<td><input type='checkbox' inventoryId='" + inventory.id + "' class='check_item' /></td>");
						var clientCode = $("<td></td>").append(inventory.clientCode);
						var clientName = $("<td></td>").append(inventory.clientName);
						var itemCode = $("<td></td>").append(inventory.itemCode);
						var itemName = $("<td></td>").append(inventory.itemName);
						var specification = $("<td></td>").append(inventory.specification);
						var modelNum = $("<td></td>").append(inventory.modelNum);
						var initialNum = $("<td></td>").append(inventory.initialNum);
						var isVerify = $("<td></td>").append(inventory.isVerify);
						$("<tr></tr>")
							.append(checkBox)
							.append(clientCode)
							.append(clientName)
							.append(itemCode)
							.append(itemName)
							.append(specification)
							.append(modelNum)
							.append(initialNum)
							.append(isVerify)
							.appendTo("#inventoryForm tbody");
					});
				}
			});
		});

		function updateIsVerify() {
			var ids = "";
			$.each($(".check_item:checked"), function() {
				ids += $(this).parents("tr").find("td:eq(1)").text() + "-";
			});
			ids = ids.substring(0, ids.length - 1);
			$.ajax({
				url: "${ctx}/inventory/updateIsVerify.action",
				data: {
					"ids": ids
				},
				type: "get",
				success: function(e) {
					if(e == 0) {
						alert("请选择")
					} else if(e == 1) {
						alert("只能选择一个")
					} else if(e == 2) {
						alert("请勿重复确认")
					} else {
						alert("确认成功！")
						window.self.location = "${ctx}/view/inventory/inv_init_qty_confirm.jsp";
					}
				}
			});
		}

		/* **********mymessage.jsp页面:完成CheckBox全选和删除*********** */
		$("#check_all").click(function() {
			$(".check_item").prop("checked", $(this).prop("checked"));
		});
		$(document).on("click", ".check_item", function() {
			var flag = $(".check_item:checked").length == $(".check_item").length;
			$("#check_all").prop("checked", flag);
		});
	</script>
</body>

</html>