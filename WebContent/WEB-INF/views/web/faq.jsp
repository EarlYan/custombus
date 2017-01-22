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
            <div class="faq">
    <h2 class="page-header">常见问题解答</h2>
    <div class="content">
        <div class="row">
            <div class="span6">
                <h2>关于预定和线路</h2>

                <div class="accordion" id="faq1">
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#faq1" href="#collapse1">
                                <span class="sign"></span>定制巴士如何预订？
                            </a>
                        </div><!-- /.accordion-heading -->

                        <div id="collapse1" class="accordion-body collapse">
                            <div class="accordion-inner">
                               通过网页进行预订和支付。
                            </div><!-- /.accordion-inner -->
                        </div><!-- /.accordion-body -->
                    </div><!-- /.accordion-group -->

                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#faq1" href="#collapse2">
                                <span class="sign"></span>在网上没有看到适合我的线路，怎么办？
                            </a>
                        </div><!-- /.accordion-heading -->

                        <div id="collapse2" class="accordion-body collapse">
                            <div class="accordion-inner">
                                如果没有找到适合您的线路，您可以通过官网“众筹你的路线”参与路线需求调查 ，当报名人数达到指定数量后，我们就会为您开通专线
                            </div><!-- /.accordion-inner -->
                        </div><!-- /.accordion-body -->
                    </div><!-- /.accordion-group -->

                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#faq1" href="#collapse3">
                                <span class="sign"></span>订票有时间限制吗？可以即时乘坐吗？
                            </a>
                        </div><!-- /.accordion-heading -->

                        <div id="collapse3" class="accordion-body collapse">
                            <div class="accordion-inner">
                                不支持即时乘坐，需提前预订，预订时间：</br>
                                (1)按次票：指定时间段的可以订一次或多次票。</br>
                                (2)订票时间：每天00:00至24:00。
                            </div><!-- /.accordion-inner -->
                        </div><!-- /.accordion-body -->
                    </div><!-- /.accordion-group -->

                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#faq1" href="#collapse4">
                                <span class="sign"></span>如何了解巴士的具体路线、设站、发车时间等信息
                            </a>
                        </div><!-- /.accordion-heading -->

                        <div id="collapse4" class="accordion-body collapse">
                            <div class="accordion-inner">
                                已经订票的乘客可以在“我的订单”里面查看自己线路的时间、站点、车牌号等信息。
                            </div><!-- /.accordion-inner -->
                        </div><!-- /.accordion-body -->
                    </div><!-- /.accordion-group -->

                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#faq1" href="#collapse5">
                                <span class="sign"></span>巴士支持多长时间的预订？
                            </a>
                        </div><!-- /.accordion-heading -->

                        <div id="collapse5" class="accordion-body collapse">
                            <div class="accordion-inner">
                                暂时只支持短期或单日预订。
                            </div><!-- /.accordion-inner -->
                        </div><!-- /.accordion-body -->
                    </div><!-- /.accordion-group -->
                </div><!-- /.accordion -->

                <h2>联系客服</h2>

                <div class="accordion" id="faq3">
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#faq3" href="#collapse9">
                                <span class="sign"></span>在线客服
                            </a>
                        </div><!-- /.accordion-heading -->

                        <div id="collapse9" class="accordion-body collapse">
                            <div class="accordion-inner">
                                你可以在首页看到客服的集体信息，他们很乐意为你解答。
                            </div><!-- /.accordion-inner -->
                        </div><!-- /.accordion-body -->
                    </div><!-- /.accordion-group -->

                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#faq3" href="#collapse10">
                                <span class="sign"></span>客服热线
                            </a>
                        </div><!-- /.accordion-heading -->

                        <div id="collapse10" class="accordion-body collapse">
                            <div class="accordion-inner">
                                +86 XXXXXXXX
                            </div><!-- /.accordion-inner -->
                        </div><!-- /.accordion-body -->
                    </div><!-- /.accordion-group -->

                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#faq3" href="#collapse11">
                                <span class="sign"></span>商务合作
                            </a>
                        </div><!-- /.accordion-heading -->

                        <div id="collapse11" class="accordion-body collapse">
                            <div class="accordion-inner">
                                ① 商务合作可拨热线电话：+86 XXXXXXXX。</br>
                                ② 将合作相关资料发送至公司邮箱hezuo@dzbs.com,会有专人查收回复。
                            </div><!-- /.accordion-inner -->
                        </div><!-- /.accordion-body -->
                    </div><!-- /.accordion-group -->
                </div><!-- /.accordion -->
            </div><!-- /.span6 -->

            <div class="span6">


                <h2>退款问题</h2>

                <div class="accordion" id="faq4">
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#faq4" href="#collapse14">
                                <span class="sign"></span>如何退款？ 
                            </a>
                        </div><!-- /.accordion-heading -->

                        <div id="collapse14" class="accordion-body collapse">
                            <div class="accordion-inner">
                                在“我的订单”中进入相应订单，点击“退款”即可自助退款。
                            </div><!-- /.accordion-inner -->
                        </div><!-- /.accordion-body -->
                    </div><!-- /.accordion-group -->

                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#faq4" href="#collapse15">
                                <span class="sign"></span>由于天气、市政施工、交通管制等不可抗因素造成的巴士临时取消或线路调整，导致我不能乘坐，可否申请退款？
                            </a>
                        </div><!-- /.accordion-heading -->

                        <div id="collapse15" class="accordion-body collapse">
                            <div class="accordion-inner">
                                可以通过拨打客服热线（+86 XXXXXXXX）申请退款。
                            </div><!-- /.accordion-inner -->
                        </div><!-- /.accordion-body -->
                    </div><!-- /.accordion-group -->

                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#faq4" href="#collapse16">
                                <span class="sign"></span>由于运营问题，造成线路撤销或调整，使用户无法实现乘车目的，可以退款吗？
                            </a>
                        </div><!-- /.accordion-heading -->

                        <div id="collapse16" class="accordion-body collapse">
                            <div class="accordion-inner">
                                由于以上问题导致乘客无法乘车，我们会退还全额票款至用户账户。
                            </div><!-- /.accordion-inner -->
                        </div><!-- /.accordion-body -->
                    </div><!-- /.accordion-group -->

                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#faq4" href="#collapse17">
                                <span class="sign"></span>退款周期大概多久？
                            </a>
                        </div><!-- /.accordion-heading -->

                        <div id="collapse17" class="accordion-body collapse">
                            <div class="accordion-inner">
                                退款后，钱款将按照订单支付时的渠道退回，一般为3个工作日内到账。
                            </div><!-- /.accordion-inner -->
                        </div><!-- /.accordion-body -->
                    </div><!-- /.accordion-group -->
                </div><!-- /.accordion -->
            </div><!-- /.span6 -->
        </div><!-- /.row -->
    </div><!-- /.content -->
</div><!-- /.faq -->
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