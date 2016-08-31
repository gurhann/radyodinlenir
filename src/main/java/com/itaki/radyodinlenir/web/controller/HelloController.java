package com.itaki.radyodinlenir.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itaki.radyodinlenir.exception.UserNotFoundException;
import com.itaki.radyodinlenir.service.UserService;

@Controller
public class HelloController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/hello")
	public String hello() {
		return "home";
	}

	@RequestMapping(value = "/")
	public String sendToHello() {
		try {
			userService.getUserByUserName("gurhan");
		}catch (UserNotFoundException e) {
			return "redirect:/hello";
		}
		return "redirect:/null";
	}
}
