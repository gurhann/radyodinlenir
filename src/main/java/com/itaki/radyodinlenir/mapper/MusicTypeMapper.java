package com.itaki.radyodinlenir.mapper;

import java.util.ArrayList;
import java.util.List;

import com.itaki.radyodinlenir.persistence.model.MusicType;
import com.itaki.radyodinlenir.web.dto.MusicTypeDTO;

public class MusicTypeMapper {

	private MusicTypeMapper() {

	}

	public static MusicTypeDTO modelToDto(MusicType model) {
		if (model == null) {
			return null;
		}
		MusicTypeDTO dto = new MusicTypeDTO();
		dto.setId(model.getId());
		dto.setName(model.getName());
		dto.setPriority(model.getPriority());
		return dto;
	}

	public static MusicType dtoToModel(MusicTypeDTO dto) {
		if (dto == null) {
			return null;
		}
		MusicType model = new MusicType();
		model.setId(dto.getId());
		model.setName(dto.getName());
		model.setPriority(dto.getPriority());
		return model;
	}

	public static List<MusicTypeDTO> modelToDtoList(List<MusicType> modelList) {
		if (modelList == null) {
			return null;
		}

		List<MusicTypeDTO> dtoList = new ArrayList<MusicTypeDTO>();
		for (MusicType model : modelList) {
			dtoList.add(modelToDto(model));
		}
		return dtoList;
	}

	public static List<MusicType> dtoToModelList(List<MusicTypeDTO> dtoList) {
		if (dtoList == null) {
			return null;
		}
		List<MusicType> modelList = new ArrayList<MusicType>();
		for (MusicTypeDTO dto : dtoList) {
			modelList.add(dtoToModel(dto));
		}
		return modelList;
	}
}
