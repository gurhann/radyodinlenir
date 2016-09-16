<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<section id="audio-player" class="the-xv-Jplayer">
	<div id="player-instance" class="jp-jplayer"></div>
	<div class="controls jp-controls-holder">
		<button class="playList-trigger pc-playlist2"></button>
		<div class="jp-prev pc-back"></div>
		<div class="play-pause jp-play pc-play"></div>
		<div class="play-pause jp-pause fa pc-pause" style="display: none"></div>
		<div class="jp-next pc-next"></div>
	</div>
	<div class="jp-volume-controls">
		<button class="sound-trigger pc-volume"></button>
		<div class="jp-volume-bar" style="display: none;">
			<div class="jp-volume-bar-value" style="width: 1.4737%;"></div>
		</div>
	</div>
	<h5 class="audio-title">&ensp;</h5>
	<div class="player-status">
		<div class="audio-progress">
			<div class="jp-seek-bar">
				<div class="audio-play-bar jp-play-bar" style="width: 20%;"></div>
			</div>
			<!--jp-seek-bar-->
		</div>
		<!--audio-progress-->
	</div>
	<!--player-status-->

	<!--Add Songs In mp3 formate here-->
	<ul class="hidden playlist-files">
		<li data-title="Ukulele Story" data-artist="Audio Jungle"
			data-mp3="https://0.s3.envato.com/files/152256065/preview.mp3"></li>
		<li data-title="Bright and Inspiring" data-artist="Audio Jungle"
			data-mp3="https://0.s3.envato.com/files/152351972/preview.mp3"></li>
		<li data-title="Indie Rock" data-artist="Audio Jungle"
			data-mp3="https://0.s3.envato.com/files/162668841/preview.mp3"></li>
		<li data-title="Up in the Sky" data-artist="Audio Jungle"
			data-mp3="https://0.s3.envato.com/files/69092344/preview.mp3"></li>
		<li data-title="Inspiring" data-artist="Audio Jungle"
			data-mp3="https://0.s3.envato.com/files/167149310/preview.mp3"></li>
		<li data-title="Inspiring Thoughts" data-artist="Audio Jungle"
			data-mp3="https://0.s3.envato.com/files/156059055/preview.mp3"></li>

		<li data-title="Gypsy Jazz From France" data-artist="Audio Jungle"
			data-mp3="https://0.s3.envato.com/files/152733871/preview.mp3"></li>
		<li data-title="Happy" data-artist="Audio Jungle"
			data-mp3="https://0.s3.envato.com/files/166500700/preview.mp3"></li>
		<li data-title="The Water Clock" data-artist="Audio Jungle"
			data-mp3="https://0.s3.envato.com/files/151397943/preview.mp3"></li>

	</ul>
	<!--Playlist ends-->

	<div class="jp-playlist">
		<ul>
			<li></li>
		</ul>
	</div>

</section>
