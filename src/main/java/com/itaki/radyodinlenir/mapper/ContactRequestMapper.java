package com.itaki.radyodinlenir.mapper;

import java.util.ArrayList;
import java.util.List;

import com.itaki.radyodinlenir.persistence.model.ContactRequest;
import com.itaki.radyodinlenir.web.dto.ContactRequestDTO;

public class ContactRequestMapper {

	private ContactRequestMapper() {

	}

	public static ContactRequestDTO modelToDto(ContactRequest model) {
		if (model == null) {
			return null;
		}
		ContactRequestDTO dto = new ContactRequestDTO();
		dto.setId(model.getId());
		dto.setSubject(model.getSubject());
		dto.setMessage(model.getMessage());
		dto.setEmail(model.getEmail());
		dto.setWasAnswered(model.isWasAnswered());
		dto.setSendDate(model.getSendDate());
		return dto;
	}

	public static ContactRequest dtoToModel(ContactRequestDTO dto) {
		if (dto == null) {
			return null;
		}
		ContactRequest model = new ContactRequest();
		model.setId(dto.getId());
		model.setSubject(dto.getSubject());
		model.setMessage(dto.getMessage());
		model.setEmail(dto.getEmail());
		model.setWasAnswered(dto.isWasAnswered());
		model.setSendDate(dto.getSendDate());
		return model;
	}

	public static List<ContactRequestDTO> modelToDtoList(List<ContactRequest> modelList) {
		if (modelList == null) {
			return null;
		}
		List<ContactRequestDTO> dtoList = new ArrayList<ContactRequestDTO>();
		for (ContactRequest model : modelList) {
			dtoList.add(modelToDto(model));
		}
		return dtoList;
	}

	public static List<ContactRequest> dtoToModelList(List<ContactRequestDTO> dtoList) {
		if (dtoList == null) {
			return null;
		}
		List<ContactRequest> modelList = new ArrayList<ContactRequest>();
		for (ContactRequestDTO dto : dtoList) {
			modelList.add(dtoToModel(dto));
		}
		return modelList;
	}
}
