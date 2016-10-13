package com.itaki.radyodinlenir.web.controller.errorpanel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {

	 @RequestMapping(value="/error404",method=RequestMethod.GET)
	 public String getError404(){
		 return "error404";
	 }
	 @RequestMapping(value="/error403",method=RequestMethod.GET)
	 public String getError403(){
		 return "error403";
	 }
	 @RequestMapping(value="/error500",method=RequestMethod.GET)
	 public String getError500(){
		 return "error500";
	 }
}
