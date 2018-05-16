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
			<dl class="am-icon-home" style="float: left;"> 当前位置：分销商库存管理>流向单维护
			</dl>
		</div>

		<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
			<ul>
				<form id="searchForm">
					<li style="margin-right: 0;">
						<span class="tubiao am-icon-calendar"></span>
						<input type="text" class="am-form-field am-input-sm am-input-zm  am-icon-calendar" id="beginDate" placeholder="开始日期" data-am-datepicker="{theme: 'success',}" readonly/>
					</li>
					<li style="margin-left: -4px;">
						<span class="tubiao am-icon-calendar"></span>
						<input type="text" class="am-form-field am-input-sm am-input-zm  am-icon-calendar" id="endDate" placeholder="结束日期" data-am-datepicker="{theme: 'success',}" readonly/>
					</li>
					<li>供方分销商代码:</li>
					<li><input type="text" class="am-form-field am-input-sm am-input-xm" id="clientCode" /></li>
					<li><button type="button" onclick="search()" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;margin-left: 50px;">搜索</button></li>
					<li><button type="reset" onclick="resetValue()" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;">重置</button></li>
				</form>
			</ul>
		</div>

		<form class="am-form am-g" id="flowCardForm">
			<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
				<thead>
					<tr class="am-success">
						<th class="table-check"><input type="checkbox" id="check_all" /></th>
						<th>流向单号</th>
						<th>供方分销商代码</th>
						<th>供方分销商名称</th>
						<th>录入人</th>
						<th>录入日期</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>

			<div class="am-btn-group am-btn-group-xs">
				<button type="button" class="am-btn am-btn-default" onClick="addForCard()"><span class="am-icon-plus"></span>新增</button>
				<button type="button" class="am-btn am-btn-default" onClick="deleteForCard()"><span class="am-icon-trash-o"></span>删除</button>
				<button type="button" class="am-btn am-btn-default" onClick="modifyForCard()"><span class="am-icon-save"></span>修改</button>
				<button type="button" class="am-btn am-btn-default" onClick="submitForCensorship()"><span class="am-icon-archive"></span>送审</button>
			</div>

		</form>

	</div>
	<script src="${ctx}/js/amazeui.min.js"></script>
	<script type="text/javascript">
		function resetValue() {
			$.ajax({
				type: "get",
				url: "${ctx}/flowCard/findAll.action",
				data: {},
				success: function(data) {
					$("#flowCardForm tbody").empty();
					var flowCardDtoList = eval('(' + data + ')');
					$.each(flowCardDtoList.flowCardDtoList, function(index, flowCard) {
						var checkBox = $("<td><input type='checkbox' flowCardId='" + flowCard.id + "' class='check_item' /></td>");
						var flowCardNum = $("<td></td>").append(flowCard.flowCardNum);
						var clientCode = $("<td></td>").append(flowCard.clientCode);
						var clientName = $("<td></td>").append(flowCard.clientName);
						var recoederName = $("<td></td>").append(flowCard.recoederName);
						var recoedDate = $("<td></td>").append(flowCard.recoedDate);
						$("<tr></tr>")
							.append(checkBox)
							.append(flowCardNum)
							.append(clientCode)
							.append(clientName)
							.append(recoederName)
							.append(recoedDate)
							.appendTo("#flowCardForm tbody");
					});
				}
			});
		}

		//加载数据
		$(document).ready(function() {
			$.ajax({
				type: "get",
				url: "${ctx}/flowCard/findAll.action",
				data: {},
				success: function(data) {
					$("#flowCardForm tbody").empty();
					var flowCardDtoList = eval('(' + data + ')');
					$.each(flowCardDtoList.flowCardDtoList, function(index, flowCard) {
						var checkBox = $("<td><input type='checkbox' flowCardId='" + flowCard.id + "' class='check_item' /></td>");
						var flowCardNum = $("<td></td>").append(flowCard.flowCardNum);
						var clientCode = $("<td></td>").append(flowCard.clientCode);
						var clientName = $("<td></td>").append(flowCard.clientName);
						var recoederName = $("<td></td>").append(flowCard.recoederName);
						var recoedDate = $("<td></td>").append(flowCard.recoedDate);
						$("<tr></tr>")
							.append(checkBox)
							.append(flowCardNum)
							.append(clientCode)
							.append(clientName)
							.append(recoederName)
							.append(recoedDate)
							.appendTo("#flowCardForm tbody");
					});
				}
			});
		});

		function search() {
			$.ajax({
				type: "get",
				url: "${ctx}/flowCard/search.action",
				data: {
					"beginDate": $('#beginDate').val(),
					"endDate": $('#endDate').val(),
					"clientCode": $('#clientCode').val()
				},
				success: function(data) {
					$("#flowCardForm tbody").empty();
					var flowCardDtoList = eval('(' + data + ')');
					$.each(flowCardDtoList.flowCardDtoList, function(index, flowCard) {
						var checkBox = $("<td><input type='checkbox' flowCardId='" + flowCard.id + "' class='check_item' /></td>");
						var flowCardNum = $("<td></td>").append(flowCard.flowCardNum);
						var clientCode = $("<td></td>").append(flowCard.clientCode);
						var clientName = $("<td></td>").append(flowCard.clientName);
						var recoederName = $("<td></td>").append(flowCard.recoederName);
						var recoedDate = $("<td></td>").append(flowCard.recoedDate);
						$("<tr></tr>")
							.append(checkBox)
							.append(flowCardNum)
							.append(clientCode)
							.append(clientName)
							.append(recoederName)
							.append(recoedDate)
							.appendTo("#flowCardForm tbody");
					});
				}
			})
		}

		function addForCard() {
			window.self.location = "${ctx}/view/inventory/flow_card_add.jsp";
		}

		function modifyForCard() {
			var ids = "";
			$.each($(".check_item:checked"), function() {
				ids += $(this).attr("flowCardId") + "-";
			});
			ids = ids.substring(0, ids.length - 1);
			$.ajax({
				url: "${ctx}/flowCard/findOne.action",
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
						window.self.location = "${ctx}/view/inventory/flow_card_modify.jsp";
					}
				}
			});
		}

		function submitForCensorship() {
			var ids = "";
			$.each($(".check_item:checked"), function() {
				ids += $(this).attr("flowCardId") + "-";
			});
			ids = ids.substring(0, ids.length - 1);
			$.ajax({
				url: "${ctx}/flowCard/submitForCensorship.action",
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
						alert("送审成功！")
						window.self.location = "${ctx}/view/inventory/flow_card_maint.jsp";
					}
				}
			});
		}

		//批量删除
		function deleteForCard() {
			var ids = "";
			$.each($(".check_item:checked"), function() {
				ids += $(this).attr("flowCardId") + "-";
			});
			//去除多余的横线
			ids = ids.substring(0, ids.length - 1);
			if(ids.length == 0) {
				alert("请选择");
			} else if(confirm("确定删除？")) {
				$.ajax({
					url: "${ctx}/flowCard/delete.action",
					data: {
						"ids": ids
					},
					type: "post",
					success: function(e) {
						alert("删除成功！");
						window.location.href = "${ctx}/view/inventory/flow_card_maint.jsp"
					}
				});
			}
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