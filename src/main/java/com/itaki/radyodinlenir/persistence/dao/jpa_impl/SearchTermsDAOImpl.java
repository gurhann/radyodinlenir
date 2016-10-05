package com.itaki.radyodinlenir.persistence.dao.jpa_impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.itaki.radyodinlenir.persistence.dao.SearchTermsDAO;
import com.itaki.radyodinlenir.persistence.model.SearchTerms;
import com.itaki.radyodinlenir.util.QueryUtil;

@Repository
public class SearchTermsDAOImpl extends GenericDAOImpl<SearchTerms> implements SearchTermsDAO {
	
	public SearchTermsDAOImpl() {
		setClazz(SearchTerms.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SearchTerms> getSearchTermsForPager(int page, int itemSize) {
		Query query = QueryUtil.getPageFromQuery(em.createNamedQuery(SearchTerms.GET_ALL_SEARCH_TERMS), page, itemSize);
		return (List<SearchTerms>) query.getResultList();
	}

}
