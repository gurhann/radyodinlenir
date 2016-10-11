<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container">
	<div class="row">
		<div class="col-sm-8 ">
			<div class="breadcrumb">
				<a href="/" class="first">Anasayfa </a> » <a href="/contact"
					class="last"> İletişim </a>
			</div>
			<div class="radio-info">
				<div class="tabs">
					<div class="tab-heading">İletişim</div>
					<div class="tab-content">
						<form:form method="POST" modelAttribute="contactRequest"
							id="contactForm" class="text-uppercase text-semibold row">

							<c:if test="${not empty msg}">
								<div class="col-xs-12 text-center">
									<div class="validationError">
										<div class="alert alert-${css}" role="alert">
											<c:out value="${msg}"></c:out>
										</div>
									</div>
								</div>
							</c:if>
							<div class="col-xs-12 ">
								<div class="field-wrap">
									<p>Bizimle iletişime geçmek için aşağıdaki formu doldurup
										göndermeniz yeterli olacaktır.</p>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6">
								<div class="field-wrap">
									<spring:bind path="name">
										<label for="name">İsminiz</label>
										<form:input path="name" id="name" type="text"
											required="required" />
										<form:errors path="name" class="control-label error" />
									</spring:bind>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6">
								<div class="field-wrap">
									<spring:bind path="email">
										<label class="tranparent" for="email">mailadresiniz@example.com</label>
										<form:input path="email" class="tranparent" id="email"
											type="email" required="required" />
										<form:errors path="email" class="control-label error" />
									</spring:bind>
								</div>
							</div>
							<div class="col-xs-12">
								<div class="field-wrap textarea-wrap">
									<spring:bind path="message">
										<label for="message">Mesajınız</label>
										<form:textarea path="message" id="message" required="required"></form:textarea>
										<form:errors path="message" class="control-label error" />
									</spring:bind>
								</div>
							</div>
							<div class="col-xs-12">
								<div class="field-wrap ">
									<spring:bind path="security">
										<label for="security">Günelik Sorusu: 7*3=? </label>
										<form:input path="security" class="tranparent" id="security"
											type="number" required="required" />
										<form:errors path="security" class="control-label error" />
									</spring:bind>
								</div>
							</div>

							<div class="col-xs-12 text-center">
								<button class="btn btn-default btn-md" type="submit">Gönder</button>
							</div>

						</form:form>
						<div class="clear"></div>
					</div>
				</div>
			</div>
		</div>
		<aside class="col-sm-4">
			<tiles:insertAttribute name="leftBar"></tiles:insertAttribute>
		</aside>
	</div>
</div>
