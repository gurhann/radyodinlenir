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
				Yeni Radyo İstasyonu Ekle <a href="/admin/radiostations/1"
					class="btn btn-success btn-sm" style="float: right">Radyo
					İstasyonları</a>
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
				<form:form method="POST" action="/admin/radiostations/add"
					enctype="multipart/form-data" modelAttribute="radiostation">
					<form:hidden path="id" />
					<form:hidden path="logo" />
					<form:hidden path="cleanUrl" />
					<form:hidden path="hitCount" />
					<spring:bind path="name">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="control-label"> Radyo Adı</label>
							<form:input path="name" type="text" class="form-control"
								placeholder="Adı" />
							<form:errors path="name" class="control-label" />
						</div>
					</spring:bind>
					<spring:bind path="description">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="control-label"> Radyo Hakkında</label>
							<form:textarea path="description" class="form-control" />
							<form:errors path="description" class="control-label" />
						</div>
					</spring:bind>

					<spring:bind path="logoFile">
						<div
							class="form-group ${status.error ? 'has-error' : ''} ${not empty radiostation.logo ? 'col-md-10' : ''}">
							<label class="control-label">Radyo Logo</label> <input
								name="logoFile" type="file" class="form-control " />

							<form:errors path="logoFile" class="control-label" />
						</div>
						<c:if test="${not empty radiostation.logo}">
							<div class="form-group  col-md-2">
								<img alt="" height="150" width="150"
									src="/resources/radiologos/${radiostation.logo}">
							</div>
						</c:if>
					</spring:bind>


					<spring:bind path="musicType.id">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="control-label"> Radyo Yayın Tipi</label>
							<form:select multiple="false" path="musicType.id"
								class="form-control">
								<form:options items="${musicTypes}" itemValue="id"
									itemLabel="name" />
							</form:select>
							<form:errors path="musicType.id" class="control-label" />
						</div>
					</spring:bind>
					
					
					<spring:bind path="radioCity.id">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="control-label"> Radyo Yayın Merkezi</label>
							<form:select multiple="false" path="radioCity.id"
								class="form-control">
								<form:options   items="${cities}" itemValue="id"
									itemLabel="name" />
							</form:select>
							<form:errors path="radioCity.id" class="control-label" />
						</div>
					</spring:bind>
					
					<spring:bind path="streamUrl">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="control-label"> Radyo Stream Url</label>
							<form:input path="streamUrl" type="text" class="form-control"
								placeholder="Stream Url" />
							<form:errors path="streamUrl" class="control-label" />
						</div>
					</spring:bind>
					<spring:bind path="embeddedUrl">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="control-label"> Radyo Embed Code</label>
							<form:input path="embeddedUrl" type="text" class="form-control"
								placeholder="Embed Code" />
							<form:errors path="embeddedUrl" class="control-label" />
						</div>
					</spring:bind>
					<spring:bind path="priority">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="control-label"> Radyo Önem Derecesi</label>
							<form:input path="priority" type="number" class="form-control"
								placeholder="Önem derecesi" />
							<form:errors path="priority" class="control-label" />
						</div>
					</spring:bind>
					<spring:bind path="seoKeywords">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="control-label" for="success"> SEO Anahtar
								Kelimeler</label>
							<form:input path="seoKeywords" type="text" class="form-control"
								placeholder="Seo Anahtar kelimeler" />
							<form:errors path="seoKeywords" class="control-label" />
						</div>
					</spring:bind>
					<spring:bind path="seoDescription">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="control-label"> SEO Tanımlaması</label>
							<form:input path="seoDescription" type="text"
								class="form-control" placeholder="Seo Tanımlaması" />
							<form:errors path="seoDescription" class="control-label" />
						</div>
					</spring:bind>
					<c:if test="${radiostation.id !=0 }">
						<div class="checkbox">
							<label> <form:checkbox path="enabled"  />
								Yayın Dışına Al
							</label>
						</div>
					</c:if>
					<div class="form-group" style="float: right">
						<button type="submit" class="btn btn-success">Kaydet</button>
					</div>
				</form:form>
			</div>
		</div>
		<!--  end  Context Classes  -->
	</div>
</div>