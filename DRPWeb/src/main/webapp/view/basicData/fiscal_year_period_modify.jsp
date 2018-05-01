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
				window.self.location = "${ctx}/view/basicData/fiscal_year_period_maint.jsp";
			}
		</script>
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
				<dl class="am-icon-home" style="float: left;"> 当前位置：基础数据管理>
					<a href="#">会计核算期间维护</a>>修改
				</dl>
			</div>

			<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf" style="height:200px;width:250px">
				<form id="updateFiscalForm">
					<ul>
						<li>*核算年: </li>&nbsp;&nbsp;&nbsp;
						<input id="updateFiscal_fiscalYear" name="fiscalYear" type="text" value="${sessionScope.fiscal.fiscalYear}" style="width: 100px;"/><br />
					</ul>
					<ul style="margin-top: 2px;">
						<li>*核算月: </li>&nbsp;&nbsp;&nbsp;
						<input id="updateFiscal_fiscalPeriod" name="fiscalPeriod" type="text" value="${sessionScope.fiscal.fiscalPeriod}" style="width: 100px;"/><br />
					</ul>
					<ul style="margin-top: 2px;">
						<li>*开始日期:</li>
						<li style="margin-right: 0;">
							<input id="updateFiscal_beginDate" name="beginDate" type="text" class="am-form-field am-input-sm am-input-zm  am-icon-calendar" data-am-datepicker="{theme: 'success',}" value="${sessionScope.fiscal.beginDate}" />
						</li><br />
					</ul>
					<ul style="margin-top: 2px;">
						<li>*结束日期:</li>
						<li style="margin-right: 0;">
							<input id="updateFiscal_endDate" name="endDate" type="text" class="am-form-field am-input-sm am-input-zm  am-icon-calendar" data-am-datepicker="{theme: 'success',}" value="${sessionScope.fiscal.endDate}" />
						</li><br />
					</ul>
					<ul style="margin-top: 2px;">
						<li>
							*是否可用:
						</li>
						<input id="updateFiscal_periodFlag" name="periodFlag" type="checkbox"/><br />
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
				//从session中获取要修改的信息
				$("#update_fiscal").attr("fiscalId",${sessionScope.fiscal.id})
				var fiscalYear = "${sessionScope.fiscal.fiscalYear}";
				var fiscalPeriod = "${sessionScope.fiscal.fiscalPeriod}";
				var beginDate = "${sessionScope.fiscal.beginDate}";
				var endDate = "${sessionScope.fiscal.endDate}";
				var periodFlag = "${sessionScope.fiscal.periodFlag}";
				
				/*$("#updateFiscal_fiscalYear")[0].value = fiscalYear;
				$("#updateFiscal_fiscalPeriod")[0].value = fiscalPeriod;
				$("#updateFiscal_beginDate")[0].value = beginDate;
				$("#updateFiscal_endDate")[0].value = endDate;*/
				
				//判断是否，选中checkbox
				/*if(periodFlag == "是"){
					$("#updateFiscal_periodFlag").prop("checked",true);;
				}*/
			});
			
			$("#update_fiscal").click(function(){
				//发送ajax清除session
				$.ajax({
					type:"post",
					url:"",
					async:true
				});
				var id = $(this).attr("fiscalId");
				alert(id);
				$.ajax({
					url:"${ctx}/updateFiscal.action",
					type:"post",
					data:$("#addFiscalForm").serializeArray(),
					success:function(data){
						window.self.location = "${ctx}/view/basicData/fiscal_year_period_maint.jsp";
					}
				});
			});
		</script>
	</body>

</html>