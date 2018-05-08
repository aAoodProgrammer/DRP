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
	<link rel="stylesheet" href="../../dist/amazeui.page.css">
	<script src="../../js/jquery.min.js"></script>
	<script src="../../js/app.js"></script>
	<script type="text/javascript" src="../../dist/amazeui.min.js"></script>
	<script type="text/javascript" src="../../dist/amazeui.page.js"></script>

</head>

<body>
	<div class="daohang">
	</div>
	<div class="admin-biaogelist">
		<div class="listbiaoti am-cf">
			<dl class="am-icon-home" style="float: left;"> 当前位置：分销商库存管理>分销商库存数量初始化
			</dl>
		</div>
		<form id="searchForm">
			<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf" id="clientInfo">
				<ul>
					<li>供方分销商代码:</li>
					<li><input type="text" class="am-form-field am-input-sm am-input-xm" id="clientCode" value="" /></li>
					<li>物料代码:</li>
					<li><input type="text" class="am-form-field am-input-sm am-input-xm" id="itemCode" style="margin-left: 48px;" /></li>
					<li><button type="button" onclick="search()" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;margin-left: 100px;">搜索</button></li>
					<li><button type="reset" onclick="resetValue()" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;">重置</button></li>
				</ul>
			</div>
		</form>
		<form class="am-form am-g" id="inventoryForm">
			<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
				<thead>
					<tr class="am-success">
						<th class="table-check"><input type="checkbox" id="check_all" /></th>
						<th>分销商代码</th>
						<th>分销商名称</th>
						<th>物料代码</th>
						<th>物料名称</th>
						<th>规格</th>
						<th>型号</th>
						<th>初始数量</th>
						<th>是否确认</th>
					</tr>
				</thead>

				<tbody>
				</tbody>
			</table>

			<div class="am-btn-group am-btn-group-xs">
				<button type="button" class="am-btn am-btn-default" onClick="addInventory()"><span class="am-icon-plus"></span>新增</button>
				<button type="button" class="am-btn am-btn-default" id="deleteInventory"><span class="am-icon-trash-o"></span>删除</button>
				<button type="button" class="am-btn am-btn-default" onClick="updateInventory()"><span class="am-icon-save"></span>修改</button>
			</div>
			<div data-am-page="{pages:10}"></div>

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

		</form>
	</div>
	<script src="../../js/amazeui.min.js"></script>
	<script type="text/javascript">
		function search() {
			var itemCode = $('#itemCode').val();
			var clientCode = $('#clientCode').val();
			console.log("itemCode:" + itemCode + "clientCode:" + clientCode);
			$.ajax({
				url: "../../inventory/findByClientCodeOrItemCode.action",
				data: {
					"clientCode": $('#clientCode').val(),
					"itemCode": $('#itemCode').val()
				},
				type: "get",
				success: function(data) {
					$("#inventoryForm tbody").empty();
					var inventoryDtoList = eval('(' + data + ')');
					$.each(inventoryDtoList.inventoryDtoList, function(index, inventory) {
						var checkBox = $("<td><input type='checkbox' inventoryId='" + inventory.id + "' class='check_itemItem' /></td>");
						var clientCode = $("<td></td>").append(inventory.clientCode);
						var clientName = $("<td></td>").append(inventory.clientName);
						var itemCode = $("<td></td>").append(inventory.itemCode);
						var itemName = $("<td></td>").append(inventory.itemName);
						var specification = $("<td></td>").append(inventory.specification);
						var modelNum = $("<td></td>").append(inventory.modelNum);
						var initialNum = $("<td></td>").append(inventory.initialNum);
						var isVerify = $("<td></td>").append(inventory.isVerify);
						$("<tr></tr>")
							.append(checkBox)
							.append(clientCode)
							.append(clientName)
							.append(itemCode)
							.append(itemName)
							.append(specification)
							.append(modelNum)
							.append(initialNum)
							.append(isVerify)
							.appendTo("#inventoryForm tbody");
					});
				}
			});
		}

		function resetValue() {
			$.ajax({
				url: "../../inventory/findAll.action",
				data: {},
				type: "get",
				success: function(data) {
					$("#inventoryForm tbody").empty();
					var inventoryDtoList = eval('(' + data + ')');
					$.each(inventoryDtoList.inventoryDtoList, function(index, inventory) {
						var checkBox = $("<td><input type='checkbox' inventoryId='" + inventory.id + "' class='check_itemItem' /></td>");
						var clientCode = $("<td></td>").append(inventory.clientCode);
						var clientName = $("<td></td>").append(inventory.clientName);
						var itemCode = $("<td></td>").append(inventory.itemCode);
						var itemName = $("<td></td>").append(inventory.itemName);
						var specification = $("<td></td>").append(inventory.specification);
						var modelNum = $("<td></td>").append(inventory.modelNum);
						var initialNum = $("<td></td>").append(inventory.initialNum);
						var isVerify = $("<td></td>").append(inventory.isVerify);
						$("<tr></tr>")
							.append(checkBox)
							.append(clientCode)
							.append(clientName)
							.append(itemCode)
							.append(itemName)
							.append(specification)
							.append(modelNum)
							.append(initialNum)
							.append(isVerify)
							.appendTo("#inventoryForm tbody");
					});
				}
			});
		}

		//加载数据
		$(document).ready(function() {
			$.ajax({
				type: "get",
				url: "../../inventory/findAll.action",
				data: {},
				success: function(data) {
					$("#inventoryForm tbody").empty();
					var inventoryDtoList = eval('(' + data + ')');
					$.each(inventoryDtoList.inventoryDtoList, function(index, inventory) {
						var checkBox = $("<td><input type='checkbox' inventoryId='" + inventory.id + "' class='check_item' /></td>");
						var clientCode = $("<td></td>").append(inventory.clientCode);
						var clientName = $("<td></td>").append(inventory.clientName);
						var itemCode = $("<td></td>").append(inventory.itemCode);
						var itemName = $("<td></td>").append(inventory.itemName);
						var specification = $("<td></td>").append(inventory.specification);
						var modelNum = $("<td></td>").append(inventory.modelNum);
						var initialNum = $("<td></td>").append(inventory.initialNum);
						var isVerify = $("<td></td>").append(inventory.isVerify);
						$("<tr></tr>")
							.append(checkBox)
							.append(clientCode)
							.append(clientName)
							.append(itemCode)
							.append(itemName)
							.append(specification)
							.append(modelNum)
							.append(initialNum)
							.append(isVerify)
							.appendTo("#inventoryForm tbody");
					});
				}
			});
		});

		function addInventory() {
			window.self.location = "../../view/inventory/inv_init_qty_add.jsp";
		}

		function updateInventory() {
			var ids = "";
			$.each($(".check_item:checked"), function() {
				ids += $(this).attr("inventoryId") + "-";
			});
			ids = ids.substring(0, ids.length - 1);
			$.ajax({
				url: "../../inventory/findOne.action",
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
						window.self.location = "../../view/inventory/inv_init_qty_modify.jsp";
					}
				}
			});
		}

		//批量删除
		$("#deleteInventory").click(function() {
			var ids = "";
			$.each($(".check_item:checked"), function() {
				ids += $(this).attr("inventoryId") + "-";
			});
			//去除多余的横线
			ids = ids.substring(0, ids.length - 1);
			if(ids.length == 0) {
				alert("请选择");
			} else if(confirm("确定删除？")) {
				$.ajax({
					url: "../../inventory/deleteInventory.action",
					data: {
						"ids": ids
					},
					type: "post",
					success: function(e) {
						alert("删除成功！");
						window.location.href = "../inventory/inv_init_qty_maint.jsp"
					}
				});
			}
		});

		/* **********mymessage.jsp页面:完成CheckBox全选和删除*********** */
		$("#check_all").click(function() {
			$(".check_item").prop("checked", $(this).prop("checked"));
		});
		$(document).on("click", ".check_item", function() {
			var flag = $(".check_item:checked").length == $(".check_item").length;
			$("#check_all").prop("checked", flag);
		});

		//测试数据
		var data = ["北京", "上海", "广州", "深圳", "杭州", "长沙", "合肥", "宁夏", "成都", "西安", "南昌", "上饶", "沈阳", "济南", "厦门", "福州", "九江", "宜春", "赣州", "宁波", "绍兴", "无锡", "苏州", "徐州", "东莞", "佛山", "中山", "成都", "武汉", "青岛", "天津", "重庆", "南京", "九江", "香港", "澳门", "台北"];
		var nums = 5; //每页出现的数量
		var pages = Math.ceil(data.length / nums); //得到总页数

		var thisDate = function(curr) {
			//此处只是演示，实际场景通常是返回已经当前页已经分组好的数据
			var str = '',
				last = curr * nums - 1;
			last = last >= data.length ? (data.length - 1) : last;
			for(var i = (curr * nums - nums); i <= last; i++) {
				str += '<li>' + data[i] + '</li>';
			}
			return str;
		};
		$(function() {
			//返回的是一个page示例，拥有实例方法
			var $page = $("#page").page({
				pages: pages, //页数
				curr: 1, //当前页 
				type: 'default', //主题
				groups: 5, //连续显示分页数
				prev: '<', //若不显示，设置false即可
				next: '>', //若不显示，设置false即可        
				first: "首页",
				last: "尾页", //false则不显示
				before: function(context, next) { //加载前触发，如果没有执行next()则中断加载
					console.log('开始加载...');
					context.time = (new Date()).getTime(); //只是演示，并没有什么卵用，可以保存一些数据到上下文中
					next();
				},
				render: function(context, $el, index) { //渲染[context：对this的引用，$el：当前元素，index：当前索引]
					//逻辑处理
					if(index == 'last') { //虽然上面设置了last的文字为尾页，但是经过render处理，结果变为最后一页
						$el.find('a').html('最后一页');
						return $el; //如果有返回值则使用返回值渲染
					}
					return false; //没有返回值则按默认处理
				},
				after: function(context, next) { //加载完成后触发
					var time = (new Date()).getTime(); //没有什么卵用的演示
					console.log('分页组件加载完毕，耗时：' + (time - context.time) + 'ms');
					next();
				},
				/*
				 * 触发分页后的回调，如果首次加载时后端已处理好分页数据则需要在after中判断终止或在jump中判断first是否为假
				 */
				jump: function(context, first) {
					console.log('当前第：' + context.option.curr + "页");
					$("#content").html(thisDate(context.option.curr));
				}
			});

		})
	</script>
</body>

</html>