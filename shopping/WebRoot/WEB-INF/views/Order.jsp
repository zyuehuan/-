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
    
    <title>My JSP 'Order.jsp' starting page</title>
    
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
  
  <body>
  <div class="container-fluid bigHead">
    <div class="row">
                       <div role="tabpanel" class="tab-pane" id="all">
                        <table class="table table-hover center" id="allTable">
                        <tr>
                               <th width="15%">订单号</th>
                               <th width="25%">购买时间</th>
                               <th width="15%">付款金额</th>
                               <th width="15%">订单状态</th>
                        </tr>
                        <c:forEach items="${orders}" var="o">
                        <tr>
                           <td style="text-align:center;">${o.oid}</td>
                           <td style="text-align:center;">${o.time}</td>
                           <td style="text-align:center;">￥${o.totalPrices}</td>
                           <td style="text-align:center;">${o.orderstate.orderstate}</td>
                        </tr>
                        </c:forEach>
                        </table>
                    </div>
 <div style="position:absolute; bottom:50px;left:200px;font-size:20px;">
  <c:if test="${pager.curPage>1}">
   	<p align="center">
   		<a href="indexlistProduct.action?pager.curPage=1">首页</a>
   		<a href="indexlistProduct.action?pager.curPage=${pager.curPage-1}">上一页</a>
   	</p>
   </c:if>
   <c:if test="${pager.curPage < pager.pageCount}">
   	<p align="center">
   		<a href="indexlistProduct.action?pager.curPage=${pager.curPage+1}">下一页</a>
   		<a href="indexlistProduct.action?pager.curPage=${pager.pageCount}">尾页</a>
   	</p>
   </c:if>
</div>
            </div>
            </div>
  </body>
</html>
