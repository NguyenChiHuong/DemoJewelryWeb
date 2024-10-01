<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/taglib/taglib.jsp" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
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
		<li class="active">Đăng nhập</li>
    </ul>
	<h3> Đăng nhập</h3>	
	<hr class="soft"/>
	
	<div class="row">
		<div class="span1"> &nbsp;</div>
		<div class="span4">
			<div class="well">
			<c:if test="${param.incorrectAccount != null}">
				<div class="alert alert-danger">Username or password incorrect</div>
			</c:if>
			<c:if test="${param.accessDenied != null}">
				<div class="alert alert-danger">Not authorize incorrect</div>
			</c:if>
			<form action="j_spring_security_check" id="formLogin" method="post">
			  <div class="control-group">
				<label class="control-label" for="inputUsername">Tài khoản</label>
				<div class="form-group">
						<input type="text" class="form-control" id="userName" name="j_username" placeholder="Tên đăng nhập">
				</div>
			  </div>
			  <div class="control-group">
				<label class="control-label" for="inputPassword">Mật khẩu</label>
				<div class="form-group">
						<input type="password" class="form-control" id="password" name="j_password" placeholder="Mật khẩu">
				</div>
			  </div>
			  <div class="control-group">
				<div class="controls">
				  <button type="submit" class="defaultBtn">Đăng nhập</button> <a href="<c:url value='/quen-matkhau'/>">Quên mật khẩu?</a>
				</div>
			  </div>
			</form>
		</div>
		</div>
	</div>	
</div>
</div>
</div>
</body>
</html>
