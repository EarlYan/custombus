<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
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
            <div id="content"><div class="container">
    <div id="main">
        <div class="row">
            <div class="span9">
                <h1 class="page-header">${driver.realname}</h1>
                <div class="property-detail" style="overflow:hidden;">
                    <div class="pull-left overview">
                        <div class="row">
                            <div class="span3">
                                <h2>司机概述</h2>
                                <table>
                                    <tr>
                                        <th>手机号:</th>
                                        <td>${driver.mobile}</td>
                                    </tr>
                                    <tr>
                                        <th>邮箱:</th>
                                        <td><a href="mailto:${driver.email}">${driver.email}</a></td>
                                    </tr>
                                    <tr>
                                        <th>车牌号:</th>
                                        <td>${bus.plate_number}</td>
                                    </tr>
                                    <tr>
                                        <th>巴士座位数:</th>
                                        <td>${bus.seat_number}</td>
                                    </tr>
                                    <tr>
                                        <th>巴士车型</th>
                                        <c:if test="${bus.bus_type == '1'}">
                                        <td>小型客车</td>
                                        </c:if>
                                        <c:if test="${bus.bus_type == '2'}">
                                        <td>中型客车</td>
                                        </c:if>
                                        <c:if test="${bus.bus_type == '3'}">
                                        <td>大型客车</td>
                                        </c:if>
                                    </tr>
                                </table>
                            </div>
                            <!-- /.span2 -->
                        </div>
                        <!-- /.row -->
                    </div>
                    <div class="pull-right overview">
                        <div class="row">
                            <div class="span3">
                                <h2>路线概述</h2>
                                <table>
                                    <tr>
                                        <th>起点:</th>
                                        <td>${route.start_location}</td>
                                    </tr>
                                    <tr>
                                        <th>终点:</th>
                                        <td>${route.end_location}</td>
                                    </tr>
                                    <tr>
                                        <th>起始时间:</th>
                                        <td><fmt:formatDate value="${route.start_time}" type="time"/></td>
                                    </tr>
                                    <tr>
                                        <th>里程数:</th>
                                        <td>${route.mileage}</td>
                                    </tr>
                                    <tr>
                                        <th>大约时间(分钟)</th>                                     
                                        <td>${route.about_time}</td>
                                    </tr>
                                </table>
                            </div>
                            <!-- /.span2 -->
                        </div>
                        <!-- /.row -->
                    </div>
                </div>

            </div>
            <div class="sidebar span3">
                <div class="widget our-agents">
    <div class="title">
        <h2>联系客服</h2>
    </div><!-- /.title -->

    <div class="content">
        <div class="agent">
            <div class="image">
                <img src="../assets/img/photos/laosiji.jpg" alt="">
            </div><!-- /.image -->
            <div class="name">老司机</div><!-- /.name -->
            <div class="phone">XXX-XXX-XX</div><!-- /.phone -->
            <div class="email"><a href="mailto:laosiji@dzbs.com">laosiji@dzbs.com</a></div><!-- /.email -->
        </div><!-- /.agent -->

        <div class="agent">
            <div class="image">
                <img src="../assets/img/photos/dainifei.png" alt="">
            </div><!-- /.image -->
            <div class="name">带你飞</div><!-- /.name -->
            <div class="phone">XXX-XXX-XX</div><!-- /.phone -->
            <div class="email"><a href="mailto:dainifei@dzbs.com">dainifei@dzbs.com</a></div><!-- /.email -->
        </div><!-- /.agent -->
    </div><!-- /.content -->
</div><!-- /.our-agents -->
            </div>
        </div>
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