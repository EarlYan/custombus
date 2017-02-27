<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
    <h2 class="page-header">推荐列表</h2>
    <div class="content">
          <table class="table">
          <thead>
          <tr>
              <th>起点</th>
              <th>终点</th>
              <th>起始时间</th>
              <th>里程数</th>
              <th>行程时间</th>
              <th>车型</th>
              <th>操作</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="r" items="${recommendRoutes}">
          <tr>
              <td>${r.start_location}</td>
              <td>${r.end_location}</td>         
              <td><fmt:formatDate value="${r.start_time}" type="time"/></td>
              <td>${r.mileage}</td>
              <td>${r.about_time}</td>
              <td>
              <c:if test="${r.bus_type == '1'}">小型客车</c:if>
              <c:if test="${r.bus_type == '2'}">中型客车</c:if>
              <c:if test="${r.bus_type == '3'}">大型客车</c:if>
			  </td>
              <td><a href='../order/bookPage?id=${r.id}'>预定</a></td>
          </tr>
          </c:forEach>
          </tbody>
      </table>
    </div><!-- /.content -->
</div><!-- /.our-agents -->        
	 <div class="our-agents-large">
    <h2 class="page-header">其他推荐</h2>
    <div class="content">
          <table class="table">
          <thead>
          <tr>
              <th>起点</th>
              <th>终点</th>
              <th>起始时间</th>
              <th>里程数</th>
              <th>行程时间</th>
              <th>车型</th>
              <th>操作</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="o" items="${otherRoutes}">
          <tr>
              <td>${o.start_location}</td>
              <td>${o.end_location}</td>
              <td><fmt:formatDate value="${o.start_time}" type="time"/></td>
              <td>${o.mileage}</td>
              <td>${o.about_time}</td>
              <td>
              <c:if test="${o.bus_type == '1'}">小型客车</c:if>
              <c:if test="${o.bus_type == '2'}">中型客车</c:if>
              <c:if test="${o.bus_type == '3'}">大型客车</c:if>
              </td>
              <td><a href='../order/bookPage?id=${o.id}'>预定</a></td>
          </tr>
          </c:forEach>
          </tbody>
      </table>
    </div><!-- /.content -->
</div><!-- /.our-agents -->
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