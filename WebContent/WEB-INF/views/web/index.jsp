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
    <link rel="stylesheet" href="../assets/css/flatpickr.min.css" type="text/css"> <!--日期选择器-->
    <link rel="stylesheet" href="../assets/css/bootstrap-responsive.css" type="text/css">
    <link rel="stylesheet" href="../assets/libraries/chosen/chosen.css" type="text/css">
    <link rel="stylesheet" href="../assets/libraries/bootstrap-fileupload/bootstrap-fileupload.css" type="text/css">
    <link rel="stylesheet" href="../assets/libraries/jquery-ui-1.10.2.custom/css/ui-lightness/jquery-ui-1.10.2.custom.min.css" type="text/css">
    <link rel="stylesheet" href="../assets/css/realia-blue.css" type="text/css" id="color-variant-default">
    <link rel="stylesheet" href="../dist/css/swiper.min.css" type="text/css">
    <style type="text/css">
    .error{
        color: red;
    }
    #inputStart-error{
    	color: red;
    }
    #inputEnd-error{
    	color: red;
    }
    #inputDate-error{
    	color: red;
    }
    .properties-grid .property {
		margin-bottom:0;
	}
	
	.properties-grid .property:nth-child(n+4){
		margin-top:30px
	}
    .content .play{
        background: #eee;
        font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
        font-size: 14px;
        color:#000;
        margin: 0;
        padding: 0;
    }
    .swiper-container {
        width: 100%;
        height: 300px;
        margin: 20px auto;
    }
    .swiper-slide {
        text-align: center;
        font-size: 18px;
        background: #fff;
        width: 250px;

        /* Center slide text vertically */
        display: -webkit-box;
        display: -ms-flexbox;
        display: -webkit-flex;
        display: flex;
        -webkit-box-pack: center;
        -ms-flex-pack: center;
        -webkit-justify-content: center;
        justify-content: center;
        -webkit-box-align: center;
        -ms-flex-align: center;
        -webkit-align-items: center;
        align-items: center;
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
    <div id="main">
        <div class="slider-wrapper">
    <div class="slider">
        <div class="slider-inner">
            <div class="row">
                <div class="images span9">
                    <div class="map-top">
                        <div class="map" id = "map_cavans" style="width: 100%;height: 466px;">
                        <!-- <iframe src="map.html" frameBorder=0 height=424 width=870 name="mapFrame" id="mapFrame"></iframe> -->
                        </div>
                    </div>
                </div><!-- /.images -->

                <div class="span3">
                    <div class="property-filter">
                        <div class="content">
                            <form method="post" action="" id="orderForm">
                                <div class="start control-group">
                                    <label class="control-label" for="inputStart">
                                        起点
                                    </label>
                                    <div class="controls">
                                        <input placeholder="请输入起点" type="text" name="inputStart" id="inputStart">
                                        <div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>
                                    </div>
                                </div>

                                <div class="end control-group">
                                    <label class="control-label" for="inputEnd">
                                        终点
                                    </label>
                                    <div class="controls">
                                        <input placeholder="请输入终点" type="text" name="inputEnd" id="inputEnd">
                                    </div>
                                </div>

                                <div class="bustype control-group">
                                    <label class="control-label" for="inputBusType">
                                        车型
                                    </label>
                                    <div class="controls">
                                        <select id="chooseBusType">
                                            <option value="1">小型客车</option>
                                            <option value="2">中型客车</option>
                                            <option value="2">大型客车</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="datepicker control-group">
                                    <label class="control-label" for="inputDate">
                                        选择时间
                                    </label>
                                    <div class="controls">
                                        <input id="inputDate" name="inputDate" class="flatpickr" type="text" data-time_24hr="true" placeholder="请选择时间" readonly="readonly" style="width: 230px;height: 40px;">
                                    </div>
                                </div>
                                <div class="form-actions">
                                    <input type="button" value="查看地图" class="btn btn-primary btn-large" id="lookingRoute">
                                </div><!-- /.form-actions -->
                                <div class="form-actions">
                                    <input type="button" value="重置地图" class="btn btn-primary btn-large" id="refreshMap">
                                </div><!-- /.form-actions -->
                                <div class="form-actions">
                                    <input type="button" value="我要下单" class="btn btn-primary btn-large" id="placeOrder">
                                </div><!-- /.form-actions -->
                            </form>
                        </div><!-- /.content -->
                    </div><!-- /.property-filter -->

                </div><!-- /.span3 -->
            </div><!-- /.row -->
        </div><!-- /.slider-inner -->
    </div><!-- /.slider -->
</div><!-- /.slider-wrapper -->

        <div class="row">
            <div class="span9">
                <h1 class="page-header">最新众筹</h1>
                <div class="properties-grid">
    <div class="row">
    	<c:forEach items="${propertyList}" var="p">   	
	        <div class="property span3">
	            <div class="image">
	                <div class="content">
	                    <a href="../web/propertydetail?id=${p.id}"></a>
	                    <img src="../assets/img/map.png" alt="">
	                </div><!-- /.content -->
	
	                <div class="price">¥<fmt:formatNumber type="number" pattern="#" value="${p.distance/1000*1.5}"/>到¥<fmt:formatNumber type="number" pattern="#" value="${p.distance/1000*3.5}"/></div><!-- /.price -->
	                <div class="reduced">申请中</div><!-- /.reduced -->
	            </div><!-- /.image -->
	
	            <div class="title">
	                <h2><a style="display: block;width:100%;text-overflow:ellipsis;white-space:nowrap;overflow: hidden;">${p.startLocation}</a></h2>
	            </div><!-- /.title -->
	
	            <div class="location" style="display: block;width:90%;text-overflow:ellipsis;white-space:nowrap;overflow: hidden;">到${p.endLocation}</div><!-- /.location -->
	            <div class="area">
	                <span class="key">距离:</span><!-- /.key -->
	                <span class="value">${p.distance}</span><!-- /.value -->
	            </div><!-- /.area -->
	            <div class="bedrooms"><div class="content">1</div></div><!-- /.bedrooms -->
	            <div class="bathrooms"><div class="content">2</div></div><!-- /.bathrooms -->
	        </div><!-- /.property -->
        </c:forEach>
    </div><!-- /.row -->
</div><!-- /.properties-grid -->
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
                <div class="hidden-tablet">
                    <div class="widget properties last">
    <div class="title">
        <h2>司机展示</h2>
    </div><!-- /.title -->

    <div class="content">
    	<c:forEach var="d" items="${drivers}">
        <div class="property">
            <div class="image">
                <a href="../web/driverdetail?id=${d.id}"></a>
                <img src="${d.imgurl}" alt="" style="width:70px;">
            </div><!-- /.image -->

            <div class="wrapper">
                <div class="title">
                    <h3>
                        <a>${d.realname}</a>
                    </h3>
                </div><!-- /.title -->
                <div class="location">${d.mobile}</div><!-- /.location -->
                <div class="price"><a href="mailto:${d.email}">${d.email}</a></div><!-- /.price -->
            </div><!-- /.wrapper -->
        </div><!-- /.property -->
        </c:forEach>
    </div><!-- /.content -->
</div><!-- /.properties -->
                </div>
            </div>
        </div>
        <div class="carousel">
    <h2 class="page-header">所有线路</h2>

    <div class="content play">
    <div class="swiper-container">
        <div class="swiper-wrapper">
            <div class="swiper-slide">
            <li>
                <div class="image">
                    <a href="detail.html"></a>
                    <img src="../assets/img/tmp/property-small-3.png" alt="">
                </div><!-- /.image -->
                <div class="title">
                    <h3><a href="detail.html">1 Pacific Coast</a></h3>
                </div><!-- /.title -->
                <div class="location">Palo Alto CA</div><!-- /.location-->
                <div class="price">€2 300 000</div><!-- .price -->
                <div class="area">
                    <span class="key">Area:</span>
                    <span class="value">750m<sup>2</sup></span>
                </div><!-- /.area -->
                <div class="bathrooms"><div class="inner">3</div></div><!-- /.bathrooms -->
                <div class="bedrooms"><div class="inner">3</div></div><!-- /.bedrooms -->
            </li>
            </div>          
            <div class="swiper-slide">
                <li>
                <div class="image">
                    <a href="detail.html"></a>
                    <img src="../assets/img/tmp/property-small-3.png" alt="">
                </div><!-- /.image -->
                <div class="title">
                    <h3><a href="detail.html">7 Pacific Coast</a></h3>
                </div><!-- /.title -->
                <div class="location">Palo Alto CA</div><!-- /.location-->
                <div class="price">€2 300 000</div><!-- .price -->
                <div class="area">
                    <span class="key">Area:</span>
                    <span class="value">750m<sup>2</sup></span>
                </div><!-- /.area -->
                <div class="bathrooms"><div class="inner">3</div></div><!-- /.bathrooms -->
                <div class="bedrooms"><div class="inner">3</div></div><!-- /.bedrooms -->
            </li>
            </div>
            <div class="swiper-slide">
                <li>
                <div class="image">
                    <a href="detail.html"></a>
                    <img src="../assets/img/tmp/property-small-3.png" alt="">
                </div><!-- /.image -->
                <div class="title">
                    <h3><a href="detail.html">8 Pacific Coast</a></h3>
                </div><!-- /.title -->
                <div class="location">Palo Alto CA</div><!-- /.location-->
                <div class="price">€2 300 000</div><!-- .price -->
                <div class="area">
                    <span class="key">Area:</span>
                    <span class="value">750m<sup>2</sup></span>
                </div><!-- /.area -->
                <div class="bathrooms"><div class="inner">3</div></div><!-- /.bathrooms -->
                <div class="bedrooms"><div class="inner">3</div></div><!-- /.bedrooms -->
            </li>
            </div>
        </div>
        <!-- Add Scrollbar -->
        <div class="swiper-scrollbar"></div>
    </div>
    </div><!-- /.content -->
</div><!-- /.carousel -->          
</div><!-- /.main -->          
</div><!-- /.container -->          

<div class="bottom-wrapper">
    <div class="bottom container">
        <div class="bottom-inner row">
            <div class="item span4">
                <div class="address decoration"></div>
                <h2><a>众筹你的路线</a></h2>
                <p>定制符合自己的上下班路线，享受专属个性化服务，专车专道，一路畅行</p>
                <a href="..web/property" class="btn btn-primary">开始众筹</a>
            </div><!-- /.item -->

            <div class="item span4">
                <div class="gps decoration"></div>
                <h2><a>规划行车路径</a></h2>
                <p>前所未有的上下班体验，解决全国白领通勤出行难题。查看优选地图路径，快速直达目的地</p>
                <a href="javascript:window.scrollTo( 0, 0 );" class="btn btn-primary">查看地图</a>
            </div><!-- /.item -->

            <div class="item span4">
                <div class="key decoration"></div>
                <h2><a>安全可靠出行</a></h2>
                <p>专座一觉睡到目的地，出行告别拥挤，一站直达，优选站点，购票省时省心</p>
                <a href="../web/vip" class="btn btn-primary">加入会员</a>
            </div><!-- /.item -->
        </div><!-- /.bottom-inner -->
    </div><!-- /.bottom -->
</div><!-- /.bottom-wrapper -->    </div><!-- /#content -->
</div><!-- /#wrapper-inner -->

<%@include file="/WEB-INF/views/web/footer.jsp"%>
</div><!-- /#wrapper -->
</div><!-- /#wrapper-outer -->


<script src="http://api.map.baidu.com/api?v=2.0&ak=sYY91vHWc5btABI2DOM7gEfm"></script> 
<script type="text/javascript" src="http://api.map.baidu.com/library/LuShu/1.2/src/LuShu_min.js"></script>
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
<script type="text/javascript" src="../dist/js/swiper.min.js"></script><!-- Swiper JS -->
<script type="text/javascript">
    var swiper = new Swiper('.swiper-container', {
        scrollbar: '.swiper-scrollbar',
        scrollbarHide: true,
        slidesPerView: 'auto',
        centeredSlides: true,
        spaceBetween: 30,
        grabCursor: true
    });
</script>
<script type="text/javascript">
	//调用百度地图
    var map = new BMap.Map('map_cavans');
    map.enableScrollWheelZoom();
    map.centerAndZoom(new BMap.Point(121.47535,31.233588), 12);
    function LookForLocate(start, end, icon){
        var lushu;
        // 实例化一个驾车导航用来生成路线
        var drv = new BMap.DrivingRoute(map, {
	        renderOptions: {
	          map: map,
	          panel: "allmap-result",
	        },
            onSearchComplete: function(res) {
                if (drv.getStatus() == BMAP_STATUS_SUCCESS) {
                    var plan = res.getPlan(0);
                    var arrPois =[];
                    var output = "";
                    output += "总时间为：" ;
                    output += plan.getDuration(true) + "\n";             //获取时间
                    output += "总路程为：" ;
                    output += plan.getDistance(true) + "\n";             //获取距离                  
                    for(var j=0;j<plan.getNumRoutes();j++){
                        var route = plan.getRoute(j);
                        arrPois= arrPois.concat(route.getPath());
                    }
                    map.addOverlay(new BMap.Polyline(arrPois, {strokeColor: '#111'}));
                    map.setViewport(arrPois);                   
                    lushu = new BMapLib.LuShu(map,arrPois,{
                    defaultContent:output,//标签内容
                    autoView:true,//是否开启自动视野调整，如果开启那么路书在运动过程中会根据视野自动调整
                    icon  : new BMap.Icon(icon, new BMap.Size(52,26),{anchor : new BMap.Size(27, 13)}),
                    speed: 4500,
                    enableRotation:true,//是否设置marker随着道路的走向进行旋转
                    landmarkPois: [
                    ]});  
                    lushu.start(); 
                }else{
                	alert("未能搜索到相关信息");
                }
            }
        });
        drv.search(start,end);
    }
	//时间选择器
    flatpickr(".flatpickr", {
        enableTime: true,
        noCalendar: true,
        minuteIncrement: 1
    });
    //查询地图操作
    $('#lookingRoute').on('click',function(){
        var chooseBusType = $('#chooseBusType').val();
        if(chooseBusType == '1'){
            chooseBusType = "../Front-HTML/smallbus.png";
        }else if(chooseBusType == '2'){
            chooseBusType = "../Front-HTML/mediumbus.png";
        }else if(chooseBusType == '3'){
            chooseBusType = "../Front-HTML/bigbus.png";
        }
        var inputStart = $('#inputStart').val();
        var inputEnd = $('#inputEnd').val();
        LookForLocate(inputStart,inputEnd,chooseBusType);
    });

    //重置地图操作
    $('#refreshMap').on('click',function(){
        map.clearOverlays();
        $('#inputStart').val("");
        $('#inputEnd').val("");
        $('#chooseBusType option:selected').val('1');
    });
	
    function checkorder(){ 
        return $("#orderForm").validate({
            rules: {
              inputStart: "required",
              inputEnd: "required",             
              inputDate: "required"
            },
            messages: {
              inputStart: "请输入起点",
              inputEnd: "请输入终点",
              inputDate: "请选择日期",
            }
        });
    }
    
    //我要下单操作
    $('#placeOrder').on('click',function(){
    	if(!checkorder().form()) return; 
        var inputStart = $('#inputStart').val();
        var inputEnd = $('#inputEnd').val();
        var chooseBusType = $('#chooseBusType').val();
        var inputDate = $('#inputDate').val();
        $.ajax({
			type: "POST",
	    	url: "../route/judge",
	        data: {
	        	inputStart : inputStart,
	        	inputEnd : inputEnd,
	        	chooseBusType : chooseBusType,
	        	inputDate : inputDate,        	
	        },
	        dataType: "json",   
 	        async : false,   
	        success:function(data){
				var have = data.have;
				if(false == have){
					alert("暂无该路线，请先众筹")
					window.location.href="../web/property";
				}else{
					var start = data.start;
					var end = data.end;
					var type = data.type;
					var time = data.time;
					window.location.href="../route/recommend?start="+start+"&end="+end+"&type="+type+"&time="+time+"";
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
				type: "post",
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
<!--百度地图联想输入-->
<script type="text/javascript">
    function G(id) {
        return document.getElementById(id);
    }

    var start = new BMap.Autocomplete(    //建立一个自动完成的对象
        {"input" : "inputStart"
        ,"location" : map
    });

    start.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
    var str = "";
        var _value = e.fromitem.value;
        var value = "";
        if (e.fromitem.index > -1) {
            value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        }    
        str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
        
        value = "";
        if (e.toitem.index > -1) {
            _value = e.toitem.value;
            value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        }    
        str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
        G("searchResultPanel").innerHTML = str;
    });

    var myValue;
    start.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
    var _value = e.item.value;
        myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
        
        setPlace();
    });

    var end = new BMap.Autocomplete(    //建立一个自动完成的对象
        {"input" : "inputEnd"
        ,"location" : map
    });

    end.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
    var str = "";
        var _value = e.fromitem.value;
        var value = "";
        if (e.fromitem.index > -1) {
            value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        }    
        str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
        
        value = "";
        if (e.toitem.index > -1) {
            _value = e.toitem.value;
            value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        }    
        str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
        G("searchResultPanel").innerHTML = str;
    });

    var myValue;

    end.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
    var _value = e.item.value;
        myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
        
        setPlace();
    });

    function setPlace(){
        map.clearOverlays();    //清除地图上所有覆盖物
        function myFun(){
            var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
            map.centerAndZoom(pp, 18);
            map.addOverlay(new BMap.Marker(pp));    //添加标注
        }
        var local = new BMap.LocalSearch(map, { //智能搜索
          onSearchComplete: myFun
        });
        local.search(myValue);
    }
</script>
</body>
</html>