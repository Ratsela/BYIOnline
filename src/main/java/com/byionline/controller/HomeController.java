package com.byionline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/byi")
public class HomeController {
	@RequestMapping(value="",method = RequestMethod.GET)
	public String getHome()
	{
		return "views/home";
	}
}
