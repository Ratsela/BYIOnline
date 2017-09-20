package com.byionline.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "circuit")
public class Circuit implements Serializable{
	
	@Id
	@Column(name = "circuit_code")
	private String circuitCode;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "province")
	private String province;
	
	@OneToOne
	@JoinColumn(name = "circuit_code",referencedColumnName = "circuit_code")
	private School school;
	
	/*@OneToMany(mappedBy = "circuit",targetEntity = School.class,fetch = FetchType.EAGER)
	private List<School> schools;*/

	public Circuit() {
	}

	public Circuit(String circuitCode, String name, String province) {
		super();
		this.circuitCode = circuitCode;
		this.name = name;
		this.province = province;
	}

	public String getCircuitCode() {
		return circuitCode;
	}

	public void setCircuitCode(String circuitCode) {
		this.circuitCode = circuitCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	
	
	
	

}
