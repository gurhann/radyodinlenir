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

import com.itaki.radyodinlenir.service.SearchTermsService;
import com.itaki.radyodinlenir.web.dto.SearchTermsDTO;

@Controller
public class SearchTermsController {

	@Autowired
	SearchTermsService searchTermsService;

	@Autowired
	MessageSource msgsrc;

	@RequestMapping(value = "/admin/searchterms/{pageIndex}", method = RequestMethod.GET)
	public String getSearchTerms(Model model, @PathVariable(value = "pageIndex") Integer pageIndex) {
		try {
			int searchTermsCount = searchTermsService.getSearchTermsCount();

			List<SearchTermsDTO> searchTermsList = null;
			int maxPageIndex = (int) Math.ceil((double) searchTermsCount / 10);
			if (pageIndex == null || pageIndex < 1 || pageIndex > maxPageIndex) {
				pageIndex = 1;
			}
			searchTermsList = searchTermsService.getSearchTermsPager(pageIndex, 10);
			model.addAttribute("maxPageIndex", maxPageIndex);
			model.addAttribute("pageIndex", pageIndex);
			model.addAttribute("searchTermsList", searchTermsList);
			return "searchtermslist";
		} catch (Exception e) {
			System.out.println(e);
			return "error403";
		}
	}

	@RequestMapping(value = "/admin/searchterms/{deleteid}/delete", method = RequestMethod.GET)
	public String deleteContactRequestWithId(@PathVariable(value = "deleteid") Integer id, Model model, final RedirectAttributes redirectAttributes, Locale locale) {
		try {
			searchTermsService.deleteSearchTerms(id);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", msgsrc.getMessage("Form.Succesfull", new String[] {}, locale));
			return "redirect:/admin/searchterms/1";

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", msgsrc.getMessage("Form.Alert", new String[] {}, locale));
			return "redirect:/admin/searchterms/1";
		}
	}

}
