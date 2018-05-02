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
			<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs"><a href="index.html">首页</a></button></li>
			<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">帮助中心<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>
			<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">奖金管理<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>
			<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">产品管理<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>
		</ul>
	</div>
	<div class="admin-biaogelist">
		<div class="listbiaoti am-cf">
			<dl class="am-icon-home" style="float: left;"> 当前位置：分销商库存管理>分销商库存数量初始化
			</dl>
		</div>
		<form action="" method="post">
			<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf" id="clientInfo">
				<ul>
					<li>供方分销商代码:</li>
					<li><input type="text" class="am-form-field am-input-sm am-input-xm" value="${sessionScope.client.code}" /></li>
					<li><button type="button" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;margin-left: 100px;">搜索</button></li>
				</ul>
				<ul>
					<li>物料代码:</li>
					<li><input type="text" class="am-form-field am-input-sm am-input-xm" style="margin-left: 48px;" /></li>
					<li><button type="reset" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;margin-left: 100px;">重置</button></li>
				</ul>
			</div>
		</form>
		<form class="am-form am-g">
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

				<c:forEach items="${requestScope.inventoryDtos}" var="inventory" varStatus="stat">
					<tbody>
						<tr>
							<td><input type="checkbox" class="check_item" /></td>
							<td style="display: none;">${inventory.id}</td>
							<td>${inventory.clientCode}</td>
							<td>${inventory.clientName}</td>
							<td>${inventory.itemCode}</td>
							<td>${inventory.itemName}</td>
							<td>${inventory.specification}</td>
							<td>${inventory.modelNum}</td>
							<td>${inventory.initialNum}</td>
							<td>${inventory.isVerify}</td>
						</tr>
					</tbody>
				</c:forEach>
			</table>

			<div class="am-btn-group am-btn-group-xs">
				<button type="button" class="am-btn am-btn-default" onClick="addInventory()"><span class="am-icon-plus"></span>新增</button>
				<button type="button" class="am-btn am-btn-default" id="deleteInventory"><span class="am-icon-trash-o"></span>删除</button>
				<button type="button" class="am-btn am-btn-default" onClick="updateInventory()"><span class="am-icon-save"></span>修改</button>
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
			<p>注： 共5页&nbsp;&nbsp;&nbsp;&nbsp;当前第1页</p>
		</form>
	</div>
	<script src="${ctx}/js/amazeui.min.js"></script>
	<script type="text/javascript">
		function addInventory() {
			window.self.location = "${ctx}/view/inventory/inv_init_qty_add.jsp";
		}

		function updateInventory() {
			var ids = "";
			$.each($(".check_item:checked"), function() {
				ids += $(this).parents("tr").find("td:eq(1)").text() + "-";
			});
			ids = ids.substring(0, ids.length - 1);
			$.ajax({
				url: "${ctx}/inventory/findOne.action",
				data: {
					"ids": ids
				},
				type: "get",
				success: function(e) {
					if(e == 0) {
						alert("请选择")
					} else if(e == 1) {
						alert("只能选择一个")
					} else {
						console.log(e);
						window.self.location = "${ctx}/view/inventory/inv_init_qty_modify.jsp";
					}
				}
			});
		}

		//批量删除
		$("#deleteInventory").click(function() {
			var ids = "";
			$.each($(".check_item:checked"), function() {
				ids += $(this).parents("tr").find("td:eq(1)").text() + "-";
			});
			//去除多余的横线
			ids = ids.substring(0, ids.length - 1);
			if(ids.length == 0) {
				alert("请选择");
			} else if(confirm("确定删除？")) {
				$.ajax({
					url: "${ctx}/inventory/deleteInventory.action",
					data: {
						"ids": ids
					},
					type: "post",
					success: function(e) {
						alert("删除成功！");
						window.location.href = "${ctx}/inventory/inv_init_qty_maint.action"
					}
				});
			}
		});

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