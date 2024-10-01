<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/taglib/taglib.jsp" %>
<head>
<meta charset="UTF-8">
<title>Chi tiết sản phẩm</title>
</head>
<body>
<div class="container">
<div class="row">
<div id="sidebar" class="span3">
<div class="well well-small">
	<ul class="nav nav-list">
		<c:forEach var="item" items="${category}">
			<li><a href="<c:url value='/the-loai?id=${item.id}&page=1&limit=9'/>"><span class="icon-chevron-right"></span> ${item.name}</a></li>
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
  <div class="well well-small" ><a href="#"><img src="assets/img/paypal.jpg" alt="payment method paypal"></a></div>

<a class="shopBtn btn-block" href="#">Upcoming products <br><small>Click to view</small></a>
<br>
<br>
<ul class="nav nav-list promowrapper">
<li>
  <div class="thumbnail">
	<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
	<img src="assets/img/bootstrap-ecommerce-templates.png" alt="bootstrap ecommerce templates">
	<div class="caption">
	  <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span class="pull-right">$22.00</span></h4>
	</div>
  </div>
</li>
<li style="border:0"> &nbsp;</li>
<li>
  <div class="thumbnail">
	<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
	<img src="assets/img/shopping-cart-template.png" alt="shopping cart template">
	<div class="caption">
	  <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span class="pull-right">$22.00</span></h4>
	</div>
  </div>
</li>
<li style="border:0"> &nbsp;</li>
		<li>
		  <div class="thumbnail">
			<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
			<img src="assets/img/bootstrap-template.png" alt="bootstrap template">
			<div class="caption">
			  <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span class="pull-right">$22.00</span></h4>
			</div>
		  </div>
		</li>
	  </ul>

</div>
<div class="span9">
   <ul class="breadcrumb">
   <li><b><a href="<c:url value="/trang-chu"/>">Trang chủ</a></b> <span class="divider">/</span></li>
   <li><a href="<c:url value="/san-pham?page=1&limit=9"/>">Sản phẩm</a> <span class="divider">/</span></li>
   <li class="">Chi tiết</li>
   </ul>	
<div class="well well-small">
<div class="row-fluid">
		<div class="span5">
		<div id="myCarousel" class="carousel slide cntr">
               <div class="carousel-inner">
                 <div class="item active">
                  <a href="#"> <img src="<c:url value="/template/user/assets/img/${model.img}"/>" alt="" style="width:100%"></a>
              </div>
               </div>
               <a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>
               <a class="right carousel-control" href="#myCarousel" data-slide="next">›</a>
           </div>
		</div>
		<div class="span7">
			<h3>${model.name}</h3>
			<hr class="soft"/>
			
		<form class="form-horizontal qtyFrm" action="<c:url value='/giohang'/>" method="get">
		    <div class="control-group">
		        <label class="control-label">
		            <span>
		                <fmt:formatNumber type="number" groupingUsed="true" value="${model.price}" /> ₫
		            </span>
		        </label>
		        <div class="controls">
		            <input type="number" class="span6" min="0" value="${model.quanTy}">
		        </div>
		    </div>
		
		   <div class="control-group">
			    <label class="control-label"><span>Color</span></label>
			    <div class="controls">
			        <select class="span11">
			            <option style="background-color: ${model.colorCode}">${model.colorName}</option>
			        </select>
			    </div>
			</div>

		    <h4></h4>
		    <p>${model.title}</p>
		    <a type="button" href="<c:url value='/addCart/${model.id}'/>" class="shopBtn">
		        <span class="icon-shopping-cart"></span> Thêm giỏ hàng
		    </a>
		</form>
		</div>
		</div>
			<hr class="softn clr"/>

           <ul id="productDetail" class="nav nav-tabs">
             <li class="active"><a href="#home" data-toggle="tab">Chi tiết sản phẩm</a></li>
             <li class=""><a href="#profile" data-toggle="tab">Sản phẩm liên quan</a></li>
           </ul>
           <div id="myTabContent" class="tab-content tabWrapper">
           <div class="tab-pane fade active in" id="home">
           ${model.detail}
		</div>
		<div class="tab-pane fade" id="profile">
		
		<c:set var="count" value="${product.size()}"/>
		<c:if test="${product.size() > 10}">
			<c:set var="count" value="5"/>
		</c:if>
		<c:forEach var="item" items="${product}" begin="1" end="${count}">
			<div class="row-fluid">	  
				<div class="span2">
					<img src="<c:url value="/template/user/assets/img/${item.img}"/>" alt="">
				</div>
				<div class="span4">
					<h5>${item.name } </h5>
					<p>
					${item.title}
					</p>
				</div>
				<div class="span4 alignR">
				<form class="form-horizontal qtyFrm">
				<label class="control-label"><span><fmt:formatNumber type="number" groupingUsed="true" value="${ item.price }" /> ₫</span></label>
				<div class="btn-group">
				  <a href="<c:url value='/addCart/${item.id}'/>" class="defaultBtn"><span class=" icon-shopping-cart"></span> Thêm giỏ hàng</a>
				  <a href="product_details.html" class="shopBtn">XEM THÊM</a>
				 </div>
					</form>
				</div>
			</div>
			<hr class="soft"/>
		</c:forEach>
		</div>
	 </div>
</div>
</div>
</div>
</div>
</body>
