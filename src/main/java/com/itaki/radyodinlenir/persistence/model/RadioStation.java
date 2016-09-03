package com.itaki.radyodinlenir.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "radio_station")
@NamedQueries({ @NamedQuery(name = RadioStation.RADIO_STATION_FIND_BY_NAME, query = "select r from RadioStation r where r.name=:name"),
		@NamedQuery(name = RadioStation.RADIO_STATION_BY_CLEAN_URL, query = "select r from RadioStation r where r.cleanUrl=:cleanUrl"),
		@NamedQuery(name = RadioStation.GET_ALL_RADIO_STATIONS, query = "select r from RadioStation r order by r.hitCount"),
		@NamedQuery(name = RadioStation.GET_RADIO_STATIONS_BY_MUSIC_TYPE, query = "select r from RadioStation r where r.musicType.id=:musicType order by r.hitCount"),
		@NamedQuery(name = RadioStation.GET_RADIO_STATIONS_BY_MUSIC_TYPE_COUNT, query = "select count(r.id) from RadioStation r where r.musicType.id=:musicType"),
		@NamedQuery(name = RadioStation.SEARCH_RADIO_STATION_BY_NAME_AND_DESCRIPTION, query = "select r from RadioStation r where r.name like :name or r.description like :description order by r.hitCount")})
public class RadioStation {

	public static final String RADIO_STATION_FIND_BY_NAME = "RadioStation.findByName";
	public static final String RADIO_STATION_BY_CLEAN_URL = "RadioStation.findByCleanUrl";
	public static final String GET_ALL_RADIO_STATIONS = "RadioStation.getAllStations";
	public static final String GET_RADIO_STATIONS_BY_MUSIC_TYPE = "RadioStation.getStationsByMusicType";
	public static final String GET_RADIO_STATIONS_BY_MUSIC_TYPE_COUNT = "RadioStation.getStationByMusicTypeCount";
	public static final String SEARCH_RADIO_STATION_BY_NAME_AND_DESCRIPTION = "RadioStation.searchStationByNameAndDescription";

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
	private String streamUrl;

	@Column(name = "embedded_url")
	private String embeddedUrl;

	@Column(name = "hit_count")
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
		RadioStation other = (RadioStation) obj;
		return new EqualsBuilder().append(id, other.getId()).append(name, other.getName()).append(description, other.getDescription()).append(cleanUrl, other.getCleanUrl())
				.append(streamUrl, other.getStreamUrl()).append(embeddedUrl, other.getEmbeddedUrl()).append(hitCount, other.getHitCount()).append(priority, other.getPriority())
				.append(seoKeywords, other.getSeoKeywords()).append(seoDescription, other.getSeoDescription()).append(musicType, other.getMusicType()).append(radioCity, other.getRadioCity())
				.append(isEnabled, other.isEnabled).append(priority, other.getPriority()).isEquals();
	}

}
