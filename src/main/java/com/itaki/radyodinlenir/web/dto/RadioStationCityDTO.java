package com.itaki.radyodinlenir.web.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class RadioStationCityDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String cleanUrl;
	private String seoKeywords;
	private String seoDescription;

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

	public String getCleanUrl() {
		return cleanUrl;
	}

	public void setCleanUrl(String cleanUrl) {
		this.cleanUrl = cleanUrl;
	}
	
	public String getSeoDescription() {
		return seoDescription;
	}
	public void setSeoDescription(String seoDescription) {
		this.seoDescription = seoDescription;
	}
	
	public void setSeoKeywords(String seoKeywords) {
		this.seoKeywords = seoKeywords;
	}
	public String getSeoKeywords() {
		return seoKeywords;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(9, 11).append(id).append(name).toHashCode();
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
		RadioStationCityDTO other = (RadioStationCityDTO) obj;
		return new EqualsBuilder().append(id, other.getId()).append(name, other.getName()).isEquals();
	}
}
