<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Aviators - byaviators.com">

    <link rel="shortcut icon" href="../assets/img/favicon.png" type="image/png">
    <link rel="stylesheet" href="../assets/css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="../assets/css/bootstrap-responsive.css" type="text/css">
    <link rel="stylesheet" href="../assets/libraries/chosen/chosen.css" type="text/css">
    <link rel="stylesheet" href="../assets/libraries/bootstrap-fileupload/bootstrap-fileupload.css" type="text/css">
    <link rel="stylesheet" href="../assets/libraries/jquery-ui-1.10.2.custom/css/ui-lightness/jquery-ui-1.10.2.custom.min.css" type="text/css">
    <link rel="stylesheet" href="../assets/css/realia-blue.css" type="text/css" id="color-variant-default">
    <link rel="stylesheet" href="../assets/css/jquery.steps.css" type="text/css">
    <link rel="stylesheet" href="../assets/css/slide-unlock.css" type="text/css">
    <style type="text/css">
    .error{
        color: red;
    }
    </style>
    <title>定制巴士</title>
</head>
<body>
<div id="wrapper-outer" >
    <div id="wrapper">
        <div id="wrapper-inner">
           <%@include file="/WEB-INF/views/web/header.jsp"%>
          
            <!-- CONTENT -->
            <div id="content">
<div class="container">
    <div>
        <div id="main">
            <div class="our-agents-large">
    <h2 class="page-header">找回密码</h2>

    <div class="content">
        <div class="agent">
            <div class="row">
                <form id="example-advanced-form" action="#">
                    <h3>提示</h3>
                    <fieldset>
                        <legend>流程</legend>
                 
                        <p>接下来您将按照流程来找回你的密码</p>
                    </fieldset>
                 
                    <h3>信息</h3>
                    <fieldset>
                        <legend>输入</legend>
                        <p>请填写需要找回的账号：</p>
                        <label for="username">用户名 *</label>
                        <input id="username" name="name" type="text" class="required">
                        <label for="userphone">手机号 *</label>
                        <input id="userphone" name="phone" type="text" class="required">
                        <input id="existTest" name="existTest" type="hidden" value="no"> 
                        <p>(*) 必填</p>
                        <div id="demo">
                          <div id="slider" style="margin-left: 0">
                            <div id="slider_bg"></div>
                            <span id="label">>></span> <span id="labelTip">拖动滑块验证</span></div>
                            <input id="sliderTestInfo" name="sliderTestInfo" style="display:none" type="text">    
                        <input id="sliderTest" name="sliderTest" type="hidden" value="no"> 
                        </div>        
                    </fieldset>
                 
                    <h3>警告</h3>
                    <fieldset>
                        <legend>出错</legend>
                 
                        <p>没有相关信息⚠️</p>
                    </fieldset>
                 
                    <h3>完成</h3>
                    <fieldset>
                        <legend>成功</legend>
                        <label for="acceptTerms-2">成功找回你的密码,你的密码被重设为:</label><input id="passwordBack" type="text" disabled="disabled" value="password">
                    </fieldset>
                </form>
            </div><!-- /.row -->
        </div><!-- /.agent -->

        
        
    </div><!-- /.content -->
</div><!-- /.our-agents -->        </div>
    </div>
</div>

    </div><!-- /#content -->
</div><!-- /#wrapper-inner -->
<%@include file="/WEB-INF/views/web/footer.jsp"%>
</div><!-- /#wrapper -->
</div><!-- /#wrapper-outer -->


