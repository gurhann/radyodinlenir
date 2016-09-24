package com.itaki.radyodinlenir.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "music_category")
@NamedQueries({ @NamedQuery(name = MusicType.GET_ALL_MUSIC_TYPES, query = "select m from MusicType m order by priority"),
		@NamedQuery(name = MusicType.FIND_MUSIC_TYPE_BY_CLEANURL, query = "select m from MusicType m where m.cleanUrl=:cleanUrl"),
		@NamedQuery(name = MusicType.FIND_MUSIC_TYPE_BY_NAME, query = "select m from MusicType m where m.name=:name") })
public class MusicType extends BaseCategory {

	public static final String GET_ALL_MUSIC_TYPES = "MusicType.getAllMusicTypes";
	public static final String FIND_MUSIC_TYPE_BY_CLEANURL = "MusicType.findByCleanUrl";
	public static final String FIND_MUSIC_TYPE_BY_NAME = "MusicType.findByName";

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
		return new HashCodeBuilder(7, 9).append(id).append(name).append(priority).toHashCode();
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
		MusicType other = (MusicType) obj;
		return new EqualsBuilder().append(id, other.getId()).append(name, other.getName()).append(priority, other.getPriority()).isEquals();
	}
}
