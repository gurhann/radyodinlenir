package com.itaki.radyodinlenir.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact_request")
public class ContactRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "subject")
	private String subject;

	@Column(name = "message")
	private String message;

	@Column(name = "email")
	private String email;

	@Column(name = "was_answered")
	private boolean wasAnswered;

	public Long getId() {
		return id;
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

}
