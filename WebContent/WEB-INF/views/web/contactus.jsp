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
            <div id="content">    <div class="container">
        <div id="main">
            <div class="row">
                <div class="span9">
                    <h1 class="page-header">联系我们</h1>
                        <iframe class="map" width="425" height="350" src="../Front-HTML/baidumap.html" scrolling=no></iframe>
                        <div class="row">
                            <div class="span3">
                                <h3 class="address">地址</h3>
                                <p class="content-icon-spacing">
                                    XX<br>
                                    上海, 松江区<br>
                                </p>
                            </div>
                            <div class="span3">
                                <h3 class="call-us">电话</h3>
                                <p class="content-icon-spacing">
                                    +86 XXXXXXXX<br>
                                    9：00AM-17：00PM
                                </p>
                            </div>
                            <div class="span3">
                                <h3 class="email">邮箱</h3>
                                <p class="content-icon-spacing">
                                    <a href="mailto:ysuperpaul@gmail.com">有问题找我</a><br>
                                </p>
                            </div>
                        </div>
                </div>

                <div class="sidebar span3">
                    <div class="widget properties last">
    <div class="title">
        <h2>巴士合作商</h2>
    </div><!-- /.title -->

    <div class="content">
        <div class="property">
            <div class="image">
                <a href="http://www.jac.com.cn/"></a>
                <img src="../assets/img/jianghuai.png" alt="">
            </div><!-- /.image -->

            <div class="wrapper">
                <div class="title">
                    <h3>
                        <a href="http://www.jac.com.cn/">江淮客车</a>
                    </h3>
                </div><!-- /.title -->
                <div class="location">安徽省合肥市东流路176号</div><!-- /.location -->
                <div class="price">400-888-9933</div><!-- /.price -->
            </div><!-- /.wrapper -->
        </div><!-- /.property -->

        <div class="property">
            <div class="image">
                <a href="http://www.higer.com/"></a>
                <img src="../assets/img/higer.png" alt="">
            </div><!-- /.image -->

            <div class="wrapper">
                <div class="title">
                    <h3>
                        <a href="http://www.higer.com/">海格客车</a>
                    </h3>
                </div><!-- /.title -->
                <div class="location">苏州工业园区苏虹东路288号</div><!-- /.location -->
                <div class="price">400-828-2019</div><!-- /.price -->
            </div><!-- /.wrapper -->
        </div><!-- /.property -->

        <div class="property">
            <div class="image">
                <a href="http://www.king-long.com.cn/"></a>
                <img src="../assets/img/kinglong.png" alt="">
            </div><!-- /.image -->

            <div class="wrapper">
                <div class="title">
                    <h3>
                        <a href="http://www.king-long.com.cn/">金龙客车</a>
                    </h3>
                </div><!-- /.title -->
                <div class="location">福建省厦门市集美区金龙路9号</div><!-- /.location -->
                <div class="price">400-886-6700</div><!-- /.price -->
            </div><!-- /.wrapper -->
        </div><!-- /.property -->

        <div class="property">
            <div class="image">
                <a href="http://www.yutong.com/"></a>
                <img src="../assets/img/yutong.png" alt="">
            </div><!-- /.image -->

            <div class="wrapper">
                <div class="title">
                    <h3>
                        <a href="http://www.yutong.com/">宇通客车</a>
                    </h3>
                </div><!-- /.title -->
                <div class="location">郑州市宇通路宇通工业园</div><!-- /.location -->
                <div class="price">400-659-6666</div><!-- /.price -->
            </div><!-- /.wrapper -->
        </div><!-- /.property -->
    </div><!-- /.content -->
</div><!-- /.properties -->
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
    
</script>
</body>
</html>