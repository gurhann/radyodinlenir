package com.itaki.radyodinlenir.web.controller.adminpanel;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@Autowired
	MessageSource msgsrc;

	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String getLoginForm(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout, Model model, Locale locale) {
		if (error != null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", msgsrc.getMessage("Login.Error", new String[] {}, locale));
		}

		if (logout != null) {
			model.addAttribute("css", "success");
			model.addAttribute("msg",msgsrc.getMessage("Logout.Successfull", new String[] {}, locale));
		}
		return "login";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";
	}

}
