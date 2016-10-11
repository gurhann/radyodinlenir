<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.itaki.radyodinlenir.util.PageUtils"%>


<div class="container">
	<div class="row">
		<div class="col-sm-8 ">
		<div class="breadcrumb">
				<a href="/" class="first">Anasayfa </a> » <a href="/about"
					class="last"> Hakkımızda </a>
			</div>
			<div class="ads"><c:out escapeXml="false" value=""></c:out></div>
			<div class="radio-info">
				<div class="tabs">
					<div class="tab-heading">Hakkımızda</div>
					<div class="tab-content">
						<c:out value="${about.description}" escapeXml="false"></c:out>
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