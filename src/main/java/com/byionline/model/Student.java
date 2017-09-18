package com.byionline.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_details")
public class Student implements Serializable{
	
	@Id
	@Column(name = "IDNumber")
	private String id;
	
	@Column(name = "FirstName")
	private String firstName;
	
	@Column(name = "LastName")
	private String lastName;
	
	@Column(name = "Gender")
	private String gender;
	
	@Column(name = "EmailAddress")
	private String emailAddress;
	
	@Column(name = "contact")
	private String contact;
	
	@Column(name = "postalAddress")
	private String postalAddress;
	
	@Column(name = "physicalAddress")
	private String physicalAddress;
	
	@Column(name = "postalCode")
	private String postalCode;
	
	@OneToOne
	@JoinColumn(name = "IDNumber")
	private NextOfKin nextOfKin;
	
	@OneToOne
	@JoinColumn(name = "school_code")
	private School school;
	
	@OneToMany
	@JoinColumn(name = "subject_code")
	private List<SchoolSubject> schoolSubjects;

	public Student() {
	}

	public Student(String id, String firstName, String lastName, String gender, String emailAddress, String contact,
			String postalAddress, String physicalAddress, String postalCode) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.emailAddress = emailAddress;
		this.contact = contact;
		this.postalAddress = postalAddress;
		this.physicalAddress = physicalAddress;
		this.postalCode = postalCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getPhysicalAddress() {
		return physicalAddress;
	}

	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public NextOfKin getNextOfKin() {
		return nextOfKin;
	}

	public void setNextOfKin(NextOfKin nextOfKin) {
		this.nextOfKin = nextOfKin;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public List<SchoolSubject> getSchoolSubjects() {
		return schoolSubjects;
	}

	public void setSchoolSubjects(List<SchoolSubject> schoolSubjects) {
		this.schoolSubjects = schoolSubjects;
	}

		
	

}
