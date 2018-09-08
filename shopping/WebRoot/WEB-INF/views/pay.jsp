<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pay1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <style>
.pay-skip{width:978px;margin:20px auto;height: 400px;border: 1px solid #D6D6D6;line-height: 40px;}
.pay-skip h1{padding-left: 20px;height:40px;line-height:40px;font-size: 16px;color:#E25F2B;word-spacing: 10px; }
.pay-skip .payskip-inner{width: 450px;margin: 0 auto;}
.pay-skip .payskip-inner strong{color: #E3602C}
.pay-skip .payskip-inner .zffs{position: relative;top:10px;}
.pay-skip .payskip-inner .zfyh{position: relative;top:10px;}
.pay-skip .pay-sub{margin: 20px;width: 180px;height: 40px;line-height:40px;padding-left:20px;background-color:#f38256;}
</style>
  </head>
  
  <body>
    	
	<!--导航栏部分-->
   <jsp:include page="include/header.jsp"/>
	
	

		<div class="container-fluid">
			<div class="pay-skip">
				<h1>感谢您在本商城购物</h1>
				 <s:set var="items" value="#session.cart.items"/>
				<div class="payskip-inner">
					<div>
						<span>订单号:</span><strong>${order.oid}</strong><span>&#91;请您记住这个号码，以便在付款和查询时使用&#93;</span>
					</div>
					<div>
						<span>支付金额：</span><strong>￥${order.totalPrices}</strong>
					</div>
					<div>
						<span>支付方式：</span><img class="zffs" src="files/yibao.jpg"/>
					</div>
				
					<div>	
					<br>
		            <div class="pay-inner">
		                  <a class="btn btn-danger" href="pay.action?oid=${order.oid}">立即支付</a>
		            </div>
	            		<!-- 
						<div class="pay-sub">
							<input type='submit' value="登陆网上银行，立即支付"/>
						</div>
	            		 -->	
						
					</div>
				</div>
			</div>
</div>
  <!-- 尾部 -->
    <jsp:include page="include/foot.jsp"/>
  </body>
</html>
