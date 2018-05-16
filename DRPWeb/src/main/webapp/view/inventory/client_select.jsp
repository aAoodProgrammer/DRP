<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 设置一个项目路径的变量  -->
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>

<head>
	<meta charset="utf-8">
	<title>请选择分销商</title>
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
			<dl class="am-icon-home" style="float: left;"> 当前位置：请选择分销商</dl>
		</div>

		<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
			<ul>
				<li>分销商代码/名称:</li>
				<li><input type="text" class="am-form-field am-input-sm am-input-xm" /></li>
				<li><button type="button" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;margin-left: 50px;">搜索</button></li>
			</ul>
		</div>

		<form class="am-form am-g">
			<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
				<thead>
					<tr class="am-success">
						<th class="table-check"><input type="checkbox" id="check_all" /></th>
						<th class="table-id">分销商代码</th>
						<th class="table-title">分销商名称</th>
						<th class="table-type">分销商类型</th>
					</tr>
				</thead>
				<c:forEach items="${sessionScope.clients}" var="client" varStatus="stat">
					<tbody>
						<td><input type="checkbox" class="check_item" /></td>
						<td><input type="hidden" name="id" id="id" value="${client.id}" />${client.code}</td>
						<td>${client.name}</td>
						<td>${client.level.name}</td>
					</tbody>
				</c:forEach>
			</table>

			<div class="am-btn-group am-btn-group-xs">
				<button type="submit" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;" onclick="selectOk()">确定</button>
				<button type="button" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;margin-left: 50px;" onclick="window.close()">关闭</button>
			</div>

		</form>

	</div>
	<script src="${ctx}/js/amazeui.min.js"></script>
	<script language="javascript">
		/* **********mymessage.jsp页面:完成CheckBox全选和删除*********** */
		$("#check_all").click(function() {
			$(".check_item").prop("checked", $(this).prop("checked"));
		});
		$(document).on("click", ".check_item", function() {
			var flag = $(".check_item:checked").length == $(".check_item").length;
			$("#check_all").prop("checked", flag);
		});

		function selectOk() {
			var ids = "";
			var tbody = window.opener.document.getElementById("clientInfo");
			$.each($(".check_item:checked"), function() {
				ids += $('#id').val() + "-";
			});
			ids = ids.substring(0, ids.length - 1);
			$.ajax({
				url: "${ctx}/client/choiceOne.action",
				data: {
					"ids": ids
				},
				type: "get",
				success: function(e) {
					if(e == 0) {
						alert("请选择分销商")
					} else if(e == 1) {
						alert("只能选择一个分销商")
					} else {
						var str = "";
						var data = msg.data;

						for(i in data) {
							str += "<tr>" +
								"<td>" + data[i].hotel_seq + "</td>" +
								"<td>" + data[i].hotel_name + "</td>" +
								"<td>" + data[i].order_no + "</td>" +
								"<td>" + data[i].user_phone + "</td>" +
								"<td>" + data[i].create_time + "</td>" +
								"<td>" + data[i].user_id + "</td>" +
								"<td>" + data[i].cellid + "</td>" +
								"<td>" + data[i].gps_city + "</td>" +
								"<td>" + data[i].cell_city + "</td>" +
								"<td>" + data[i].distance + "</td>" +
								"</tr>";
						}
						tbody.innerHTML = str;
						window.close();
					}
				}
			});

		}
	</script>
</body>

</html>