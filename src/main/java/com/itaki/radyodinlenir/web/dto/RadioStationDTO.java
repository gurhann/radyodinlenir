package com.itaki.radyodinlenir.web.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.web.multipart.MultipartFile;

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
	private MultipartFile logoFile;
	private MusicTypeDTO musicType;
	private RadioStationCityDTO radioCity;
	private boolean enabled;

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
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public MultipartFile getLogoFile() {
		return logoFile;
	}
	
	public void setLogoFile(MultipartFile logoFile) {
		this.logoFile = logoFile;
	}
	

	@Override
	public int hashCode() {
		return new HashCodeBuilder(11, 13).append(id).append(name).append(description).append(cleanUrl).append(streamUrl).append(embeddedUrl).append(hitCount).append(priority).append(seoKeywords)
				.append(seoDescription).append(musicType).append(radioCity).append(isEnabled()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		RadioStationDTO other = (RadioStationDTO) obj;
		return new EqualsBuilder().append(id, other.getId()).append(name, other.getName()).append(description, other.getDescription())
				.append(cleanUrl, other.getCleanUrl()).append(streamUrl, other.getStreamUrl()).append(embeddedUrl, other.getEmbeddedUrl()).append(hitCount, other.getHitCount())
				.append(priority, other.getPriority()).append(seoKeywords, other.getSeoKeywords()).append(seoDescription, other.getSeoDescription()).append(musicType, other.getMusicType())
				.append(radioCity, other.getRadioCity()).append(enabled, other.enabled).append(priority, other.getPriority()).isEquals();
	}

}
