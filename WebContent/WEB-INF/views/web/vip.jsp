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
    <link rel="stylesheet" type="text/css" href="../assets/css/flatpickr.min.css"> <!--日期选择器-->
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
            <div class="pricing boxed">
    <h2 class="page-header">会员价格表</h2>

    <div class="row">
        <div class="span4">
            <div class="column">
                <h2>基础会员</h2>
                <div class="content">
                    <h3>免费</h3>
                    <h4>永久</h4>
                    <ul class="unstyled">
                        <li>工作日上班时间客服</li>
                        <li class="unimportant">9折优惠</li>
                        <li class="unimportant">快速取消订单</li>
                        <li class="unimportant">私人订制座</li>
                    </ul>
                    <div style="visibility: hidden;">
                    <a href="#" class="btn btn-primary btn-large">Sign up</a>
                    </div>
                </div><!-- /.content -->
            </div><!-- /.column -->
        </div><!-- /.span4 -->

        <div class="span4">
            <div class="column promoted">
                <h2>普通会员</h2>
                <div class="content">
                    <h3>¥9,90</h3>
                    <h4>每月</h4>
                    <ul class="unstyled">
                        <li>工作日24小时客服</li>
                        <li>9折优惠</li>
                        <li>快速取消订单</li>
                        <li class="unimportant">私人订制座位</li>
                    </ul>
                    <a href="#" class="btn btn-primary btn-large">购买</a>
                </div><!-- /.content -->
            </div><!-- /.column -->
        </div><!-- /.span4 -->

        <div class="span4">
            <div class="column">
                <h2>高级会员</h2>
                <div class="content">
                    <h3>¥19,99</h3>
                    <h4>每月</h4>
                    <ul class="unstyled">
                        <li>7*24小时无间断客服</li>
                        <li>8折优惠</li>
                        <li>快速取消订单</li>
                        <li>私人订制座位</li>
                    </ul>
                    <a href="#" class="btn btn-primary btn-large">购买</a>
                </div><!-- /.content -->
            </div><!-- /.column -->
        </div><!-- /.span4 -->
    </div><!-- /.row -->
</div><!-- /.pricing -->        </div>
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
<script type="text/javascript" src="../assets/js/flatpickr.js"></script><!--时间选择器-->
<script type="text/javascript" src="../assets/js/jquery.validate.js"></script> 
<script type="text/javascript">
    //留言在此操作
    $("#messageForm").validate({
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
    
  //保存留言
    $('#sendMessage').on('click',function(){
    	var inputName = $('#inputName').val();
    	var inputEmail = $('#inputEmail').val();
    	var inputMessage = $('#inputMessage').val();
    	$.ajax(
 			{
				type: "post",
		    	url: "../message/saveMessage",
		        data: {
		        	inputName:inputName,
		        	inputEmail:inputEmail,
		        	inputMessage:inputMessage
		            },
		        dataType: "json",      
		        success:function(data){
		            alert("感谢评论");
		            window.location.href = "../web/index";
			    },
			    error:function(data){
				    alert("error");
				}
 			});
    });
</script>
</body>
</html>