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
	<script type="text/javascript">
		function addForCard() {
			window.self.location = "${ctx}/view/basicData/fiscal_year_period_add.jsp";
		}

		function modifyForCard() {
			var count = 0;
			$.each($(".check_itemFiscal:checked"),function(){
				count++;
			});
			if(count != 1){
				if(count == 0){
					alert("选择不能为空，请选择一项进行修改");
				}else if(count > 1){
					alert("不能多选，只能选择一项进行修改");
				}
				return;
			}
			$.each($(".check_itemFiscal:checked"),function(){
				var id = $(this).attr("fiscalId");
				$.ajax({
					type:"get",
					url:"${ctx}/getOneFiscal.action",
					data:{"id":id},
					success:function(data){
						window.self.location = "${ctx}/view/basicData/fiscal_year_period_modify.jsp";
					}
				});
			});
		}
	</script>
</head>

<body>
	<div class="daohang">
	</div>
	<div class="admin-biaogelist">
		<div class="listbiaoti am-cf">
			<dl class="am-icon-home" style="float: left;"> 当前位置： 基础数据管理 >会计核算期间维护
			</dl>
		</div>

		<form id="fiscalForm" class="am-form am-g">
			<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
				<thead>
					<tr class="am-success">
						<th class="table-check check_allFiscal"><input type="checkbox" /></th>
						<th>核算年</th>
						<th>核算月</th>
						<th>开始日期</th>
						<th>结束日期</th>
						<th>是否核算</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="checkbox" /></td>
						<td>2018</td>
						<td>4</td>
						<td>2018-03-25</td>
						<td>2018-03-25</td>
						<td>是</td>
					</tr>
				</tbody>
			</table>

			<div class="am-btn-group am-btn-group-xs">
				<button type="button" class="am-btn am-btn-default" onclick="addForCard()"><span class="am-icon-plus" ></span> 新增</button>
				<button type="button" class="am-btn am-btn-default" onclick="modifyForCard()"><span class="am-icon-save" ></span> 修改</button>
			</div>
		</form>
	</div>
	<script src="../../js/amazeui.min.js"></script>
	<script type="text/javascript">
		//加载数据
		$(document).ready(function() {
			$.ajax({
				type: "get",
				url: "${ctx}/getFiscalAll.action",
				data: {},
				success: function(data) {
					$("#fiscalForm tbody").empty();
					var fiscalList = eval('(' + data + ')');
					$.each(fiscalList.fiscalList, function(index, item) {
						var checkBox = $("<td><input type='checkbox' fiscalId='" + item.id + "' class='check_itemFiscal' /></td>");
						var fiscalYear = $("<td></td>").append(item.fiscalYear);
						var fiscalPeriod = $("<td></td>").append(item.fiscalPeriod);
						var beginDate = $("<td></td>").append(item.beginDate);
						var endDate = $("<td></td>").append(item.endDate);
						var periodFlag = $("<td></td>").append(item.periodFlag);

						$("<tr></tr>")
							.append(checkBox)
							.append(fiscalYear)
							.append(fiscalPeriod)
							.append(beginDate)
							.append(endDate)
							.append(periodFlag)
							.appendTo("#fiscalForm tbody");
					});
				}
			});
		});
		//全选
		$("#check_allFiscal").click(function() {
				$(".check_itemFiscal").prop("checked", $(this).prop("checked"));
			});
	</script>
</body>

</html>