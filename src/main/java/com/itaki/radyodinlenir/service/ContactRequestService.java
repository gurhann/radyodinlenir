package com.itaki.radyodinlenir.service;

import java.util.List;

import com.itaki.radyodinlenir.persistence.model.ContactRequest;

public interface ContactRequestService {

    public void addContactRequest(ContactRequest contactRequest);
	
	public void updateContactRequest(ContactRequest contactRequest);
	
	public void  deleteContactRequest(int id);
	
	public ContactRequest getContactRequestWithId(int id);
	
	public List<ContactRequest> getContactRequestForPager(int page, int itemSize);
		
	public int getContactRequestCount();
	
}
