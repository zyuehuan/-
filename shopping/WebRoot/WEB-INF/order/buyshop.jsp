<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cartdetail1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

      <link href="${cp}/css/bootstrap.min.css" rel="stylesheet">
	  <link href="${cp}/css/style.css" rel="stylesheet">

	  <script src="${cp}/js/jquery.min.js" type="text/javascript"></script>
	  <script src="${cp}/js/bootstrap.min.js" type="text/javascript"></script>
	  <script src="${cp}/js/layer.js" type="text/javascript"></script>
  </head>
    <!--导航栏部分-->
    <jsp:include page="include/header.jsp"/>
  
  
  <body>
<div>
    
</div>
<div class="container">

	<h2 class="page-header">收货信息</h2>
	
	<div class="docs-methods">
	
		<form class="form-inline">
		
		<table class="table table-hover center">
				      
	                
						<tr>
						<td width="10%">
						
						<label>
						<input type="checkbox" id="cbox" name="cbox" value="option1">
						</label>
						
						</td>
						
    	     	             
						<td width="10%"><s:property value="#session.user.username"/></td>
						<td width="20%"><s:property value="#session.user.phone"/></td>
						<td width="20%"><s:property value="#session.user.address"/></td>
						<td></td>
						</tr>
				</table>

		</form>
        
        </div>
   <table>
    <tr>
     <td width=15%>商品编号</td>
     <td width=15%>商品</td>
     <td width=15%>单价</td>
     <td width=15%>数量</td>
    </tr>
    <s:set var="items" value="#session.cart1.items"/>
    	<s:if test="#items.size != 0">
    		<s:iterator value="#items">
    		<tr>
    			<td style="border:0;background-color:white;"><s:property value="value.product.id"/></td>
    			<td><img width="85" height="85" src="<s:property value="value.product.path"/>"/></td>
    			<td><strong>￥<input id="price" name="price" value="<s:property value="value.product.price"/>" disabled="disabled" style="border:0;background-color:white;"></strong></td>
    			<td><input name="number" id="number" value="<s:property value="value.number"/>" disabled="disabled" style="border:0;background-color:white;"></td>
    		<tr>
    		</s:iterator>
    	</s:if>
		<s:else>
			<tr>
				<td colspan="4">您的购物车中暂时还没有数据！</td>
			</tr>
		</s:else>
    
    
   </table>
   <br>
   <div>
    	总计：<strong>￥:<s:property value="#session.cart1.totalPrice"/></strong>
   </div><!--zongji/-->
    <div style="width:10px;">
    <a class="btn btn-danger" type="button" onclick="check();" href="javascript:void(0);">提交订单</a>
   
   
    </div><!--jiesuan/-->
      </div>


   
  
   
  
  </body>
  <script type="text/javascript">
     function check(){
           var statue=document.getElementById("cbox");
           if(statue.checked){
              document.location.href="checkout2.action";
           }
           else
              alert("未选择地址");
           
     }
  </script>
</html>
