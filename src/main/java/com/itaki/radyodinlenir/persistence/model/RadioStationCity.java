package com.itaki.radyodinlenir.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "radio_station_city")
public class RadioStationCity extends BaseCategory {

	@Column(name = "clean_url")
	private String cleanUrl;

	@Column(name = "seo_keywords")
	private String seoKeywords;

	@Column(name = "seo_description", length = 500)
	private String seoDescription;

	public String getCleanUrl() {
		return cleanUrl;
	}

	public void setCleanUrl(String cleanUrl) {
		this.cleanUrl = cleanUrl;
	}

	public String getSeoDescription() {
		return seoDescription;
	}

	public String getSeoKeywords() {
		return seoKeywords;
	}

	public void setSeoDescription(String seoDescription) {
		this.seoDescription = seoDescription;
	}

	public void setSeoKeywords(String seoKeywords) {
		this.seoKeywords = seoKeywords;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(9, 11).append(id).append(name).append(priority).toHashCode();
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
		RadioStationCity other = (RadioStationCity) obj;
		return new EqualsBuilder().append(id, other.getId()).append(name, other.getName()).append(priority, other.getPriority()).isEquals();
	}
}
