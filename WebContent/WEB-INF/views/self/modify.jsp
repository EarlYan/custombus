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
<title>个人资料编辑</title>
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
				<h5>编辑个人信息</h5>
				<div class="ibox-tools">
					<a class="collapse-link"> <i class="fa fa-chevron-up"></i> </a> <a
						class="close-link"> <i class="fa fa-times"></i> </a>
				</div>
			</div>
			<div class="ibox-content">
				<form class="form-horizontal m-t" id="modifyForm">
				    <input type="hidden" id="memberId" value="${member.id}"/>
				    <div class="form-group">
						<label class="col-sm-3 control-label">真实姓名：</label>
						<div class="col-sm-8">
							<input id="memberRealName" name="memberRealName" class="form-control"
								type="text" aria-required="true" aria-invalid="true"
								class="error" value="${member.realname}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">邮箱：</label>
						<div class="col-sm-8">
							<input id="memberEmail" name="memberEmail" class="form-control"
								type="text" aria-required="true" aria-invalid="true"
								class="error" value="${member.email}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">性别：</label>
						<div class="col-sm-8">
						<c:if test="${member.gender == false}">
							<input type="radio" name="sex" id="sex1" value="0" checked="">男
							<input type="radio" name="sex" id="sex2" value="1" >女
						</c:if>
						<c:if test="${member.gender == true}">
							<input type="radio" name="sex" id="sex1" value="0" >男
							<input type="radio" name="sex" id="sex2" value="1" >女
						</c:if>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">手机号：</label>
						<div class="col-sm-8">
							<input id="memberMobile" name="memberMobile" class="form-control"
								type="text" aria-required="true" aria-invalid="true"
								class="error" value="${member.mobile}">
							<font id="errorpass" style="display:none" color="red">手机号已经被占用,请重新输入</font>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">头像：</label>
						<div class="col-sm-3">
							<div class="form-single-img">
								<div class="img-box plus" id="headImg1"
									style="background-image: url('${member.imgurl}');">
									<input type="file" id="img1" name="img1"> <input
										type="hidden" name="img" id="img" value="${member.imgurl}">
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
	<script type="text/javascript" src="../assets/js/jquery.validate.js"></script> 
	<script type="text/javascript">
    jQuery.validator.addMethod("isMobile", function(value, element) {
        var length = value.length;
        var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, "请正确填写您的手机号码");
    
    jQuery.validator.addMethod("mobileCanModify", function(value, element) {
        var flag = 1;
        $.ajax({
          type:"GET",
          url:'../login/isMobileCanModify',
          async:false,
          data:{'mobile':value},
          success: function(msg){
        	console.log(msg);
            if(msg == 'true'){
              flag = 0;
            }
          }
        });
        if(flag == 0){
          return true;
        }else{
          return false;
        }
     }, "对不起手机号码已经被注册");
	</script>
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
	function checkModify(){ 
	    return $("#modifyForm").validate({
	        rules: {
	        	memberRealName: "required",
	        	memberEmail: {
	            required: true,
	            email: true
	          },
	          memberMobile:{
	            required : true,
	            minlength : 11,
	            isMobile : true,
	            mobileCanModify : true
	          }
	        },
	        messages: {
	        	memberRealName: "请输入用户名",
	        	memberEmail: "请输入一个正确的邮箱",
	        	memberMobile: {
	        	  isMobile:  "请正确填写您的手机号码",
	        	  mobileCanModify:  "对不起手机号码已经被注册"
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
	            id:$("#memberId").val(),
	            memberRealName:$("#memberRealName").val(),
	            memberEmail:$("#memberEmail").val(),
	            memberGender:$("input[name='sex']:checked").val(),
	            memberMobile:$("#memberMobile").val(),
	        	memberImageURL:$("#img").val()
	        },
	        dataType: "text",
	        async : true,
	        success:function(data){
	            alert("succeed");
	            window.location.href = "../self/modifyPage";
		    },
		    error:function(data){
			    alert("error");
	    	}
		});
	};
	</script>
</body>
</html>