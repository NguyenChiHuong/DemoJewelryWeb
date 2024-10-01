<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.webbanhang.util.SecurityUtil" %>
<%@ include file="/taglib/taglib.jsp" %>
<!DOCTYPE html>
<div class="container">
<header id="header">
<div class="row">
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="topNav">
		<div class="alignR">
			<div class="pull-left socialNw">
				<a href="https://twitter.com"><span class="icon-twitter"></span></a>
				<a href="https://www.facebook.com"><span class="icon-facebook"></span></a>
				<a href="https://www.youtube.com"><span class="icon-youtube"></span></a>
			</div>
			<security:authorize access="isAuthenticated()"> <!-- Đăng nhập thành công -->
			<a class="active" href="<c:url value='/trang-chu'/>"> <span class="icon-home" ></span> Trang chủ</a> 
			<a href="#"><span class="icon-user"></span> Wellcome <%=SecurityUtil.getPrincipal().getFullName() %></a> 
			<a href="<c:url value='/giohang'/>"><span class="icon-shopping-cart"></span> ${totalQuanTyCart} - 
			<c:if test="${empty totalPriceCart}">
				<span class="badge badge-warning"> 0$</span>
			</c:if>
			<c:if test="${not empty totalPriceCart }">
				<span class="badge badge-warning"> ${totalPriceCart} $</span>
			</c:if>
			</a>
			<a class="nav-link" href="<c:url value='/thoat'/>">Thoát</a>
			</security:authorize>
		</div>
	</div>
</div>
</div>
</header>

<div class="navbar">
  <div class="navbar-inner">
	  <a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar">
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
	  </a>
	  <div class="nav-collapse">
		<ul class="nav">
			<c:forEach var="item" items="${menu}" >
			<c:if test="${item.id == 1}">
				<li><a href="<c:url value='/trang-chu'/>">${item.name}</a></li>
			</c:if>
			<c:if test="${item.id == 2}">
				 <li><a href="<c:url value='/san-pham?page=1&limit=9'/>">${item.name}</a></li>
			</c:if>
			<c:if test="${item.id == 3}">
				<li><a href="<c:url value='/sosanh'/>">${item.name}</a></li>
			</c:if>
			<c:if test="${item.id == 4}">
				<li><a href="<c:url value='/giohang'/>">${item.name}</a></li>
			</c:if>
			<c:if test="${item.id == 5}">
				<li><a href="<c:url value='/baiviet'/>">${item.name}</a></li>
			</c:if>
			<c:if test="${item.id == 6}">
				<li><a href="<c:url value='/lienhe'/>">${item.name}</a></li>
			</c:if>
			</c:forEach>
		</ul>
		<form action="#" class="navbar-search pull-left">
		  <input type="text" placeholder="Tìm kiếm" class="search-query span2">
		</form>
		<ul class="nav pull-right">
		<li class="dropdown">
		<security:authorize access="isAnonymous()"> <!-- ẩn danh chưa đăng nhập hoặc chưa đăng kí -->
			<li class="nav-item"><a  class="icon-user" class="nav-link" href='<c:url value='/dang-nhap'/>'>Đăng nhập</a></li>
			<li class="nav-item"><a class="icon-edit"  class="nav-link" href='<c:url value='/dang-ki'/>'> Đăng kí</a></li>
		</security:authorize>
		</li>
		</ul>
	  </div>
	</div>
  </div>
</div>