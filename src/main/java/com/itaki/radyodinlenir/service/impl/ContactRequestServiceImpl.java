package com.itaki.radyodinlenir.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itaki.radyodinlenir.exception.ContactRequestNotFound;
import com.itaki.radyodinlenir.mapper.ContactRequestMapper;
import com.itaki.radyodinlenir.persistence.dao.ContactRequestDAO;
import com.itaki.radyodinlenir.persistence.model.ContactRequest;
import com.itaki.radyodinlenir.service.ContactRequestService;
import com.itaki.radyodinlenir.web.dto.ContactRequestDTO;

@Service
public class ContactRequestServiceImpl implements ContactRequestService {

	@Autowired
	private ContactRequestDAO contactDAO;

	@Override
	public void addContactRequest(ContactRequestDTO contactRequest) {
		contactDAO.create(ContactRequestMapper.dtoToModel(contactRequest));
	}

	@Override
	public void updateContactRequest(ContactRequestDTO contactRequest) throws ContactRequestNotFound {
		ContactRequest contact = contactDAO.findOne(contactRequest.getId());
		if (contact == null) {
			throw new ContactRequestNotFound(contactRequest.getId());
		}
		contactDAO.update(ContactRequestMapper.dtoToModel(contactRequest));
	}

	@Override
	public void deleteContactRequest(Long id) throws ContactRequestNotFound {
		ContactRequest contact = contactDAO.findOne(id);
		if (contact == null) {
			throw new ContactRequestNotFound(id);
		}
		contactDAO.deleteById(id);
	}

	@Override
	public ContactRequestDTO getContactRequestWithId(Long id) throws ContactRequestNotFound {
		ContactRequest contact = contactDAO.findOne(id);
		if (contact == null) {
			throw new ContactRequestNotFound(id);
		}
		return ContactRequestMapper.modelToDto(contact);
	}

	@Override
	public List<ContactRequestDTO> getContactRequestForPager(int page, int itemSize) {
		List<ContactRequest> contactList = contactDAO.getContactRequestForPager(page, itemSize);
		return ContactRequestMapper.modelToDtoList(contactList);
	}

	@Override
	public int getContactRequestCount() {
		return contactDAO.getRowCount();
	}

}
