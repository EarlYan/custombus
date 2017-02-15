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
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>司机资格审核</title>
<link href="<%=path%>/user/css/bootstrap.min.css?v=3.4.0"
	rel="stylesheet">
<link href="<%=path%>/user/css/font-awesome.min.css?v=4.3.0"
	rel="stylesheet">
<link href="<%=path%>/user/css/animate.min.css" rel="stylesheet">
<link href="<%=path%>/user/css/style.min.css?v=3.2.0" rel="stylesheet">
<link rel="stylesheet" href="../assets/css/flatpickr.min.css" type="text/css"> <!--日期选择器-->
<style type="text/css">
.error{
    color: red;
}
</style>
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
				<h5>资格认证</h5>
				<div class="ibox-tools">
					<a class="collapse-link"> <i class="fa fa-chevron-up"></i> </a> <a
						class="close-link"> <i class="fa fa-times"></i> </a>
				</div>
			</div>
			<div class="ibox-content">
				<form class="form-horizontal m-t" id="identifyForm">
				    <input type="hidden" id="driverId" value="${member.id}"/>
				    <div class="form-group">
						<label class="col-sm-3 control-label">车牌号：</label>
						<div class="col-sm-8">
							<input id="bus_plate_number" name="bus_plate_number" class="form-control"
								type="text" aria-required="true" aria-invalid="true"
								class="error" value="${bus.plate_number}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">巴士座位数：</label>
						<div class="col-sm-8">
							<input id="bus_seat_number" name="bus_seat_number" class="form-control"
								type="text" aria-required="true" aria-invalid="true"
								class="error" value="${bus.seat_number}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">巴士车型：</label>
						<div class="col-sm-8">
							<select name="bus_type" id="bus_type" class="select">
							<option value="1">小型客车</option>
							<option value="2">中型客车</option>
							<option value="3">大型客车</option>
							</select>
						</div>
					</div>
				    <div class="form-group">
						<label class="col-sm-3 control-label">驾驶证类型：</label>
						<div class="col-sm-8">
							<input id="licenseType" name="licenseType" class="form-control"
								type="text" aria-required="true" aria-invalid="true"
								class="error" value="${license.type}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">驾驶证编号：</label>
						<div class="col-sm-8">
							<input id="license_serial_number" name="license_serial_number" class="form-control"
								type="text" aria-required="true" aria-invalid="true"
								class="error" value="${license.serial_number}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">有效起始日期：</label>
						<div class="col-sm-8">
							<input id="license_start_time" name="license_start_time" class="flatpickr"
								type="text" aria-required="true" aria-invalid="true"
								data-time_24hr="true" placeholder="请选择时间" readonly="readonly"
								class="error" value="${license.start_time}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">有效年限：</label>
						<div class="col-sm-8">
							<input id="license_time_limit" name="license_time_limit" class="form-control"
								type="text" aria-required="true" aria-invalid="true"
								class="error" value="${license.time_limit}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">执照：</label>
						<div class="col-sm-3">
							<div class="form-single-img">
								<div class="img-box plus" id="headImg1"
									style="background-image: url('${license.imgurl}');">
									<input type="file" id="img1" name="img1"> <input
										type="hidden" name="img" id="img" value="${license.imgurl}">
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-8 col-sm-offset-3">
							<input onClick="user_submit();" class="btn btn-primary" type="submit" value="提交">
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
	    jQuery.validator.addMethod("isVehicle", function(value, element) {
	        var length = value.length;
	        var express = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
	        return this.optional(element) || (length == 7 && express.test(value));
	    }, "请正确填写您车牌号");
	</script>
	<script>
	    flatpickr(".flatpickr", {
	        minuteIncrement: 1
	    });
		$('.form-single-img').on('change', 'input[type=file]', function(){
		var fileid = $(this).attr('id');
		var parent = $(this).parent();
		var child1 = $(this).parent().children('input[type=file]').first().next();
		$.ajaxFileUpload({
			url:'../image/uploadImage',
			secureuri:false,
			dataType:'text',
			fileElementId:fileid,//file标签的id
			success: function (data, status) {
				//图片预览
				var jsonobj=eval('('+data+')');
				var imageurl = "/custombus/image/readImage?name="+jsonobj.fileName;
				parent.css('background-image', 'url('+ imageurl+')');
				//图片地址赋值给后台
				child1.val(imageurl);
			},
			error: function (data, status, e) {
			}
		});
	});
	</script>
	<script type="text/javascript">	
    function check(){ 
        return $("#identifyForm").validate({
            rules: {
              bus_plate_number: {
            	  required: true, 
            	  isVehicle :true
              },
        	  bus_seat_number: {
                required: true,
                digits:true
              },
              licenseType: "required",
              license_serial_number : "required",
              license_time_limit : {
                  required: true,
                  digits:true
              }
            },
            messages: {
              bus_plate_number: {
            	  required: "请输入车牌号",
            	  isVehicle : "请正确填写车牌号",
              },
              bus_seat_number: {
            	  required:  "请输入座位数",
            	  digits: "座位数必须为数字"
              },
              licenseType: "请输入驾驶证类型",
              license_serial_number :"请输入驾驶证编号",
              license_time_limit:{
            	  required: "请输入有效年限",
                  digits:"有效年限必须为数字"
              }
            }
        });
    }
    
	function user_submit()
	{   
		if(!check().form()) return; 
		$.ajax(
		{
			type: "post",
	    	url: "upload",
	        data: {
	            id:$("#driverId").val(),
	            bus_plate_number:$("#bus_plate_number").val(),
	            bus_seat_number:$("#bus_seat_number").val(),
	            bus_type:$("#bus_type").val(),
	            licenseType:$("#licenseType").val(),
	            license_serial_number:$("#license_serial_number").val(),
	            license_start_time:$("#license_start_time").val(),
	            license_time_limit:$("#license_time_limit").val(),
	            imgurl:$("#img").val()
	        },
	        dataType: "text",
	        async : true,
	        success:function(data){
	            alert("上传成功请等待管理员审核");
	            window.location.href = "../manage/front";
		    },
		    error:function(data){
			    alert("error");
	    	}
		});
	};
	</script>
</body>
</html>