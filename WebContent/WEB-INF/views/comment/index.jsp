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
										<th>评论者</th>
										<th>被评论者</th>
										<th>内容</th>
										<th>评论时间</th>
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
		var userLogin = '${member.realname}';
		var table = $('#data-Table').dataTable( {
		    "lengthChange":false,
		    "info": false,
			"pagingType": "full_numbers",
			"searching":false,
			"processing" : false,
			"serverSide" : true,
	        "ajax": {
	        	url:"../comment/data",
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
	            { "data": "commentPerson","orderable":false},
	            { "data": "commentedPerson","orderable":false},
	            { "data": "content","orderable":false},
	            { "data": "create_date","orderable":false},
	            { "data": "id","orderable":false}
	        ],
	        "columnDefs": [
	            {
	            "defaultContent":"",
	            "targets":['_all']
	            },
	            {
	            "render": function(data, type, row) {
	                return "<a href='../comment/modifyPage?id=" + data + "'><i class=\"fa fa-edit text-navy\"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a value='" + data + "' onclick='deletefunc(" + data +")'><i class=\"fa fa-times text-navy\"></i></a>";
	            },
	            "targets": 4},
	            {
		            "render": function(data) {
		                return  new Date(data).Format("yyyy-MM-dd hh:mm:ss");
		        },
		        "targets": 3},
		        {
		            "render": function(data) {
		               if(data == userLogin){
		            	   return "您";
		               }else{
		            	   return data;
		               }
		        },
		        "targets": 0}
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