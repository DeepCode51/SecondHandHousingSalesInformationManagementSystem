<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>二手房买卖信息管理系统</title>
<link rel="stylesheet" type="text/css" href="/text2/css/common.css" />
<link rel="stylesheet" type="text/css" href="/text2/css/main.css" />
<script type="text/javascript" src="/text2/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="/text2/js/libs/modernizr.min.js"></script>
<style>
a:hover {
	cursor: pointer;
}
</style>
<script language=javascript>
	// 提交分页的查询的表单
	function to_page(url1){
                 $.ajax({ url:url1,
                         type:"post",
                         async : false, 
                        
                        success:function(data){
                                $("#inside").html(data);
                                alert("成功");
                                
                        },
                        error: function() {  
                            alert("失败，请稍后再试！");  
                        }  
                });
        }
	
</script>
</head>
<body>
	<div class="topbar-wrap white">
		<div class="topbar-inner clearfix">
			<div class="topbar-logo-wrap clearfix">
				<h1 class="topbar-logo none">
					<a href="index.html" class="navbar-brand">后台管理</a>
				</h1>
				<ul class="navbar-list clearfix">
					<li><a class="on sendRequest" href="javascript::void(0)"
						onclick="to_page('toindex.action')">首页</a></li>

				</ul>
			</div>
			<div class="top-info-wrap">
				<ul class="top-info-list clearfix">
					<li>欢迎您，${sessionScope.user.username}！</li>

					<li><a
						href="javascript:if(confirm('确实要退出登录吗?'))location='/text2/login.action'">退出</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container clearfix">
		<div class="sidebar-wrap">
			<div class="sidebar-title">
				<h1>菜单</h1>
			</div>
			<div class="sidebar-content">
				<ul class="sidebar-list">
					<li><a class="a"><i class="icon-font">&#xe003;</i>信息采集</a>
						<div class="p">
							<ul class="sub-menu">
								<li><a href="/text2/buyerlistforseller.action"><i
										class="icon-font">&#xe008;</i>买方信息列表</a></li>
<!-- 								<li><a href="/text2/sellerlistforseller.action"><i -->
<!-- 										class="icon-font">&#xe008;</i>卖方信息列表</a></li> -->
							</ul>
						</div>
					</li>
					<li><a class="a"><i class="icon-font">&#xe003;</i>信息匹配</a>
						<div class="p">
							<ul class="sub-menu">
								<li><a href="/text2/tofindbuyer.action"><i
										class="icon-font">&#xe008;</i>匹配房源列表</a></li>
							</ul>
						</div>
					</li>
					<li><a class="a"><i class="icon-font">&#xe003;</i>过户流程</a>
						<div class="p">
							<ul class="sub-menu">
		                        <li><a href="/text2/contract/contractlistforcustomer.action"><i class="icon-font">&#xe037;</i>合同列表</a></li>
                    		</ul>
                    	</div>
                	</li>
					<li>
                    	<a class="a"><i class="icon-font">&#xe018;</i>其他操作</a>
               			<div class="p">      
               				<ul class="sub-menu">
                        		<li><a href="/text2/findalluser.action"><i class="icon-font">&#xe017;</i>账户管理</a></li>
                    		</ul>
                    	</div>
                	</li>
				</ul>
			</div>
		</div>
		<!--/sidebar-->
		<div class="main-wrap">
			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font">&#xe06b;</i><span>欢迎使用本系统！</span>
				</div>
			</div>

			<div class="result-wrap" id="inside">
				<jsp:include page="${mainPage==null?'../admin/index.jsp':mainPage}"></jsp:include>
			</div>
		</div>

	</div>
	<!--/main-->
	</div>
</body>
</html>