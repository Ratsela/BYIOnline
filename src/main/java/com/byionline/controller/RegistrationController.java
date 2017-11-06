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
@RequestMapping(value = "/student")
public class RegistrationController {
	
	//private final StudentRepository studentRepository;
	private final StudentRepoImplementation studentRepository;
	private final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	@Autowired
	public RegistrationController(StudentRepoImplementation studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@RequestMapping(value = "/checkStudent",method = RequestMethod.GET)
	public ModelAndView checkStudent(Model model,@RequestParam(value = "studentId")String studentId) {
		String exists = "";
		String message = "";
		String page = "";
		
		if(studentRepository.validateIdNnumber(studentId)) {
			String gender = studentRepository.maleOrFemale(studentId);
			logger.info(gender);
			if(studentRepository.checkIfStudentExists(studentId)) {
				logger.info("Student with ID number: " + studentId + " Already applied");
				exists = "Exist";
				message = "Student with ID number: " + studentId + " Already applied";
				//page = "redirect:/byi";
				
				model.addAttribute("exist", exists);
				model.addAttribute("message", message);
				page = "views/studentExistsError";
			}else if(!studentRepository.checkIfStudentExists(studentId)){
				exists = "Not Existing";
				model.addAttribute("exist", exists);
				model.addAttribute("gender", gender);
				model.addAttribute("studentId", studentId);
				page = "views/applicationForm";
				logger.info("Proceed");
			}
		}else {
			logger.info("Invalid ID Number");
			page = "views/invalidIdError";
		}
		
		
		return new ModelAndView(page);
	}
	
	
	/*@RequestMapping(value = "/registerStudent",method = RequestMethod.POST)
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
	}*/

}
