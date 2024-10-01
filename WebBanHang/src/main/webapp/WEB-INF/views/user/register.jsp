<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/taglib/taglib.jsp" %>    
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Đăng kí</title>
</head>
<body>
<div class="container">
<div class="row">
<div id="sidebar" class="span3">
<div class="well well-small">
			<ul class="nav nav-list">
					<c:forEach var="item" items="${category}">
						<li><a href="products.html"><span class="icon-chevron-right"></span> ${item.name}</a></li>
					</c:forEach>
					<li style="border: 0">&nbsp;</li>
					<li><a class="totalInCart" href="cart.html"><strong>Tổng <span class="badge badge-warning pull-right"
								style="line-height: 18px;">0$</span>
						</strong></a></li>
				</ul>
			</div>

			  <div class="well well-small alert alert-warning cntr">
				  <h2>50% Discount</h2>
				  <p> 
					 only valid for online order. <br><br><a class="defaultBtn" href="#">Click here </a>
				  </p>
			  </div>
			  <div class="well well-small" ><a href="#"><img src="<c:url value='/template/user/assets/img/paypal.jpg'/>" alt="payment method paypal"></a></div>
			
			<a class="shopBtn btn-block" href="#">Upcoming products <br><small>Click to view</small></a>
			<br>
			<br>
			<ul class="nav nav-list promowrapper">
		  </ul>

	</div>
	<div class="span9">
    <ul class="breadcrumb">
		<li><a href="index.html"><b>Trang chủ</b></a> <span class="divider">/</span></li>
		<li class="active">Đăng kí</li>
    </ul>
	<h3>Đăng kí tài khoản</h3>	
	<hr class="soft"/>
	<div class="well">
	<form:form action="${pageContext.request.contextPath}/dang-ki" method="POST" modelAttribute="User" class="form-horizontal">
	    <h3>Chi tiết đăng kí</h3>
	    <div class="control-group">
	        <label class="control-label" for="inputname">Họ và tên <sup>*</sup></label>
	        <div class="controls">
	            <form:input type="text" path="fullName"  placeholder="Nhập họ và tên"/>  
	        </div>
	    </div>  
	    <div class="control-group">
	        <label class="control-label" for="inputname">Tên tài khoản <sup>*</sup></label>
	        <div class="controls">
	            <form:input type="text" path="username"  placeholder="Nhập tên người dùng"/> 
	        </div>
	    </div>  
	    <div class="control-group">
	        <label class="control-label" for="inputname">Email <sup>*</sup></label>
	        <div class="controls">
	            <form:input type="text" path="email"  placeholder="Địa chỉ email"/> 
	        </div>
	    </div>  
	    <div class="control-group">
	        <label class="control-label">Mật khẩu <sup>*</sup></label>
	        <div class="controls">
	            <form:input type="password" path="password"  placeholder="Nhập mật khẩu"/> 
	        </div>
	    </div>
	    <div class="control-group">
	        <div class="controls">
	            <button  type="submit" class="exclusive shopBtn">Đăng ký tài khoản</button>
	        </div>
	    </div>
	</form:form>
</div>
</div>
</div>
</div>
</body>