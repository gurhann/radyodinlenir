package com.itaki.radyodinlenir.dao.impl;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.itaki.radyodinlenir.persistence.dao.ContactRequestDAO;
import com.itaki.radyodinlenir.persistence.model.ContactRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:com/itaki/radyodinlenir/config/test-persistence-context.xml", "classpath:com/itaki/radyodinlenir/config/dao-context.xml" })
@Transactional
public class ContactTypeRequestDAOTest {

	@Autowired
	private ContactRequestDAO contactRequestDAO;

	private static ContactRequest contactRequest3;
	private static ContactRequest contactRequest4;

	@BeforeClass
	public static void init() {
		try {
			SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			contactRequest3 = createDummyContactRequest(new Long(3), "name3", "message3", "email3", false, fmt.parse("12/12/2016 14:12"));
			contactRequest4 = createDummyContactRequest(new Long(4), "name4", "message4", "email4", true, fmt.parse("12/12/2016 12:12"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void check_contact_request_list_by_page() {
		List<ContactRequest> page1 = contactRequestDAO.getContactRequestForPager(1, 3);
		List<ContactRequest> page2 = contactRequestDAO.getContactRequestForPager(2, 3);
		assertEquals(page1.get(0), contactRequest3);
		assertEquals(page2.get(0), contactRequest4);
		
	}

	private static ContactRequest createDummyContactRequest(Long id, String name, String message, String email, boolean wasAnswered, Date date) {
		ContactRequest contactRequest = new ContactRequest();
		contactRequest.setId(id);
		contactRequest.setName(name);
		contactRequest.setMessage(message);
		contactRequest.setEmail(email);
		contactRequest.setWasAnswered(wasAnswered);
		contactRequest.setSendDate(date);
		return contactRequest;
	}
}
