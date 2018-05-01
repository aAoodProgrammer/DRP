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
				<dl class="am-icon-home" style="float: left;"> 当前位置： 分销商库存管理 >
					<a href="#">盘点结果维护</a>
				</dl>
			</div>

			<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
				<ul>
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
					<li><button type="button" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;">选择</button></li>
					<li>供方分销商名称:</li>
					<li><input type="text" class="am-form-field am-input-sm am-input-xm" placeholder="供方分销商名称" /></li>
					<li><button type="button" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;margin-left: 50px;">搜索</button></li>
					<li><button type="button" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;">重置</button></li>
				</ul>
			</div>

			<form class="am-form am-g">
				<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
					<thead>
						<tr class="am-success">
							<th class="table-check"><input type="checkbox" /></th>
							<th class="table-id">单号</th>
							<th class="table-id">分销商代码</th>
							<th class="table-title">分销商名称</th>
							<th class="table-type">录入人</th>
							<th class="table-date am-hide-sm-only">录入日期</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="checkbox" /></td>
							<td>14</td>
							<td>
								<a href="#">Business management</a>
							</td>
							<td>default</td>
							<td class="am-hide-sm-only">张三</td>
							<td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
						</tr>
						<tr>
							<td><input type="checkbox" /></td>
							<td>15</td>
							<td>
								<a href="#">Business management</a>
							</td>
							<td>default</td>
							<td class="am-hide-sm-only">李四</i>
							</td>
							<td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
						</tr>
					</tbody>
				</table>

				<div class="am-btn-group am-btn-group-xs">
					<button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 新增</button>
					<button type="button" class="am-btn am-btn-default"><span class="am-icon-trash-o"></span> 删除</button>
					<button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 修改</button>
					<button type="button" class="am-btn am-btn-default"><span class="am-icon-archive"></span> 送审</button>
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
				<p>注：
 共  页      当前第    页</p>
			</form>

			<div class="foods">
				<ul>
					版权所有@2015. 模板收集自
					<a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - More Templates
					<a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
				</ul>
				<dl>
					<a href="" title="返回头部" class="am-icon-btn am-icon-arrow-up"></a>
				</dl>
			</div>
		</div>
		<script src="../../js/amazeui.min.js"></script>
	</body>

</html>