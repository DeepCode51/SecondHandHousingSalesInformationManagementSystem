<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/text2/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/text2/css/main.css"/>
    <script type="text/javascript" src="/text2/js/libs/modernizr.min.js"></script>
    <script type="text/javascript" src="/text2/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="/text2/js/jquery-ui-datepicker.js"></script>
    <script type="text/javascript" src="/text2/js/jquery.validate.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/text2/css/jquery-ui.css"/>
    <style type="text/css">
    .title{
      margin:10px auto;
      text-align:center;
      font-size:30px;
    }
    .button{
    margin:10px auto;
    text-align:center;
    }
    </style>
    <script type="text/javascript">
    function to_dayin(){
    	alert("打印中...");
    }
   
    </script>
</head>
<body>
<div><br />
	<form name="contract" action="/text2/contract/updatecontract.action">
	<div class="title">房屋买卖合同</div>
	<input type="hidden" name="id" value="${contract.id}"/>
	<p>卖房人：<span name="sellername">${contract.sellername}</span>（以下简称甲方）；</p>　　　
	<p>买房人：<span name="buyername">${contract.buyername}</span>（以下简称乙方）。　</p>　
	<p>购买房屋地址：<span name="houselocation">${contract.houselocation}</span>　</p>　
	<p>依据《中华人民共和国合同法》有关条款，甲乙双方经过充分协商，就乙方购买甲方房屋事宜达成如下协议：</p>
	<p>一、乙方购买甲方房屋，以下简称购买房屋。</p>
	<p>二、甲乙双方商定成交价格为人民币<span name="houseprice">${contract.houseprice}</span>元。乙方在<span name="endtime">${contract.endtime}</span>前分<span name="paycount">${contract.paycount}</span>次付清，付款方式为<span name="paytype">${contract.paytype}</span>。</p>
	<p>三、甲方在<span name="endtime">${contract.endtime}</span>前将上述房屋交付给乙方。该房屋占用范围内土地使用权同时转让。</p>
	<p>四、出卖的房屋如存在产权纠纷，由甲方承担全部责任。</p>
	<p>五、本合同经双方签章并经房地产交易管理所审查鉴定后生效，并对双方都具有约束力，应严格履行。如有违约，违约方愿意承担违约责任，并赔偿损失，支付违约费用。</p>
	<p>六、双方愿按国家规定缴纳税，费及办理有关手续。未尽事宜，双方愿按国家有关规定办理。如发生争议，双方协商解决，协商不成的双方愿向冲裁委员会申请仲裁。</p>
	<p>七、本合同一式四份，甲乙双方及税务部门各一份，房管部门一份。</p>
	<p>八、双方约定的其他事项：<span name="note">${contract.note}</span></p>
		　<br />　　甲方（盖章）：_________　　　　　　　　乙方（盖章）：_________　　<br />　
		　法定代表人（签字）：_________　　　　　法定代表人（签字）：_________　　<br />　　
		担保人（签章）：_________　　<br />　　
		_________年____月____日　　　　　　　　_________年____月____日　　<br />　　
		签订地点：_________　　　　　　　　　　签订地点：_________ 
		<div class="button">			
<!-- 		<input class="btn btn-primary btn6 mr10"  value="修改合同" type="submit"> -->
<!--         <input class="btn btn6" onclick="javascript:to_dayin()" value="打印合同" type="button"> -->
        <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
        </div>
	</form>
</div>
</body>
</html>