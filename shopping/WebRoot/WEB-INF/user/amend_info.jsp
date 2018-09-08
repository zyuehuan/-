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
    <link href="${cp}/css/xiala.css" rel="stylesheet">
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
<div class="dropdown">
  <button class="dropbtn">个人管理</button>
  <div class="dropdown-content">
    <a href="updateUser.action?uid=#session.user.id">资料修改</a>
    <a href="updateuserpwd.action?uid=#session.user.id">密码修改</a>
    <a href="updateAddress.action">地址管理</a>
  </div>
  </div>
<!-- 中间内容 -->
<div class="container-fluid">
    <h1 class="title center">个人信息</h1>
    <br/>
  
    <div class="col-sm-offset-2 col-md-offest-2">
        <!-- 表单输入 -->
       <div  class="form-horizontal">
           <form action="updatedUser" method="post">
           <input type="hidden" name="id" value="${user.id }">
           
                <div class="form-group">
                    <label for="inputUsername" class="col-sm-2 col-md-2 control-label">用户名</label>
                    <div class="col-sm-6 col-md-6">
                        <input type="text" class="form-control" name="username"  value="${user.username}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail" class="col-sm-2 col-md-2 control-label">邮箱</label>
                    <div class="col-sm-6 col-md-6">
                        <input type="email" class="form-control" name="email"  value="${user.email}"/>
                    </div>
                </div>
         
                <div class="form-group">
                    <label for="inputPassword" class="col-sm-2 col-md-2 control-label">密码</label>
                    <div class="col-sm-6 col-md-6">
                        <input type="password" class="form-control" name="password" id="inputPassword" value="${user.password}" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPhoneNumber" class="col-sm-2 col-md-2 control-label">手机号码</label>
                    <div class="col-sm-6 col-md-6">
                        <input type="text" class="form-control" name="phone" id="inputPhoneNumber" value="${user.phone }" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="man" class="col-sm-2 col-md-2 control-label">性别</label>
                    <div class="col-sm-6 col-md-6">
                        <label class="radio-inline">
                            <input type="radio" id="man" name="sex" value="男"> 男
                        </label>
                        <label class="radio-inline">
                            <input type="radio" id="woman" name="sex" value="女"> 女
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="address" class="col-sm-2 col-md-2 control-label">地址</label>
                    <div class="col-sm-6 col-md-6">
                        <input type="text" class="form-control" name="address" id="address" value="${user.address}" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-6">
                        <button class="btn btn-lg btn-primary btn-block" type="submit">更改</button>
                    </div>
                </div>
          
                </form>
        </div>
        <br/>
    </div>
</div>

<!--尾部-->
<jsp:include page="include/foot.jsp"/>
<script type="text/javascript">
</script>
</body>
</html>
