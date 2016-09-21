package com.itaki.radyodinlenir.web.dto;

import java.io.Serializable;
import java.util.List;

public class GeneralConfigsFormDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ApplicationConfigDTO> configs;
	

	public GeneralConfigsFormDTO() {
		// TODO Auto-generated constructor stub
	}

	public List<ApplicationConfigDTO> getConfigs() {
		return configs;
	}
	public void setConfigs(List<ApplicationConfigDTO> configs) {
		this.configs = configs;
	}

}
