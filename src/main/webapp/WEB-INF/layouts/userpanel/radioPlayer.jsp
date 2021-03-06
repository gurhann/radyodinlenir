<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="jwplayer">
	<div class="container">
		<div class="radio-wrap clearfix">
			<div class="radio-logo">
				<img src="/resources/radiologos/${item.logo}" />
			</div>
			<div class="radio-controllers">
				
				<button type="button" id="play-button"
					class="play-controller loading">Yükleniyor</button>
				
				<h1 class="radio-title">${item.name}</h1>
				<div id="volume-container">
					<span class="tooltip"></span>
					<div id="slider"></div>
					<span class="volume"></span>
				</div>
			</div>		

		</div>
	</div>
</div>
<script type='text/javascript'>
	$(document).ready(function() {
	});
</script>
<script>
	$(document)
			.ready(
					function() {
						var userAgent = navigator.userAgent || navigator.vendor
								|| window.opera;
						if (!$('#ismobile').is(':visible')) {
							var Player = jwplayer('hidden-radyo-player')
									.setup(
											{
												file : '${item.streamUrl}',
												image : '/resources/radiologos/${item.logo}',
												title : '${radio.name}',
												primary : 'html5',
												width : '100%',
												height : '20',
												autostart : true,
											});
							Player
									.onPlay(function() {
										$('.play-controller').removeClass(
												'loading').text('');
										var RadioTitle = $('.radio-title')
												.text().replace("Canlı Dinle",
														"Dinliyorsunuz");
										$('.radio-title').text(RadioTitle);
									});
							Player.onPause(function() {
								var RadioTitle = $('.radio-title').text()
										.replace("Dinliyorsunuz", "Dinle");
								$('.radio-title').text(RadioTitle);
							});
							$('.play-controller').click(
									function() {
										if ($(this).hasClass('play')) {
											Player.pause(false);
											var RadioTitle = $('.radio-title')
													.text().replace("Dinle",
															"Dinliyorsunuz");
											$('.radio-title').text(RadioTitle);
											$(this).removeClass('play');
										} else {
											Player.pause(true);
											var RadioTitle = $('.radio-title')
													.text().replace(
															"Dinliyorsunuz",
															"Dinle");
											$('.radio-title').text(RadioTitle);
											$(this).addClass('play');
										}
									});

							function JWsetVolume(v) {
								Player.setVolume(v);
							}
							var slider = $('#slider'), tooltip = $('.tooltip');
							tooltip.hide();
							slider
									.slider({
										range : "min",
										min : 0,
										value : 50,
										start : function(event, ui) {
											tooltip.fadeIn('fast');
										},
										slide : function(event, ui) {
											var value = slider.slider('value'), volume = $('.volume');
											tooltip.css('left', value).text(
													ui.value);
											if (value <= 5) {
												volume.css(
														'background-position',
														'0 0');
											} else if (value <= 25) {
												volume.css(
														'background-position',
														'0 -25px');
											} else if (value <= 75) {
												volume.css(
														'background-position',
														'0 -50px');
											} else {
												volume.css(
														'background-position',
														'0 -75px');
											}
											;
											JWsetVolume(value);
										},
										stop : function(event, ui) {
											tooltip.fadeOut('fast');
										},
									});
						}
					});
</script>