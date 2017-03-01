<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>修改众筹</title>
<link href="<%=path%>/user/css/bootstrap.min.css?v=3.4.0"
	rel="stylesheet">
<link href="<%=path%>/user/css/font-awesome.min.css?v=4.3.0"
	rel="stylesheet">
<link href="<%=path%>/user/css/animate.min.css" rel="stylesheet">
<link href="<%=path%>/user/css/style.min.css?v=3.2.0" rel="stylesheet">
<link rel="stylesheet" href="../assets/css/flatpickr.min.css" type="text/css"> <!--日期选择器-->
<style type="text/css">
.form-single-img .img-box {
    width: 130px;
    height: 0;
    padding-bottom: 82px;
    position: relative;
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    border-radius: 5px;
    background-color: #fff;
    background-repeat: no-repeat;
    background-size: cover;
    background-position: center;
    box-shadow: 0 0 0 1px #a89e99 inset;
}
.form-single-img .img-box.plus:after {
    content: '';
    position: absolute;
    left: 0;
    top: 0;
    z-index: 2;
    width: 100%;
    height: 100%;
    background-image: url(<%=path%>/user/img/icon-cross.png);
    background-repeat: no-repeat;
    background-size: 34px;
    background-position: center;
}
.form-single-img .img-box input[type=file] {
    position: absolute;
    width: 100%;
    height: 100%;
    left: 0;
    top: 0;
    z-index: 100;
    opacity: 0;
}

</style>
</head>

<body class="gray-bg">
	<div class="col-sm-12">
		<div class="ibox float-e-margins">
			<div class="ibox-title">
				<h5>修改众筹</h5>
				<div class="ibox-tools">
					<a class="collapse-link"> <i class="fa fa-chevron-up"></i> </a> <a
						class="close-link"> <i class="fa fa-times"></i> </a>
				</div>
			</div>
			<div class="ibox-content">
				<form class="form-horizontal m-t" id="modifyForm">
				    <input type="hidden" id="propertyId" value="${property.id}"/>
				    <div class="form-group">
						<label class="col-sm-3 control-label">起点：</label>
						<div class="col-sm-8">
							<input id="startLocation" name="startLocation" class="form-control"
								aria-required="true" aria-invalid="true"
								class="error" value="${property.startLocation}">							
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">终点：</label>
						<div class="col-sm-8">
							<input id="endLocation" name="endLocation" class="form-control"
								aria-required="true" aria-invalid="true"
								class="error" value="${property.endLocation}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">出发时间：</label>
						<div class="col-sm-8">
							<input id="goTime" name="goTime" class="flatpickr"
								aria-required="true" aria-invalid="true"
								class="error" value="${property.goTime}"
								readonly="readonly"
								data-enable-time=true data-enable-seconds=true data-no-calendar=true>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">回程时间：</label>
						<div class="col-sm-8">
							<input id="backTime" name="backTime" class="flatpickr"
								aria-required="true" aria-invalid="true"
								class="error" value="${property.backTime}"
								readonly="readonly"
								data-enable-time=true data-enable-seconds=true data-no-calendar=true>
						</div>
					</div>					
					<div class="form-group">
						<label class="col-sm-3 control-label">提议：</label>
						<div class="col-sm-8">
							<input id="notes" name="notes" class="form-control"
								aria-required="true" aria-invalid="true"
								class="error" value="${property.notes}">
						</div>
					</div>	
					<div class="form-group">
						<label class="col-sm-3 control-label">距离：</label>
						<div class="col-sm-8">
							<input id="distance" name="distance" class="form-control"
								aria-required="true" aria-invalid="true"
								class="error" value="${property.distance}">
						</div>
					</div>					
					<div class="form-group">
						<div class="col-sm-8 col-sm-offset-3">
							<input onClick="user_submit();" class="btn btn-primary" type="button" value="提交">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- 全局js -->
	<script src="<%=path%>/user/js/jquery-2.1.1.min.js"></script>
	<script src="<%=path%>/user/js/bootstrap.min.js?v=3.4.0"></script>

	<!-- 自定义js -->
	<script src="<%=path%>/user/js/content.min.js?v=1.0.0"></script>

	<!-- jQuery Validation plugin javascript-->
	<script src="<%=path%>/user/js/plugins/validate/jquery.validate.min.js"></script>
	<script src="<%=path%>/user/js/plugins/validate/messages_zh.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/ajaxfileupload.js"></script>
	<script type="text/javascript" src="../assets/js/flatpickr.js"></script><!--时间选择器-->
	<script type="text/javascript" src="../assets/js/jquery.validate.js"></script> 
	<script type="text/javascript">
	//时间选择器
    flatpickr(".flatpickr", {
        enableTime: true,
        noCalendar: true,
        minuteIncrement: 1
    });
	
	function checkModify(){ 
	    return $("#modifyForm").validate({
	        rules: {
	        	startLocation: "required",
	        	endLocation: "required",
	        	goTime: "required",
	        	backTime: "required",
	        	notes: "required",
	        	distance:{
	        		required : true,
	        		number : true
	        	}
	        },
	        messages: {
	        	startLocation: "请输入起点",
	        	endLocation: "请输入终点",
	        	goTime: "请选择出发时间",
	        	backTime: "请选择回程时间",
	        	notes: "请输入提议",	        	
	        	distance: {
	          		required:  "请输入距离",
	        		digits:  "距离必须为数字"
		        }
	        }
	    }); 
	}
	
	function user_submit()
	{   
		if(!checkModify().form()) return; 
		$.ajax(
		{
			type: "post",
	    	url: "update",
	        data: {
	            id:$("#propertyId").val(),
	            startLocation:$("#startLocation").val(),
	            endLocation:$("#endLocation").val(),
	            goTime:$("#goTime").val(),
	            backTime:$("#backTime").val(),
	            notes:$("#notes").val(),
	            distance:$("#distance").val()
	        },
	        dataType: "json",
	        async : true,
	        success:function(data){
	            alert("succeed");
	            window.location.href = "../property/index";
		    },
		    error:function(data){
			    alert("error");
	    	}
		});
	};
	</script>
</body>
</html>