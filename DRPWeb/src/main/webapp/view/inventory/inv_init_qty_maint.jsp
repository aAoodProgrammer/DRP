<!doctype html>
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

		<script type="text/javascript">
			function choiceClient(index) {
				var width = 1000;
				var height = 600;
				var top = Math.round((window.screen.height - height) / 2);
				var left = Math.round((window.screen.width - width) / 2);
				window.open('client_select.jsp?index=' + index, '请选择需方客户', "height=" + height + ", width=" + width + ",top=" + top + ", left= " + left + ", scrollbars=no");
			}

			function addForCard() {
				window.self.location = "flow_card_add.jsp?id=id";
			}

			function modifyForCard() {
				window.self.location = "flow_card_modify.html?id=id";
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
					<a href="#">分销商库存数量初始化</a>
				</dl>
			</div>
			<form action="" method="post">
				<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
					<ul>
						<li>供方分销商代码:</li>
						<li><input type="text" class="am-form-field am-input-sm am-input-xm" /></li>
						<li>供方分销商名称:</li>
						<li><input type="text" class="am-form-field am-input-sm am-input-xm" /></li>
						<li><button type="button" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;" onclick="choiceClient(this.index)">选择</button></li>
						<li><button type="button" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;margin-left: 100px;">搜索</button></li>
					</ul>
				</div>
				<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
					<ul>
						<li>物料代码:</li>
						<li><input type="text" class="am-form-field am-input-sm am-input-xm" style="margin-left: 48px;"/></li>
						<li>物料名称:</li>
						<li><input type="text" class="am-form-field am-input-sm am-input-xm" style="margin-left: 48px;"/></li>
						<li><button type="button" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;" onclick="choiceClient(this.index)">选择</button></li>
						<li><button type="reset" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;margin-left: 100px;">重置</button></li>
					</ul>
				</div>
			</form>
			<form class="am-form am-g">
				<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
					<thead>
						<tr class="am-success">
							<th class="table-check"><input type="checkbox" /></th>
							<th class="table-id">分销商代码</th>
							<th class="table-id">分销商名称</th>
							<th class="table-title">物料代码</th>
							<th class="table-type">物料名称</th>
							<th class="table-date am-hide-sm-only">规格</th>
							<th class="table-title">型号</th>
							<th class="table-type">计量单位</th>
							<th class="table-type">数量</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="checkbox" /></td>
							<td>${inventory.client.code}</td>
							<td>${inventory.client.name}</td>
							<td>${inventory.item.code}</td>
							<td class="am-hide-sm-only">${inventory.item.name}</td>
							<td class="am-hide-sm-only">${inventory.item.specification}</td>
							<td>${inventory.item.modelNum}</td>
							<td class="am-hide-sm-only">${inventory.item.unitType.name}</td>
							<td class="am-hide-sm-only">${inventory.initialNum}</td>
						</tr>
						<tr>
							<td><input type="checkbox" /></td>
							<td>${inventory.client.code}</td>
							<td>${inventory.client.name}</td>
							<td>${inventory.item.code}</td>
							<td class="am-hide-sm-only">${inventory.item.name}</td>
							<td class="am-hide-sm-only">${inventory.item.specification}</td>
							<td>${inventory.item.modelNum}</td>
							<td class="am-hide-sm-only">${inventory.item.unitType.name}</td>
							<td class="am-hide-sm-only">${inventory.initialNum}</td>
						</tr>
					</tbody>
				</table>

				<div class="am-btn-group am-btn-group-xs">
					<button type="button" class="am-btn am-btn-default" onClick="addForCard()"><span class="am-icon-plus"></span>  新增</button>
					<button type="button" class="am-btn am-btn-default" onClick="deleteForCard()"><span class="am-icon-trash-o"></span> 删除</button>
					<button type="button" class="am-btn am-btn-default" onClick="modifyForCard()"><span class="am-icon-save"></span> 修改</button>
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
				<p>注： 共xx页&nbsp;&nbsp;&nbsp;&nbsp;当前第xx页</p>
			</form>
		</div>
		<script src="../../js/amazeui.min.js"></script>
	</body>

</html>