package com.byionline.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/application")
public class ApplicationController {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);
	
	@RequestMapping(value = "/createStudentObject",method = RequestMethod.GET)
	public ModelAndView registerStudent(Model model,@RequestParam("studentId")String studId,
										@RequestParam("fullNames") String fullNames,
										@RequestParam("surname") String surname,
										@RequestParam("studGender") String studGender,
										@RequestParam("email") String email,
										@RequestParam("mobile")String mobile,
										@RequestParam("physicalAddress")String physicalAddress,
										@RequestParam("postalAddress")String postalAddress,
										@RequestParam("postalCode")String postalCode) {
		model.addAttribute("studentId", studId);
		logger.info("ID number = " , studId);
		
		return new ModelAndView("redirect:/student/checkStudent");
	}

}
