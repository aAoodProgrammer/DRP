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
			<dl class="am-icon-home" style="float: left;"> 当前位置： 用户管理 >用户维护</dl>
		</div>

		<form class="am-form am-g" id="userForm">
			<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
				<thead>
					<tr class="am-success">
						<th class="table-check"><input type="checkbox" id="check_all" /></th>
						<th>用户代码</th>
						<th>用户名称</th>
						<th>联系电话</th>
						<th>email</th>
						<th>创建日期</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>

			<div class="am-btn-group am-btn-group-xs">
				<button type="button" class="am-btn am-btn-default" onclick="addUser()"><span class="am-icon-plus"></span>新增</button>
				<button type="button" class="am-btn am-btn-default" id="deleteUser"><span class="am-icon-trash-o"></span>删除</button>
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
			<p>注： 共5页 当前第1页</p>
		</form>

	</div>
	<script src="${ctx}/js/amazeui.min.js"></script>
	<script>
		//加载数据
		$(document).ready(function() {
			$.ajax({
				type: "get",
				url: "${ctx}/findAll.action",
				data: {},
				success: function(data) {
					$("#userForm tbody").empty();
					var userDtoList = eval('(' + data + ')');
					$.each(userDtoList.userDtoList, function(index, user) {
						var checkBox = $("<td><input type='checkbox' userId='" + user.id + "' class='check_item' /></td>");
						var userCode = $("<td></td>").append(user.userCode);
						var userName = $("<td></td>").append(user.userName);
						var userTel = $("<td></td>").append(user.userTel);
						var userEmail = $("<td></td>").append(user.userEmail);
						var createTime = $("<td></td>").append(user.createTime);
						$("<tr></tr>")
							.append(checkBox)
							.append(userCode)
							.append(userName)
							.append(userTel)
							.append(userEmail)
							.append(createTime)
							.appendTo("#userForm tbody");
					});
				}
			});
		});

		function addUser() {
			window.self.location = "${ctx}/view/systemManager/user_add.jsp";
		}

		function updateUser() {
			var ids = "";
			$.each($(".check_item:checked"), function() {
				ids += $(this).attr("userId") + "-";
			});
			ids = ids.substring(0, ids.length - 1);
			$.ajax({
				url: "${ctx}/user_findOne.action",
				data: {
					"ids": ids
				},
				type: "get",
				success: function(e) {
					if(e == 0) {
						alert("请选择用户")
					} else if(e == 1) {
						alert("只能选择一个用户")
					} else {
						window.self.location = "${ctx}/view/systemManager/user_modify.jsp";
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

		//批量删除
		$("#deleteUser").click(function() {
			var ids = "";
			var userNames = "";
			$.each($(".check_item:checked"), function() {
				userNames += $(this).parents("tr").find("td:eq(2)").text() + "-";
				ids += $(this).attr("userId") + "-";
			});
			//去除多余的横线
			userNames = userNames.substring(0, userNames.length - 1);
			ids = ids.substring(0, ids.length - 1);
			if(ids.length == 0) {
				alert("请选择需要删除的用户");
			}
			if(confirm("确定删除用户？\n" + userNames)) {
				$.ajax({
					url: "${ctx}/deleteUser.action",
					data: {
						"ids": ids
					},
					type: "post",
					success: function(e) {
						alert("删除成功！");
						window.location.href = "${ctx}/view/systemManager/user_maint.jsp"
					}
				});
			}
		});
	</script>
</body>

</html>