<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="row">
	<div class="col-md-12">

		<!--    Context Classes  -->
		<div class="panel panel-default">
			<div class="panel-heading">
				Genel Ayarlar <a href="#" class="btn btn-default btn-sm"
					style="float: right">Alternatif 2</a> <a
					href="/admin/ayarlar/hakkimizda" class="btn btn-warning btn-sm"
					style="float: right">Hakkımızda</a> <a href="/admin/ayarlar/sosyal"
					class="btn btn-info btn-sm" style="float: right">Sosyal Ağlar</a> <a
					href="/admin/generalconfig" class="btn btn-success btn-sm"
					style="float: right">Genel Ayarlar</a>
			</div>
			<div class="panel-body">
				<form:form method="POST" action="/admin/generalconfig"	modelAttribute="generalConfigsForm">
					<spring:bind path="title">
						<div class="form-group  ${status.error ? 'has-error' : ''}">
							<label>Site Başlığı</label>
							<form:input path="title" type="text" class="form-control"
								placeholder="Site Başlığı" />
								<form:errors path="title" class="control-label" />
						</div>
					</spring:bind>
					<spring:bind path="description">
					<div class="form-group  ${status.error ? 'has-error' : ''}">
						<label>Site Description</label>
						<form:input path="description" type="text" class="form-control"
							placeholder="Site Description" />
							<form:errors path="description" class="control-label" />
					</div>
						</spring:bind>
					<spring:bind path="keywords">
					<div class="form-group  ${status.error ? 'has-error' : ''}">
						<label>Site Keywords</label>
						<form:input path="keywords" type="text" class="form-control"
							placeholder="Site Keywords" />
							<form:errors path="keywords" class="control-label" />
					</div>
						</spring:bind>
					<spring:bind path="copyright">
					<div class="form-group  ${status.error ? 'has-error' : ''}">
						<label>Site Copyright</label>
						<form:input path="copyright" type="text" class="form-control"
							placeholder="Site Copyright" />
							<form:errors path="copyright" class="control-label" />
					</div>
						</spring:bind>
					<div class="form-group" style="float: right">
						<button type="submit" class="btn btn-success">Kaydet</button>
					</div>
				</form:form>
			</div>
		</div>
		<!--  end  Context Classes  -->
	</div>
</div>