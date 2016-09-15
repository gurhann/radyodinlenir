<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				&nbsp;
				<button class="btn btn-success" style="float: right"
					data-toggle="modal" data-target="#newMusicType">Müzik Tipi
					Ekle</button>
			</div>
			<div class="modal fade" id="newMusicType" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true"
				style="display: none;">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">Yeni Müzik Tipi</h4>
						</div>
						<form:form method="POST" modelAttribute="musicType"
							action="/admin/musictypelist">
							<div class="modal-body">
								<spring:bind path="name">
									<div class="form-group  ${status.error ? 'has-error' : ''}">
										<label>Adı:</label>
										<form:input path="name" type="text" class="form-control"
											id="name" placeholder="Adı" />
										<form:errors path="name" class="control-label" />
									</div>
								</spring:bind>
								<spring:bind path="priority">
									<div class="form-group">
										<label>Öncelik:</label>
										<form:select path="priority" class="form-control" id="queue">
											<c:forEach var="i" begin="1" end="15">
												<option>${i}</option>
											</c:forEach>
										</form:select>
										<form:errors path="priority" class="control-label" />
									</div>
								</spring:bind>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Kapat</button>
								<input type="submit" class="btn btn-primary" value="Kaydet" />
							</div>
						</form:form>
					</div>
				</div>
			</div>
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
				<c:if test="${ empty musicTypes}">
					<div class="alert alert-danger alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<strong><spring:message code="MusicTypes.NotFound" /></strong>
					</div>
				</c:if>
				<table class="table table-hover table-bordered">
					<thead>
						<tr>
							<th width="50">#ID</th>
							<th>Adı</th>
							<th width="200">Temiz Url</th>
							<th width="50">Öncelik</th>
							<td width="100">Düzenle</td>
						</tr>
					</thead>
					<tbody>
						<c:if test="${not empty musicTypes}">
							<c:forEach var="musicType" items="${musicTypes}">
								<tr class="success">
									<td>${musicType.id}</td>
									<td>${musicType.name}</td>
									<td>${musicType.cleanUrl}</td>
									<td>${musicType.priority}</td>
									<td><a href="/admin/musictypelist/${musicType.id}/edit"
										class="btn btn-info btn-xs">Düzenle</a> <a
										href="/admin/musictypelist/${musicType.id}/delete"
										class="btn btn-danger btn-xs">Sil</a></td>
								</tr>
							</c:forEach>
						</c:if>

					</tbody>


				</table>

			</div>
		</div>
	</div>
</div>