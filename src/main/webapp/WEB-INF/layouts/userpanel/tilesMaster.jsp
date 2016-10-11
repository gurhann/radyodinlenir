<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<!--[if lte IE 9]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 9]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<title><c:out
		value="${iTitle eq null ? title.description : iTitle.concat(' ').concat(title.description)}"></c:out></title>

<!--=== Meta tags ===-->
<meta name="description"
	content="${empty popularRadios ? item.seoDescription : decription.description  }">
<meta name="keywords"
	content="${empty popularRadios ? item.seoKeywords : keywords.description  }" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta name="viewport"
	content="minimum-scale=1.0, width=device-width, maximum-scale=1, user-scalable=no" />
<c:out value="${meta1.description }" escapeXml="false"></c:out>
<c:out value="${meta2.description }" escapeXml="false"></c:out>
<c:out value="${headerscript1.description }" escapeXml="false"></c:out>
<c:out value="${headerscript2.description }" escapeXml="false"></c:out>
<c:out value="${headerscript3.description }" escapeXml="false"></c:out>
<meta property="og:title" content="${iTitle eq null ? title.description : iTitle.concat(' ').concat(title.description)}"/>
<meta property="og:site_name" content="${title.description}"/>
<meta property="og:description" content="${empty popularRadios ? item.seoDescription : decription.description  }"/>
	
<link rel="shortcut icon" type="image/x-icon" href="/resources/favicon.ico">
<!--=== Style Sheets ===-->
<link
	href="http://fonts.googleapis.com/css?family=Lato:400,900,700,400italic,300,700italic"
	rel="stylesheet" type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,400italic,700'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css"
	href="${baseURL}/resources/userPanelAssets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${baseURL}/resources/userPanelAssets/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${baseURL}/resources/userPanelAssets/css/animations.css">
<link rel="stylesheet" type="text/css"
	href="${baseURL}/resources/userPanelAssets/css/dl-menu.css">
<link rel="stylesheet"
	href="${baseURL}/resources/userPanelAssets/css/main.css">

<script
	src="${baseURL}/resources/userPanelAssets/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>

<script src="${baseURL}/resources/userPanelAssets/js/jquery.js"></script>
<script src="/resources/userPanelAssets/js/jquery-ui.min.js"></script>
<script src="/resources/userPanelAssets/js/jwplayer.js"></script>
<script src="/resources/userPanelAssets/js/jwplayer.html5.js"></script>
<script src="/resources/userPanelAssets/js/jwpsrv.js"></script>
</head>
</head>
<body>
	<div style="position: absolute; top: -300px; z-index: -1;">
		<div id="hidden-radyo-player"></div>
	</div>
	<div class="majorWrap">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>

		<tiles:insertAttribute name="musicTypeNavigation"></tiles:insertAttribute>

		<div id="ajaxArea">
				
			
					<tiles:insertAttribute name="body"></tiles:insertAttribute>
					
		</div>
	</div>

	<tiles:insertAttribute name="radioPlayer"></tiles:insertAttribute>
	<tiles:insertAttribute name="footer"></tiles:insertAttribute>

	<script src="${baseURL}/resources/userPanelAssets/js/jquery.sticky.js"></script>
	<c:out value="${footerscript.description }"></c:out>
	<script src="${baseURL}/resources/userPanelAssets/js/main.js"></script>

</body>
</html>
