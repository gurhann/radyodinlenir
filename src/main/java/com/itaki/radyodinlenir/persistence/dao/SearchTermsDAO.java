package com.itaki.radyodinlenir.persistence.dao;

import java.util.List;

import com.itaki.radyodinlenir.persistence.model.SearchTerms;

public interface SearchTermsDAO extends GenericDAO<SearchTerms> {
	public List<SearchTerms> getSearchTermsForPager(int page, int itemSize);
}
