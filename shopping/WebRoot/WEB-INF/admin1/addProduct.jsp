<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>购物+</title>
    <!--[if lt IE 9]>
      <script src="${cp}/js/html5shiv.min.js"></script>
      <script src="${cp}/js/respond.min.js"></script>
    <![endif]-->
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
                    <li class="list-group-item-diy"><a href="listUser.action" >查看所有用户<span class="sr-only">(current)</span></a></li>
                    <li class="list-group-item-diy"><a href="listProduct.action" >查看所有商品</a></li>
                    <li class="list-group-item-diy"><a href="addInputProduct.action">添加商品</a></li>
                    <li class="list-group-item-diy"><a href="countCenter.action">数据统计</a></li>
               </ul>
             </div>
  
   <!-- 控制内容 -->
  
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <div class="col-md-12">
                <h1><a name="section3" style="text-algin:center">添加商品</a></h1>
 
                    <div class="col-sm-offset-2 col-md-offest-2">
                      
                <form action="addProduct" method="post" enctype="multipart/form-data">       <!-- 表单输入 -->
                        <div  class="form-horizontal">
                            <div class="form-group">
                                <label for="productName" class="col-sm-2 col-md-2 control-label">商品名称</label>
                                <div class="col-sm-6 col-md-6">
                                    <input type="text" name="name" class="form-control" id="productName" placeholder="安踏" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="productDescribe" class="col-sm-2 col-md-2 control-label">商品描述</label>
                                <div class="col-sm-6 col-md-6">
                                    <textarea type="text" name="description" class="form-control" id="productDescribe" placeholder="好商品"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="keyWord" class="col-sm-2 col-md-2 control-label">关键词</label>
                                <div class="col-sm-6 col-md-6">
                                    <textarea type="text" class="form-control" name="keyword" id="keyword" placeholder="好看"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="productPrice" class="col-sm-2 col-md-2 control-label">商品价格</label>
                                <div class="col-sm-6 col-md-6">
                                    <input type="text" class="form-control" name="price" id="productPrice" placeholder="399" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="productCount" class="col-sm-2 col-md-2 control-label">商品数量</label>
                                <div class="col-sm-6 col-md-6">
                                    <input type="text" class="form-control" name="counts" id="productCount" placeholder="100" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="productType" class="col-sm-2 col-md-2 control-label">商品类别</label>
                                <div class="col-sm-6 col-md-6">
                                    <select name="type" class="form-control" id="productType">
                                        <option value="1">衣服配饰</option>
                                        <option value="2">手机数码</option>
                                        <option value="3">电脑办公</option>
                                        <option value="4">游戏周边</option>
                                        <option value="5">生活用品</option>
                                        <option value="6">美妆清洁</option>
                                        <option value="7">运动户外</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="productImgUpload" class="col-sm-2 col-md-2 control-label">商品图片</label>
                                <div class="col-sm-6 col-md-6">
                                    <input name="upload" type="file"  id="productImgUpload"/>
                                    <p class="help-block">上传的图片大小应为280*160大小</p>
                                </div>
                                <%--<button class="btn btn-primary col-sm-2 col-md-2" onclick="fileUpload()">上传图片</button>--%>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-6" id="imgPreSee">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-6">
                                    <button class="btn btn-lg btn-primary btn-block" type="submit" onclick="addProduct()">添加商品</button>
                                </div>
                            </div>
                        </div>
                        <br/>
                  </form>
                    </div>
               </div>
            </div>
            </div>
       </div>

  <!-- 尾部 -->
    <jsp:include page="include/foot.jsp"/>

  
  </body>
</html>