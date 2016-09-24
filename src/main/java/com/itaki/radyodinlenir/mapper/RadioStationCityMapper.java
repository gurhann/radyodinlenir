package com.itaki.radyodinlenir.mapper;

import java.util.ArrayList;
import java.util.List;

import com.itaki.radyodinlenir.persistence.model.RadioStationCity;
import com.itaki.radyodinlenir.web.dto.RadioStationCityDTO;

public class RadioStationCityMapper {

	private RadioStationCityMapper() {

	}

	public static RadioStationCityDTO modelToDto(RadioStationCity model) {
		if (model == null) {
			return null;
		}
		RadioStationCityDTO dto = new RadioStationCityDTO();
		dto.setId(model.getId());
		dto.setName(model.getName());
		dto.setCleanUrl(model.getCleanUrl());
		dto.setSeoDescription(model.getSeoDescription());
		dto.setSeoKeywords(model.getSeoKeywords());
		return dto;
	}

	public static RadioStationCity dtoToModel(RadioStationCityDTO dto) {
		if (dto == null) {
			return null;
		}
		RadioStationCity model = new RadioStationCity();
		model.setId(dto.getId());
		model.setName(dto.getName());
		model.setCleanUrl(dto.getCleanUrl());
		model.setSeoDescription(dto.getSeoDescription());
		model.setSeoKeywords(dto.getSeoKeywords());
		return model;
	}

	public static List<RadioStationCityDTO> modelToDtoList(List<RadioStationCity> modelList) {
		if (modelList == null) {
			return null;
		}

		List<RadioStationCityDTO> dtoList = new ArrayList<RadioStationCityDTO>();
		for (RadioStationCity model : modelList) {
			dtoList.add(modelToDto(model));
		}
		return dtoList;
	}

	public static List<RadioStationCity> dtoToModelList(List<RadioStationCityDTO> dtoList) {
		if (dtoList == null) {
			return null;
		}
		List<RadioStationCity> modelList = new ArrayList<RadioStationCity>();
		for (RadioStationCityDTO dto : dtoList) {
			modelList.add(dtoToModel(dto));
		}
		return modelList;
	}
}
