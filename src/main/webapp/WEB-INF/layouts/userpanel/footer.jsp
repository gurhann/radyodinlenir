<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<footer class="doc-footer text-uppercase text-center text-bold">
	<div class="container">
		<ul class="social-list style2 circular">
			<li><a href="https://www.facebook.com/${facebookid.description }" target="_blank" class="fa fa-facebook"></a></li>
			<li><a href="https://twitter.com/${twitterid.description }" target="_blank" class="fa fa-twitter"></a></li>
			<li><a href="https://plus.google.com/${googlplusid.description }" target="_blank" class="fa fa-google-plus"></a></li>
			<li><a href="https://www.instagram.com/${instagramid.description }" target="_blank" class="fa fa-instagram"></a></li>
			<li><a href="https://www.youtube.com/channel/${youtubeid.description}}" target="_blank" class="fa fa-youtube"></a></li>
			<li><a href="https://vimeo.com/${vimeoid.description}" target="_blank" class="fa fa-vimeo"></a></li>
		</ul>
		<div class="row">
			<div class="col-xs-12">
				<strong> <c:out escapeXml="false" value="${copyrigt.description}"></c:out> </strong>
				<p>Her telden radyoyu sadece bu adresde bulabilirsiniz.</p>
			</div>
		</div>
	</div>
</footer>
