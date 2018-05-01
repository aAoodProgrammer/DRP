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
				window.self.location = "${ctx}/view/inventory/flow_card_maint.jsp"
			}
		</script>
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
				<dl class="am-icon-home" style="float: left;"> 当前位置：分销商库存管理>
					<a href="flow_card_maint.html">流向单维护</a>>修改
				</dl>
			</div>

			<form class="am-form am-g">
				<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped" name="tblFlowCardDetail" id="tblFlowCardDetail">
					<thead>
						<tr class="am-success">
							<th class="table-id">流向单号</th>
							<th class="table-id">供方分销商代码</th>
							<th class="table-title">供方分销商名称</th>
							<th class="table-type">录入人</th>
							<th class="table-type">录入日期</th>
							<th class="table-type">删除</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" name="id" value="14" /></td>
							<td><input type="text" name="id" value="Business managementas" /></td>
							<td><input type="text" name="id" value="default" /></td>
							<td><input type="text" name="id" value="张三" /></td>
							<td><input type="text" name="id" value="2014年9月4日 7:28:47" /></td>
							<td><input type='button' value='删除' id=btnDeleteLine name=btnDeleteLine onclick="return DeleteRow(row + rowIndex )" style="margin-top: 5px;"></td>
						</tr>

					</tbody>
				</table>

				<div class="am-btn-group am-btn-group-xs">
					<input name="btnSave" type="submit" id="btnSave" value="保存">
					<input name="btnBack" type="button" id="btnBack" onClick="goBack()" value="返回">
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
				<p>注：共5页 &nbsp;&nbsp;&nbsp;&nbsp;当前第1页</p>
			</form>
		</div>
		<script src="../../js/amazeui.min.js"></script>
	</body>

</html>