<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'orderDetail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->



  <style type="text/css">
 .positions{height:55px;line-height:55px;padding-left:25px; background:#fff url(../images/home2.png) 5px center no-repeat;}
.positions a{color:#333;}
.positions a:hover,.positions .posCur{color:#F00;}
  
  </style>
  </head>
  
  <body>
   <!--导航栏部分-->
  <jsp:include page="include/header.jsp"/>
  <!-- 中间内容 -->
<div class="container-fluid bigHead">
    <div class="row">
        <div class="col-sm-10  col-md-10 col-sm-offset-1 col-md-offset-1">
            <div class="jumbotron">
                <h1 style="font-size:40px">欢迎来到订单页</h1>
                <p>您的购买清单为</p>
            </div>
        </div>
        <div class="col-sm-10  col-md-10 col-sm-offset-1 col-md-offset-1">
            <div class="row">
              
           <div class="positions">
                    当前位置：<a href="index.action">首页</a> &gt; <a href="updateUser.action">个人中心</a> &gt;<a href="orderRecord.action" class="posCur">我的订单</a>
          </div><!--positions/-->
                <div class="tab-content">
           <div class="container-fluid bigHead">
             <div class="row">
               <div class="tab-pane" id="all">
            <table class="table table-hover center" id="allTable">
                      
                    <tr>
                     <th>订单编号:</th>
                     <td colspan="2">${order.oid}</td>
                    </tr>
                    <tr>
                        <th>用户名称:</th>
                       <td colspan="2">${order.user.username}</td>
                    </tr>
                        <tr>
                      <th>订单价钱:</th>
                       <td colspan="2">${order.totalPrices}</td>
                        </tr>
                         <tr>
                    <th>收货地址:</th>
                    <td colspan="2">${order.user.address}</td>
                    </tr>
                    <tr>
                    <th>联系电话:</th>
                      <td  colspan="2">${order.user.phone}</td>
                      </tr>
                     <tr>
                     <th>订单状态:</th>
                     <td colspan="2">${order.orderstate.orderstate}</td>
                      </tr>
                     <tr style="text-align:center"><th colspan="3" align="center" style="text-align:center">商品清单</th></tr>
                     <tr>
    	             <th>商品名称</th><th>商品数量</th><th>单价</th>
                       </tr>
                         <c:forEach items="${order.orderitems}" var="oi">
                              	<tr>
                                 		<th>${oi.product.name}</th>
     	                            	<td> ${oi.number}</td>
     	                             	<td>${oi.product.price}</td>
                             	</tr>
                         </c:forEach>
 
                   
                        </table>
                    </div>
     
            </div>
            </div>
                </div>
            </div>
        </div>
    </div>
</div>

  <!-- 尾部 -->
<jsp:include page="include/foot.jsp"/>
  </body>
</html>
