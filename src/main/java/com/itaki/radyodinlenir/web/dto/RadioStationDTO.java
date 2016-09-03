package com.itaki.radyodinlenir.web.dto;

import com.itaki.radyodinlenir.persistence.model.MusicType;
import com.itaki.radyodinlenir.persistence.model.RadioStationCity;

public class RadioStationDTO {

	private int id;
	private String name;
	private String description;
	private String logo;
	private String cleanUrl;
	private String streamUrl;
	private String embeddedUrl;
	private int hitCount;
	private int priority;
	private String seoKeywords;
	private String seoDescription;
	private MusicTypeDTO musicType;
	private RadioStationCityDTO radioCity;
	private boolean isEnabled;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getCleanUrl() {
		return cleanUrl;
	}

	public void setCleanUrl(String cleanUrl) {
		this.cleanUrl = cleanUrl;
	}

	public String getStreamUrl() {
		return streamUrl;
	}

	public void setStreamUrl(String streamUrl) {
		this.streamUrl = streamUrl;
	}

	public String getEmbeddedUrl() {
		return embeddedUrl;
	}

	public void setEmbeddedUrl(String embeddedUrl) {
		this.embeddedUrl = embeddedUrl;
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getSeoKeywords() {
		return seoKeywords;
	}

	public void setSeoKeywords(String seoKeywords) {
		this.seoKeywords = seoKeywords;
	}

	public String getSeoDescription() {
		return seoDescription;
	}

	public void setSeoDescription(String seoDescription) {
		this.seoDescription = seoDescription;
	}

	public MusicTypeDTO getMusicType() {
		return musicType;
	}

	public void setMusicType(MusicTypeDTO musicType) {
		this.musicType = musicType;
	}

	public RadioStationCityDTO getRadioCity() {
		return radioCity;
	}

	public void setRadioCity(RadioStationCityDTO radioCity) {
		this.radioCity = radioCity;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	

}
