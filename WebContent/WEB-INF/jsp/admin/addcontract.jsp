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
                sellername : {
                    required : true,
                  
                },
                selleridcard : {
                    required : true,
                  
                },
                buyername: {
                    required : true,
              
                  
                },
                buyeridcard : {
                    required : true,
                   
                  
                },
                agencyname : {
                    required : true,
                  
                  
                },
                houselocation : {
                    required : true,
                  
                },
                houseprice : {
                    required : true,
                  
                },
                paytype : {
                    required : true,
                  
                },
                paycount : {
                    required : true,
                  
                },
                starttime : {
                    required : true,
                  
                },
                endtime : {
                    required : true,
                  
                }
            },
            messages : {
                sellername : {
                    required : "卖方姓名不能为空！",
                  
                },
                selleridcard: {
                    required :  "卖方身份证号不能为空！",
                    min:"请输入正确的身份证号"
                  
                },
                buyername : {
                    required : "买方姓名不能为空！",
                  
                },
                buyeridcard: {
                    required :  "买方身份证号不能为空！",
                    min:"请输入正确的身份证号"
                  
                },
                agencyname : {
                    required : "中介姓名不能为空！",
                  
                },
                houselocation : {
                    required : "房屋位置不能为空！",
                  
                },
                houseprice : {
                    required : "房屋价格不能为空！",
                  
                },
                paytype : {
                    required : "支付方式不能为空！",
                  
                },
                paycount : {
                    required : "支付次数不能为空！",
                  
                },
                starttime : {
                    required : "生效日期不能为空！",
                  
                },
                endtime : {
                    required : "结束时间不能为空！",
                  
                }
                
            }
        });
    })
	</script>
	
</head>
<body>

<div class="result-title">
<h1>签订合同</h1>
</div>
<div class="result-content">
<div class="sidebar-title">
        <form action="addcontract.action" method="post" id="myform" name="myform" enctype="multipart/form-data" >
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>卖方姓名：</th>
                                <td><input class="common-text" name="sellername" value="${contractlist.sellername }" id="sellername" size="50" type="text" ></td>
                            </tr>
                           <tr>
                                <th><i class="require-red">*</i>卖方身份证号：</th>
                                <td><input class="common-text" name="selleridcard" value="${contractlist.selleridcard }" id="selleridcard" size="50" type="text"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>买方姓名：</th>
                                <td><input class="common-text" name="buyername" value="${contractlist.buyername }" id="buyername" size="50" type="text"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>买方身份证号：</th>
                                <td><input class="common-text" name="buyeridcard" value="${contractlist.buyeridcard }" id="buyeridcard" size="50" type="text" ></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>中介姓名：</th>
                                <td><input class="common-text" name="agencyname" value="${contractlist.agencyname }" id="agencyname" size="50" type="text"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>房屋位置：</th>
                                <td><input class="common-text" name="houselocation" value="${contractlist.houselocation }" id="houselocation" size="50" type="text"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>房屋价格：</th>
                                <td><input class="common-text" name="houseprice" value="${contractlist.houseprice }" id="houseprice" size="50" type="text"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>付款方式：</th>
                                <td><input class="common-text" name="paytype" value="${contractlist.paytype }" id="paytype" size="50" type="text"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>付款次数：</th>
                                <td><input class="common-text" name="paycount" value="${contractlist.paycount }" id="paycount" size="50" type="text"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>生效日期：</th>
                                <td><input class="common-text" name="starttime" value="${contractlist.starttime }" id="starttime" size="50" type="text"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>有效日期：</th>
                                <td><input class="common-text" name="endtime" value="${contractlist.endtime }" id="endtime" size="50" type="text"></td>
                            </tr>
                            <tr>
                                <th>备注：</th>
                                <td><input class="common-text" name="note" value="${contractlist.note }" id="note" size="50" type="text"></td>
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