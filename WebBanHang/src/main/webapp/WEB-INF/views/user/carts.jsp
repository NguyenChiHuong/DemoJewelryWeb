<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/taglib/taglib.jsp" %> 
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng</title>
</head>
<body>
<div class="container">
<div class="row">
	<div class="span12">
    <ul class="breadcrumb">
		<li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
		<li class="active">Giỏ hàng</li>
    </ul>
	<div class="well well-small">
		<h1>Giỏ hàng <small class="pull-right"> ${totalQuanTyCart} sản phẩm trong giỏ hàng </small></h1>
	<hr class="soften"/>	

	<table class="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th>Sản phẩm</th>
                  <th>Mô tả</th>
				  <th>Màu sắc</th>
                  <th>Giá bán</th>
                  <th>Số lượng</th>
                  <th>Chỉnh sửa </th>
                  <th>Xóa</th>
                  <th>Tổng tiền</th>
				</tr>
              </thead>
              <tbody>
              <c:forEach var="item" items="${Cart}" varStatus="loop">
               <tr>
                  <td class="span2"><img src="<c:url value="/template/user/assets/img/${item.value.product.img}"/>" alt=""></td>
                  <td class="span3">${item.value.product.title}</td>
                  <td>
				    <span class="shopBtn" style="background-color: ${item.value.product.colorCode}">
				        <span class="icon-ok"></span>
				    </span>
				  </td>
                  <td>${item.value.product.price}</td>
                  <td><input class="span1" min="0" max="100" style="max-width:34px" placeholder="1" id="quanTy-cart-${item.key}" size="16" type="number" value="${item.value.quanTy}" >
				  </td>
                  <td>
					<button data-id="${item.key}" class="btn btn-mini btn-danger edit-cart" type="button"><span class="icon-edit"></span></button>
				  </td>
                  <td><a href="<c:url value='/deleteCart/${item.key}'/>" class="btn btn-mini btn-danger" type="button"><span class="icon-remove"></span></a></td>
                  <td><span class="pull-right"><fmt:formatNumber type="number" groupingUsed="true" value="${item.value.totalPrice}" /> ₫</span></td>
                </tr>
              </c:forEach>
				</tbody>
            </table><br/>
	<a href="<c:url value='/trang-chu'/>" class="shopBtn btn-large"><span class="icon-arrow-left"></span>Tiếp tục mua sắm</a>
	<a href="<c:url value='/thanh-toan'/>" class="shopBtn btn-large pull-right">Thanh toán <span class="icon-arrow-right"></span></a>
</div>
</div>
</div>
</div>

<content tag="script">
<script type="text/javascript">
	$(".edit-cart").on("click",function(){
		var id = $(this).data("id");
		var quanTy = $("#quanTy-cart-" + id).val();
		window.location = "/editCart/" + id + "/" + quanTy;
		});
</script>
</content>

</body>
