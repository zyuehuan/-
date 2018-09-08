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
          <table class="table table-hover center" id="allTable">
     <tr>
      <th>用户名</th>
      <th>邮箱</th>
      <th>联系方式</th>
      <th>地址</th>
      
     </tr>
     <tr>
      <td>${user.username}</td>
      <td>${user.email}</td>
      <td>${user.phone}</td>
      <td>${user.address}</td>
     </tr>
    </table><!--vipMy/-->
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