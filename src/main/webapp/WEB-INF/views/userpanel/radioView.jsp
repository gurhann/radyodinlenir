<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.itaki.radyodinlenir.util.PageUtils"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<c:set var="currentURL"
	value="${PageUtils.getCurentFullPath(pageContext.request)}" />

<div class="col-sm-8 ">
	<div class="breadcrumb">
		<a href="/" class="first">Anasayfa </a> » <a
			href="/station/${item.cleanUrl }" class="last"> <c:out
				value="${item.name }"></c:out> Dinle
		</a>
	</div>
	<div class="radio-info">
		<div class="row ">
			<div class="col-sm-4">
				<div class="left spacing">
					<img width="270" height="270"
						src="/resources/radiologos/${item.logo}" alt="${item.name}" />
				</div>
			</div>
			<div class="col-sm-8">
				<div class="tabs">
					<div class="tab-heading">${item.name}
						<span class="right"><i class="fa fa-eye" aria-hidden="true"></i>
							${item.hitCount}</span>
					</div>
					<div class="tab-content">
						<c:out escapeXml="false" value="${item.description}"></c:out>
						<div class="clear"></div>
					</div>
				</div>
			</div>

		</div>
	</div>


	<!-- Sharing -->
	<div class="tabs">
		<div class="tab-heading">
			<i class="fa fa-share-square" aria-hidden="true"></i> Paylaş

			<sec:authorize access="hasRole('ROLE_USER')">

				<a href="/admin/radiostations/${item.id}/details" class="right"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Düzenle</a>

			</sec:authorize>
		</div>
		<div class="tab-content">

			<div class="mb_share">
				<div class="button facebook slide_x">
					<div class="icon"></div>
					<div class="slide">
						<span> facebook </span>
					</div>
					<div class="native_button">
						<div>
							<a class="fb-share"
								href="https://www.facebook.com/sharer/sharer.php?u=${currentURL }"
								target="_blank"> Paylaş </a>
						</div>
					</div>
				</div>
				<div class="button twitter slide_y">
					<div class="icon"></div>
					<div class="slide">
						<span> twitter </span>
					</div>
					<div class="native_button">
						<div>
							<a
								href="https://twitter.com/home?status=${item.name } ${currentURL }">Paylaş</a>
						</div>
					</div>
				</div>
				<div class="button gplus slide_ny">
					<div class="icon"></div>
					<div class="slide">
						<span> google </span>
					</div>
					<div class="native_button">
						<div>
							<a href="https://plus.google.com/share?url=${currentURL }">Paylaş</a>
						</div>
					</div>
				</div>
				<div class="button linkedin slide_nx">
					<div class="icon"></div>
					<div class="slide">
						<span> linkedIn </span>
					</div>
					<div class="native_button">
						<div>
							<a
								href="https://www.linkedin.com/shareArticle?mini=true&url=${currentURL }&title=${item.name }&summary=&source=">Paylaş</a>
						</div>
					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="tabs">
		<div class="tab-heading">
			<i class="fa fa-comments-o" aria-hidden="true"></i> Bizi desteklemek
			için lüften yorum yaparak katkıda bulunun.
		</div>
		<div class="tab-content">
			<div id="fb-root"></div>
			<script>
				(function(d, s, id) {
					var js, fjs = d.getElementsByTagName(s)[0];
					if (d.getElementById(id))
						return;
					js = d.createElement(s);
					js.id = id;
					js.src = "//connect.facebook.net/tr_TR/sdk.js#xfbml=1&version=v2.7&appId=1784357955172226";
					fjs.parentNode.insertBefore(js, fjs);
				}(document, 'script', 'facebook-jssdk'));
			</script>
			<div class="fb-comments" data-href="${currentURL }" data-width="770"
				data-numposts="10"></div>
		</div>
	</div>
	<div class="tabs">
		<div class="tab-heading">
			<i class="fa fa-bullhorn" aria-hidden="true"></i> Benzer Radyolar
		</div>
		<div class="tab-content">
			<div class="store-grid text-uppercase text-bold">
				<c:forEach var="similaradio" items="${similarRadios}">
					<div class="similar-product">
						<figure>
							<img width="152" height="152"
								src="/resources/radiologos/${similaradio.logo}">
							<figcaption>
								<a href="/station/${similaradio.cleanUrl}" class="btn btn-grey"><i
									class="fa fa-ticket "></i> Dinle</a>
							</figcaption>
						</figure>
						<div class="product-info">
							<h3>${similaradio.name}</h3>

						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
<aside class="col-sm-4">
	<tiles:insertAttribute name="leftBar"></tiles:insertAttribute>
</aside>
