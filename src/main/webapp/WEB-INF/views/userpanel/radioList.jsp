<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="events-finder">
	<div class="container">
		<header>
			<div class="row">
				<div class="col-xs-12 col-md-8">
					<h2 class="text-uppercase">Popüler Radyolar</h2>
				</div>
				<div class="col-xs-12 col-md-4">
					<div class="event-form text-right">
						<form>
							<div class="form-input search-keyword">
								<input type="text" placeholder="Radyo Ara"> <i class="icon fa fa-search"></i>
							</div>
							<button class="btn btn-default" type="submit">Radyo Ara</button>
						</form>
					</div>
				</div>
			</div>
		</header>
		<div class="featured-events">
			<div class="row">
				<div class="col-xs-12">
					<div class="store-grid text-uppercase text-bold">
						<c:forEach var="radio" items="${radioList}">
							<div class="store-product">
								<figure>
									<img width="152" height="152" src="${baseURL}/resources/radiologos/${radio.logo}">
									<figcaption>
										<a href="event-single.html" class="btn btn-grey"><i class="fa fa-ticket "></i> Dinle</a>
									</figcaption>
								</figure>
								<div class="product-info">
									<h3>${radio.name}</h3>
								</div>
							</div>
						</c:forEach>
					</div>
					<!--album-grid-->
					<ul class="pagination">
						<c:url value="${pagerBaseUrl}/${pageIndex-1}" var="prev">
						</c:url>
						<c:if test="${pageIndex > 1}">
							<li><a class="prev page-numbers" href="<c:out value="${prev}" />">←</a></li>
						</c:if>
						<c:if test="${pageIndex <= 4}">
							<c:forEach begin="1" end="${((pageIndex+4) <= maxPageIndex ? 7 : maxPageIndex)}" step="1"
								varStatus="i">
								<c:choose>
									<c:when test="${pageIndex == i.index}">
										<li class='active'><span>${i.index}</span></li>
									</c:when>
									<c:otherwise>
										<c:url value="${pagerBaseUrl}/${i.index}" var="url">
										</c:url>
										<li><a href="${url}">${i.index}</a></li>

									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:if>
						<c:if test="${pageIndex > 4}">
							<c:forEach begin="${pageIndex-4}"
								end="${((pageIndex+4) <= maxPageIndex ? (pageIndex+3) : maxPageIndex)}" step="1"
								varStatus="i">
								<c:choose>
									<c:when test="${pageIndex == i.index}">
										<li class='active'><span>${i.index}</span></li>
									</c:when>
									<c:otherwise>
										<c:url value="${pagerBaseUrl}/${i.index}" var="url">
										</c:url>
										<li><a href="${url}">${i.index}</a></li>

									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:if>

						<c:url value="${pagerBaseUrl}/${pageIndex+1}" var="next">
						</c:url>
						<c:if test="${pageIndex + 1 <= maxPageIndex}">
							<li><a class='next page-numbers' href="${ next}">→</a></li>
						</c:if>
					</ul>
				</div>
				<!--column-->
			</div>
		</div>
	</div>
</section>