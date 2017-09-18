package com.byionline.repository;

import org.springframework.data.repository.CrudRepository;

import com.byionline.model.Student;

public interface StudentRepository extends CrudRepository<Student, String> {
	//boolean checkIfStudentExists(String idNumber);
}
