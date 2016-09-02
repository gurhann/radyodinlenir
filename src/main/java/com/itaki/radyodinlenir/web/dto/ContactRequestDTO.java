package com.itaki.radyodinlenir.web.dto;

import java.util.Date;

public class ContactRequestDTO {

	private Long id;
	private String subject;
	private String message;
	private String email;
	private boolean wasAnswered;
	private Date sendDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isWasAnswered() {
		return wasAnswered;
	}

	public void setWasAnswered(boolean wasAnswered) {
		this.wasAnswered = wasAnswered;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

}
