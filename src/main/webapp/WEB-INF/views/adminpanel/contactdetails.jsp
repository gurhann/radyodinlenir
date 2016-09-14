<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="panel panel-success">
	<div class="panel-heading">
		<span class="contact-details-name"><i class="fa fa-user"
			aria-hidden="true"></i> <c:out value="${contactdetails.name}"
				escapeXml="true"></c:out> &nbsp;&nbsp;&nbsp;<i
			class="fa fa-envelope" aria-hidden="true"></i> <c:out
				value="${contactdetails.email}" escapeXml="true"></c:out>
			&nbsp;&nbsp;&nbsp;<i class="fa fa-calendar" aria-hidden="true"></i> <c:out
				value="${contactdetails.sendDate}"></c:out></span>
	</div>
	<div class="panel-body">
		<p>
			<c:out value="${contactdetails.message}" escapeXml="true" />
		</p>
	</div>
</div>
<div class="panel panel-default">
	<div class="panel-heading"><span class="contact-details-name"><i class="fa fa-share" aria-hidden="true"></i> Cevapla</span></div>
	<div class="panel-body">
	<textarea class="form-control" rows="3" placeholder="Text Area"></textarea>
	<hr/>
	<a href="#" style="float:right;" class="btn btn-success ">Gönder</a>
	
	</div>
</div>