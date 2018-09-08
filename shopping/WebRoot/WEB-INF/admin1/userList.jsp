<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'categoryList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   
  </head>
  
  <body>
   <!--导航栏部分-->
    <jsp:include page="include/header.jsp"/>
<form id="form1" runat="server">
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
                      <h3>用户列表：</h3>
     <div class="container-fluid bigHead">
    <div class="row">
       <div class="tab-pane" id="all">
           <table class="table table-hover center" id="allTable">
    
    	<tr align="center">
    		<th width="5%">序号</th>
    		<th width="15%">用户名</th>
    		<th width="15%">email</th>
    		<th width="10%">性别</th>
    		<th width="15%">联系电话</th>
    		<th width="10%">操作</th>
    	</tr>
    	
    	<s:iterator value="users" var="user" status="stu">
    		<tr align="center">
    			<td width="60"><s:property value="#stu.count+7*(pager.curPage-1)"/></td>
    			<td width="120"><s:property value="#user.username"/></td>
    			<td width="120"><s:property value="#user.email"/></td>
    			<td width="120"><s:property value="#user.sex"/></td>
    			<td width="120"><s:property value="#user.phone"/></td>
    			<td width="120">
    				<s:a href="showUser.action?uid=%{#user.id}">查看</s:a>
    			</td>
    		</tr>
    	</s:iterator>   
    </table> 
    <s:if test="pager.curPage>1">
   	<p align="center">
   		<s:a href="/listUser.action?pager.curPage=1">首页</s:a>
   		<s:a href="/listUser.action?pager.curPage=%{pager.curPage-1}">上一页</s:a>
   	</p>
   </s:if>
   <s:if test="pager.curPage < pager.pageCount">
   	<p align="center">
   		<s:a href="/listUser.action?pager.curPage=%{pager.curPage+1}">下一页</s:a>
   		<s:a href="/listUser.action?pager.curPage=%{pager.pageCount}">尾页</s:a>
   	</p>
   </s:if>
   </div>
    </div>
  </div>
               </div>
            </div>
            </div>
       </div>
</form>
  <!-- 尾部 -->
    <jsp:include page="include/foot.jsp"/>

  </body>
</html>
