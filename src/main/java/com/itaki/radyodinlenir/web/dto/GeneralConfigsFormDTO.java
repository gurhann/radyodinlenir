package com.itaki.radyodinlenir.web.dto;

public class ApplicationGeneralConfigsDTO {

	private String title;
	private String description;
	private String keywords;
	private String copyright;

	public ApplicationGeneralConfigsDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getCopyright() {
		return copyright;
	}

	public String getDescription() {
		return description;
	}

	public String getKeywords() {
		return keywords;
	}

	public String getTitle() {
		return title;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
