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
    .flatpickr-input {
        z-index: 1;
        max-width: 320px;
        display: block;
        outline: none;
        border: 1px solid #ddd;
        border-radius: 3px;
        color: rgba(0, 0, 0, 0.87);
        padding: 0 0 0 11px;
        height: 40px;
        width: 93%;
        margin-right: 0;
        margin-bottom: 0.5rem;
    }
    </style>
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
            <div class="list-your-property-form">
    <h2 class="page-header">众筹你的路线</h2>

    <div class="content">
        <div class="row">
            <div class="span8">
                <p>
                    定制符合自己的上下班路线，享受专属个性化服务，专车专道，一路畅行。
                </p>
            </div><!-- /.span8 -->
        </div><!-- /.row -->
		<div id="l-map" style="visibility: hidden;"></div>
            <form method="post" action="" id="propertyForm">
            <div class="row">
                <div class="span4">
                    <h3><strong>1.</strong> <span>个人信息</span></h3>

                    <div class="control-group">
                        <label class="control-label" for="inputPropertyName">
                            姓名
                            <span class="form-required" title="This field is required.">*</span>
                        </label>
                        <div class="controls">
                            <input type="text" id="inputPropertyName" name="inputPropertyName">
                        </div><!-- /.controls -->
                    </div><!-- /.control-group -->

                    <div class="control-group">
                        <label class="control-label" for="inputPropertyEmail">
                            邮箱
                            <span class="form-required" title="This field is required.">*</span>
                        </label>
                        <div class="controls">
                            <input type="text" id="inputPropertyEmail" name="inputPropertyEmail">
                        </div><!-- /.controls -->
                    </div><!-- /.control-group -->

                    <div class="control-group">
                        <label class="control-label" for="inputPropertyPhone">
                            手机号
                            <span class="form-required" title="This field is required.">*</span>
                        </label>
                        <div class="controls">
                            <input type="text" id="inputPropertyPhone" name="inputPropertyPhone">
                        </div><!-- /.controls -->
                    </div><!-- /.control-group -->
                </div><!-- /.span4 -->

                <div class="span4">
                    <h3><strong>2.</strong> <span>众筹路线</span></h3>

                    <div class="control-group">
                        <label class="control-label" for="inputPropertyLocationStart">
                            起点
                            <span class="form-required" title="This field is required.">*</span>
                        </label>
                        <div class="controls">
                            <input type="text" id="inputPropertyLocationStart" name="inputPropertyLocationStart">
                            <div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>
                        </div><!-- /.controls -->
                    </div><!-- /.control-group -->

                    <div class="control-group">
                        <label class="control-label" for="inputPropertyLocationEnd">
                            终点
                            <span class="form-required" title="This field is required.">*</span>
                        </label>
                        <div class="controls">
                            <input type="text" id="inputPropertyLocationEnd" name="inputPropertyLocationEnd">
                        </div><!-- /.controls -->
                    </div><!-- /.control-group -->

                    <div class="property-type control-group">
                        <label class="control-label" for="inputPropertyTimeStart">
                            出发时间
                            <span class="form-required" title="This field is required.">*</span>
                        </label>
                        <div class="controls">
                            <input class=flatpickr data-enable-time=true data-enable-seconds=true data-no-calendar=true placeholder="选择时间" style="        background: #ffffff;cursor: pointer;" id="inputPropertyTimeStart" name="inputPropertyTimeStart">
                        </div><!-- /.controls -->
                    </div><!-- /.control-group -->

                    <div class="contract-type control-group">
                        <label class="control-label" for="inputPropertyTimeEnd">
                            回程时间
                            <span class="form-required" title="This field is required.">*</span>
                        </label>
                        <div class="controls">
                            <input class=flatpickr data-enable-time=true data-enable-seconds=true data-no-calendar=true placeholder="选择时间" style="        background: #ffffff;cursor: pointer;" id="inputPropertyTimeEnd" name="inputPropertyTimeEnd">
                        </div><!-- /.controls -->
                    </div><!-- /.control-group -->
                </div><!-- /.span4 -->

                <div class="span4">
                    <h3><strong>3.</strong> <span>完成提交</span></h3>                    
                    <div class="control-group">
                        <label class="control-label" for="inputPropertyNotes">
                            你的提议
                        </label>
                        <div class="controls">
                            <textarea id="inputPropertyNotes" name="inputPropertyNotes"></textarea>
                        </div><!-- /.controls -->
                    </div><!-- /.control-group -->

                    <div class="control-group">
                        <div class="controls">
                            <input type="button" class="btn btn-primary" value="提交" id="sendProperty">
                        </div><!-- /.input-append -->
                    </div><!-- .fileupload -->

                </div><!-- /.span4 -->
            </div><!-- /.row -->
        </form>
    </div><!-- /.content -->
