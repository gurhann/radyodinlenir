<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="box info category">
<div class="ads"><c:out value="${adleftmenu.description}" escapeXml="false"></c:out></div>
	<div class="box-heading">İllere Göre Radyolar</div>
	<div class="box-content">
		<div class="box-category">
			<ul>				
				<c:forEach var="city" items="${cities}">
					<li><a href="/radiosofcity/${city.cleanUrl}/1"><span>${city.id < 10 ? '0'.concat(city.id) : city.id}</span> ${city.name} </a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>