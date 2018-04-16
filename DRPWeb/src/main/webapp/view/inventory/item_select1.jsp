<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%@ page import="java.text.*" %>   
<%--<%@ page import="com.demo.drp.util.*" %> 
<%@ page import="com.demo.drp.basedata.manager.*" %>
<%@ page import="com.demo.drp.basedata.domain.*" %>
<%@ page import="com.demo.drp.util.*" %>
<% 
	int index = Integer.parseInt(request.getParameter("index"));
	
	String queryStr = request.getParameter("itemNoOrName");
	if (queryStr == null){
		queryStr= "";
	} 

	int pageNo = 1;
	int pageSize = 2;
	String strPageNo = request.getParameter("pageNo");
	if (strPageNo != null && !strPageNo.equals("")) {
		pageNo = Integer.parseInt(strPageNo);
	}
	BeanFactory factory = (BeanFactory)this.getServletContext().getAttribute(BeanFactory.class.getName());
	ItemService itemSerivce = (ItemService)factory.getBean(ItemService.class);
	PageModel pageModel = itemSerivce.findAllItem(queryStr,pageNo, pageSize);
%>--%>    
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择物料</title>
<link rel="stylesheet" href="../../css/drp.css">
<script type="text/javascript">
	function topPage() {
		window.self.location = "item_select.jsp?index=index&pageNo=getTopPageNo()%>&itemNoOrName=queryStr";
	}
	
	function previousPage() {
		window.self.location = "item_select.jsp?index=index&pageNo=getPreviousPageNo()%>&itemNoOrName=queryStr";
	}
	
	function nextPage() {
		window.self.location = "item_select.jsp?index=index&pageNo=getNextPageNo()%>&itemNoOrName=queryStr";
	}
	
	function bottomPage() {
		window.self.location = "item_select.jsp?index=index&pageNo=getButtomPageNo()%>&itemNoOrName=queryStr";
	}

	function queryItem() {
		with(document.getElementById("itemForm")) {
			method = "post";
			action = "item_select.jsp";
			submit();
		}
	}
	
	function doubleclick(itemNo, itemName, spec, pattern, unit) {
		var rowLength = window.opener.document.all.tblFlowCardDetail.rows.length;
		if (rowLength == 2) {
			window.opener.document.all.itemNo.value = itemNo;
			window.opener.document.all.itemName.value = itemName;
			window.opener.document.all.spec.value = spec;
			window.opener.document.all.pattern.value = pattern;
			window.opener.document.all.unit.value = unit;
		}else {
			window.opener.document.all.itemNo[index].value = itemNo;
			window.opener.document.all.itemName[index].value = itemName;
			window.opener.document.all.spec[index].value = spec;
			window.opener.document.all.pattern[index].value = pattern;
			window.opener.document.all.unit[index].value = unit;
		}
		window.close();
	}
</script>
</head>

<body  class="body1">
<form name="itemForm" >
  <div align="center">
    <table width="95%" border="0" cellspacing="2" cellpadding="2">
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table>
    <table width="95%" border="0" cellspacing="0" cellpadding="0" height="8">
      <tr>
        <td width="522" class="p1" height="2" nowrap><img src="../../images/mark_arrow_02.gif" width="14" height="14">&nbsp;<b>基础数据管理&gt;&gt;选择物料信息</b></td>
      </tr>
    </table>
    <hr width="97%" align="center" size=0>
    <table width="95%" border="0" cellpadding="0" cellspacing="0">
      <tr> 
        <td width="17%" height="29"> <div align="left">物料代码/名称:</div></td>
        <td width="46%"><input name="itemNoOrName" type="text"  class="text1" id="itemNoOrName" value="queryStr" size="50" maxlength="50"> 
        </td>
        <td width="37%"> <div align="left"> 
            <input name="btnQuery" type="button" class="button1" id="btnQuery"  value="查询" onClick="queryItem()">
        </div></td>
      </tr>
      <tr> 
        <td height="16"> 
          <div align="right"></div></td>
        <td>&nbsp; </td>
        <td><div align="right"></div></td>
      </tr>
    </table>
    
  </div>
  <table width="95%" border="0" cellspacing="0" cellpadding="0"  class="rd1" align="center">
    <tr> 
      <td nowrap height="10" class="p2">物料信息</td>
      <td nowrap  height="10" class="p3">&nbsp;</td>
    </tr>
  </table>
  <table width="95%" border="1" cellspacing="0" cellpadding="0" align="center" class="table1">
    <tr> 
      <td width="35" class="rd6">选择</td>
      <td width="170" class="rd6">物料代码</td>
      <td width="222" class="rd6">物料名称</td>
      <td width="195" class="rd6">物料规格</td>
      <td width="293" class="rd6">物料型号</td>
      <td width="293" class="rd6">类别</td>
      <td width="293" class="rd6">计量单位</td>
    </tr>
    
    <tr> 
      <td class="rd8" ><input type="radio" name="selectFlag" value="radiobutton" ondblClick="doubleclick(' getItemNo()%>', ' getItemName()%>', ' getSpec()%>', ' getPattern()%>', ' getItemUnit().getName()%>')"></td>
      <td width="170" class="rd8" > getItemNo()</td>
      <td width="222" class="rd8" > getItemName()</td>
      <td width="195" class="rd8" > getSpec()</td>
      <td width="293" class="rd8" > getPattern()</td>
      <td width="293" class="rd8" > getItemCategory().getName()</td>
      <td width="293" class="rd8" > getItemUnit().getName()</td>
    </tr>
  

  </table>
  <table width="95%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" class="rd1">
    <tr> 
      <td  nowrap class="rd19" height="2" width="36%"> <div align="left"><font color="#FFFFFF">&nbsp;共&nbsp&nbsp页</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="#FFFFFF">
	  当前第</font>&nbsp<font color="#FF0000"> </font>&nbsp<font color="#FFFFFF">页</font> 
        </div></td>
      <td  nowrap class="rd19" width="64%"> <div align="right">
        <input name="btnTopPage" class="button1" type="button" id="btnTopPage" value="|&lt;&lt; "  title="首页" onClick="topPage()">
        <input name="btnPreviousPage" class="button1" type="button" id="btnPreviousPage" value=" &lt;  "  title="上页" onClick="previousPage()">
        <input name="btnNext" class="button1" type="button" id="btnNext" value="  &gt; "  title="下页" onClick="nextPage()">
        <input name="btnBottomPage" class="button1" type="button" id="btnBottomPage" value=" &gt;&gt;|"  title="尾页" onClick="bottomPage()">
          <input name="btnOk" class="button1" type="button" id="btnOk" value="确定" onClick="selectOk()">
          <input name="btnClose" class="button1" type="button" id="btnClose" value="关闭" onClick="window.close()">
      </div></td>
    </tr>
  </table>
</form>
</body>
</html>