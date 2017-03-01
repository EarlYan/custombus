<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../driver/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="../driver/css/default.css">
	<!-- Syntax Highlighter -->
	<link href="../driver/css/shCore.css" rel="stylesheet" type="text/css" />
	<link href="../driver/css/shThemeDefault.css" rel="stylesheet" type="text/css" />
	<!-- Demo CSS -->
	<!-- <link rel="stylesheet" href="css/demo.css" type="text/css" media="screen" /> -->
	<link rel="stylesheet" href="../driver/css/flexslider.css" type="text/css" media="screen" />

	<!-- Modernizr -->
	<script src="../driver/js/modernizr.js"></script>
</head>
<body class="loading">
	<div id="container" class="cf">
		<div id="main" role="main">
	      <section class="slider">
	        <div class="flexslider">
	          <ul class="slides">
	            <li>
	  	    	    <img src="../driver/images/1.jpg" />
	  	    		</li>
	  	    		<li>
	  	    	    <img src="../driver/images/2.jpg" />
	  	    		</li>
	  	    		<li>
	  	    	    <img src="../driver/images/3.jpg" />
	  	    		</li>
	  	    		<li>
	  	    	    <img src="../driver/images/4.jpg" />
	  	    		</li>
	          </ul>
	        </div>
	      </section>
	    </div>
	  </div>
	
	<script src="http://libs.useso.com/js/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
	<script>window.jQuery || document.write('<script src="../driver/js/jquery-1.7.2.min.js"><\/script>')</script>
	<!-- FlexSlider -->
	  <script src="../driver/js/jquery.flexslider.js"></script>

	  <script type="text/javascript">
	    $(function(){
	      SyntaxHighlighter.all();
	    });
	    $(window).load(function(){
	      $('.flexslider').flexslider({
	        animation: "slide",
	        start: function(slider){
	          $('body').removeClass('loading');
	        }
	      });
	    });
	  </script>


	  <!-- Syntax Highlighter -->
	  <script type="text/javascript" src="../driver/js/shCore.js"></script>
	  <script type="text/javascript" src="../driver/js/shBrushXml.js"></script>
	  <script type="text/javascript" src="../driver/js/shBrushJScript.js"></script>

	  <!-- Optional FlexSlider Additions -->
	  <script src="../driver/js/jquery.easing.js"></script>
	  <script src="../driver/js/jquery.mousewheel.js"></script>
	  <script defer src="../driver/js/demo.js"></script>
</body>
</html>