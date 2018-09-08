<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>购物+</title>
	  <link href="${cp}/css/bootstrap.min.css" rel="stylesheet">
	  <link href="${cp}/css/style.css" rel="stylesheet">

	  <script src="${cp}/js/jquery.min.js" type="text/javascript"></script>
	  <script src="${cp}/js/bootstrap.min.js" type="text/javascript"></script>
	  <script src="${cp}/js/layer.js" type="text/javascript"></script>
    <!--[if lt IE 9]>
      <script src="${cp}/js/html5shiv.min.js"></script>
      <script src="${cp}/js/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <!--导航栏部分-->
	<jsp:include page="include/header.jsp"/>

	<!-- 中间内容 -->
	<form action=addShoppingCar method="post">
	<div class="container-fluid bigHead">
		<div class="row">
			<div class="col-sm-10  col-md-10 col-sm-offset-1 col-md-offset-1">
				<div class="jumbotron">
					<h1>欢迎来到购物车</h1>
					<p>您的购物车清单为</p>
				</div>
			</div>
			<div class="col-sm-10  col-md-10 col-sm-offset-1 col-md-offset-1">
				<table class="table table-hover center" id="shoppingCarTable">
				        <tr>
							<th>是否购买</th>
							<th>商品名称</th>
							<th>商品单价</th>
							<th>商品数量</th>
							<th>操作</th>
						</tr>
	                   <s:set var="items" value="#session.cart.items"/>
    	                    <s:if test="#items.size != 0">
    	                     <s:iterator value="#items">
						<tr>
						<td>
						<div class="checkbox">
						<label>
						<input type="checkbox" id="checkbox'+allShoppingCars[i].productId+'" value="option1">
						</label>
						</div>
						</td>
						
    	     	             
						<td><s:property value="value.product.name"/></td>
						<td><s:property value="value.product.price"/></td>
						<td>
							<input value="-" type="button" onclick="add(-1,<s:property value="value.product.id"/>)"/>
     						<input name="number" id="number<s:property value="value.product.id"/>" value="<s:property value="value.number"/>" style="width:30px;text-align:center;">
							<input value="+" type="button" onclick="add(1,<s:property value="value.product.id"/>)"/></td>
						<td><a href="removeCartproduct.action?pid=<s:property value="value.product.id"/>" class="green">删除</a></td>
						</tr>
							</s:iterator>
			            </s:if>
						
		    <s:else>
			          <tr>
				   <td colspan="4">您的购物车中暂时还没有数据！</td>
			       </tr>
		  </s:else>
				</table>
           <div class="row">
    	        总计：<strong>￥:<s:property value="#session.cart.totalPrice"/></strong>
           </div>
				<hr/>
				<div class="row">
					<div class="col-lg-4 col-md-4 col-sm-4"></div>
					<a href="index.action" class="btn btn-danger btn-lg col-lg-4 col-md-4 col-sm-4" style="width:250px;left:-20px">继续购物&gt;&gt;</a>
					<div class="col-lg-4 col-md-4 col-sm-4"></div>
					<a href="addOrder.action" class="btn btn-danger btn-lg col-lg-4 col-md-4 col-sm-4" style="width:250px">立即结算&gt;&gt;</a>
				</div>
			</div>
		</div>
	</div>
	</form>
	<!-- 尾部 -->
	<jsp:include page="include/foot.jsp"/>

	<script type="text/javascript">
     function add(t,pid){ 
       var string = 'number' + pid;
		  	var number1 = parseInt(document.getElementById(string).value);
		  	if(number1==1&&t==-1){
		  		document.getElementById(string).value=1;
		  		}
		  	else{
		    	document.getElementById(string).value = number1+t; 
		    	document.location.href="updateCart.action?pid="+pid+"&number=" +document.getElementById(string).value;
		    	}
		    
		} 
		function outPut(pid){
		var string = 'number' + pid;
		var num = parseInt(document.getElementById(string).value);
			//var pid=parseInt(document.getElementById("pid").value);
			document.location.href="updateCart.action?pid="+pid+"&number=" +num;
			}

       
	</script>
  </body>
</html>