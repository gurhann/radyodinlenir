package com.itaki.radyodinlenir.mapper;

import java.util.ArrayList;
import java.util.List;

import com.itaki.radyodinlenir.persistence.model.SearchTerms;
import com.itaki.radyodinlenir.web.dto.SearchTermsDTO;

public class SearchTermsMapper {

	public SearchTermsMapper() {
		// TODO Auto-generated constructor stub
	}

	public static SearchTermsDTO modelToDto(SearchTerms model) {
		if (model == null) {
			return null;
		}
		SearchTermsDTO dto = new SearchTermsDTO();
		dto.setId(model.getId());
		dto.setSendDate(model.getSendDate());
		dto.setTerm(model.getTerm());
		return dto;

	}
	
	public static SearchTerms dtoToModel(SearchTermsDTO dto) {
		if (dto == null) {
			return null;
		}
		SearchTerms model = new SearchTerms();
		model.setId(dto.getId());
		model.setSendDate(dto.getSendDate());
		model.setTerm(dto.getTerm());
		return model;
	}
	public static List<SearchTermsDTO> modelToDtoList(List<SearchTerms> modelList) {
		if (modelList == null) {
			return null;
		}

		List<SearchTermsDTO> dtoList = new ArrayList<SearchTermsDTO>();
		for (SearchTerms model : modelList) {
			dtoList.add(modelToDto(model));
		}
		return dtoList;
	}

	public static List<SearchTerms> dtoToModelList(List<SearchTermsDTO> dtoList) {
		if (dtoList == null) {
			return null;
		}
		List<SearchTerms> modelList = new ArrayList<SearchTerms>();
		for (SearchTermsDTO dto : dtoList) {
			modelList.add(dtoToModel(dto));
		}
		return modelList;
	}
}
