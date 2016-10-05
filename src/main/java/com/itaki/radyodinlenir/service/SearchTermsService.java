package com.itaki.radyodinlenir.service;

import java.util.List;

import com.itaki.radyodinlenir.exception.SearchTermsNotFoundException;
import com.itaki.radyodinlenir.web.dto.SearchTermsDTO;

public interface SearchTermsService {
	
	public void deleteSearchTerms(int id) throws SearchTermsNotFoundException;
	
	public List<SearchTermsDTO> getSearchTermsPager(int page, int itemSize);
	
	public int getSearchTermsCount();
	
	public void addSearchTerm(SearchTermsDTO searchTerm) ;
}
