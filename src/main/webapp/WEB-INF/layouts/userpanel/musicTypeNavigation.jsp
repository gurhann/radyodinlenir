<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section>
	<div class="container">
		<nav>
			<ul class="sf-menu">
				<li class="current"><a href="#"><i class="fa fa-music" aria-hidden="true"></i> Hepsi</a></li>
				<c:forEach var="musicType" items="${musicTypeList}">
					<li><a href="/stations/${musicType.cleanUrl}"> <i class="fa fa-music"
							aria-hidden="true"></i> ${musicType.name}
					</a></li>
				</c:forEach>
			</ul>
		</nav>
	</div>
</section>