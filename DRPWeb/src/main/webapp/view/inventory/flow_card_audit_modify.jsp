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
				window.self.location = "flow_card_audit.html";
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
							<th class="table-id">需方客户代码</th>
							<th class="table-id">需方客户名称</th>
							<th class="table-title">物料代码</th>
							<th class="table-type">物料名称</th>
							<th class="table-type">规格</th>
							<th class="table-type">型号</th>
							<th class="table-id">计量单位</th>
							<th class="table-title">数量</th>
							<th class="table-type">*调整原因</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" name="id" value="14" /></td>
							<td><input type="text" name="id" value="Business managementas" /></td>
							<td><input type="text" name="id" value="default" /></td>
							<td><input type="text" name="id" value="张三" /></td>
							<td><input type="text" name="id" value="2014年9月4日 7:28:47" /></td>
							<td><input type="text" name="id" value="14" /></td>
							<td><input type="text" name="id" value="Business managementas" /></td>
							<td><input type="text" name="id" value="default" /></td>
							<td><input type="text" name="id" value="" /></td>
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
				<p>注： 共5页 当前第1页</p>
			</form>
		</div>
		<script src="../../js/amazeui.min.js"></script>
	</body>

</html>