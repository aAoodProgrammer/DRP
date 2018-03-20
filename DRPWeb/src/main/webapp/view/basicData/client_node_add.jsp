<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--<%@ page import="com.demo.drp.basedata.manager.*" %>
<%@ page import="com.demo.drp.basedata.domain.*" %>
<%@ page import="com.demo.drp.util.*" %>
<%
	int pid = Integer.parseInt(request.getParameter("id"));
	String command = request.getParameter("command");
	if (Constants.ADD.equals(command)) {
		Client region = new Client();
		region.setPid(pid);
		region.setName(request.getParameter("name"));
		region.setIsLeaf(Constants.YES);
		region.setIsClient(Constants.NO);
		
		ClientManager.getInstance().addRegionOrClient(region);
		out.println("添加成功！");
	}
%> --%>
<html>

	<head>
		<link rel="stylesheet" href="../../css/drp.css" />
		<script src="../../js/client_validate.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>添加区域节点</title>
		<script type="text/javascript">
			function addRegion() {
				if(trim(document.getElementById("name").value).length == 0) {
					alert("区域名称不能为空！");
					document.getElementById("name").focus();
					return;
				}
				with(document.forms[0]) {
					action = "client_node_add.jsp";
					method = "post";
					submit();
				}

			}

			function goBack() {
				window.self.location = "client_node_crud.jsp";
			}
		</script>
	</head>

	<body class="body1">
		<form>
			<input type="hidden" name="command" value="ADD">
			<input type="hidden" name="id" value="pid">
			<table width="95%" border="0" cellspacing="0" cellpadding="0" height="8">
				<tr>
					<td width="522" class="p1" height="2" nowrap="nowrap">
						<img src="../../images/mark_arrow_03.gif" width="14" height="14" /> &nbsp;
						<b>基础数据管理&gt;&gt;分销商维护&gt;&gt;添加区域节点</b>
					</td>
				</tr>
			</table>
			<hr width="97%" align="center" size="0" />
			<p></p>
			<p></p>
			<table width="95%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="213">
						<div align="right">
							<font color="black">*</font>区域名称：
						</div>
					</td>
					<td width="410">
						<label>
							<input name="name" type="text" class="text1" id="name" />
						</label>
					</td>
				</tr>
			</table>
			<p></p>
			<label>
				<br />
			</label>
			<hr />
			<p align="center">
				<input name="btnAdd" class="button1" type="button" value="添加" onClick="addRegion()" /> &nbsp;&nbsp;&nbsp;&nbsp;
				<input name="btnBack" class="button1" type="button" value="返回" onclick="goBack()" />
			</p>
		</form>
	</body>

</html>