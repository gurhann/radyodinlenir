package com.itaki.radyodinlenir.web.controller.userpanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itaki.radyodinlenir.service.SiteMapEntryService;

@Controller
public class SitemapController {
	@Autowired
	SiteMapEntryService service;
	@RequestMapping(path = "/sitemap.xml")
	public @ResponseBody String  create() {		
		return service.createSiteMap();
	}
}
