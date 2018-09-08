<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <!--假装我是代码，代码一定要对齐，对齐，对齐！-->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>购物+</title>
   <link href="${cp}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${cp}/css/style.css" rel="stylesheet">

    <script src="${cp}/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${cp}/js/layer.js" type="text/javascript"></script>
   
    <!--[if lt IE 9]>
    <script src="${cp}/js/html5shiv.min.js"></script>
    <script src="${cp}/js/js/respond.min.js"></script>
    <![endif]-->
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
                            <li><a href="userCenter.action">个人中心</a></li>
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

<script type="text/javascript">
    
</script>

</body>
</html>