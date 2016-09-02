package com.itaki.radyodinlenir.mapper;

import java.util.ArrayList;
import java.util.List;

import com.itaki.radyodinlenir.persistence.model.RadioStation;
import com.itaki.radyodinlenir.web.dto.RadioStationDTO;

public class RadioStationMapper {
	private RadioStationMapper() {

	}

	public static RadioStationDTO modelToDto(RadioStation model) {
		if (model == null) {
			return null;
		}
		RadioStationDTO dto = new RadioStationDTO();
		dto.setId(model.getId());
		dto.setName(model.getName());
		dto.setDescription(model.getDescription());
		dto.setLogo(model.getLogo());
		dto.setCleanUrl(model.getCleanUrl());
		dto.setStreamUrl(model.getStreamUrl());
		dto.setEmbeddedUrl(model.getEmbeddedUrl());
		dto.setHitCount(model.getHitCount());
		dto.setPriority(model.getPriority());
		dto.setSeoKeywords(model.getSeoKeywords());
		dto.setSeoDescription(model.getSeoDescription());
		return dto;
	}

	public static RadioStation dtoToModel(RadioStationDTO dto) {
		if (dto == null) {
			return null;
		}
		RadioStation model = new RadioStation();
		model.setId(dto.getId());
		model.setName(dto.getName());
		model.setDescription(dto.getDescription());
		model.setLogo(dto.getLogo());
		model.setCleanUrl(dto.getCleanUrl());
		model.setStreamUrl(dto.getStreamUrl());
		model.setEmbeddedUrl(dto.getEmbeddedUrl());
		model.setHitCount(dto.getHitCount());
		model.setPriority(dto.getPriority());
		model.setSeoKeywords(dto.getSeoKeywords());
		model.setSeoDescription(dto.getSeoDescription());
		return model;
	}

	public static List<RadioStationDTO> modelToDtoList(List<RadioStation> modelList) {
		if (modelList == null) {
			return null;
		}
		List<RadioStationDTO> dtoList = new ArrayList<RadioStationDTO>();
		for (RadioStation model : modelList) {
			dtoList.add(modelToDto(model));
		}
		return dtoList;
	}

	public static List<RadioStation> dtoToModelList(List<RadioStationDTO> dtoList) {
		if (dtoList == null) {
			return null;
		}
		List<RadioStation> modelList = new ArrayList<RadioStation>();
		for (RadioStationDTO dto : dtoList) {
			modelList.add(dtoToModel(dto));
		}
		return modelList;
	}
}
