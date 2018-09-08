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
   
    <link href="${cp}/css/xiala.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="css/city-picker.css" rel="stylesheet" type="text/css" />
    
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/city-picker.data.js"></script>
    <script src="js/city-picker.js"></script>
    <script src="js/main.js"></script>
  
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
    
  
    <div class="col-sm-offset-2 col-md-offest-2">
        <!-- 表单输入 -->
       <div  class="form-horizontal">
          <h1>修改个人地址</h1>
          
           <form action="updatedAddress" method="post">
                  <input type="hidden" name="id" value="${user.id}">
                 <div class="form-group">
                   <div class="col-sm-6 col-md-6">
                    <label for="address">地址:</label>
                    </div>                  
                 </div>
                 <div class="form-group">
                  <div class="col-sm-6 col-md-6">
                        <input type="text" class="form-control" name="address2" id="address2" value="${user.address}" />
                    </div>
                 </div>
                  <div class="form-group">
                   <div class="col-sm-6 col-md-6"> 
                  <input type="submit" class="btn btn-danger" value="更新"> 
                  </div>
                </div>
           </form>
    <br/>
          <label><span class="red"></span>选择地区:</label>
	  
		   <form>
			<div id="distpicker">
			   
				<div class="form-group">
					<div class="col-sm-6 col-md-6">
						<input id="city-picker3" class="form-control" readonly type="text" value="广东省/广州市/从化区" data-toggle="city-picker">
					</div>
				</div>
				<div class="form-group">
				    <div class="col-sm-6 col-md-6">
					<button class="btn btn-warning" id="reset" type="button">重置</button>
					<button class="btn btn-danger" id="destroy" type="button">确定</button>
					</div>
				</div>
				<div class="form-group">
				      <div class="col-sm-6 col-md-6">
				       <label for="inputUsername">详细地址:</label>
				      </div>
				</div>
				 <div class="form-group">				     
                    <div class="col-sm-6 col-md-6">     
                        <input type="text" class="form-control" id="address1" name="address1"/>
                    </div>                  	
    			</div> 
    			<div class="form-group">
    			    <div class="col-sm-6 col-md-6"> 
    				<input type="button" class="btn btn-danger" onclick="update()" value="确定">
    				</div>
    			</div>
			</div>
		</form>
	</div>
	</div>
	</div>

                
       


<!--尾部-->
<jsp:include page="include/foot.jsp"/>
<script type="text/javascript">
     function update(){ 
       var city = document.getElementById("city-picker3").value;
       var address1 = document.getElementById("address1").value;
	   document.getElementById("address2").value= city + '/' + address1;
		} 
   
</script>
</body>
</html>