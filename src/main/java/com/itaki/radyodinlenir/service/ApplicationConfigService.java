package com.itaki.radyodinlenir.service;

import java.util.List;

import com.itaki.radyodinlenir.exception.ApplicationConfigIsExistException;
import com.itaki.radyodinlenir.exception.ApplicationConfigNotFoundException;
import com.itaki.radyodinlenir.web.dto.ApplicationConfigDTO;

public interface ApplicationConfigService {

	public ApplicationConfigDTO addApplicationConfig(ApplicationConfigDTO applicationConfig) throws ApplicationConfigIsExistException;

	public ApplicationConfigDTO updateApplicationConfig(ApplicationConfigDTO applicationConfig) throws ApplicationConfigNotFoundException;

	public ApplicationConfigDTO getApplicationConfigByName(String name) throws ApplicationConfigNotFoundException;

	public List<ApplicationConfigDTO> getAllApplicationConfigs();

	public List<ApplicationConfigDTO> getApplicationConfigListByPage(int pageNumber, int pageSize);

	public ApplicationConfigDTO getApplicationConfigById(byte id) throws ApplicationConfigNotFoundException;

}
