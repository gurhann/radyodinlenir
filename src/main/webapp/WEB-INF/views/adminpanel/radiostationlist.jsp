<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				&nbsp; <a href="/admin/radiostations/add" class="btn btn-success" style="float: right">Radyo
					İstasyonu Ekle</a>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<c:if test="${not empty msg}">
						<div class="alert alert-${css} alert-dismissible" role="alert">
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">×</span>
							</button>
							<strong>${msg}</strong>
						</div>
					</c:if>
					<c:if test="${empty radioStationList}">
						<div class="alert alert-danger alert-dismissible" role="alert">
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">×</span>
							</button>
							<strong><spring:message code="RadioStation.NotFound" /></strong>
						</div>
					</c:if>
					<table class="table table-hover table-bordered">
						<thead>
							<tr>
								<th width="50">#ID</th>
								<th><i class="fa fa-play" aria-hidden="true"></i>&nbsp;Adı</th>
								<th width="200"><i class="fa fa-bar-chart"
									aria-hidden="true"></i> &nbsp;Hit</th>
								<th width="200"><i class="fa  fa-bell-slash"
									aria-hidden="true"></i>&nbsp;Yayın Durumu</th>
								<td width="100"><i class="fa fa-cogs" aria-hidden="true"></i>&nbsp;Detaylar</td>
							</tr>
						</thead>
						<tbody>
							<c:if test="${not empty radioStationList}">
								<c:forEach var="radioStation" items="${radioStationList}">
									<tr
										class="form-group ">
										<td>${radioStation.id}</td>
										<td>${radioStation.name}</td>
										<td>${radioStation.hitCount}</td>
										<td>${radioStation.enabled ? "Yayında" : "Yayında Değil"}</td>
										<td><a href="/admin/radiostations/${radioStation.id}/details"
											class="btn btn-info btn-xs">Detay</a> <a
											href="/admin/radiostations/${radioStation.id}/delete"
											class="btn btn-danger btn-xs">Sil</a></td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>

					<ul class="pagination">
						<c:url value="/admin/radiostations/${pageIndex-1}" var="prev">
						</c:url>
						<c:if test="${pageIndex > 1}">
							<li><a class="prev page-numbers"
								href="<c:out value="${prev}" />">←</a></li>
						</c:if>
						<c:if test="${pageIndex <= 4}">
							<c:forEach begin="1"
								end="${((pageIndex+4) <= maxPageIndex ? 7 : maxPageIndex)}" step="1"
								varStatus="i">
								<c:choose>
									<c:when test="${pageIndex == i.index}">
										<li class='active'><span>${i.index}</span></li>
									</c:when>
									<c:otherwise>
										<c:url value="/admin/radiostations/${i.index}" var="url">
										</c:url>
										<li><a href="${url}">${i.index}</a></li>

									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:if>
						<c:if test="${pageIndex > 4}">
							<c:forEach begin="${pageIndex-4}"
								end="${((pageIndex+4) <= maxPageIndex ? (pageIndex+3) : maxPageIndex)}"
								step="1" varStatus="i">
								<c:choose>
									<c:when test="${pageIndex == i.index}">
										<li class='active'><span>${i.index}</span></li>
									</c:when>
									<c:otherwise>
										<c:url value="/admin/radiostations/${i.index}" var="url">
										</c:url>
										<li><a href="${url}">${i.index}</a></li>

									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:if>

						<c:url value="/admin/radiostations/${pageIndex+1}" var="next">
						</c:url>
						<c:if test="${pageIndex + 1 <= maxPageIndex}">
							<li><a class='next page-numbers' href="${ next}">→</a></li>
						</c:if>
					</ul>

				</div>
			</div>
		</div>
	</div>
</div>