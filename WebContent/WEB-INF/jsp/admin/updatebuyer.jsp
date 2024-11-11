<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="UTF-8">
    <title>二手房买卖信息管理系统</title>
    <link rel="stylesheet" type="text/css" href="/text2/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/text2/css/main.css"/>
    <script type="text/javascript" src="/text2/js/libs/modernizr.min.js"></script>
    <script type="text/javascript" src="/text2/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="/text2/js/jquery.validate.min.js"></script>
   <style>
   

.error {
  
  font-size:13px;
  color: red;
  
}

   </style>
    <script type="text/javascript">
    $().ready(function() {
        // 在键盘按下并释放及提交后验证提交表单
        $("#myform").validate({
        	
            rules : {
                name : {
                    required : true,
                },
                idcardnumber : {
                    required : true,
                    min: 0
                },
                telephone: {
                    required : true,
                    min: 0
                  
                },
                totalhouseprice: {
                    required : true,
                    min: 0
                  
                }
                
            },
            messages : {
                name : {
                    required : "姓名不能为空！",
                },
                idcardnumber : {
                    required : "身份证号不能为空！",
                    min:"请输入正确的身份证号"
                  
                },
                telephone: {
                    required :  "联系方式不能为空！",
                    min:"请输入正确的联系方式"
                  
                },
                totalhouseprice: {
                    required :  "总房价不能为空！",
                    min:"请输入正确的房价"
                  
                }
                
            }
        });
    })
	</script>
	
</head>
<body>

<div class="result-title">
<h1>买方信息采集</h1>
</div>
<div class="result-content">
<div class="sidebar-title">
        <form action="changebuyer.action?id=${buyerlist.id}" method="post" id="myform" name="myform" enctype="multipart/form-data" >
                    <table class="insert-tab" width="100%">
                        <tbody>
<!--                         	<tr> -->
<!--                                 <th><i class="require-red">*</i>序号：</th> -->
<!--                                 <td> -->
<%--                                     <input class="common-text required" value="${buyerlist.id}" id="id" name="id" size="50" type="text"> --%>
<!--                                 </td> -->
<!--                             </tr> -->
                            <tr>
                                <th><i class="require-red">*</i>姓名：</th>
                                <td><input class="common-text" name="name" value="${buyerlist.name }" id="name" size="50" type="text"></td>
                            </tr>
                           <tr>
                                <th><i class="require-red">*</i>身份证号：</th>
                                <td><input class="common-text" name="idcardnumber" value="${buyerlist.idcardnumber }" id="idcardnumber" size="50" type="text"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>联系方式：</th>
                                <td><input class="common-text" name="telephone" value="${buyerlist.telephone }" id="telephone" size="50" type="text"></td>
                            </tr>
                            <tr>
                             	<th>企业名称：</th>
                                <td><input class="common-text" name="companyname" value="${buyerlist.companyname }" id="companyname" size="50" type="text" ></td>
                            </tr>
                            <tr>
                             	<th>工商编码：</th>
                                <td>
                                    <input class="common-text businesscode" value="${buyerlist.businesscode}" id="businesscode" name="businesscode" size="50" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th>房屋位置：</th>
                                <td><input class="common-text" name="location" value="${buyerlist.location }" id="location" size="50" type="text" ></td>
                            </tr>
                           <tr>
                                <th>户型：</th>
                                <td><input class="common-text" name="housetype" value="${buyerlist.housetype }" id="housetype" size="50" type="text"></td>
                            </tr>
                            <tr>
                                <th>面积：</th>
                                <td><input class="common-text" name="acreage" value="${buyerlist.acreage }" id="acreage" size="50" type="text"></td>
                            </tr>
                            <tr>
                                <th>单价：</th>
                                <td><input class="common-text" name="unitprice" value="${buyerlist.unitprice }" id="unitprice" size="50" type="text" ></td>
                            </tr>
                           <tr>
                                <th><i class="require-red">*</i>总房价：</th>
                                <td><input class="common-text" name="totalhouseprice" value="${buyerlist.totalhouseprice }" id="totalhouseprice" size="50" type="text"></td>
                            </tr>
                            <tr>
                                <th>支付方式：</th>
                                <td><input class="common-text" name="paymentmode" value="${buyerlist.paymentmode }" id="paymentmode" size="50" type="text"></td>
                            </tr>
								<tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
							<tr>
                                <font id="error" color="red">${error }</font>
                            </tr>	
                        </tbody></table>
                </form>
          </div>
          </div>
    
</body>
</html>