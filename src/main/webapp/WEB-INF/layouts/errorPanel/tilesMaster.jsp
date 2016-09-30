<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="/resources/userPanelAssets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/resources/userPanelAssets/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="/resources/userPanelAssets/css/animate.css">
<link rel="stylesheet" type="text/css"
	href="/resources/userPanelAssets/css/error.css">
<title><tiles:insertAttribute name="errorName" /></title>
</head>
<body>

	<section>
	<div class="container">
		<div class="row row1">
			<div class="col-md-12">
				<h3 class="center capital f1 wow fadeInLeft" data-wow-duration="2s">
					<tiles:insertAttribute name="title" />

				</h3>
				<h1 id="error" class="center wow fadeInRight" data-wow-duration="2s">0</h1>
				<p class="center wow bounceIn" data-wow-delay="2s">
					<tiles:insertAttribute name="errorName" />
				</p>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<div id="cflask-holder" class="wow fadeIn" data-wow-delay="2800ms">
					<span class="wow tada " data-wow-delay="3000ms"><i
						class="fa fa-flask fa-5x flask wow flip" data-wow-delay="3300ms"></i>
						<i id="b1" class="bubble"></i> <i id="b2" class="bubble"></i> <i
						id="b3" class="bubble"></i> </span>
				</div>
			</div>
		</div>



		<div class="row">
			<!--Links Start-->
			<div class="col-md-12">
				<div class="links-wrapper col-md-4 col-md-offset-5">
					<div class="links col-md-3 col-md-offset-2 wow fadeIn" style="padding-left: 0px" data-wow-delay="3300ms">
						 <h3 style="margin-left:-15px">İtaki Yazılım</h3>
					</div>
				</div>
			</div>

		</div>
		<!-- Links End-->
	</div>
	</section>
	<script src="/resources/userPanelAssets/js/jquery.js"></script>
	<script src="/resources/userPanelAssets/js/countUp.js"></script>
	<script src="/resources/userPanelAssets/js/wow.js"></script>
	<!--Initiating the CountUp Script-->
	<script type="text/javascript">
		"use strict";
		var count = new countUp("error", 0,
				<tiles:insertAttribute name='errorCode' />, 0, 3);

		window.onload = function() {
			// fire animation
			count.start();
		}
	</script>
	<!--Initiating the Wow Script-->
	<script>
		"use strict";
		var wow = new WOW({
			animateClass : 'animated',
			offset : 100
		});
		wow.init();
	</script>
</body>
</html>