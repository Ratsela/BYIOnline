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
	private static final int checkSumChecker = 10;
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
	
	public Student getStudent(String idNumber) {
		return studentRepository.findOne(idNumber);
	}
	
	public boolean validateIdNnumber(String idNumber) {
		boolean valid = false;
		boolean checkLength = false;
		int totalOddPositions = 0;
		int totalEvenPositions = 0;
		String strEvens = "";
		int[] evens = new int[6];
		
		checkLength = idNumber.length() == 13 ? true : false;
		if(checkLength) {
			totalOddPositions = Integer.parseInt(idNumber.charAt(0)+"") +
					Integer.parseInt(idNumber.charAt(2)+"") +
					Integer.parseInt(idNumber.charAt(4)+"") +
					Integer.parseInt(idNumber.charAt(6)+"") + 
					Integer.parseInt(idNumber.charAt(8)+"") +
					Integer.parseInt(idNumber.charAt(10)+"");
			
			evens[0] = Integer.parseInt(idNumber.charAt(1)+"");
			evens[1] = Integer.parseInt(idNumber.charAt(3)+"");
			evens[2] = Integer.parseInt(idNumber.charAt(5)+"");
			evens[3] = Integer.parseInt(idNumber.charAt(7)+"");
			evens[4] = Integer.parseInt(idNumber.charAt(9)+"");
			evens[5] = Integer.parseInt(idNumber.charAt(11)+"");
			
			for(int i : evens) {
				strEvens += i;
			}
			
			totalEvenPositions = Integer.parseInt(strEvens) * 2;
			
			String strEvensResultsAdded = totalEvenPositions + "";
			int total = 0;
			int temp = 0;
			for(int x = 0;x < strEvensResultsAdded.length();x++) {
				temp = Integer.parseInt(strEvensResultsAdded.charAt(x) + "");
				total += temp;
			}
			
			int sum = total + totalOddPositions;
			int checkSum = Integer.parseInt(idNumber.charAt(12) + "");
			
			String strSum = sum + "";
			int lastDigitOfSum = 0;
			if(strSum.length() > 1) {
				lastDigitOfSum = Integer.parseInt(strSum.substring(strSum.length() - 1));
			}
			
			valid = checkSumChecker - lastDigitOfSum == checkSum ? true : false;
			
			logger.info("Total odd positions " + totalOddPositions);
			logger.info("Evens " + strEvens + " total times 2 = " + totalEvenPositions + " Sum of digits = " + strEvensResultsAdded.length() + " Total " + total);
			logger.info(sum + " Sum");
			logger.info("Checksum " + checkSum);
			logger.info("Last digit of sum = " + lastDigitOfSum);
		}
		return valid;
	}
	
	public String maleOrFemale(String idNumber) {
		String gender = "";
		int genderPart = Integer.parseInt(idNumber.substring(6,10));
		gender = genderPart >= 5000 ? "Male" : "Female";
		return gender;
	}
	
	

}
