package com.itaki.radyodinlenir.persistence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "contact_request")
@NamedQueries({ @NamedQuery(name = ContactRequest.ALL_CONTACT_REQUESTS, query = "select c from ContactRequest c")})
public class ContactRequest {

	public static final String ALL_CONTACT_REQUESTS = "ContactRequest.allRequests";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "message")
	private String message;

	@Column(name = "email")
	private String email;

	@Column(name = "was_answered")
	private boolean wasAnswered;

	@Temporal(TemporalType.TIMESTAMP)
	private Date sendDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
		return new HashCodeBuilder(5, 7).append(id).append(name).append(message).append(email).append(wasAnswered).append(sendDate).toHashCode();
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
		ContactRequest other = (ContactRequest) obj;
		return new EqualsBuilder().append(id, other.getId()).append(name, other.getName()).append(message, other.getMessage()).append(wasAnswered, other.isWasAnswered())
				.append(sendDate, other.getSendDate()).isEquals();
	}

}
