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
            <h1 class="page-header">登录/注册</h1>
            <div class="login-register">
<div class="row">
<div class="span4">
    <ul class="tabs nav nav-tabs" id="loginRegisterShift">
        <li class="active"><a href="#login">登录</a></li>
        <li><a href="#register">注册</a></li>
    </ul>
    <!-- /.nav -->

    <div class="tab-content">
        <div class="tab-pane active" id="login">
            <form method="post" action="../j_spring_security_check" id="loginForm" autocomplete='off'>
                <div class="control-group">
                    <label class="control-label" for="j_username">
                        用户名
                        <span class="form-required" title="This field is required.">*</span>
                    </label>

                    <div class="controls">
                        <input type="text" id="j_username" name="j_username">
                    </div>
                    <!-- /.controls -->
                </div>
                <!-- /.control-group -->

                <div class="control-group">
                    <label class="control-label" for="j_password">
                        密码
                        <span class="form-required" title="This field is required.">*</span>
                    </label>

                    <div class="controls">
                        <input type="password" id="j_password" name="j_password">
                    </div>
                    <!-- /.controls -->
                </div>
                <!-- /.control-group -->
                <div class="control-group">
                    <span>
                        <a href="../login/forgetpassword">忘记密码?点这里找回密码</a>
                    </span>
                </div>
                <div class="form-actions">
                    <input type="submit" value="登录" class="btn btn-primary arrow-right">
                </div>
                <!-- /.form-actions -->
            </form>
        </div>
        <!-- /.tab-pane -->

        <div class="tab-pane" id="register">
            <form method="post" action="" id="registerForm">
                <div class="control-group">
                    <label class="control-label" for="inputRegisterUserName">
                        用户名
                        <span class="form-required" title="This field is required.">*</span>
                    </label>

                    <div class="controls">
                        <input type="text" id="inputRegisterUserName" name="inputRegisterUserName">
                    </div>
                    <!-- /.controls -->
                </div>
                <!-- /.control-group -->

                <div class="control-group">
                    <label class="control-label" for="inputRegisterTel">
                        手机号
                        <span class="form-required" title="This field is required.">*</span>
                    </label>

                    <div class="controls">
                        <input type="text" id="inputRegisterTel" name="inputRegisterTel">
                    </div>
                    <!-- /.controls -->
                </div>
                <!-- /.control-group -->

                <div class="control-group">
                    <label class="control-label" for="inputRegisterEmail">
                        邮箱
                        <span class="form-required" title="This field is required.">*</span>
                    </label>

                    <div class="controls">
                        <input type="text" id="inputRegisterEmail" name="inputRegisterEmail">
                    </div>
                    <!-- /.controls -->
                </div>
                <!-- /.control-group -->

                <div class="control-group">
                    <label class="control-label" for="inputRegisterPassword">
                        密码
                        <span class="form-required" title="This field is required.">*</span>
                    </label>

                    <div class="controls">
                        <input type="password" id="inputRegisterPassword" name="inputRegisterPassword">
                    </div>
                    <!-- /.controls -->
                </div>
                <!-- /.control-group -->

                <div class="control-group">
                    <label class="control-label" for="inputRegisterRetype">
                        重新输入密码
                        <span class="form-required" title="This field is required.">*</span>
                    </label>
                    <div class="controls">
                        <input type="password" id="inputRegisterRetype" name="inputRegisterRetype">
                    </div>
                    <!-- /.controls -->
                </div>
                <!-- /.control-group -->
                
                <div class="control-group">
                    <label class="control-label" for="inputRegisterType">
                        选择账号类型
                        <span class="form-required" title="This field is required.">*</span>
                    </label>

                    <div class="controls">
                        <select id="inputRegisterType" name="inputRegisterType">
						  <option value ="1">乘客</option>
						  <option value ="2">司机</option>
						</select>
                    </div>
                    <!-- /.controls -->
                </div>
                <!-- /.control-group -->

                <div class="form-actions">
                    <input type="submit" value="注册" class="btn btn-primary arrow-right" id="registerSubmit">
                </div>
                <!-- /.form-actions -->
            </form>
        </div>
        <!-- /.tab-pane -->
    </div>
    <!-- /.tab-content -->
</div>
<!-- /.span4-->

