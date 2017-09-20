package com.byionline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byionline.model.Student;
import com.byionline.repository.StudentRepository;

@Service
public class StudentRepoImplementation {
	
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentRepoImplementation(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public boolean checkIfStudentExists(String idNumber) {
		boolean exist = false;
		Student student = studentRepository.findOne(idNumber);
		if(student != null) {
			exist = true;
		}
		return exist;
	}
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

}
