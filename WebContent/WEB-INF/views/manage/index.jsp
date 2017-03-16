<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <title>管理</title>
    <!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->

    <link rel="shortcut icon" href="favicon.ico">
    <link href="../user/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="../user/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="../user/css/animate.min.css" rel="stylesheet">
    <link href="../user/css/style.min.css?v=4.0.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg  pace-done" style="overflow:hidden">
<div class="pace  pace-inactive">
    <div class="pace-progress" data-progress-text="100%" data-progress="99" style="width: 100%;">
        <div class="pace-progress-inner"></div>
    </div>
    <div class="pace-activity"></div>
</div>
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side navbar-static-side-gray" role="navigation">
        <div class="nav-close">
            <i class="fa fa-times-circle"></i>
        </div>
        <div class="slimScrollDiv" style="position: relative; width: auto; height: 100%;">
            <div class="sidebar-collapse" style="width: auto; height: 100%;">
                <ul class="nav nav-gray" id="side-menu">
                    <li class="nav-header navbar-gray logo">
                        <div class="dropdown profile-element">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <img src="../user/img/bus-logo.png" alt="LOGO" style="
    									margin-right: 140px;">                       
                            </a>
                        </div>
                    </li>
                 
                    <li class="">
                        <a href="#">
                            <i class="fa fa-home"></i>
                            <span class="nav-label">个人信息配置</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level collapse" aria-expanded="false" style="height: 0px;">
                            <li> 	
                                <a class="J_menuItem" href="../self/modifyPage" data-index="0">个人基本信息</a>
                                <a class="J_menuItem" href="../self/passwordModifyPage" data-index="0">密码修改</a>
                                <security:authorize ifAnyGranted="ROLE_DRIVER">
                                <a class="J_menuItem" href="../driver/identify" data-index="0">资格认证</a>
                                </security:authorize>
                            </li>
                        </ul>
                    </li>
					<security:authorize ifAnyGranted="ROLE_ADMIN">
                    <li class="">
                        <a href="#">
                            <i class="fa fa-users"></i>
                            <span class="nav-label">客户管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level collapse" aria-expanded="false" style="height: 0px;">
                            <li>
                                <a class="J_menuItem" href="../customer/index" data-index="0">客户信息管理</a>
                            </li>
                        </ul>
                    </li>
					</security:authorize>
					<security:authorize ifAnyGranted="ROLE_ADMIN">
                    <li class="">
                        <a href="#">
                            <i class="fa fa-bus"></i>
                            <span class="nav-label">司机管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level collapse" aria-expanded="false" style="height: 0px;">
                            <li>
                                <a class="J_menuItem" href="../driver/index" data-index="0">司机信息管理</a>
                            </li>
                        </ul>
                    </li>
					</security:authorize>
					<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_DRIVER">
                    <li class="">
                        <a href="#">
                            <i class="fa fa-flag"></i>
                            <span class="nav-label">路线管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level collapse" aria-expanded="false" style="height: 0px;">
                            <li>                         	
                                <a class="J_menuItem" href="../route/index" data-index="0">现有路线管理</a>
                                <security:authorize ifAnyGranted="ROLE_ADMIN">
                                <a class="J_menuItem" href="../property/index" data-index="0">众筹线路管理</a>
                                </security:authorize>
                            </li>
                        </ul>
                    </li>
					</security:authorize>
                    <li>
                        <a href="index.html#"><i class="fa fa fa-area-chart"></i><span class="nav-label">资金管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                               <a class="J_menuItem" href="../order/report">统计报表</a>
                               <a class="J_menuItem" href="../order/index">订单管理</a>
                            </li>
                        </ul>
                    </li>

                    <li>
                        <a href="index.html#"><i class="fa fa-comment"></i> <span class="nav-label">评论管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="../comment/index">评论查看</a>
                                <security:authorize ifAnyGranted="ROLE_ADMIN">
                                <a class="J_menuItem" href="../message/index">留言查看</a>
                                </security:authorize>
                            </li>
                        </ul>
                    </li>
                </ul>
                
                
<!--                 <div class="copyright copyright-gray">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                    <div class="profile-element">
                        <img style="width: 30px;" src="../user/img/bus-logo.png" alt="LOGO">
                        <span>XXXXXXXXXX有限公司</span>
                         ©️Copyright 2017 by More EarlYan.
                    </div>
                    <div class="logo-element">DZBS</div>
                    </a>
                   
                </div> -->
            </div>
            <div class="slimScrollBar"
                 style="background: rgb(0, 0, 0); width: 4px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 1px; height: 682px;"></div>
            <div class="slimScrollRail"
                 style="width: 4px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; background: rgb(51, 51, 51); opacity: 0.9; z-index: 90; right: 1px;"></div>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top blue-bg" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-gray hexagon hexagon-gray" href="#">
                        <i class="fa fa-bars"></i>
                    </a>
                </div>
                <!--class="nav navbar-top-links navbar-right-->
                <div class="dropdown navUserAvatar navbar-right">
                    <span><img alt="image" class="img-circle" src="${member.imgurl}" style="height:40px;width:40px"></span>
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#" aria-expanded="false">
                                <span class="clear">
                              	<span class="block m-t-xs"><strong class="font-bold"><security:authentication property='principal.username'/></strong></span>
                                <security:authorize ifAnyGranted="ROLE_ADMIN">
                                <span class="text-muted text-xs block">管理员<b class="caret"></b></span>
                                </security:authorize>
                                <security:authorize ifAnyGranted="ROLE_PASSENGER">
                                <span class="text-muted text-xs block">乘客<b class="caret"></b></span>
                                </security:authorize>
                                <security:authorize ifAnyGranted="ROLE_DRIVER">
                                <span class="text-muted text-xs block">司机<b class="caret"></b></span>
                                </security:authorize>
                                </span>
                    </a>
                    <ul class="dropdown-menu animated fadeInRight m-t-xs">
                        <li><a class="J_menuItem" href="../self/modifyPage" data-index="0">修改头像</a>
                        </li>
                        <li><a class="J_menuItem" href="../self/modifyPage" data-index="1">个人资料</a>
                        </li>
                        <li><a class="J_menuItem" href="../web/contactus" data-index="2">联系我们</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="../j_spring_security_logout">安全退出</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-angle-double-left"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                 <div class="page-tabs-content">
                    <a href="javascript:;" class="active J_menuTab" data-id="index_v1.html">首页</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight"><i class="fa fa-angle-double-right"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                    </li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                    </li>
                </ul>
            </div>
            <a href="../j_spring_security_logout" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="front" frameborder="0" data-id="index_v1.html" seamless=""></iframe>
        </div>

    </div>
    <!--右侧部分结束-->


</div>
<script src="../user/js/jquery.min.js?v=2.1.4"></script>
<script src="../user/js/bootstrap.min.js?v=3.3.5"></script>
<script src="../user/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="../user/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="../user/js/plugins/layer/layer.min.js"></script>
<script src="../user/js/hplus.min.js?v=4.0.0"></script>
<script type="text/javascript" src="../user/js/contabs.min.js"></script>
<script src="../user/js/plugins/pace/pace.min.js"></script>


</body>

</html>
