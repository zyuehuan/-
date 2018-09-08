<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
    <div class="container-fluid" style="padding-top: 80px;padding-bottom: 150px" >

        <h1 class="title center">登录</h1>
        <br/>
        <div class="col-sm-offset-2 col-md-offest-2" style="align:center;">
            <!-- 表单输入 -->
            <form action="login" method="post">
            <div  class="form-horizontal">
                <div class="form-group">
                    <label for="inputphone" class="col-sm-2 col-md-2 control-label">手机号</label>
                    <div class="col-sm-6 col-md-6">
                        <input type="text" class="form-control" style="width:500px;" name="phone" id="inputphone" placeholder="请输入手机号"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-sm-2 col-md-2 control-label">密码</label>
                    <div class="col-sm-6 col-md-6">
                        <input type="password" class="form-control" style="width:500px;" name="password" id="inputPassword" placeholder="禁止输入非法字符" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-6">
                        <button class="btn btn-lg btn-primary btn-block" style="width:500px;" type="submit" >登录</button>
                    </div>
                </div>
            </div>
           </form>
            <br/>
        </div>
    </div>

    <!--尾部-->
    <jsp:include page="include/foot.jsp"/>

  
  </body>
</html>