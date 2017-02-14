<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>主页</title>
    <style>	    
	html,body{
	    height: 100%;
	    width: 100%;
	    padding: 0;
	    margin: 0;
	}
	body{
	    overflow: hidden;
	    font-family: "Microsoft YaHei" , "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
	}
	.bg-warp{
	    display: inline-block;
	    background: #666 50% 40% no-repeat;
	    height:100%;
	    width: 100%;
	    background-size:cover;
	    position: relative;
	    letter-spacing:5px;
	}
	.bg-title{
	    display: inline-block;
	    position: absolute;
	    top:34%;
	    right: 7%;
	}
	.bg-title-t{
	    color: #ffffff;
	}
	.bg-title-b{
	    margin-top: 10px;
	    transform:rotateX(180deg) ;
	}
	.bg-title-b .bg-title-h{
	    opacity: .3;
	    color: #ffffff;
	}
	.bg-title-b .bg-title-p{
	    opacity: .05;
	}
	
	.bg-title-h{
	    font-size: 50px;
	    font-weight: bold;
	}
	.bg-title-p{
	    margin-top: 10px;
	    font-size: 30px;
	}
    </style>
</head>
<body class="gray-bg">
    <div class="bg-warp" style="background-image: url(../assets/img/bgimg.png)">
        <div class="bg-title">
            <div class="bg-title-t">
                <div class="bg-title-h">欢迎使用</div>              
            </div>
            <div class="bg-title-b">
                <div class="bg-title-h">欢迎使用</div>
            </div>
        </div>
    </div>
</body>
</html>