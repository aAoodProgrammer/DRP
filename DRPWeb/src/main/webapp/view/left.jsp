<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 设置一个项目路径的变量  -->
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>

<head>
<meta charset="UTF-8">
<title>DRP 分销资源计划</title>
<link rel="icon" type="image/png" href="../i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="../i/app-icon72x72@2x.png" type="text/css">
<link rel="stylesheet" href="../css/amazeui.min.css" />
<link rel="stylesheet" href="../css/admin.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/app.js"></script>
</head>

<body>
	<div class="nav-navicon admin-main admin-sidebar">
		<div class="sideMenu">
			<h3 class="am-icon-flag">
				<em></em> <a href="#">分销库存管理</a>
			</h3>
			<ul class="slider">
				<li><a href="${ctx}/inventory/inv_init_qty_maint.action"
					target="main">分销商库存数量初始化</a></li>
				<li><a href="../view/inventory/inv_init_qty_confirm.html"
					target="main">分销商库存数量初始化确认</a></li>
				<li><a href="../view/inventory/flow_card_maint.jsp"
					target="main">流向单维护</a></li>
				<li><a href="../view/inventory/flow_card_audit.html"
					target="main">流向单审核</a></li>
				<li><a href="../view/inventory/flow_card_spot_test.html"
					target="main">流向单抽查</a></li>
				<li><a href="../view/inventory/flow_card_rehear.html"
					target="main">流向单复审</a></li>
				<li><a href="../view/inventory/checkvou_maint.html"
					target="main">盘点结果维护</a></li>
				<li><a href="../view/inventory/checkvou_audit.html"
					target="main">盘点结果审核</a></li>
			</ul>

			<h3 class="am-icon-volume-up">
				<em></em> <a href="#">统计报表管理</a>
			</h3>
			<ul class="slider">
				<li><a href="statement/client_level_chart.jsp" target="main">分销商级别分布图</a>
				</li>
				<li><a href="statement/flow_card_audit_report.html"
					target="main">流向单审核报告</a></li>
				<li><a href="" target="main">分消费计算查询</a></li>
				<li><a href="statement/client_stock_report.html" target="main">分销商库存台账</a>
				</li>
				<li><a href="" target="main">分销商销售汇总</a></li>
			</ul>

			<h3 class="am-icon-volume-up">
				<em></em> <a href="#">基础数据管理</a>
			</h3>
			<ul class="slider">
				<li><a href="../view/basicData/fiscal_year_period_maint.jsp"
					target="main">会计核算期间维护</a></li>
				<li><a href="../view/basicData/item_maint.jsp" target="main">物料维护</a>
				</li>
				<li><a href="../view/basicData/client_node_crud.jsp"
					target="main">分销商维护</a></li>
				<li><a href="../view/basicData/temi_client_node_crud.html"
					target="main">终端客户维护</a></li>
				<li><a href="" target="main">物料价格维护</a></li>
				<li><a href="" target="main">基础代码维护</a></li>
			</ul>

			<h3 class="am-icon-gears">
				<em></em> <a href="#">系统管理</a>
			</h3>
			<ul class="slider">
				<li><a href="systemManager/password_modify.jsp" target="main">修改密码</a>
				</li>
				<li><a href="systemManager/user_maint.jsp" target="main">用户维护</a>
				</li>
				<li><a href="会员列表.html" target="main">菜单定义</a></li>
				<li><a href="会员列表.html" target="main">角色菜单分配</a></li>
				<li><a href="会员列表.html" target="main">角色维护</a></li>
				<li><a href="会员列表.html" target="main">查看在线用户</a></li>
			</ul>
		</div>
		<script type="text/javascript">
				jQuery(".sideMenu").slide({
					trigger: "click",
					titCell: "h3", //鼠标触发对象
					targetCell: "ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
					effect: "slideDown", //targetCell下拉效果
					delayTime: 300, //效果时间
					triggerTime: 150, //鼠标延迟触发时间（默认150）
					defaultPlay: false, //默认是否执行效果（默认true）
				});
			</script>
	</div>
	<script src="../js/amazeui.min.js"></script>
</body>

</html>