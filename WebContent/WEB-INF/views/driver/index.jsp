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
										<th>真实姓名</th>
										<th>邮箱</th>
										<th>性别</th>
										<th>手机号</th>
										<th>头像</th>
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
	
		var table = $('#data-Table').dataTable( {
		    "lengthChange":false,
		    "info": false,
			"pagingType": "full_numbers",
			"searching":false,
			"processing" : false,
			"serverSide" : true,
	        "ajax": {
	        	url:"../driver/data",
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
	            { "data": "realname","orderable":false},
	            { "data": "email","orderable":false},
	            { "data": "gender","orderable":false},
	            { "data": "mobile","orderable":false},
	            { "data": "imgurl","orderable":false},
	            { "data": "id","orderable":false},
	            { "data": "license","orderable":false,"visible":false}
	        ],
	        "columnDefs": [
	            {
	            "defaultContent":"",
	            "targets":['_all']
	            },
	            {
		        "render": function(data, type, row) {
		                return "<img src=\'"+data+"\' height='50' width='50'></img>";
		            },
		        "targets": 4},
	            {
	            "render": function(data, type, row) {
	            	if(row.license == 1){
	            		return "<a href='../self/modifyPage?id=" + data + "'><i class=\"fa fa-edit text-navy\"></i></a>";
	            	}else if(row.license == 0){
	            		return "<a href='../self/modifyPage?id=" + data + "'><i class=\"fa fa-edit text-navy\"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='../self/checkPage?id=" + data + "'><i class=\"fa fa-certificate text-navy\"></i></a>";
	            	}	                
	            },
	            "targets": 5},
	            {
		            "render": function(data) {
		                if(data ==0){
		                	return "男";
		                }else if(data ==1){
		                	return "女";
		                }
		            },
		        "targets": 2}
	        ]
	    } );
	    
	    //综合搜索
	    $("#query-btn").on("click",function(){
	    	myParam = $("#myParam").val();
	    	table.api().ajax.reload();
	    });	    
  
	});	
</script>

</body>

</html>