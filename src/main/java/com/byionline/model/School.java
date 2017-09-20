package com.byionline.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "school")
public class School implements Serializable{
	
	@Id
	@Column(name = "school_code")
	private String schoolCode;
	
	@Column(name = "subject_code",insertable = false,updatable = false)
	private String subjectCode;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "contact")
	private String contact;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "physical_address")
	private String physicalAddress;
	
	@Column(name = "postal_address")
	private String postalAddress;
	
	@OneToOne
	@JoinColumn(name = "IDNumber",referencedColumnName = "IDNumber")
	private Student student;
	
	@OneToMany(mappedBy = "schoolStudent",targetEntity = Student.class,fetch = FetchType.EAGER)
	private List<Student> students;
	
	@OneToOne(optional = false,cascade = CascadeType.ALL,mappedBy = "school",targetEntity = Circuit.class)
	private Circuit circuit;
	
	
	@OneToMany(mappedBy = "school",targetEntity = SchoolSubject.class,fetch = FetchType.LAZY)
	//@JoinColumn(name = "subject_code",referencedColumnName = "subject_code")
	private List<SchoolSubject> subjects;
	
	/*@OneToMany
	@Column(name = "IDNumber")
	private List<Student> students;*/

	public School() {
		
	}
	
	public School(String schoolCode, String name, String contact, String email, String physicalAddress,
			String postalAddress, Circuit circuit) {
		super();
		this.schoolCode = schoolCode;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.physicalAddress = physicalAddress;
		this.postalAddress = postalAddress;
		this.circuit = circuit;
	}




	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhysicalAddress() {
		return physicalAddress;
	}

	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	
	
	
	
	
	

}
