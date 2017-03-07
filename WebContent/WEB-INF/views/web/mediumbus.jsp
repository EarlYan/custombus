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
    <link rel="stylesheet" href="../assets/css/jquery.seat-charts.css" type="text/css">
    <style type="text/css">
    .error{
        color: red;
    }
    </style>
    <style type="text/css">
        #content a {
            color: #b71a4c;
        }
        .front-indicator {
            width: 145px;
            margin: 5px 32px 15px 32px;
            background-color: #f6f6f6;  
            color: #adadad;
            text-align: center;
            padding: 3px;
            border-radius: 5px;
        }
/*        #content .container {
            margin: 0 auto;
            width: 500px;
            text-align: left;
        }*/
        .booking-details {
            float: left;
            text-align: left;
            margin-left: 35px;
            font-size: 12px;
            position: relative;
            height: 401px;
        }
        .booking-details h2 {
            margin: 25px 0 20px 0;
            font-size: 17px;
        }
        .booking-details h3 {
            margin: 5px 5px 0 0;
            font-size: 14px;
        }
        div.seatCharts-cell {
            color: #182C4E;
            height: 25px;
            width: 25px;
            line-height: 25px;
            
        }
        div.seatCharts-seat {
            color: #FFFFFF;
            cursor: pointer;    
        }
        div.seatCharts-row {
            height: 35px;
        }
        div.seatCharts-seat.available {
            background-color: #B9DEA0;

        }
        div.seatCharts-seat.available.first-class {
        /*  background: url(vip.png); */
            background-color: #3a78c3;
        }
        div.seatCharts-seat.focused {
            background-color: #76B474;
        }
        div.seatCharts-seat.selected {
            background-color: #E6CAC4;
        }
        div.seatCharts-seat.unavailable {
            background-color: #ccc;
        }
        div.seatCharts-container {
            border-right: 1px dotted #adadad;
            width: 200px;
            padding: 20px;
            float: left;
        }
        div.seatCharts-legend {
            padding-left: 0px;
            bottom: 0;
        }
        ul.seatCharts-legendList {
            padding-left: 0px;
        }
        span.seatCharts-legendDescription {
            margin-left: 5px;
            line-height: 30px;
        }
        .checkout-button {
            display: block;
            margin: 10px 0;
            font-size: 14px;
        }
        #selected-seats {
            max-height: 200px;
            overflow-y: scroll;
            overflow-x: hidden;
            width: 170px;
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
    <h2 class="page-header">选择座位</h2>

    <div class="content">
        <div class="agent">
            <div class="row">
                <div id="seat-map">
                      <div class="front-indicator" style="width: 83px">车头</div>
                    </div>
                    <div class="booking-details">
                      <h3>已选中的座位 (<span id="counter">0</span>):</h3>
                      <ul id="selected-seats">
                      </ul>
                      <p>总价: <b>¥<span id="total">0</span></b></p>
                      <p><input type="button" class="btn btn-primary arrow-right checkout-button" value="结算"></p>
                      <div id="legend"></div>
                    </div>
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
<script type="text/javascript" src="../assets/js/jquery.seat-charts.min.js"></script> 
<script>
            var firstSeatLabel = 1;
            var seatsOccupied = '${seatsOccupied}';
            $(document).ready(function() {
            	var price =Math.floor('${price}'); 
                var $cart = $('#selected-seats'),
                    $counter = $('#counter'),
                    $total = $('#total'),
                    sc = $('#seat-map').seatCharts({
                    map: [
                          '___e',
                          'ee__',
                          'ee_e',
                          'ee_e',
                          'ee_e',
                          'eeee',
                    ],
                    seats: {
                        e: {
                            price   : price,
                            classes : 'economy-class', //your custom CSS class
                            category: '未预定'
                        }                           
                    },
                    naming : {
                        top : false,
                        getLabel : function (character, row, column) {
                            return firstSeatLabel++;
                        },
                    },
                    legend : {
                        node : $('#legend'),
                        items : [
                            [ 'e', 'available',   '未预定'],
                            [ 'f', 'unavailable', '已预定']
                        ]                   
                    },
                    click: function () {
                        if (this.status() == 'available') {
                            $('<li>'+this.data().category+this.settings.label+'号座位'+'：<br/>价格：<b>¥'+this.data().price+'</b> <a class="cancel-cart-item">[删除]</a></li>')
                                .attr('id','cart-item-'+this.settings.id)
                                .data('seatId', this.settings.id)
                                .appendTo($cart);
                            $counter.text(sc.find('selected').length+1);
                            $total.text(recalculateTotal(sc)+this.data().price);
                            
                            return 'selected';
                        } else if (this.status() == 'selected') {
                            //update the counter
                            $counter.text(sc.find('selected').length-1);
                            //and total
                            $total.text(recalculateTotal(sc)-this.data().price);
                        
                            //remove the item from our cart
                            $('#cart-item-'+this.settings.id).remove();
                        
                            //seat has been vacated
                            return 'available';
                        } else if (this.status() == 'unavailable') {
                            //seat has been already booked
                            return 'unavailable';
                        } else {
                            return this.style();
                        }
                    }
                });

                //this will handle "[cancel]" link clicks
                $('#selected-seats').on('click', '.cancel-cart-item', function () {
                    //let's just trigger Click event on the appropriate seat, so we don't have to repeat the logic here
                    sc.get($(this).parents('li:first').data('seatId')).click();
                });

                //let's pretend some seats have already been booked   
                sc.get(getUnavailable()).status('unavailable');
        });
        function getUnavailable(){
        	var uns=new Array();
        	<c:forEach var="s" items="${seatsOccupied}">
        	var i = ${s};
        	var id = $('.seatCharts-seat.seatCharts-cell.economy-class.available').eq(i).attr('id');
        	uns.push(id);
        	</c:forEach>
        	return uns;
        }
        
        function recalculateTotal(sc) {
            var total = 0;
        
            //basically find every selected seat and sum its price
            sc.find('selected').each(function () {
                total += this.data().price;
            });
            
            return total;
        }
        //结算
        $('.checkout-button').on('click',function(){
        	var routeId = '${route.id}';
        	console.log(routeId);
        	var array = new Array();
        	var len = $('.seatCharts-seat.seatCharts-cell.economy-class.selected').size();
        	for(var i=0;i<len;i++){
        		array.push($('.seatCharts-seat.seatCharts-cell.economy-class.selected').eq(i).text());
        	}
            var price = $('#total').text();
            $.ajax(
       			{
       			type: "POST",
       	    	url: "../order/book",
       	        data: {
       	        	price : price,
       	        	array : array,
       	        	routeId : routeId
       	        },
       	        dataType: "json",   
       	        async : false,   
       	        success:function(data){
       	            alert("感谢订购");
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