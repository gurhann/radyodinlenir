package com.itaki.radyodinlenir.web.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ApplicationConfigDTO {

	private byte id;
	private String name;
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

	@Override
	public int hashCode() {
		return new HashCodeBuilder(3, 5).append(id).append(name).append(description).toHashCode();
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
		ApplicationConfigDTO other = (ApplicationConfigDTO) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(id, other.getId()).append(name, other.getName()).append(description, other.getDescription()).isEquals();
	}

}
