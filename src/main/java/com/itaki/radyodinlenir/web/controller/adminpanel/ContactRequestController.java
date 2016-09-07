package com.itaki.radyodinlenir.web.controller.adminpanel;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itaki.radyodinlenir.service.impl.ContactRequestServiceImpl;
import com.itaki.radyodinlenir.web.dto.ContactRequestDTO;

@Controller
public class ContactRequestController {

	@Autowired
	ContactRequestServiceImpl contactRequestService;
	
	@Autowired
	MessageSource msgsrc;


	@RequestMapping(value = "/admin/contactlist", method = RequestMethod.GET)
	public String getContactRequestList(Model model) {
		try {
			List<ContactRequestDTO> contactlist = contactRequestService.getContactRequestForPager(1, 20);
			model.addAttribute("contactlist", contactlist);
			return "contactlist";
		} catch (Exception e) {
			return "error403";
		}
	}

	@RequestMapping(value = "/admin/contactlist/{deleteid}/delete", method = RequestMethod.GET)
	public String deleteContactRequestWithId(@PathVariable(value = "deleteid") Long id, Model model, final RedirectAttributes redirectAttributes, Locale locale) {
		try {			
			contactRequestService.deleteContactRequest(id);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", msgsrc.getMessage("Form.Succesfull", new String[] {}, locale));
			return "redirect:/admin/contactlist";

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", msgsrc.getMessage("Form.Alert", new String[] {}, locale));
			return "redirect:/admin/contactlist";
		}

	}

}