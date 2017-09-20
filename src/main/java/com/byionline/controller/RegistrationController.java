package com.byionline.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.byionline.model.Student;
import com.byionline.service.StudentRepoImplementation;

@Controller
@RequestMapping(value = "/register")
public class RegistrationController {
	
	//private final StudentRepository studentRepository;
	private final StudentRepoImplementation studentRepository;
	private final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	@Autowired
	public RegistrationController(StudentRepoImplementation studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@RequestMapping(value = "/registerStudent",method = RequestMethod.POST)
	public ModelAndView registerStudent(Model model,@RequestParam("idNumber")String idNumber,
										@RequestParam("nameAndSurname") String nameAndSurname,
										@RequestParam("gender") String gender,
										@RequestParam("email") String email,
										@RequestParam("mobile")String mobile,
										@RequestParam("PhysicalAddress")String physicalAddress,
										@RequestParam("postalAddress")String postalAddress,
										@RequestParam("postalCode")String postalCode) {
		
		String firstName = nameAndSurname.substring(0, nameAndSurname.indexOf(" "));
		String lastName = nameAndSurname.substring(nameAndSurname.indexOf(" "));
		
		Student student = new Student(idNumber, firstName, lastName, gender, email, mobile, postalAddress, physicalAddress, postalCode);
		
		if(studentRepository.checkIfStudentExists(student.getId())) {
			logger.info("Student with id number " + idNumber +" exist");
		}else {
			logger.info("Continue with registration = {}");
			
			
			
			studentRepository.createStudent(student);
			logger.info(firstName + "#" + lastName);
		}
		
		return new ModelAndView("views/home");
	}

}
