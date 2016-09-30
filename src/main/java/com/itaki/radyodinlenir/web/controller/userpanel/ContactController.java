package com.itaki.radyodinlenir.web.controller.userpanel;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.itaki.radyodinlenir.service.ContactRequestService;
import com.itaki.radyodinlenir.web.dto.ContactRequestDTO;
import com.itaki.radyodinlenir.web.validation.ContactRequestFormValidation;

@Controller
public class ContactController {
	
	@Autowired
	ContactRequestService contactService;

	@Autowired
	MessageSource msgsrc;
	
	@Autowired
	ContactRequestFormValidation validation;


	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(validation);
	}

	@RequestMapping(value = "/contact")
	public String contactPage(Model model) {
		model.addAttribute("contactRequest", new ContactRequestDTO());
		return "contact";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String getContactRequest(@ModelAttribute("contactRequest") @Validated ContactRequestDTO contactRequest, BindingResult result, Model model, final RedirectAttributes redirectAttributes, Locale locale) {
		try {
			if (result.hasErrors()) {
				model.addAttribute("css", "danger");
				model.addAttribute("msg", msgsrc.getMessage("ContactRequest.Alert", new String[] {}, locale));
				return "contact";
			}
			contactService.addContactRequest(contactRequest);			
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", msgsrc.getMessage("ContactRequest.Succesfull", new String[] {}, locale));
			return "redirect:/contact";
		} catch (Exception e) {
		System.out.println(e);
			return "error403";
		}
	}
}
