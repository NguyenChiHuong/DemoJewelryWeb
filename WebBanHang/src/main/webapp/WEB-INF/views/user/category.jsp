<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/taglib/taglib.jsp" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Sản phẩm</title>
</head>
<body>
<form action="<c:url value='/the-loai'/>" id="formSubmit" method="get">
<div class="container">
<div class="row">
<div id="sidebar" class="span3">
<div class="well well-small">
	<ul class="nav nav-list">
		<c:forEach var="item" items="${category}">
		<li>
            <a href="<c:url value='/the-loai?id=${item.id}&page=1&limit=9'/>">
                <span class="icon-chevron-right"></span> ${item.name}
            </a>
       	</li>
		</c:forEach>
		<li style="border:0"> &nbsp;</li>
		<li> <a class="totalInCart" href="cart.html"><strong>Tổng <span class="badge badge-warning pull-right" style="line-height:18px;">$448.42</span></strong></a></li>
	</ul>
</div>

		  <div class="well well-small alert alert-warning cntr">
			  <h2>50% Discount</h2>
			  <p> 
				 only valid for online order. <br><br><a class="defaultBtn" href="#">Click here </a>
			  </p>
		  </div>
		  <div class="well well-small" ><a href="#"><img src="<c:url value= '/template/user/assets/img/paypal.jpg'/>" alt="payment method paypal"></a></div>
		
		<a class="shopBtn btn-block" href="#">Upcoming products <br><small>Click to view</small></a>
		<br>
		<br>
		<ul class="nav nav-list promowrapper">
		<li>
		  <div class="thumbnail">
			<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
			<img src="<c:url value= '/template/user/assets/img/bootstrap-ecommerce-templates.PNG'/>" alt="bootstrap ecommerce templates">
			<div class="caption">
			  <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span class="pull-right">$22.00</span></h4>
			</div>
		  </div>
		</li>
		<li style="border:0"> &nbsp;</li>
		<li>
		  <div class="thumbnail">
			<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
			<img src="<c:url value= '/template/user/assets/img/shopping-cart-template.PNG'/>" alt="shopping cart template">
			<div class="caption">
			  <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span class="pull-right">$22.00</span></h4>
			</div>
		  </div>
		</li>
		<li style="border:0"> &nbsp;</li>
		<li>
		  <div class="thumbnail">
			<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
			<img src="<c:url value= '/template/user/assets/img/bootstrap-template.png'/>" alt="bootstrap template">
			<div class="caption">
			  <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span class="pull-right">$22.00</span></h4>
			</div>
		  </div>
		</li>
	  </ul>
	</div>
<div class="span9">
<!-- 
New Products
-->

<div class="well well-small">
	<div class="row-fluid">
	  <ul class="thumbnails">
	  <c:forEach var="item" items="${model.listResult}" varStatus="loop">
		<li class="span4">
		  <div class="thumbnail">
			<a href="product_details.html" class="overlay"></a>
			<a class="zoomTool" href="<c:url value="/chi-tiet"/>" title="add to cart"><span class="icon-search"></span> XEM NHANH</a>
			<a href="<c:url value="/chi-tiet"/>"><img src="<c:url value= '/template/user/assets/img/${item.img}'/>" alt=""></a>
			<div class="caption cntr">
				<p>${item.name}</p>
				<p><strong> ${item.price}</strong></p>
				<h4><a class="shopBtn" href="<c:url value='/addCart/${item.id}'/>" title="add to cart"> thêm vào giỏ hàng </a></h4>
				<div class="actionList">
					<a class="pull-left" href="#">thêm danh sách </a> 
					<a class="pull-left" href="#">thêm so sánh </a>
				</div> 
				<br class="clr">
			</div>
		  </div>
		</li>
	 	<!-- Mỗi khi đã hiển thị 3 sản phẩm, đóng thẻ ul hiện tại và mở ul mới -->
        <c:if test="${loop.index % 3 == 2 or loop.last}">
            </ul>
            <ul class="thumbnails">
        </c:if>
		</c:forEach>
	</ul>
	</div>
	<ul class="pagination" id="pagination"></ul>	
	<input type="hidden" value="" id="id" name="id"/>
	<input type="hidden" value="" id="page" name="page"/>
	<input type="hidden" value="" id="limit" name="limit"/>	
</div>
</div>
</div>
</div>
</form>
<script>
$(document).ready(function() {
    var totalPages = ${model.totalPage};
    var currentPage = ${model.page};
    var id = ${model.id}
    window.pagObj = $('#pagination').twbsPagination({
         totalPages: totalPages,
         visiblePages: 3,
         startPage: currentPage,
         onPageClick: function (event, page) {
             if (currentPage != page) {
            	 $('#id').val(id);
            	 $('#page').val(page);
                 $('#limit').val(9);
                 $('#formSubmit').submit();
             }
         }
    });
});

</script>
</body>
</html>