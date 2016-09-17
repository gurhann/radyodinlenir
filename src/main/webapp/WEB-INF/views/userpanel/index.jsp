<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="events-finder">
	<div class="container">
		<header>
			<div class="row">
				<div class="col-xs-12 col-md-8">
					<h2 class="text-uppercase">Popüler Radyolar</h2>
				</div>
				<div class="col-xs-12 col-md-4">
					<div class="event-form text-right">
						<form>
							<div class="form-input search-keyword">
								<input type="text" placeholder="Radyo Ara"> <i class="icon fa fa-search"></i>
							</div>
							<button class="btn btn-default" type="submit">Radyo Ara</button>
						</form>
					</div>
				</div>
			</div>
		</header>
		<div class="featured-events">
			<div class="row">
				<div class="col-xs-12">
					<div class="store-grid text-uppercase text-bold">
						<c:forEach var="radio" items="${popularRadios}">
							<div class="store-product">
								<figure>
									<img width="152" height="152" src="${baseURL}/resources/radiologos/${radio.logo}">
									<figcaption>
										<a href="event-single.html" class="btn btn-grey"><i class="fa fa-ticket "></i> Dinle</a>
									</figcaption>
								</figure>
								<div class="product-info">
									<h3>${radio.name}</h3>
									<span class="price-tag"><i class="fa fa-eye" aria-hidden="true"></i>156</span>
								</div>
							</div>
						</c:forEach>
					</div>
					<!--album-grid-->
					<a class="btn btn-wide btn-grey text-uppercase text-bold" href="store.html">Daha Fazlasını
						Gör</a>
				</div>
				<!--column-->
			</div>
		</div>
	</div>
</section>

<section>
	<header class="parallax parallax_two style3 text-center text-uppercase text-bold"
		data-stellar-background-ratio="0.5">
		<div class="container">
			<div class="row">
				<div class="col-xs-12 section-block">
					<h2>Son Eklenen Radyolar</h2>
					<p>
						Radyo İstasyonunuzu Bizle <a href="#">Paylaşın</a>
					</p>
				</div>
			</div>
		</div>
	</header>
	<!--section header-->

	<div class="photography">
		<div class="container color-white">
			<div class="store-grid text-uppercase text-bold clearfix">

				<c:forEach var="radio" items="${newestRadios}">
					<div class="store-product">
						<figure>
							<img width="152" height="152"
								src="${baseURL}/resources/radiologos/${radio.logo}">
							<figcaption>
								<a href="event-single.html" class="btn btn-grey"><i class="fa fa-ticket "></i> Dinle</a>
							</figcaption>
						</figure>
						<div class="product-info">
							<h3>${radio.name}</h3>
							<span class="price-tag"><i class="fa fa-eye" aria-hidden="true"></i>156</span>
						</div>
					</div>
				</c:forEach>
			</div>
			<!--album-grid-->
			<a class="btn btn-wide btn-grey text-uppercase text-bold" href="store.html">Daha Fazlasını
				Gör</a>

		</div>
		<!--container-->
	</div>
	<!--movies-->


</section>