<div class="span8">
    <h2 class="page-header">为什么要定制巴士?</h2>

    <div class="images row">
        <div class="item span2">
            <img src="../assets/img/icons/circle-dollar.png" alt="">

            <h3>实惠价格</h3>
        </div>
        <!-- /.item -->
        <div class="item span2">
            <img src="../assets/img/icons/circle-search.png" alt="">

            <h3>合理寻径</h3>
        </div>
        <!-- /.item -->
        <div class="item span2">
            <img src="../assets/img/icons/circle-global.png" alt="">

            <h3>遍布广泛</h3>
        </div>
        <!-- /.item -->
        <div class="item span2">
            <img src="../assets/img/icons/circle-seat.png" alt="">

            <h3>一人一座</h3>
        </div>
        <!-- /.item -->
    </div>
    <!-- /.row -->

    <hr class="dotted">

    <p>
       传统的大巴车租赁业务不仅价格高、流程多，且有相当一部分服务不到位，包车出游本该是件轻松舒适的事，却因为车辆问题和司机个人素质导致不愉快影响心情。为了满足乘客的多样化需求，定制巴士全新升级包车服务，全新的包车服务不仅价格更优，还有四大王牌优势保障，从此只要享受旅程，完全没有后顾之忧。
    </p>

    <ul class="unstyled dotted">
        <li>
                                        <span class="inner">
                                            <strong>一人一座</strong><br>

                                                专座一觉睡到目的地<br>
                                                出行告别拥挤

                                        </span>
        </li>

        <li>
                                        <span class="inner">
                                            <strong>一站直达</strong><br>
                                                优选站点，中途不停不靠<br>
                                                定制巴士省时、快捷
                                        </span>
        </li>
        <li>
                                        <span class="inner">
                                            <strong>价格亲民</strong><br>
                                                比传统出行方式节省1/3以上<br>
                                                绿色出行节能环保
                                        </span>
        </li>
    </ul>
</div>
</div>
<!-- /.row -->
</div><!-- /.login-register -->        </div>
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
<script type="text/javascript" src="../assets/js/jquery.validate.js"></script> 
<!--切换Login或者Register Tab页-->
<script type="text/javascript">
    $('#loginRegisterShift a').on('click',function(e){
        e.preventDefault();//阻止a链接的跳转行为 
        $(this).tab('show');//显示当前选中的链接及关联的content 
    });
</script>
<script type="text/javascript">
    jQuery.validator.addMethod("isMobile", function(value, element) {
        var length = value.length;
        var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, "请正确填写您的手机号码");
    
    jQuery.validator.addMethod("phoneSame", function(value, element) {
        var flag = 1;
        $.ajax({
          type:"GET",
          url:'../login/checkMobile',
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
          return false;
        }else{
          return true;
        }
     }, "对不起手机号码已经被注册");
</script>
<script type="text/javascript">
    $("#loginForm").validate({
        rules: {
        	j_username: "required",
        	j_password: "required"
        },
        messages: {
        	j_username: "请输入用户名",
        	j_password: "请输入密码"
        }
    });
function checkRegister(){ 
    return $("#registerForm").validate({
        rules: {
          inputRegisterUserName: "required",
          inputRegisterEmail: {
            required: true,
            email: true
          },
          inputRegisterTel:{
            required : true,
            minlength : 11,
            isMobile : true,
            phoneSame : true
          },
          inputRegisterPassword: {
            required: true,
            minlength: 5
          },
          inputRegisterRetype: {
            required: true,
            minlength: 5,
            equalTo: "#inputRegisterPassword"
          }
        },
        messages: {
          inputRegisterUserName: "请输入用户名",
          inputRegisterEmail: "请输入一个正确的邮箱",
          inputRegisterTel: {
        	  isMobile:  "请正确填写您的手机号码",
        	  phoneSame:  "对不起手机号码已经被注册"
          },
          inputRegisterPassword: {
            required: "请输入密码",
            minlength: "密码长度不能小于 5 个字母"
          },
          inputRegisterRetype: {
            required: "请输入密码",
            minlength: "密码长度不能小于 5 个字母",
            equalTo: "两次密码输入不一致"
          }
        }
    }); 
}
	
	$('#registerSubmit').on('click',function(){
		if(!checkRegister().form()) return; 
		var inputRegisterUserName = $('#inputRegisterUserName').val();
		var inputRegisterTel = $('#inputRegisterTel').val();
		var inputRegisterEmail = $('#inputRegisterEmail').val();
		var inputRegisterPassword = $('#inputRegisterPassword').val();		
		var inputRegisterType = $('#inputRegisterType').val();
		$.ajax(
			{
			type: "POST",
	    	url: "../login/add",
	        data: {
	        	inputRegisterUserName:inputRegisterUserName,
	        	inputRegisterTel:inputRegisterTel,
	        	inputRegisterEmail:inputRegisterEmail,
	        	inputRegisterPassword:inputRegisterPassword,
	        	inputRegisterType:inputRegisterType
	        },
	        dataType: "json",   
	        async : false,   
	        success:function(data){
	            alert("注册成功");
	            window.location.href="../login/index";
		    },
		    error:function(data){
			    alert("error");
			}
		});
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
		type: "POST",
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