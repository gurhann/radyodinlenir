package com.itaki.radyodinlenir.persistence.dao;

import java.util.List;

import com.itaki.radyodinlenir.persistence.model.ContactRequest;

public interface ContactRequestDAO extends GenericDAO<ContactRequest> {

	public List<ContactRequest> getContactRequestForPager(int page, int itemSize);

	public int getContactRequestCount();

}
