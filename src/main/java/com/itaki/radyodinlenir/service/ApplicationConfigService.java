package com.itaki.radyodinlenir.service;

import java.util.List;

import com.itaki.radyodinlenir.exception.ApplicationConfigNotFoundException;
import com.itaki.radyodinlenir.web.dto.ApplicationConfigDTO;

public interface ApplicationConfigService {

	public void updateApplicationConfig(ApplicationConfigDTO applicationConfig) throws ApplicationConfigNotFoundException;

	public List<ApplicationConfigDTO> getAllApplicationConfigs();

	public List<ApplicationConfigDTO> getApplicationConfigListBySize(int firstIndex, int itemSize);

	public ApplicationConfigDTO getApplicationConfigById(int id) throws ApplicationConfigNotFoundException;

}
