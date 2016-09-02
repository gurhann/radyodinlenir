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
@Table(name = "application_config")
@NamedQueries({ @NamedQuery(name = ApplicationConfig.GET_APPLICATION_CONFIG_BY_NAME, query = "select c from ApplicationConfig c where c.name=:name"),
		@NamedQuery(name = ApplicationConfig.GET_ALL_APPLICATON_CONFIGS, query = "select c from ApplicationConfig") })
public class ApplicationConfig {

	public final static String GET_APPLICATION_CONFIG_BY_NAME = "ApplicationConfig.getApplicationConfigByName";
	public final static String GET_ALL_APPLICATON_CONFIGS = "ApllicationConfit.getAllApplicationCOnfigs";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private byte id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	public byte getId() {
		return id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
