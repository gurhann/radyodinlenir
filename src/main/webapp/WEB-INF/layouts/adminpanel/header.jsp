<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>

<tilesx:useAttribute name="curl"/>
	
<header>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<strong>Gürhan KÜÇÜK - Dursun ÇİMEN </strong>
			</div>

		</div>
	</div>
</header>
<!-- HEADER END-->
<div class="navbar navbar-inverse set-radius-zero">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/admin" style="height: 120px;"> Logo Gelecek
			</a>
		</div>
	</div>
</div>
<!-- LOGO HEADER END-->
<section class="menu-section">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="navbar-collapse collapse ">
					<ul id="menu-top" class="nav navbar-nav navbar-right">
					            <li><a class="${curl == 'dashboard' ? 'menu-top-active' : '' }" href="/admin">Admin Anasayfa</a></li> 
           						<li><a class="${curl == 'dosyalar' ? 'menu-top-active' : '' }" href="/admin/dosyalar/1">Radyolar</a></li> 
            					<li><a class="${curl == 'musictype' ? 'menu-top-active' : '' }" href="/admin/musictypelist">Müzik Tipleri</a></li> 
            					<li><a class="${curl == 'contact' ? 'menu-top-active' : '' }" href="/admin/iletisim">İletişim</a></li> 
            					<li><a class="${curl == 'contactlist' ? 'menu-top-active' : '' }" href="/admin/contactlist">İletişim</a></li> 
            					<li><a class="${curl == 'configs' ? 'menu-top-active' : '' }" href="/admin/generalconfigs">Ayarlar</a></li> 
            					<li><a href="/">Anasayfa</a></li> 
            					<li><a class="${curl == 'cikis' ? 'menu-top-active' : '' }" href="/admin/cikis">Çıkış</a></li> 
					</ul>
				</div>
			</div>

		</div>
	</div>
</section>