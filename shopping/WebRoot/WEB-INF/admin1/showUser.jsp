<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css"> 
 
</style> 
  </head>
  
  <body>
     <!--导航栏部分-->
    <jsp:include page="include/header.jsp"/>

    <!-- 中间内容 -->
    <div class="container-fluid">
        <div class="row">
                    <!-- 控制栏 -->
            <div class="col-sm-3 col-md-2 sidebar sidebar-1">
              <ul class="nav nav-sidebar">
                    <li class="list-group-item-diy"><a href="listUser.action" target="myframe">查看所有用户<span class="sr-only">(current)</span></a></li>
                    <li class="list-group-item-diy"><a href="listProduct.action" target="myframe">查看所有商品</a></li>
                    <li class="list-group-item-diy"><a href="addInputProduct.action" target="myframe">添加商品</a></li>
                    <li class="list-group-item-diy"><a href="countCenter.action">数据统计</a></li>
               </ul>
             </div>
  
   <!-- 控制内容 -->
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <div class="col-md-12">
                <div class="col-sm-offset-2 col-md-offest-2">
                <div  class="form-horizontal">
                 <div class="form-group">
                        <div class="col-sm-2 col-md-2 control-label">用户名：</div>
                        <div class="col-sm-6 col-md-6">
                             <s:property value="%{user.username}"/>
                        </div>
                 </div>    
                <div class="form-group">
                        <div class="col-sm-2 col-md-2 control-label">性别：</div>
                        <div class="col-sm-6 col-md-6">
                                    <s:property value="%{user.sex}" />
                        </div>
                 </div>  
                 <div class="form-group">
                        <div class="col-sm-2 col-md-2 control-label">地址：</div>
                        <div class="col-sm-6 col-md-6">
                                    <s:property value="%{user.address}" />
                        </div>
                 </div> 
                 <div class="form-group">
                        <div class="col-sm-2 col-md-2 control-label">邮箱：</div>
                        <div class="col-sm-6 col-md-6">
                                    <s:property value="%{user.email}" />
                        </div>
                 </div> 
                 <div class="form-group">
                        <div class="col-sm-2 col-md-2 control-label">联系电话：</div>
                        <div class="col-sm-6 col-md-6">
                                   <s:property value="%{user.phone}" />
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
