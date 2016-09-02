package com.itaki.radyodinlenir.mapper;

import java.util.ArrayList;
import java.util.List;

import com.itaki.radyodinlenir.persistence.model.ApplicationConfig;
import com.itaki.radyodinlenir.web.dto.ApplicationConfigDTO;

public class ApplicationConfigMapper {

	private ApplicationConfigMapper() {

	}

	public static ApplicationConfigDTO modelToDto(ApplicationConfig model) {
		if (model == null) {
			return null;
		}
		ApplicationConfigDTO dto = new ApplicationConfigDTO();
		dto.setId(model.getId());
		dto.setName(model.getName());
		dto.setDescription(model.getDescription());
		return dto;
	}

	public static ApplicationConfig dtoToModel(ApplicationConfigDTO dto) {
		if (dto == null) {
			return null;
		}
		ApplicationConfig model = new ApplicationConfig();
		model.setId(dto.getId());
		model.setName(dto.getName());
		model.setDescription(dto.getDescription());
		return model;
	}

	public List<ApplicationConfig> dtoToModelList(List<ApplicationConfigDTO> dtoList) {
		if (dtoList == null) {
			return null;
		}
		List<ApplicationConfig> modelList = new ArrayList<ApplicationConfig>();
		for (ApplicationConfigDTO dto : dtoList) {
			modelList.add(dtoToModel(dto));
		}
		return modelList;
	}

	public List<ApplicationConfigDTO> modelToDtoList(List<ApplicationConfig> modelList) {
		if (modelList == null) {
			return null;
		}
		List<ApplicationConfigDTO> dtoList = new ArrayList<ApplicationConfigDTO>();
		for (ApplicationConfig model : modelList) {
			dtoList.add(modelToDto(model));
		}
		return dtoList;
	}
}
