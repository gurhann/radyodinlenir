<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="row">
	<div class="col-md-12">
		<!--    Context Classes  -->
		<div class="panel panel-default">
			<div class="panel-heading">
				Genel Ayarlar 
				<a href="/admin/seoconfigs" class="btn btn-default btn-sm" style="float: right">Seo Ayarlar</a> 
				<a href="/admin/aboutconfigs" class="btn btn-warning btn-sm"	style="float: right">Hakkımızda</a>
				<a href="/admin/socialconfigs"	class="btn btn-info btn-sm" style="float: right">Sosyal Ağlar</a> 
				<a href="/admin/generalconfigs" class="btn btn-success btn-sm" style="float: right">Genel Ayarlar</a>
			</div>
			<div class="panel-body">
				<c:if test="${not empty msg}">
					<div class="alert alert-${css} alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<strong>${msg}</strong>
					</div>
				</c:if>
				<form:form method="POST" action="/admin/generalconfigs"
					modelAttribute="generalConfigsForm">
					<c:forEach items="${generalConfigsForm.configs}" varStatus="stat"
						var="form">
						<spring:bind path="configs[${stat.index}].description">
						<form:hidden path="configs[${stat.index}].id"/>
						<form:hidden path="configs[${stat.index}].name"/>
							<div class="form-group  ${status.error ? 'has-error' : ''}">
								<label>Site ${form.name}</label>
								<form:input path="configs[${stat.index}].description"
									type="text" class="form-control" />
								<form:errors path="configs[${stat.index}].description"
									class="control-label" />
							</div>
						</spring:bind>
					</c:forEach>
					<div class="form-group" style="float: right">
						<button type="submit" class="btn btn-success">Kaydet</button>
					</div>
				</form:form>
			</div>
		</div>
		<!--  end  Context Classes  -->
	</div>
</div>