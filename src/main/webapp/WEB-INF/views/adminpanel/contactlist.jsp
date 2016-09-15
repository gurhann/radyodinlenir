<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="row">
	<div class="col-md-12">

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
				<c:if test="${empty contactlist}">
					<div class="alert alert-danger alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<strong><spring:message code="ContactRequest.NotFound" /></strong>
					</div>
				</c:if>
				<table class="table table-hover table-bordered">
					<thead>
						<tr>
							<th width="50">#ID</th>
							<th><i class="fa fa-user" aria-hidden="true"></i>&nbsp;Adı</th>
							<th width="200"><i class="fa fa-envelope" aria-hidden="true"></i>
								&nbsp;Mail Adresi</th>
							<th width="200"><i class="fa fa-calendar-o"
								aria-hidden="true"></i>&nbsp;Tarihi</th>
							<td width="100"><i class="fa fa-cogs" aria-hidden="true"></i>&nbsp;Detaylar</td>
						</tr>
					</thead>
					<tbody>
						<c:if test="${not empty contactlist}">
							<c:forEach var="contact" items="${contactlist}">
								<tr
									class="form-group ${contact.wasAnswered ? 'success' : 'danger'}">
									<td>${contact.id}</td>
									<td>${contact.name}</td>
									<td>${contact.email}</td>
									<td>${contact.sendDate}</td>
									<td><a href="/admin/contactlist/${contact.id}/details"
										class="btn btn-info btn-xs">Detay</a> <a
										href="/admin/contactlist/${contact.id}/delete"
										class="btn btn-danger btn-xs">Sil</a></td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>

				<ul class="pagination">
					<c:url value="/admin/contactlist/${amount-1}" var="prev">
					</c:url>
					<c:if test="${amount > 1}">
						<li><a class="prev page-numbers"
							href="<c:out value="${prev}" />">←</a></li>
					</c:if>
					<c:if test="${amount <= 4}">
						<c:forEach begin="1"	end="${((amount+4) <= maxamount ? 7 : maxamount)}" step="1"
							varStatus="i">
							<c:choose>
								<c:when test="${amount == i.index}">
									<li  class='active'><span>${i.index}</span></li>
								</c:when>
								<c:otherwise>
									<c:url value="/admin/contactlist/${i.index}" var="url">
									</c:url>
									<li><a  href="${url}">${i.index}</a></li>

								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
					<c:if test="${amount > 4}">
						<c:forEach begin="${amount-4}"
							end="${((amount+4) <= maxamount ? (amount+3) : maxamount)}"
							step="1" varStatus="i">
							<c:choose>
								<c:when test="${amount == i.index}">
									<li class='active'><span >${i.index}</span></li>
								</c:when>
								<c:otherwise>
									<c:url value="/admin/contactlist/${i.index}" var="url">
									</c:url>
									<li><a href="${url}">${i.index}</a></li>

								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>

					<c:url value="/admin/contactlist/${amount+1}" var="next">
					</c:url>
					<c:if test="${amount + 1 <= maxamount}">
						<li><a class='next page-numbers' href="${ next}">→</a></li>
					</c:if>
				</ul>

			</div>
		</div>
	</div>
</div>