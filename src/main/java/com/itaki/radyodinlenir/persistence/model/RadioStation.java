package com.itaki.radyodinlenir.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "radio_station")
public class RadioStation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "logo")
	private String logo;

	@Column(name = "clean_url")
	private String cleanUrl;

	@Column(name = "stream_url")
	private String stream_url;

	@Column(name = "embeded_url")
	private String emveded_url;

	@Column(name = "hit_coun")
	private int hitCount;

	@Column(name = "priority")
	private int priority;

	@Column(name = "seo_keywords")
	private String seoKeywords;

	@Column(name = "seo_description", length = 2000)
	private String seoDescription;

	@OneToOne
	@JoinColumn(name = "music_type_id")
	private MusicType musicType;

	@OneToOne
	@JoinColumn(name = "radi_city_id")
	private RadioStationCity radioCity;

	@Column(name = "is_enabled")
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

	public void setDescription(String desc) {
		this.description = desc;
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

	public String getStream_url() {
		return stream_url;
	}

	public void setStream_url(String stream_url) {
		this.stream_url = stream_url;
	}

	public String getEmveded_url() {
		return emveded_url;
	}

	public void setEmveded_url(String emveded_url) {
		this.emveded_url = emveded_url;
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

	public MusicType getMusicType() {
		return musicType;
	}

	public void setMusicType(MusicType musicType) {
		this.musicType = musicType;
	}

	public RadioStationCity getRadioCity() {
		return radioCity;
	}

	public void setRadioCity(RadioStationCity radioCity) {
		this.radioCity = radioCity;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
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

}
