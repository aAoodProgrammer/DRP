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
			<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs"><a href="index.html">首页</a></button>></li>
			<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">帮助中心<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>
			<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">奖金管理<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>
			<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">产品管理<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>
		</ul>
	</div>
	<div class="admin-biaogelist">
		<div class="listbiaoti am-cf">
			<dl class="am-icon-home" style="float: left;"> 当前位置：分销商库存管理>
				<a href="flow_card_maint.html">流向单维护</a>>添加
			</dl>
		</div>

		<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
			<ul>
				<form action="" method="post">
					<li>供方分销商代码:</li>
					<li><input type="text" class="am-form-field am-input-sm am-input-xm" /></li>
					<li><button type="reset" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;">重置</button></li>
				</form>
			</ul>
		</div>

		<form class="am-form am-g">
			<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped" name="tblFlowCardDetail" id="tblFlowCardDetail">
				<thead>
					<tr class="am-success">
						<th>分销商代码</th>
						<th>物料代码</th>
						<th>初始数量</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text"></td>
						<td><input type="text"></td>
						<td><input type="text"></td>
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
			<p>注： 共 页 当前第 页</p>
		</form>

	</div>
	<script src="../../js/amazeui.min.js"></script>
	<script language="javascript">
		var rowIndex = 0;

		function choiceClient(index) {
			var width = 1000;
			var height = 600;
			var top = Math.round((window.screen.height - height) / 2);
			var left = Math.round((window.screen.width - width) / 2);
			window.open('client_select.jsp?index=' + index, '请选择分销商', "height=" + height + ", width=" + width + ",top=" + top + ", left= " + left + ", scrollbars=no");
		}

		function selectAimClient(index) {
			var width = 1000;
			var height = 600;
			var top = Math.round((window.screen.height - height) / 2);
			var left = Math.round((window.screen.width - width) / 2);
			window.open('aim_client_select.jsp?index=' + index, '请选择需方客户', "height=" + height + ", width=" + width + ",top=" + top + ", left= " + left + ", scrollbars=no");
		}

		function selectItem(index) {
			var width = 1000;
			var height = 600;
			var top = Math.round((window.screen.height - height) / 2);
			var left = Math.round((window.screen.width - width) / 2);
			window.open('item_select.jsp?index=' + index, '请选择物料', "height=" + height + ", width=" + width + ",top=" + top + ", left= " + left + ", scrollbars=no");
		}

		function addOneLineOnClick() {
			var row = document.getElementById("tblFlowCardDetail").insertRow(document.getElementById("tblFlowCardDetail").rows.length);
			var col = row.insertCell(0);
			col.innerHTML = "<input type=\"hidden\" name=\"aimInnerId\"><input readonly=\"true\" maxLength=6 size=6 name=aimId><input type=button  value =...   name=btnSelectAimClient index=\"" + rowIndex + "\" onclick=\"selectAimClient(this.index)\">";
			col = row.insertCell(1);
			col.innerHTML = "<input id=aimName name=aimName size=25 maxlength=25 >";
			col = row.insertCell(2);
			// language=HTML
			col.innerHTML = "<input readonly=\"true\" maxLength=6 size=6 name=itemNo><input type=button  value =...   name=btnSelectItem index=\"" + rowIndex + "\" onclick=\"selectItem(this.index)\">";
			col = row.insertCell(3);
			col.innerHTML = "<input id=itemName name=itemName size=25 maxlength=25  >";
			col = row.insertCell(4);
			col.innerHTML = "<input id=spec name=spec size=10 maxlength=10 >";
			col = row.insertCell(5);
			col.innerHTML = "<input id=pattern name=pattern size=10 maxlength=10 >";
			col = row.insertCell(6);
			col.innerHTML = "<input id=unit name=unit size=4 maxlength=4 >";
			col = row.insertCell(7);
			col.innerHTML = "<input id=qty name=qty size=6 maxlength=6>";
			col = row.insertCell(8);
			col.innerHTML = "<input type='button' value='删除' id=btnDeleteLine name=btnDeleteLine onclick=\"return DeleteRow('row" + rowIndex + "')\">";
			row.setAttribute("id", "row" + rowIndex);
			rowIndex++;
		}

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
</body>

</html>