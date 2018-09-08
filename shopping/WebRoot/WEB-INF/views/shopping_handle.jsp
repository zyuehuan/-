<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="container-fluid bigHead">
    <div class="row">
         
         
        <div class="col-sm-10  col-md-10 col-sm-offset-1 col-md-offset-1">
            <div class="jumbotron">
                <h1 style="font-size:40px">消费中心</h1>
                <p>您的消费如下</p>
            </div>
        </div>
        <div class="col-sm-10  col-md-10 col-sm-offset-1 col-md-offset-1">
            <div class="row">
              <ul class="nav nav-tabs list-group-diy" role="tablist">
                    <li role="presentation" class="list-group-item-diy"><a href="counts.action?uid=${user.id}">个人中心&nbsp;</a></li>
                    <li role="presentation" class="list-group-item-diy"><a href="shoppingRecord.action?osid=2">消费记录&nbsp;</a></li>
                    
              </ul>

           <div class="tab-content">
           <div class="container-fluid bigHead">
             <div class="row">
                       <div role="tabpanel" class="tab-pane" id="all">
                        <table class="table table-hover center" id="allTable">
                        <tr>
                               
                               <th width="25%">支出时间</th>
                               <th width="15%">支出金额</th>
                               
                        </tr>
                        <c:forEach items="${orders}" var="o">
                        <tr>
                           
                           <td style="text-align:center;">${o.time}</td>
                           <td style="text-align:center;">￥${o.totalPrices}</td>
                           
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
                </div>

                
            </div>
        </div>
    </div>
</div>
<!-- 尾部 -->
<jsp:include page="include/foot.jsp"/>


</body>
</html>