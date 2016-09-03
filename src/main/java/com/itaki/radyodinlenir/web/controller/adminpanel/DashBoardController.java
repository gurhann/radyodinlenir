package com.itaki.radyodinlenir.web.controller.adminpanel;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class DashBoardController {
	private static final Logger logger = Logger.getLogger(DashBoardController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String introDashBoard(Locale locale, Model model) {
		logger.info("Admin Dashboard'a giris yapildi.");
		return "dashboard";
	}

}
