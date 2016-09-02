package com.itaki.radyodinlenir.util;

import javax.persistence.Query;

public class QueryUtil {
	public static Query getPageFromQuery(Query query, int pageNumber) {
		return query.setFirstResult(5 * (pageNumber - 1)).setMaxResults(pageNumber * 5);
	}

	public static Query getPageFromQuery(Query query, int pageNumber, int pageSize) {
		return query.setFirstResult(pageSize * (pageNumber - 1)).setMaxResults(pageNumber * pageSize);

	}
}
