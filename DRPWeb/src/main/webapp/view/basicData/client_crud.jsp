<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--<%@ page import="com.demo.drp.basedata.manager.*" %>
<%@ page import="com.demo.drp.basedata.domain.*" %>
<%@ page import="com.demo.drp.util.*" %>
<%
	int id = Integer.parseInt(request.getParameter("id"));
    String command = request.getParameter(Constants.command);
	Client client = ClientManager.getInstance().findRegionOrClientById(id);
	if (Constants.DEL.equals(command)) {
		ClientManager.getInstance().delRegionOrClient(id);
		out.println("删除成功！");
	}	
%> --%>
<html>

	<head>
		<link rel="stylesheet" href="../../css/drp.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>分销商维护</title>
		<script type="text/javascript">
			function validateForm() {
				return window.confirm("确认删除？");
			}
		</script>
	</head>

	<body class="body1">
		<form id="clientForm" name="clientForm" method="post" action="client_crud.jsp" onSubmit="return validateForm()">
			<input type="hidden" name="command %>" value="DEL %>">
			<input type="hidden" name="id" value="id">
			<table width="95%" border="0" cellspacing="0" cellpadding="0" height="8">
				<tr>
					<td width="522" class="p1" height="2" nowrap="nowrap">
						<img src="../../images/mark_arrow_02.gif" width="14" height="14" /> &nbsp;
						<b>基础数据管理&gt;&gt;分销商维护</b>
					</td>
				</tr>
			</table>
			<hr width="97%" align="center" size="0" />
			<p>
				<p>
					<table width="95%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="213">
								<div align="right">
									当前分销商名称：
								</div>
							</td>
							<td width="410">
								<label>
							<input name="clientName" type="text" class="text1"
								id="clientName" readonly="true" value=" getName() %>"/>
						</label>
							</td>
						</tr>
					</table>
					<p>
						<label>
					<br />
				</label>
						<hr />
						<p align="center">
							<input name="btnModifyClient" type="button" class="button1" id="btnModifyClient" onClick="self.location='client_modify.jsp?id=1'" value="修改分销商" /> &nbsp;
							<input name="btinDeleteClient" type="submit" class="button1" id="btinDeleteClient" value="删除分销商" /> &nbsp;
							<input name="btnViewDetail" type="button" class="button1" id="btnViewDetail" onClick="self.location='client_detail.html'" value="查看详细信息" />
						</p>
		</form>
	</body>

</html>