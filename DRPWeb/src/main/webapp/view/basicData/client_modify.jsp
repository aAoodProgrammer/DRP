<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>修改分销商</title>
		<link rel="stylesheet" href="../../css/drp.css">
		<script src="../../js/client_validate.js"></script>
		<script language="javascript">
			function validate(form) {
				if(trim(form.clientName.value) == "") {
					alert("分销商名称不能为空！");
					return false;
				}
				return true;
			}
		</script>
	</head>

	<body class="body1">
		<form name="clientForm" action="client_modify.jsp" id="clientForm" onSubmit="return validate(this)" method="post">
			<input type="hidden" name="id" value="id">
			<input type="hidden" name="command" value="MODIFY">
			<div align="center">
				<table width="95%" border="0" cellspacing="2" cellpadding="2">
					<tr>
						<td>&nbsp;

						</td>
					</tr>
				</table>
				<table width="95%" border="0" cellspacing="0" cellpadding="0" height="8">
					<tr>
						<td width="522" class="p1" height="2" nowrap>
							<img src="../../images/mark_arrow_03.gif" width="14" height="14"> &nbsp;
							<b>基础数据管理&gt;&gt;分销商维护&gt;&gt;修改分销商</b>
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<table width="95%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="22%" height="29">
							<div align="right">
								分销商代码:&nbsp;
							</div>
						</td>
						<td width="78%">
							<input name="clientId" type="text" class="text1" id="clientId" size="10" maxlength="10" readonly="true" value=" getClientId() %>">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								<font color="#FF0000">*</font>分销商名称:&nbsp;
							</div>
						</td>
						<td>
							<input name="clientName" type="text" class="text1" id="clientName" size="40" maxlength="40" value=" getName() %>">
						</td>
					</tr>
					<tr>
						<td height="15">
							<div align="right">
								<font color="#FF0000">*</font>分销商类型:&nbsp;
							</div>
						</td>
						<td>
							<select name="clientLevel" class="select1" id="clientLevel">

								<option value="getId()" selected="selected">cl.getName()</option>
							</select>
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								银行帐号:&nbsp;
							</div>
						</td>
						<td>
							<input name="bankAcctNo" type="text" class="text1" id="bankAcctNo" size="10" maxlength="10" value=" getBankAcctNo() %>">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								联系电话:&nbsp;
							</div>
						</td>
						<td>
							<input name="contactTel" type="text" class="text1" id="contactTel" size="10" maxlength="10" value=" getContactTel() %>">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								地址:&nbsp;
							</div>
						</td>
						<td>
							<input name="address" type="text" class="text1" id="address" size="10" maxlength="10" value=" getAddress() %>">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								邮编:&nbsp;
							</div>
						</td>
						<td>
							<input name="zipCode" type="text" class="text1" id="zipCode" size="10" maxlength="10" value=" getZipCode() %>">
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<div align="center">
					<input name="btnModify" class="button1" type="submit" id="btnModify" value="修改"> &nbsp;&nbsp;&nbsp;&nbsp;
					<input name="btnBack" class="button1" type="button" id="btnBack" value="返回" onClick="location='client_crud.jsp?id=id'" />
				</div>
			</div>
		</form>
	</body>

</html>