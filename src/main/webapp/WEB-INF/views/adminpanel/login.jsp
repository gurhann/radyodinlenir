<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row">
	<div class="col-md-6">
		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>
		<form method="POST" action="<c:url value='/login' />" name='loginForm'>
			<label>Kullanıcı Adı : </label> <input type='text' name='username'
				value='' class="form-control" /> <label>Kullanıcı Parolası :
			</label> <input type="password" name='password' class="form-control" />
			<hr>
			<button class="btn btn-info">
				<span class="glyphicon glyphicon-user"></span> &nbsp;Giriş
			</button>
			&nbsp; <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	</div>
	<div class="col-md-6">
		<div class="alert alert-success">
			This is a free bootstrap admin template with basic pages you need to
			craft your project. Use this template for free to use for personal
			and commercial use. <br> <strong> Some of its features
				are given below :</strong>
			<ul>
				<li>Responsive Design Framework Used</li>
				<li>Easy to use and customize</li>
				<li>Font awesome icons included</li>
				<li>Clean and light code used.</li>
			</ul>

		</div>
	</div>

</div>