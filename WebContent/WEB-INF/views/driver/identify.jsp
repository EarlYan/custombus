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
<title>司机资格审核</title>
<link href="<%=path%>/user/css/bootstrap.min.css?v=3.4.0"
	rel="stylesheet">
<link href="<%=path%>/user/css/font-awesome.min.css?v=4.3.0"
	rel="stylesheet">
<link href="<%=path%>/user/css/animate.min.css" rel="stylesheet">
<link href="<%=path%>/user/css/style.min.css?v=3.2.0" rel="stylesheet">
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
				<form class="form-horizontal m-t" id="modifyForm">
				    <input type="hidden" id="driverId" value="${member.id}"/>
					<div class="form-group">
						<label class="col-sm-3 control-label">执照：</label>
						<div class="col-sm-3">
							<div class="form-single-img">
								<div class="img-box plus" id="headImg1"
									style="background-image: url('${member.licenseUrl}');">
									<input type="file" id="img1" name="img1"> <input
										type="hidden" name="img" id="img" value="${member.licenseUrl}">
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
	<script>
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
	function user_submit()
	{   
		$.ajax(
		{
			type: "post",
	    	url: "upload",
	        data: {
	            id:$("#memberId").val(),
	            licenseUrl:$("#img").val()
	        },
	        dataType: "text",
	        async : true,
	        success:function(data){
	            alert("上传成功请等待管理员审核");
	            window.location.href = "../driver/identify";
		    },
		    error:function(data){
			    alert("error");
	    	}
		});
	};
	</script>
</body>
</html>