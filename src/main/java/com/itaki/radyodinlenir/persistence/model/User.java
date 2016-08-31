package com.itaki.radyodinlenir.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@NamedQueries({ @NamedQuery(name = User.FIND_BY_USER_NAME, query = "select u from User u where u.userName=:userName") })
public class User {

	public final static String FIND_BY_USER_NAME = "findByuserName";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "first_name")
	private String firtName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "userName")
	private String userName;
	@Column(name = "password", length = 60)
	private String password;
	@Column(name = "enabled")
	private Boolean enabled;

	public User() {
		super();
		this.enabled = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirtName() {
		return firtName;
	}

	public void setFirtName(String firtName) {
		this.firtName = firtName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final User user = (User) obj;
		if (!userName.equals(user.userName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "User [firtName=" + firtName + ", lastName=" + lastName + ", userName=" + userName + "]";
	}

}