<script type="text/javascript" src="../assets/js/jquery.js"></script>
<script type="text/javascript" src="../assets/js/jquery.ezmark.js"></script>
<script type="text/javascript" src="../assets/js/jquery.currency.js"></script>
<script type="text/javascript" src="../assets/js/jquery.cookie.js"></script>
<script type="text/javascript" src="../assets/js/retina.js"></script>
<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../assets/js/carousel.js"></script>
<script type="text/javascript" src="../assets/libraries/jquery-ui-1.10.2.custom/js/jquery-ui-1.10.2.custom.min.js"></script>
<script type="text/javascript" src="../assets/libraries/chosen/chosen.jquery.min.js"></script>
<script type="text/javascript" src="../assets/libraries/iosslider/_src/jquery.iosslider.min.js"></script>
<script type="text/javascript" src="../assets/libraries/bootstrap-fileupload/bootstrap-fileupload.js"></script>
<script type="text/javascript" src="../assets/js/realia.js"></script>
<script type="text/javascript" src="../assets/js/jquery.steps.js"></script> 
<script type="text/javascript" src="../assets/js/jquery.validate.js"></script> 
<script type="text/javascript" src="../assets/js/jquery.slideunlock.js"></script> 
<script type="text/javascript">
    jQuery.validator.addMethod("isMobile", function(value, element) {
        var length = value.length;
        var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, "请正确填写您的手机号码");
</script>
<script>
    $(function () {
        var slider = new SliderUnlock("#slider",{
                successLabelTip : "验证成功"    
            },function(){
                $('#sliderTest').val("yes");
                $.ajax({
                    type:"POST",
                    url:'../login/checkExist',
                    async:false,
                    data:{
                    	  'mobile':$('#userphone').val(),
                    	  'username':$('#username').val()
                    	 },
                    success: function(msg){
                       if(msg == 'true'){
                           $('#existTest').val("yes");
                        }else if(msg == 'false'){
                        	$('#existTest').val("no");
                       }
                    }
                  });
            });
        slider.init();
       	$('.actions.clearfix').find('a').eq(0).on('click',function(){
       		slider.reset();
       		slider.init();
       	})
    })
    var form = $("#example-advanced-form").show();

    form.steps({
        headerTag: "h3",
        bodyTag: "fieldset",
        transitionEffect: "slideLeft",
        onStepChanging: function (event, currentIndex, newIndex)
        {
            // Allways allow previous action even if the current form is not valid!
            if (currentIndex > newIndex)
            {
                return true;
            }
            // Forbid next action on "Warning" step if test is error
            if (newIndex === 2 && String($("#sliderTest").val()) == "no")
            {
                alert("请拖动滑块验证");
                return false;
            }
            // Needed in some cases if the user went back (clean up)
            if (currentIndex < newIndex)
            {
                // To remove error styles
                form.find(".body:eq(" + newIndex + ") label.error").remove();
                form.find(".body:eq(" + newIndex + ") .error").removeClass("error");
            }
            form.validate().settings.ignore = ":disabled,:hidden";
            return form.valid();
        },
        onStepChanged: function (event, currentIndex, priorIndex)
        {
            // Used to skip the "Warning" step if the user is old enough.
             if (currentIndex === 2 && String($("#existTest").val()) == "yes")
             {
                 form.steps("next");
             }
             /* Used to skip the "Warning" step if the user is old enough and wants to the previous step. */
            if (currentIndex === 2 && priorIndex === 3)
            {
            	
                form.steps("previous");
            }
        },
        onFinishing: function (event, currentIndex)
        {
            form.validate().settings.ignore = ":disabled";
            return form.valid();
        },
        onFinished: function (event, currentIndex)
        {
        	location.href ="../login/index";
        }
    }).validate({
        errorPlacement: function errorPlacement(error, element) { element.before(error); },
        rules: {
            confirm: {
                equalTo: "#password-2"
            },
            phone : {
                required : true,
                minlength : 11,
                // 自定义方法：校验手机号在数据库中是否存在
                // checkPhoneExist : true,
                isMobile : true
            }
        },
        messages : {
            phone : {
                required : "请输入手机号",
                minlength : "确认手机不能小于11个字符",
                isMobile : "请正确填写您的手机号码"
            }
        }
    });
</script>
<script type="text/javascript">
//留言在此操作
function check(){ 
	return $("#messageForm").validate({
	    rules: {
	      inputName: "required",
	      inputEmail: {
	        required: true,
	        email: true
	      },
	      inputMessage: "required"
	    },
	    messages: {
	      inputName: "请输入您的姓名",
	      inputEmail: "请输入一个正确的邮箱",
	      inputMessage: "请输入您对我们的留言",
	    }
	});
}

//保存留言
$('#sendMessage').on('click',function(){
	if(!check().form()) return; 
	var inputName = $('#inputName').val();
	var inputEmail = $('#inputEmail').val();
	var inputMessage = $('#inputMessage').val();
	$.ajax(
		{
		type: "get",
    	url: "../message/saveMessage",
        data: {
        	inputName:inputName,
        	inputEmail:inputEmail,
        	inputMessage:inputMessage
            },
        dataType: "json",   
        async : false,   
        success:function(data){
            alert("感谢评论");
            window.location.href="../web/index";
	    },
	    error:function(data){
		    alert("error");
		}
	});
});
</script>
</body>
</html>