<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/taglib/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
   	<title><dec:title default="Đăng nhập" /></title>
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
 	<!-- Bootstrap styles -->
    <link href="<c:url value= '/template/user/assets/css/bootstrap.css'/>" rel="stylesheet"/>
    <!-- Customize styles -->
    <link href="<c:url value= '/template/user/css/style.css'/>" rel="stylesheet"/>
    <!-- font awesome styles -->
	<link href="<c:url value= '/template/user/assets/font-awesome/css/font-awesome.css'/>" rel="stylesheet">
	<!-- Favicons -->
    <link rel="shortcut icon" href= "<c:url value='/template/user/assets/ico/favicon.ico'/>">
    <script src="<c:url value='/template/user/paging/jquery.twbsPagination.js' />"></script> 
    <style>
        body {
            background-image: url('<c:url value="/template/user/assets/img/white_leather.png"/>');
            background-image: url('<c:url value="/template/user/assets/img/new.png"/>') 
            background-repeat: repeat;
        }
        
    </style>
</head>
<body>
    <!-- Navigation -->
	<%@ include file="/common/user/header.jsp" %>

	<dec:body/>

	<!-- Footer -->
	<%@ include file="/common/user/footer.jsp" %>

	<!-- Bootstrap core JavaScript -->
	<script src="<c:url value='/template/user/assets/js/jquery.js'/>"></script>
	<script src="<c:url value='/template/user/assets/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/template/user/assets/js/jquery.easing-1.3.min.js'/>"></script>
    <script src="<c:url value='/template/user/assets/js/jquery.scrollTo-1.4.3.1-min.js'/>" ></script>
    <script src="<c:url value='/template/user/assets/js/shop.js'/>"></script>
</body>
</html>