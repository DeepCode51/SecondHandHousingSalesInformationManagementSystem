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
            	id : {
                    required : true,
                },
               
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
                  
                }
                
            },
            messages : {
            	id : {
                    required : "序号不能为空！",
                },
               
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
                  
                }
                
            }
        });
    })
	</script>
	
</head>
<body>

<div class="result-title">
<h1>修改密码</h1>
</div>
<div class="result-content">
<div class="sidebar-title">
        <form action="modifypassword.action" method="post" id="myform" name="myform" enctype="multipart/form-data" >
                    <table class="insert-tab" width="100%">
                        <tbody>
                        	<tr>
                        		<input type="hidden" name="id" value="${userlist.id}"/>
                        	</tr>
                        	<tr>
                                <th><i class="require-red">*</i>登录账号：</th>
                                <td>
                                    <input class="common-text required" value="${userlist.username}" id="username" name="username" size="50" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>新密码：</th>
                                <td><input type="password" class="common-text" name="password"  id="password" size="50" type="text"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>确认密码：</th>
                                <td><input type="password" class="common-text" name="newpassword"  id="newpassword" size="50" type="text" ></td>
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