package com.itaki.radyodinlenir.web.dto;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return new HashCodeBuilder(5, 7).append(id).append(subject).append(message).append(email).append(wasAnswered).append(sendDate).toHashCode();
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
		ContactRequestDTO other = (ContactRequestDTO) obj;
		return new EqualsBuilder().append(id, other.getId()).append(subject, other.getSubject()).append(message, other.getMessage())
				.append(wasAnswered, other.isWasAnswered()).append(sendDate, other.getSendDate()).isEquals();
	}

}
