<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<!--[if lte IE 9]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 9]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<c:set var="baseURL" value="${pageContext.request.contextPath}" />
<title>Radyo Dinlenir - HTML Theme</title>
<!--=================================
Meta tags
=================================-->
<meta name="description" content="">
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta name="viewport"
	content="minimum-scale=1.0, width=device-width, maximum-scale=1, user-scalable=no" />
<!--=================================
Style Sheets
=================================-->
<link href="http://fonts.googleapis.com/css?family=Lato:400,900,700,400italic,300,700italic"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,400italic,700'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet" type="text/css"
	href="${baseURL}/resources/userPanelAssets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${baseURL}/resources/userPanelAssets/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${baseURL}/resources/userPanelAssets/css/flexslider.css">
<link rel="stylesheet" type="text/css"
	href="${baseURL}/resources/userPanelAssets/css/owl.carousel.css">
<link rel="stylesheet" type="text/css"
	href="${baseURL}/resources/userPanelAssets/css/animations.css">
<link rel="stylesheet" type="text/css" href="${baseURL}/resources/userPanelAssets/css/dl-menu.css">
<link rel="stylesheet" type="text/css"
	href="${baseURL}/resources/userPanelAssets/css/jquery.datetimepicker.css">
<link rel="stylesheet" href="${baseURL}/resources/userPanelAssets/css/main.css">
<link rel="stylesheet" href="${baseURL}/resources/userPanelAssets/css/customizer.css">
<!--=================================
Place color files here ( right after main.css ) for example
<link rel="stylesheet" type="text/css" href="${baseURL}/resources/userPanelAssets/css/colors/color-name.css">
===================================-->

<script src="${baseURL}/resources/userPanelAssets/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>

</head>
<body>
	<div class="pageLoader"></div>
	<div class="majorWrap">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>

		<tiles:insertAttribute name="musicTypeNavigation"></tiles:insertAttribute>

		<div id="ajaxArea">

			<tiles:insertAttribute name="body"></tiles:insertAttribute>

		</div>
	</div>

	<tiles:insertAttribute name="radioPlayer"></tiles:insertAttribute>
	<tiles:insertAttribute name="footer"></tiles:insertAttribute>

	<script src="${baseURL}/resources/userPanelAssets/js/jquery.js"></script>
	<script src="${baseURL}/resources/userPanelAssets/js/ajaxify.min.js"></script>
	<script src="${baseURL}/resources/userPanelAssets/js/jquery.downCount.js"></script>
	<script src="${baseURL}/resources/userPanelAssets/js/jquery.datetimepicker.full.min.js"></script>
	<script src="${baseURL}/resources/userPanelAssets/js/jquery.bxslider.min.js"></script>
	<script src='https://maps.googleapis.com/maps/api/js?v=3.exp&#038;sensor=false&#038;ver=3.0'></script>
	<script src="${baseURL}/resources/userPanelAssets/js/jplayer/jquery.jplayer.min.js"></script>
	<script src="${baseURL}/resources/userPanelAssets/js/jplayer/jplayer.playlist.min.js"></script>
	<script src="${baseURL}/resources/userPanelAssets/js/jquery.flexslider-min.js"></script>
	<script src="${baseURL}/resources/userPanelAssets/js/jquery.stellar.min.js"></script>
	<script src="${baseURL}/resources/userPanelAssets/js/jquery.sticky.js"></script>
	<script src="${baseURL}/resources/userPanelAssets/js/jquery.waitforimages.js"></script>
	<script src="${baseURL}/resources/userPanelAssets/js/masonry.pkgd.min.js"></script>
	<script src="${baseURL}/resources/userPanelAssets/js/packery.pkgd.min.js"></script>
	<script src="${baseURL}/resources/userPanelAssets/js/tweetie.min.js"></script>
	<script src="${baseURL}/resources/userPanelAssets/js/owl.carousel.min.js"></script>

	<script src="${baseURL}/resources/userPanelAssets/js/main.js"></script>
	<script src="${baseURL}/resources/userPanelAssets/js/customizer.js"></script>

</body>
</html>
