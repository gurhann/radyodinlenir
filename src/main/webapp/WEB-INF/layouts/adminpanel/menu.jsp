<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<section class="menu-section">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="navbar-collapse collapse ">
					<ul id="menu-top" class="nav navbar-nav navbar-right">
						<li><a
							class="${curl == 'radiostations' ? 'menu-top-active' : '' }"
							href="/admin/radiostations/1">Radyolar</a></li>
						<li><a
							class="${curl == 'musictype' ? 'menu-top-active' : '' }"
							href="/admin/musictypelist">Müzik Tipleri</a></li>
						<li><a
							class="${curl == 'contactlist' ? 'menu-top-active' : '' }"
							href="/admin/contactlist/1">İletişim</a></li>
						<li><a class="${curl == 'configs' ? 'menu-top-active' : '' }"
							href="/admin/generalconfigs">Ayarlar</a></li>
						<li><a href="/">Anasayfa</a></li>
						<li><a href="javascript:formSubmit()">Çıkış</a></li>
					</ul>
				</div>
			</div>

		</div>
	</div>
</section>



<!-- csrt for log out-->
<form action="/logout" method="post" id="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>

<script>
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
</script>
