<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    
    <title>My JSP 'products.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="${cp}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${cp}/css/style.css" rel="stylesheet">

    <script src="${cp}/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${cp}/js/layer.js" type="text/javascript"></script>
    <script src="${cp}/js/jquery.min.js" type="text/javascript"></script>
   <script type="text/javascript" src="js/jquery.js"></script>
   <script type="text/javascript" src="js/js.js"></script>
   <script src="js/wb.js" type="text/javascript" charset="utf-8"></script>
   <style type="text/css">

      .cont{ background:#fff;padding:0 10px; position:relative;padding-top:10px;}
.contLeft{width:176px;border:#7BC144 2px solid;float:left;padding-bottom:1px;}
.leftPorNav{font-size:14px;}
.leftPorNav li{height:36px;line-height:36px; position:relative;}
.leftPorNav li a{ display:block;width:151px;padding-left:25px; background:url(../images/zuojian3.jpg) 151px center no-repeat;border-bottom:#efefef 1px solid;}
.leftPorNav li a:hover{color:#7BC144;border-bottom:#7BC144 1px solid; font-weight:bold; background:none;}
.leftPorNav .chilInPorNav{left:175px;}
.contRight{width:100%;float:left;border-right:#efefef 1px solid;}
.contRight .frProList{ display:block;list-style:none; width:240px; float:left;height:280px}
.contRight .frProList dl.frListDlstyle{border:#ccc 1px solid;border-right:#ccc 1px solid;}
.contRight .frProList dd{line-height:15px;margin-top:3px;}
.contRight .frProList .cheng{color:#eb9d23;font-weight:bold;font-size:14px;line-height:20px; position:absolute;}
.contRight .frProList .cheng span{ position:absolute;right:0;top:0; font-size:12px;color:#999; font-weight:400; text-decoration:line-through}
.jilu{width:100px;height:28px;border:#efefef 1px solid; font-size:14px; text-align:center;line-height:28px; position:absolute;right:10px;top:-30px;}
.jilu span{color:#F00;font-weight:bold;}
   </style>
</head>

<body>
   <!--导航栏部分-->
 
        <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.action">购物+</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

            <ul class="nav navbar-nav navbar-right">
              	<%
						if((String) session.getAttribute("username")==null){
						
					%>
                    <li><a href="register.action">注册</a></li>
                    <li><a href="loginInput.action">登录</a></li>
              
                <%
                    } else{
                 %>
                   
                    <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                ${user.username}
                            <span class="caret"></span>
                        </a>
                       
                        <ul class="dropdown-menu">
                            <li><a href="getShoppingCars.action">购物车</a></li>
                            <li><a href="orderRecord.action">订单状态</a></li>
                            <li><a href="counts.action?uid=${user.id}">消费中心</a></li>                       
                            <li class="divider"></li>
                            <li><a href="userCenter.action?uid=#session.user.id">个人中心</a></li>
                            <li><a href="removeSession.action">注销登录</a></li>
                        </ul>
                    </li>
                 <%} %>
            </ul>

            <div class="navbar-form navbar-right">
            <form action="listKeywordProduct" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" name="keyword"/>
                </div>
                <input type="submit" class="btn btn-default" value="搜索商品"/>
               
               
            </form>  
        </div>
    </div>
    </div>
</nav>
    <!-- 中间内容 -->
    <div class="container-fluid">
        <div class="row">
                    <!-- 控制栏 -->
            <div class="col-sm-3 col-md-2 sidebar sidebar-1">
              <ul class="nav nav-sidebar">
                   
                    <li class="list-group-item-diy"><a href="indexlistProduct.action?type=1" target="myframe">衣服配饰</a></li>
                   	<li class="list-group-item-diy"><a href="indexlistProduct.action?type=2" target="myframe">手机数码</a></li>
					<li class="list-group-item-diy"><a href="indexlistProduct.action?type=3" target="myframe">电脑办公</a></li>
					<li class="list-group-item-diy"><a href="indexlistProduct.action?type=4" target="myframe">游戏周边</a></li>
					<li class="list-group-item-diy"><a href="indexlistProduct.action?type=5" target="myframe">生活用品</a></li>
					<li class="list-group-item-diy"><a href="indexlistProduct.action?type=6" target="myframe">美妆清洁</a></li>
					<li class="list-group-item-diy"><a href="indexlistProduct.action?type=7" target="myframe">运动户外</a></li>
               </ul>
             </div>
  
   <!-- 控制内容 -->
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
              <div class="jumbotron">
                  <br>
					<h1>欢迎来到购物+</h1>
					<p>购物+是一个非常优秀的购物网站，你可以在这里买到物美价廉的东西</p>
				</div>
                <div class="col-md-12">
                  <div class="cont">
<div class="contRight">
 
    <c:forEach items="${products}" var="p">
     <div class="frProList">
      <dl>
      <dt><a href="productdetail.action?pid=${p.id }" target="_blank"><img src="${p.path}" width="230px" height="200px" /></a></dt>
      <dd>${p.name}</dd>
      <dd class="cheng">￥${p.price}</dd>
     </dl>
     </div>
     </c:forEach>
      <div class="clears"></div>
   
     </div><!--frProList-->
   </div><!--contRight/-->
              <div style="position:absolute; bottom:0px;left:200px;font-size:20px;">
               <c:if test="${pager.curPage>1}">
   	            <p align="center">
   	          	<a href="index.action?pager.curPage=1">首页</a>
   		       <a href="index.action?pager.curPage=${pager.curPage-1}">上一页</a>
   	           
          </c:if>
              <c:if test="${pager.curPage < pager.pageCount}">
              	
   	      	<a href="index.action?pager.curPage=${pager.curPage+1}">下一页</a>
   	  	    <a href="index.action?pager.curPage=${pager.pageCount}">尾页</a>
      
      </c:if>
      </div>
               </div>
            </div>
            
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2">
				<jsp:include page="include/foot.jsp"/>
			</div>
            </div>
       </div>
 

  

</body>
</html>
