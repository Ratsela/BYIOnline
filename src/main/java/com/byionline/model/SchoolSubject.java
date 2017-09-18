package com.byionline.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "school_subjects")
public class SchoolSubject implements Serializable {
	
	@Id
	@Column(name = "subject_code")
	private String subjectCode;
	
	@Column(name = "subject_description")
	private String subjectDescription;
	
	@Column(name = "level")
	private int level;
	
	@OneToMany
	@JoinColumn(name = "school_code")
	private List<School> shcool;
	
	@OneToMany
	@JoinColumn(name = "IDNumber")
	private List<Student> students;
	
	@ManyToOne
	@JoinColumn(name = "IDNumber")
	private Student student;

	public SchoolSubject() {
	}

	public SchoolSubject(String subjectCode, String subjectDescription, int level) {
		super();
		this.subjectCode = subjectCode;
		this.subjectDescription = subjectDescription;
		this.level = level;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectDescription() {
		return subjectDescription;
	}

	public void setSubjectDescription(String subjectDescription) {
		this.subjectDescription = subjectDescription;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	

}
