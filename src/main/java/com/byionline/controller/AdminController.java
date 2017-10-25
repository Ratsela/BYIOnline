package com.byionline.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/byi")
public class AdminController {
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@RequestMapping(value = "/admin",method=RequestMethod.GET)
	public String getAdminLoginPage(Model model) {
		return "views/login";
	}
	
	@RequestMapping(value = "/adminHome",method=RequestMethod.POST)
	public String getAdminPage(Model model) {
		
		return "views/admin";
	}
}
