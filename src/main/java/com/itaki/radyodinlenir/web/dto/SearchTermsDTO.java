package com.itaki.radyodinlenir.web.dto;

import java.io.Serializable;
import java.util.Date;

public class SearchTermsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String term;
	private Date sendDate;

	public SearchTermsDTO() {
		// TODO Auto-generated constructor stub
	}
	public SearchTermsDTO(String term) {
		this.setTerm(term);
	}
	public int getId() {
		return id;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public String getTerm() {
		return term;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public void setTerm(String term) {
		this.term = term;
	}
}
