package com.itaki.radyodinlenir.service;

import java.util.List;

import com.itaki.radyodinlenir.persistence.model.ContactRequest;

public interface ContactRequestService {

    public ContactRequest addContactRequest(ContactRequest radioStation);
	
	public void updateContactRequest(ContactRequest radioStation);
	
	public void  deleteContactRequest(int id);
	
	public ContactRequest getContactRequestWithId(int id);
	
	public List<ContactRequest> getContactRequestForPager(int page, int itemSize);
		
	public int getContactRequestCount();
	
}