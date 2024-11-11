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
    <link rel="stylesheet" type="text/css" href="/text2/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/text2/css/main.css"/>
    <script type="text/javascript" src="/text2/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="/text2/js/libs/modernizr.min.js"></script>
	</script>
	<style type="text/css">
	
	
	</style>
	<script type="text/javascript">
	var error="${param.error}";
	if(error=="applycheck"){

	alert("你还没完善个人信息，请完善个人信息后再进行申请操作");
	}else if(error=="applysuccess"){
		alert("申请成功，请耐心等待房东联系您！");	
	}else if (error=="addsuccess") {
		alert("添加成功!");
	}
		
	</script>
</head>
<body>
<div>
	<div class="result-title">
	<h1>卖方信息列表</h1>
	</div>
	<form id="sellerForm" name="sellerForm" action="sellerlist.action" method=post >
		<div class="result-title">
			<div class="result-list">
			</div>
		</div>

		<div class="result-content">
			<table id="grid" class="result-tab" width="100%">
				<tbody>
					<tr style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
						<td>序号</td>
						<td>姓名</td>
						<td>企业名称</td>
						<td>身份证号</td>
						<td>工商编码</td>
						<td>联系方式</td>
						<td>房屋位置</td>
						<td>户型</td>
						<td>面积</td>
						<td>单价</td>
						<td>总房价</td>
						<td>支付方式</td>
						<td>是否通过审核</td>
					</tr>
					<c:forEach items="${buyerlist}" var="buyerlist">
						<tr
										style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
										<td>${buyerlist.id }</td>

										<td>${buyerlist.name}</td>
										<td>${buyerlist.companyname}</td>
										<td>${buyerlist.idcardnumber}</td>
										<td>${buyerlist.businesscode}</td>
										<td>${buyerlist.telephone }</td>

										<td>${buyerlist.location}</td>
										<td>${buyerlist.housetype}</td>
										<td>${buyerlist.acreage}</td>
										<td>${buyerlist.unitprice}</td>
										<td>${buyerlist.totalhouseprice}</td>
										<td>${buyerlist.paymentmode}</td>
										<td>
											<c:if test="${ buyerlist.isvalid == '1' }">
													是 
											</c:if>
											<c:if test="${ buyerlist.isvalid == '0' }">
													否
											</c:if>
										</td>
							</tr>
					</c:forEach>
			</tbody>
		</table>
	</div>
					
						<tr>
						<tr>
							<span id=pagelink>
								<div style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right; margin-top:10px">
									共[<B>${p.total}</B>]条记录，共[<B>${p.pages}</B>]页
									,

									<c:if test="${ p.pageNum > 1 }">
													[<A href="javascript:to_page(${p.prePage})">前一页</A>]
												</c:if>
										<input type="hidden" name="page" id="page" value=""/>
									第<B>${p.pageNum}</B>页

									<c:if test="${ p.pageNum < p.pages }">
													[<A href="javascript:to_page(${p.nextPage})">后一页</A>] 
												</c:if>

									
								</div>
							</span>
						
						</tr>
						<tr>
                                <font id="error" color="red">${error }</font>
                            </tr>
						</tbody>
						</tbody>
	</form>
</div>
 <script language=javascript>
	// 提交分页的查询的表单
	function to_page(page) {
		if (page) {
			$("#page").val(page);
		}
		document.houseForm.submit();
	}
</script>
</body>
</html>