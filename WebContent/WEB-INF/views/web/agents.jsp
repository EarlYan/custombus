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
            <div class="our-agents-large">
    <h2 class="page-header">我们团队</h2>

    <div class="content">
        <div class="agent">
            <div class="row">
                <div class="image span2">
                    <img src="../assets/img/photos/agent1.png" alt="Emma">
                </div><!-- /.image -->

                <div class="body span6">
                    <h3>Jeremiah L Wood</h3>
                    <p>Jeremiah L Wood.</p>
                </div><!-- /.body -->

                <div class="info span4">
                    <div class="box">
                        <div class="phone">XXXX-XXXX-XXX </div>
                        <div class="office">(+86) XXXX-XXXX </div>
                        <div class="email">jeremiah@dzbs.com </div>
                    </div>
                </div><!-- /.info -->
            </div><!-- /.row -->
        </div><!-- /.agent -->

        <div class="agent">
            <div class="row">
                <div class="image span2">
                    <img src="../assets/img/photos/agent2.png" alt="Emma">
                </div><!-- /.image -->

                <div class="body span6">
                    <h3>Perry A Jones</h3>
                    <p>Perry A Jones.</p>
                </div><!-- /.body -->

                <div class="info span4">
                    <div class="box">
                        <div class="phone">XXXX-XXXX-XXX </div>
                        <div class="office">(+86) XXXX-XXXX </div>
                        <div class="email">perry@dzbs.com </div>
                    </div>
                </div><!-- /.info -->
            </div><!-- /.row -->
        </div><!-- /.agent -->

        <div class="agent">
            <div class="row">
                <div class="image span2">
                    <img src="../assets/img/photos/agent3.png" alt="Emma">
                </div><!-- /.image -->

                <div class="body span6">
                    <h3>Elizabeth L Alexander</h3>
                    <p>Elizabeth L Alexander.</p>
                </div><!-- /.body -->

                <div class="info span4">
                    <div class="box">
                        <div class="phone">XXXX-XXXX-XXX</div>
                        <div class="office">(+86) XXXX-XXXX </div>
                        <div class="email">elizabeth@dzbs.com </div>
                    </div>
                </div><!-- /.info -->
            </div><!-- /.row -->
        </div><!-- /.agent -->

        <div class="agent">
            <div class="row">
                <div class="image span2">
                    <img src="../assets/img/photos/agent4.png" alt="Emma">
                </div><!-- /.image -->

                <div class="body span6">
                    <h3>Theresa J Gilpin</h3>
                    <p>Theresa J Gilpin.</p>
                </div><!-- /.body -->

                <div class="info span4">
                    <div class="box">
                        <div class="phone">XXXX-XXXX-XXX </div>
                        <div class="office">(+86) XXXX-XXXX </div>
                        <div class="email">theresa@dzbs.com </div>
                    </div>
                </div><!-- /.info -->
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