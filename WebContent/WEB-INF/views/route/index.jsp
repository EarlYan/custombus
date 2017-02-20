<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="../user/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="../user/css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
    <link href="../user/css/plugins/footable/footable.core.css" rel="stylesheet">

    <link href="../user/css/animate.min.css" rel="stylesheet">
    <link href="../user/css/style.min.css?v=20161215001" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">

       <div class="row">
           <div class="col-sm-12">
               <div class="ibox float-e-margins">
						<div class="mt-20">
							<table id="data-Table" class="table table-border table-bordered table-bg table-hover table-sort">
								<thead>
									<tr class="text-c">
										<th>司机用户名</th>
										<th>司机手机号</th>
										<th>车牌号</th>
										<th>巴士车型</th>
										<th>起点</th>
										<th>终点</th>
										<th>起始时间</th>
										<th>里程数</th>
										<th>大约时间(分钟)</th>
										<th>是否满人</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
             </div>
       </div>
   </div>
   
    <!-- 全局js -->
    <script src="../user/js/jquery-2.1.1.min.js"></script>
    <script src="../user/js/bootstrap.min.js?v=3.4.0"></script>
    <script src="../user/js/plugins/footable/footable.all.min.js"></script>
	<script src="../js/datatables/1.10.0/jquery.dataTables.min.js"></script> 
    <!-- 自定义js -->
    <script src="../user/js/content.min.js?v=1.0.0"></script>
    <script type="text/javascript">
    
	var myParam;
	
	$(document).ready(function(){
		var role = '${role}';
		var table = $('#data-Table').dataTable( {
		    "lengthChange":false,
		    "info": false,
			"pagingType": "full_numbers",
			"searching":false,
			"processing" : false,
			"serverSide" : true,
	        "ajax": {
	        	url:"../route/data",
	    		headers: {
				        Accept: "application/json; charset=utf-8"
				    },
				type: "post",
			    data: function(request){   	
				    	if(myParam !=null && myParam!="")
				    	{
				    		request.myParam = myParam;
				    	}
			    	return request;
			        }
	        },
	        "columns": [
	            { "data": "d_username","orderable":false},
	            { "data": "d_mobile","orderable":false},
	            { "data": "plate_number","orderable":false},
	            { "data": "bus_type","orderable":false},
	            { "data": "start_location","orderable":false},
	            { "data": "end_location","orderable":false},
	            { "data": "start_time","orderable":false},
	            { "data": "mileage","orderable":false},
	            { "data": "about_time","orderable":false},
	            { "data": "isFull","orderable":false},
	            { "data": "id","orderable":false}
	        ],
	        "columnDefs": [
	            {
	            "defaultContent":"",
	            "targets":['_all']
	            },
	            {
	            "render": function(data, type, row) {
	            	if(role == "admin"){
	            		return "<a href='../route/modifyPage?id=" + data + "'><i class=\"fa fa-edit text-navy\"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a value='" + data + "' onclick='deletefunc(" + data +")'><i class=\"fa fa-times text-navy\"></i></a>";	
	            	}else if(role == "driver"){
	            		return "<a href='../route/modifyPage?id=" + data + "'><i class=\"fa fa-edit text-navy\"></i></a>";
	            	}    
	            },
	            "targets": 10},
	            {
		            "render": function(data) {
		                return  new Date(data).Format("hh:mm:ss");
		        },
		        "targets": 6},
		        {
		            "render": function(data) {
		               if(data == 1){
		            	   return "小型客车";
		               }else if(data == 2){
		            	   return "中型客车";
		               }else if(data == 3){
		            	   return "大型客车";
		               }
		        },
		        "targets": 3},
		        {
		            "render": function(data) {
		               if(data == 0){
		            	   return "否";
		               }else if(data == 1){
		            	   return "是";
		               }
		        },
		        "targets": 9}
	        ]
	    } );
	    
	    //综合搜索
	    $("#query-btn").on("click",function(){
	    	myParam = $("#myParam").val();
	    	table.api().ajax.reload();
	    });	    
  
	});	
	function deletefunc(data){
	    var result = confirm("确定要删除吗？");
       	if(result){
           $.ajax
           ({ 
               url: "delete?id="+data,
               method: 'GET',
               dataType: "json", 
               data: { 
               },
               success: function (data) {
                   window.location.reload();
               }
           })
       	}
	}
	//时间信息format 函数
    Date.prototype.Format = function (fmt) { 
	    var o = {
	        "M+": this.getMonth() + 1, 
	        "d+": this.getDate(), 
	        "h+": this.getHours(), 
	        "m+": this.getMinutes(), 
	        "s+": this.getSeconds(), 
	        "q+": Math.floor((this.getMonth() + 3) / 3), 
	        "S": this.getMilliseconds() 
	    };
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o)
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	    return fmt;
	}
</script>
</body>
</html>