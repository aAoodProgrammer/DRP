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
			function choiceClient(index) {
				var width = 1000;
				var height = 600;
				var top = Math.round((window.screen.height - height) / 2);
				var left = Math.round((window.screen.width - width) / 2);
				window.open('client_select.jsp?index=' + index, '请选择分销商', "height=" + height + ", width=" + width + ",top=" + top + ", left= " + left + ", scrollbars=no");
			}
		</script>
	</head>

	<body>
		<div class="daohang">
	</div>
		<div class="admin-biaogelist">
			<div class="listbiaoti am-cf">
				<dl class="am-icon-home" style="float: left;"> 当前位置： 分销商库存管理 >流向单复审
				</dl>
			</div>

			<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
				<ul>
					<form action="" method="post">

						<li style="margin-right: 0;">
							<span class="tubiao am-icon-calendar"></span>
							<input type="text" class="am-form-field am-input-sm am-input-zm  am-icon-calendar" placeholder="开始日期" data-am-datepicker="{theme: 'success',}" readonly/>
						</li>
						<li style="margin-left: -4px;">
							<span class="tubiao am-icon-calendar"></span>
							<input type="text" class="am-form-field am-input-sm am-input-zm  am-icon-calendar" placeholder="开始日期" data-am-datepicker="{theme: 'success',}" readonly/>
						</li>
						<li>供方分销商代码:</li>
						<li><input type="text" class="am-form-field am-input-sm am-input-xm" /></li>
						<li>供方分销商名称:</li>
						<li><input type="text" class="am-form-field am-input-sm am-input-xm" /></li>
						<li><button type="button" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;" onclick="choiceClient()">选择</button></li>
						<li><button type="button" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;margin-left: 50px;">搜索</button></li>
						<li><button type="reset" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;">重置</button></li>
					</form>
				</ul>
			</div>

			<form class="am-form am-g">
				<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
					<thead>
						<tr class="am-success">
							<th class="table-check"><input type="checkbox" /></th>
							<th class="table-id">流向单号</th>
							<th class="table-id">供方分销商代码</th>
							<th class="table-title">供方分销商名称</th>
							<th class="table-type">录入人</th>
							<th class="table-date am-hide-sm-only">录入日期</th>
							<th class="table-id">单据状态</th>
							<th class="table-id">抽查标志</th>
							<th class="table-title">抽查人</th>
							<th class="table-type">抽查结果描述</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="checkbox" /></td>
							<td>200706260001</td>
							<td>1001</td>
							<td>北京医药股份有限公司</td>
							<td>张三</td>
							<td>2014年9月4日 7:28:47</td>
							<td>审核</td>
							<td>抽查</td>
							<td>xxxx</td>
							<td>xxxx</td>
						</tr>
						<tr>
							<td><input type="checkbox" /></td>
							<td>200706260001</td>
							<td>1002</td>
							<td>北京医药股份有限公司</td>
							<td>李四</td>
							<td>2014年9月4日 7:28:47</td>
							<td>审核</td>
							<td>抽查</td>
							<td>xxxx</td>
							<td>xxxx</td>
						</tr>
					</tbody>
				</table>

				<div class="am-btn-group am-btn-group-xs">
					<button type="button" class="am-btn am-btn-default"> 复审</button>
					<button type="button" class="am-btn am-btn-default"> 驳回</button>
				</div>

			</form>
		</div>
		<script src="../../js/amazeui.min.js"></script>
	</body>

</html>