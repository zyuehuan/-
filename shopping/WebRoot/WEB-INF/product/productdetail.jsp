<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>商品详情</title>

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
    
    
    <div class="container-fluid">
      
        <div class="row">
            <div class="col-sm-1 col-md-1"></div>
            <div class="col-sm-10 col-md-10">
            
                <h1>${product.name}</h1>
             
                <hr/>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1 col-md-1"></div>
            <div class="col-sm-5 col-md-5">
                <img class="detail-img" src="${product.path}">
            </div>
            <div class="col-sm-5 col-md-5 detail-x">
                <table class="table table-striped">
                
                    <tr>
                        <th>商品名称</th>
                        <td>${product.name}</td>
                    </tr>
                    <tr>
                        <th>商品价格</th>
                        <td>${product.price}</td>
                    </tr>

                    <tr>
                        <th>商品类别</th>
                        <td>${product.type}</td>
                    </tr>
                    <tr>
                        <th>商品库存</th>
                        <td>${product.counts}</td>
                    </tr>
                    <tr>
                        <th>购买数量</th>
                        <td>
                            <div class="btn-group" role="group">
                                  <input value="-" type="button"  class="btn btn-default" onclick="add(-1)"/> 
      	                          <input name="number" id="number" type="button" class="btn btn-default" value="1"/>
		                          <input value="+" type="button" class="btn btn-default" onclick="add(1)"/> 
                                
                            </div>
                        </td>
                    </tr>
               
                </table>
                <div>
                                 
                     <p>商品描述</p>   
                   ${product.description}
                    
                </div>
                <br>
                <div class="row">
                    <div class="col-sm-1 col-md-1 col-lg-1"></div>
                    <button class="btn btn-danger btn-lg col-sm-4 col-md-4 col-lg-4" onClick="outPut()">添加购物车</button>
                    <div class="col-sm-2 col-md-2 col-lg-2"></div>
                    <button  class="btn btn-danger btn-lg col-sm-4 col-md-4 col-lg-4" onclick="buyConfirm()">购买</button>

                </div>
                
            </div>
        </div>
        
  
    
        </div>
     
     
   
    <!-- 尾部 -->
    <jsp:include page="include/foot.jsp"/>
    
    <script type="text/javascript">
     	  function add(t){ 
		  	var number1 = parseInt(document.getElementById("number").value); 
		  	if(number1==1&&t==-1)
		  		document.getElementById("number").value=1;
		  	else
		    	document.getElementById("number").value=number1+t; 
		} 
		function outPut(){
			var num=parseInt(document.getElementById("number").value);
			document.location.href="addToCart.action?pid=${product.id}&number=" +num;
			}
      function buyConfirm(){
			var num=parseInt(document.getElementById("number").value);
			document.location.href="buy.action?pid=${product.id}&number=" +num;
			}
        </script>
  </body>
</html>