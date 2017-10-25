package com.byionline.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byionline.model.Student;
import com.byionline.repository.StudentRepository;

@Service
public class StudentRepoImplementation {
	
	private final StudentRepository studentRepository;
	private static final Logger logger = LoggerFactory.getLogger(StudentRepoImplementation.class);
	@Autowired
	public StudentRepoImplementation(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public boolean checkIfStudentExists(String idNumber) {
		return studentRepository.exists(idNumber);
	}
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

}
