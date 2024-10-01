<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/taglib/taglib.jsp" %>
<c:url var="newURL" value="/quan-tri/san-pham/danh-sach" />
<c:url var="editNewURL" value="/quan-tri/san-pham/chinh-sua" />
<c:url var="newAPI" value="/api/new" />
<!DOCTYPE html>
<html>
<head>
	<title>Chỉnh sửa sản phẩm</title>
</head>
<body>
<div class="main-content">
	<div class="main-content-inner">
		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
				try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
			</script>
			<ul class="breadcrumb">
				<li>
					<i class="ace-icon fa fa-home home-icon"></i>
					<a href="<c:url value='/quan-tri/trang-chu'/>">Trang chủ</a>
				</li>
				<li>
					<a href="#">Forms</a>
				</li>
				<li class="active">Form sản phẩm</li>
			</ul><!-- /.breadcrumb -->
		</div>
		<div class="page-content">	 	
			<div class="row">
				<div class="col-xs-12">
					<c:if test="${not empty message}">
						<div class="alert alert-${alert}">
							${message}
						</div>
					</c:if>
					<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model" enctype="multipart/form-data">
						<div class="form-group" style="margin-left: -150px;">
						    <label for="categoryCode" class="col-sm-3 control-label no-padding-right">Thể loại</label>
						    <div class="col-sm-9">
						    	 <form:select path="categoryCode"  id="categoryCode" > <!--path={type + name}  -->
						    	 	  <form:option value="" label="--Chọn thể loại--"/>
								      <form:options items="${categories}" itemValue="code" itemLabel="name"/>
						    	</form:select>
						    </div>
						</div>
						<div class="form-group" style="margin-left: -150px;">
							<label class="col-sm-3 control-label no-padding-right" for="title">Tên sản phẩm</label>
							<div class="col-sm-9">
								<form:input path="name" cssClass="col-xs-10 col-sm-20" id="name" />
							</div>
						</div>
						<div class="form-group" style="margin-left: -150px;">
							 <label for="file" class="col-sm-3 control-label no-padding-right">Ảnh</label>
							 <div class="col-sm-9">
							  	 <form:input type="file" cssClass="form-control" id="file" path="file" multiple="multiple"/>
							 </div>
						</div>
						<div class="form-group" style="margin-left: -150px;">
						    <label for="colorCode" class="col-sm-3 control-label no-padding-right">Màu sắc</label>
						    <div class="col-sm-9">
						    	 <form:select path="colorCode"  id="colorCode" > <!--path={type + name}  -->
						    	 	  <form:option value="" label="--Chọn màu sắc --"/>
								      <form:options items="${colors}" itemValue="code" itemLabel="name"/>
						    	</form:select>
						    </div>
						</div>
						<div class="form-group" style="margin-left: -150px;">
							 <label for="shortDescription" class="col-sm-3 control-label no-padding-right">Mô tả</label>
							 <div class="col-sm-9">
						      	  <form:textarea cssClass="form-control" path="title" rows="5" cols="10" id="title"/>
							 </div>
						</div>
						<div class="form-group" style="margin-left: -150px;">
							 <label for="shortDescription" class="col-sm-3 control-label no-padding-right">Nội dung</label>
							 <div class="col-sm-9">
						      	  <form:textarea cssClass="form-control" path="detail" rows="5" cols="10" id="detail"/>
							 </div>
						</div>
						<div class="form-group" style="margin-left: -150px;">
							 <label for="content" class="col-sm-3 control-label no-padding-right">Giá thành</label>
							 <div class="col-sm-9">					
						     	 <form:input path="price" cssClass="col-xs-10 col-sm-20" id="price" />
							 </div>	  
						</div>
						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
								<form:hidden path="id" id="newId"/> 
								<c:if test="${not empty model.id}">
									<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
										<i class="ace-icon fa fa-check bigger-110"></i>
										Cập nhật sản phẩm
									</button>
								</c:if>
								<c:if test="${empty model.id}">
									<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
										<i class="ace-icon fa fa-check bigger-110"></i>
										Thêm sản phẩm
									</button>
								</c:if>

								&nbsp; &nbsp; &nbsp;
								<button class="btn" type="reset" id="">
									<i class="ace-icon fa fa-undo bigger-110"></i>
									Hủy bỏ
								</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div> 
	</div> 
</div>
<script type="text/javascript">
$(document).ready(function(){
    var editorTitle = CKEDITOR.replace('title');
    var editorDetail = CKEDITOR.replace('detail');

    $('#btnAddOrUpdateNew').click(function (e) {
        e.preventDefault();
        var formData = $('#formSubmit').serializeArray();
        var data = {};

        $.each(formData, function (i, v) {
            data[v.name] = v.value;
        });

        data["title"] = editorTitle.getData();
        data["detail"] = editorDetail.getData();
        var id = $('#newId').val();

        if (id == "") {
            createNew(data);
        } else {
            updateNew(data);
        }
    });

    function createNew(data){
        $.ajax({
            url: '${newAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${editNewURL}?id=" + result.id + "&message=insert_success";
            },
            error: function (error) {
                window.location.href = "${editNewURL}?page=1&limit=2&message=error_system";
            }
        });
    }

    function updateNew(data){
        $.ajax({
            url: '${newAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "${editNewURL}?id=" + result.id + "&message=update_success";
            },
            error: function (error) {
                window.location.href = "${editNewURL}?id=" + result.id + "&message=error_system";
            }
        });
    }
});

</script>
</body>
</html>