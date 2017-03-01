<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <div id="content">    <div class="container">
        <div id="main">
            <div class="row">
                <div class="span9">
                    <h1 class="page-header">众筹详情</h1>
                       <div class="map" id ="map_cavans" style="width: 830px;height: 310px;">
                       </div>                
                        <!-- <iframe class="map" width="425" height="350" src="../Front-HTML/baidumap.html" scrolling=no></iframe> -->
                
                <div class="row">
                            <div class="span3">
                                <h3 class="address">路线</h3>
                                <p class="content-icon-spacing">
                                    ${property.startLocation}<br>
                                    到<br>
                                    ${property.endLocation}<br>
                                </p>
                            </div>
                            <div class="span3">
                                <h3 class="call-us">发起人</h3>
                                <p class="content-icon-spacing">
                                    姓名:    ${property.name}<br>
                                    				<br>
                                    手机:    ${property.mobile}
                                </p>
                            </div>
                            <div class="span3">
                                <h3 class="funding">众筹</h3>
                                <p class="content-icon-spacing">
                                	<input type="button" id="crowdFunding" class="btn btn-primary btn-small" value="参与众筹">
                                    <!-- <a href="mailto:ysuperpaul@gmail.com">有问题找我</a><br> -->
                                </p>
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

<script src="http://api.map.baidu.com/api?v=2.0&ak=sYY91vHWc5btABI2DOM7gEfm"></script> 
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
	//调用百度地图
	var start = '${property.startLocation}';
	var end = '${property.endLocation}';
    var map = new BMap.Map('map_cavans');
    map.enableScrollWheelZoom();
    map.centerAndZoom(new BMap.Point(121.47535,31.233588), 12);
	map.clearOverlays();
	var routePolicy = BMAP_DRIVING_POLICY_LEAST_TIME;
	search(start,end); 
	function search(start,end,routePolicy){ 
		var driving = new BMap.DrivingRoute(map, {renderOptions:{map: map, autoViewport: true}});
		driving.search(start,end);
	}
</script>
<script type="text/javascript">
$('#crowdFunding').on('click',function(){
	var property_id = '${property.id}';
	$.ajax(
			{
			type: "POST",
	    	url: "../property/crowdfunding",
	        data: {
	        	property_id:property_id
	        },
	        dataType: "json",   
	        async : false,   
	        success:function(data){
	        	var resultCode = data.resultCode;
	        	if(resultCode =="300"){
	        		alert("您已经众筹过此线路,此次众筹无效");
	        		window.location.href="../web/index";
	        	}else if(resultCode =="200"){
	        		alert("谢谢您的众筹");
	 	            window.location.href="../web/index";
	        	}           
		    },
		    error:function(data){
			    alert("error");
			}
	});
});

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