</div><!-- /.list-your-property-form -->        </div>
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
<script type="text/javascript" src="../assets/js/flatpickr.js"></script><!--时间选择器-->
<script type="text/javascript" src="../assets/js/jquery.validate.js"></script> 
<script type="text/javascript">
    //时间选择器
    flatpickr(".flatpickr", {
        // minDate: new Date(),
        enableTime: true,
        noCalendar: true,
        minuteIncrement: 1
    });
</script>
<script type="text/javascript">
    jQuery.validator.addMethod("isMobile", function(value, element) {
        var length = value.length;
        var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, "请正确填写您的手机号码");
  
</script>
<!--百度地图联想输入-->
<script type="text/javascript">
    function G(id) {
        return document.getElementById(id);
    }
    
	var map = new BMap.Map("l-map");
	map.centerAndZoom("上海",12);   
	
    var start = new BMap.Autocomplete(    //建立一个自动完成的对象
        {"input" : "inputPropertyLocationStart"
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
        {"input" : "inputPropertyLocationEnd"
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
<script type="text/javascript">
function checkProperty(){ 
	return $("#propertyForm").validate({
        rules: {
          inputPropertyName: "required",
          inputPropertyEmail: {
            required: true,
            email: true
          },
          inputPropertyPhone:{
            required : true,
            minlength : 11,
            isMobile : true
          },
          inputPropertyLocationStart: "required",
          inputPropertyLocationEnd: "required",
          inputPropertyTimeStart: "required",
          inputPropertyTimeEnd: "required"
        },  
        messages: {
          inputName: "请输入您的姓名",
          inputEmail: "请输入一个正确的邮箱",
          inputPropertyPhone: "请正确填写您的手机号码",
          inputPropertyLocationStart:"请输入起点地址",
          inputPropertyLocationEnd:"请输入终点地址",
          inputPropertyTimeStart:"请选择出发时间",
          inputPropertyTimeEnd:"请选择回程时间"
        }
    });
}

$('#sendProperty').on('click',function(){
	if(!checkProperty().form()) return; 
	var inputPropertyName = $('#inputPropertyName').val();
	var inputPropertyEmail = $('#inputPropertyEmail').val();
	var inputPropertyPhone = $('#inputPropertyPhone').val();
	var inputPropertyLocationStart = $('#inputPropertyLocationStart').val();
	var inputPropertyLocationEnd = $('#inputPropertyLocationEnd').val();
	var inputPropertyTimeStart = $('#inputPropertyTimeStart').val();
	var inputPropertyTimeEnd = $('#inputPropertyTimeEnd').val();
	var inputPropertyNotes = $('#inputPropertyNotes').val();
	$.ajax({
		type: "POST",
	   	url: "../property/saveProperty",
	    data: {
		    	inputPropertyName:inputPropertyName,
		    	inputPropertyEmail:inputPropertyEmail,
		    	inputPropertyPhone:inputPropertyPhone,
		    	inputPropertyLocationStart:inputPropertyLocationStart,
		    	inputPropertyLocationEnd:inputPropertyLocationEnd,
		    	inputPropertyTimeStart:inputPropertyTimeStart,
		    	inputPropertyTimeEnd:inputPropertyTimeEnd,
		    	inputPropertyNotes:inputPropertyNotes
	    },
	    dataType: "json",   
	    async : false,   
	    success:function(data){
	        alert("感谢提交我们会留意");
	        window.location.href="../web/index";
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