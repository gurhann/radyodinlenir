<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="row">
	<div class="col-md-12">
		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>
		<form:form method="POST" modelAttribute="musicType"
			action="/admin/musictypelist/${musicType.id}/edit">
			<form:hidden path="id" />
			<form:hidden path="cleanUrl" />
			<spring:bind path="name">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="control-label" for="success"> Adı</label>
					<form:input path="name" type="text" class="form-control"
						id="success" placeholder="Adı" />
					<form:errors path="name" class="control-label" />
				</div>
			</spring:bind>
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="control-label" for="queue">Sırası:</label>
				<form:select path="priority" class="form-control" id="queue">
					<c:forEach var="i" begin="1" end="15">
						<option ${musicType.priority == i ? "selected": "" }>${i}</option>
					</c:forEach>
				</form:select>
				<form:errors path="priority" class="control-label" />
			</div>
			<div class="form-group" style="float: right">
			<a href="/admin/musictypelist" class="btn btn-info ">Müzik tipleri</a>
				<button type="submit" class="btn btn-success">Kaydet</button>
			</div>
		</form:form>

	</div>
	<!--  end  Context Classes  -->
</div>