<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-md-12">
		<!--    Context Classes  -->
		<div class="panel panel-default">
			<div class="panel-heading">
				Genel Ayarlar 
				<a href="#" class="btn btn-default btn-sm"	style="float: right">Alternatif 2</a> 
				<a href="#"	class="btn btn-default btn-sm" style="float: right">Alternatif 1</a> 
				<a href="/admin/ayarlar/sosyal" class="btn btn-info btn-sm"	style="float: right">Sosyal Ağlar</a> 
				<a href="/admin/ayarlar" class="btn btn-success btn-sm" style="float: right">Genel	Ayarlar</a>
			</div>
			<div class="panel-body">
				<form:form method="POST" action="/admin/ayarlar"
					modelAttribute="genelConfigsForm">
					<div class="form-group">
						<label for="title">Site Başlığı</label>
						<form:input path="title" type="text" class="form-control"
							placeholder="Site Baaşlığı" />
					</div>
					<div class="form-group">
						<label for="description">Site Başlığı</label>
						<form:input path="description" type="text" class="form-control"
							placeholder="Site Baaşlığı" />
					</div>
					<div class="form-group">
						<label for="keyword">Site Başlığı</label>
						<form:input path="keyword" type="text" class="form-control"
							placeholder="Site Baaşlığı" />
					</div>
					<div class="form-group">
						<label for="copyright">Site Başlığı</label>
						<form:input path="copyright" type="text" class="form-control"
							placeholder="Site Baaşlığı" />
					</div>
					<div class="form-group">
						<label for="meta1">Site Başlığı</label>
						<form:input path="meta1" type="text" class="form-control"
							placeholder="Site Baaşlığı" />
					</div>
					<div class="form-group">
						<label for="meta2">Site Başlığı</label>
						<form:input path="meta2" type="text" class="form-control"
							placeholder="Site Baaşlığı" />
					</div>
					<div class="form-group" style="float: right">
						<button type="submit" class="btn btn-success">Kaydet</button>
					</div>
				</form:form>
			</div>
		</div>
		<!--  end  Context Classes  -->
	</div>
</div>