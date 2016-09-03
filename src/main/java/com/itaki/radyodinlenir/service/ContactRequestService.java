package com.itaki.radyodinlenir.service;

import java.util.List;

import com.itaki.radyodinlenir.exception.ContactRequestNotFound;
import com.itaki.radyodinlenir.web.dto.ContactRequestDTO;

public interface ContactRequestService {

    public void addContactRequest(ContactRequestDTO contactRequest);
	
	public void updateContactRequest(ContactRequestDTO contactRequest) throws ContactRequestNotFound;
	
	public void  deleteContactRequest(Long id) throws ContactRequestNotFound;
	
	public ContactRequestDTO getContactRequestWithId(Long id) throws ContactRequestNotFound;
	
	public List<ContactRequestDTO> getContactRequestForPager(int page, int itemSize);
		
	public int getContactRequestCount();
	
}
