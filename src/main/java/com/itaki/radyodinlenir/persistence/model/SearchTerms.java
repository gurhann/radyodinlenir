package com.itaki.radyodinlenir.persistence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "search_terms")
@NamedQuery(name = SearchTerms.GET_ALL_SEARCH_TERMS, query = "select r from SearchTerms r order by r.sendDate desc")
public class SearchTerms {
	public static final String GET_ALL_SEARCH_TERMS = "SearchTerms.getAllSearchTerms";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "term")
	private String term;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "send_date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date sendDate;
	
	
	public SearchTerms() {
		// TODO Auto-generated constructor stub
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
