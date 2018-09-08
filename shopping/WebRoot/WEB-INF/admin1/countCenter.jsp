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
    
    <title>My JSP 'index.jsp' starting page</title>
<link href="css/frame.css" rel="Stylesheet" type="text/css" />
<link href="css/menu.css" rel="Stylesheet" type="text/css" />
      <link href="${cp}/css/bootstrap.min.css" rel="stylesheet">
      <link href="${cp}/css/style.css" rel="stylesheet">

      <script src="${cp}/js/jquery.min.js" type="text/javascript"></script>
      <script src="${cp}/js/ajaxfileupload.js" type="text/javascript"></script>
      <script src="${cp}/js/bootstrap.min.js" type="text/javascript"></script>
      <script src="${cp}/js/layer.js" type="text/javascript"></script>
<style type="text/css">

           
</style>
<script language="javascript" type="text/javascript">
function SetWinHeight(obj)
{
var win=obj;
if (document.getElementByIdx_x)
{
if (win && !window.opera)
{
if (win.contentDocument && win.contentDocument.body.offsetHeight)
win.height = win.contentDocument.body.offsetHeight;
else if(win.Document && win.Document.body.scrollHeight)
win.height = win.Document.body.scrollHeight;
}
}
}
</script>
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
                    <li class="list-group-item-diy"><a href="listUser.action">查看所有用户<span class="sr-only">(current)</span></a></li>
                    <li class="list-group-item-diy"><a href="listProduct.action">查看所有商品</a></li>
                    <li class="list-group-item-diy"><a href="addInputProduct.action">添加商品</a></li>
                    <li class="list-group-item-diy"><a href="countCenter.action">数据统计</a></li>
               </ul>
             </div>
  
   <!-- 控制内容 -->
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <div class="col-md-12">
                                   <h3>数据列表：</h3>
               <div class="container-fluid bigHead">
               <div class="row">
                   <div class="tab-pane" id="all">
                   <table class="table table-hover center" id="allTable">
       
                      
                        <tr>  
                               <th width="25%">统计信息</th>
                               <th width="15%"></th>     
                        </tr>
                        
                        <tr>
                           
                           <td style="text-align:center;">商品总数量：</td>
                           <td style="text-align:center;">${count.procount}</td>
                           
                        </tr>
                                   
                        <tr>
                           
                           <td style="text-align:center;">商品总金额：</td>
                           <td style="text-align:center;">${count.totalpricess}</td>
                           
                        </tr>
                         <tr>
                               
                               <th width="25%">本月统计信息</th>
                               <th width="15%"></th>
                               
                        </tr>
                        
                        <tr>
                           
                           <td style="text-align:center;">本月购买数量：</td>
                           <td style="text-align:center;">${count.montproducts}</td>
                           
                        </tr>
                                   
                        <tr>
                           
                           <td style="text-align:center;">本月购买金额：</td>
                           <td style="text-align:center;">${count.montprices}</td>
                           
                        </tr>
                        </table>
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