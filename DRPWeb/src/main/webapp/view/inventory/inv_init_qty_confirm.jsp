<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 设置一个项目路径的变量  -->
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html class="no-js">

	<head>
		<meta charset="utf-8">
		<title>分销商库存数量初始化确认</title>
		<link rel="icon" type="image/png" href="../../i/favicon.png">
		<link rel="apple-touch-icon-precomposed" href="../../i/app-icon72x72@2x.png">
		<link rel="stylesheet" href="../../css/amazeui.min.css" />
		<link rel="stylesheet" href="../../css/admin.css">
		<script src="../../js/jquery.min.js"></script>
		<script src="../../js/app.js"></script>
	</head>

	<body>

		<div class="daohang">
			<ul>
				<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">首页</button></li>
				<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">帮助中心<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>
				<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">奖金管理<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>
				<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">产品管理<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>
			</ul>

		</div>

		<div class="admin-biaogelist">

			<div class="listbiaoti am-cf">
				<dl class="am-icon-home" style="float: left;">当前位置： 分销商库存管理 >分销商库存数量初始化确认
				</dl>
			</div>

			<form class="am-form am-g">
				<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
					<thead>
						<tr class="am-success">
							<th class="table-check"><input type="checkbox" /></th>
							<th class="table-id">分销商代码</th>
							<th class="table-title">分销商名称</th>
							<th class="table-type">物料代码</th>
							<th class="table-author am-hide-sm-only">物料名称</th>
							<th class="table-author am-hide-sm-only">规格</th>
							<th class="table-date am-hide-sm-only">型号</th>
							<th class="table-date am-hide-sm-only">计量单位</th>
							<th class="table-date am-hide-sm-only">数量</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="checkbox" /></td>
							<td>1001</td>
							<td>北京医药股份有限公司</td>
							<td>2001</td>
							<td>青霉素</td>
							<td>xxxxx</td>
							<td>xxx-aa-dd</td>
							<td>盒</td>
							<td>100</td>
						</tr>
						<tr>
							<td><input type="checkbox" /></td>
							<td>1002</td>
							<td>北京医药股份有限公司</td>
							<td>2001</td>
							<td>青霉素</td>
							<td>xxxxx</td>
							<td>xxx-aa-dd</td>
							<td>盒</td>
							<td>100</td>
						</tr>
					</tbody>
				</table>

				<div class="am-btn-group am-btn-group-xs">
					<button type="button" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;">确认</button>
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
				<p>注：共 xx 页 &nbsp;&nbsp;&nbsp;&nbsp; 当前第 x 页</p>
			</form>
		</div>
		<script src="../../js/amazeui.min.js"></script>
	</body>

</html>