package com.itaki.radyodinlenir.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itaki.radyodinlenir.exception.SearchTermsNotFoundException;
import com.itaki.radyodinlenir.mapper.SearchTermsMapper;
import com.itaki.radyodinlenir.persistence.dao.SearchTermsDAO;
import com.itaki.radyodinlenir.persistence.model.SearchTerms;
import com.itaki.radyodinlenir.service.SearchTermsService;
import com.itaki.radyodinlenir.web.dto.SearchTermsDTO;

@Service
public class SearchTermsServiceImpl implements SearchTermsService {
	@Autowired
	SearchTermsDAO searchTermsDAO;

	@Override
	public void deleteSearchTerms(int id) throws SearchTermsNotFoundException {
		SearchTerms term = searchTermsDAO.findOne(id);
		if (term == null) {
			throw new SearchTermsNotFoundException(id);
		}
		searchTermsDAO.delete(term);

	}

	@Override
	public List<SearchTermsDTO> getSearchTermsPager(int page, int itemSize) {
		List<SearchTerms> termList = searchTermsDAO.getSearchTermsForPager(page, itemSize);
		return SearchTermsMapper.modelToDtoList(termList);
	}

	@Override
	public int getSearchTermsCount() {
		return searchTermsDAO.getRowCount();
	}

	@Override
	public void addSearchTerm(SearchTermsDTO searchTerm) {
		searchTermsDAO.create(SearchTermsMapper.dtoToModel(searchTerm));

	}

}
