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

			function choiceClient(index) {
				var width = 1000;
				var height = 600;
				var top = Math.round((window.screen.height - height) / 2);
				var left = Math.round((window.screen.width - width) / 2);
				window.open('client_select.jsp?index=' + index, '请选择分销商', "height=" + height + ", width=" + width + ",top=" + top + ", left= " + left + ", scrollbars=no");
			}

			function selectAimClient(index) {
				window.open('aim_client_select.jsp?index=' + index, '请选择需方客户', 'width=700, height=400, scrollbars=no');
			}

			function selectItem(index) {
				window.open('item_select.jsp?index=' + index, '请选择物料', 'width=700, height=400, scrollbars=no');
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
				window.self.location = "${ctx}/view/basicData/fiscal_year_period_maint.jsp";
			}
		</script>
	</head>

	<body>
		<div class="daohang">
	</div>
		<div class="admin-biaogelist">
			<div class="listbiaoti am-cf">
				<dl class="am-icon-home" style="float: left;"> 当前位置：基础数据管理>
					<a href="#">会计核算期间维护</a>>修改
				</dl>
			</div>

			<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf" style="height:200px;width:250px">
				<form id="updateFiscalForm">
					<ul>
						<li>*核算年: </li>&nbsp;&nbsp;&nbsp;
						<input id="updateFiscal_fiscalYear" name="fiscalYear" type="text" value="" style="width: 100px;"/><br />
					</ul>
					<ul style="margin-top: 2px;">
						<li>*核算月: </li>&nbsp;&nbsp;&nbsp;
						<input id="updateFiscal_fiscalPeriod" name="fiscalPeriod" type="text" value="" style="width: 100px;"/><br />
					</ul>
					<ul style="margin-top: 2px;">
						<li>*开始日期:</li>
						<li style="margin-right: 0;">
							<input id="updateFiscal_beginDate" name="beginDate" type="text" class="am-form-field am-input-sm am-input-zm  am-icon-calendar" data-am-datepicker="" value="
					</ul>
					<ul style="margin-top: 2px;">
						<li>*结束日期:</li>
						<li style="margin-right: 0;">
							<input id="updateFiscal_endDate" name="endDate" type="text" class="am-form-field am-input-sm am-input-zm  am-icon-calendar" data-am-datepicker="{theme: 'success',}" value="" />
						</li><br />
					</ul>
					<ul style="margin-top: 2px;">
						<li>
							*是否可用:<input id="updateFiscal_periodFlag" name="periodFlag" type="checkbox"/>
						</li>
						<br />
					</ul>
					<ul style="margin-top: 5px;">
						<input id="update_fiscal" type="button" value="修改" />
						<input type="button" value="返回" onclick="goBack()" />
					</ul>
				</form>
			</div>
		</div>
		<script src="../../js/amazeui.min.js "></script>
		<script type="text/javascript">
			
			//加载页面前将数据填写到其中
			$(document).ready(function() {
				$("#update_fiscal").attr("fiscalId",${sessionScope.fiscal.id});
				var fiscalYear = "${sessionScope.fiscal.fiscalYear}";
				var fiscalPeriod = "${sessionScope.fiscal.fiscalPeriod}";
				var beginDate = "${sessionScope.fiscal.beginDate}";
				var endDate = "${sessionScope.fiscal.endDate}";
				var periodFlag = "${sessionScope.fiscal.periodFlag}";
				
				$("#updateFiscal_fiscalYear")[0].value = fiscalYear;
				$("#updateFiscal_fiscalPeriod")[0].value = fiscalPeriod;
				$("#updateFiscal_beginDate")[0].value = beginDate;
				$("#updateFiscal_endDate")[0].value = endDate;
				
				//判断是否，选中checkbox
				if(periodFlag == "是"){
					$("#updateFiscal_periodFlag").prop("checked",true);;
				}
			});
			
			$("#update_fiscal").click(function(){
				$.ajax({
					url:"${ctx}/updateFiscal.action",
					type:"post",
					data:$("#updateFiscalForm").serialize(),
					success:function(data){
						window.self.location = "${ctx}/view/basicData/fiscal_year_period_maint.jsp";
					}
				});
			});
		</script>
	</body>

</html>