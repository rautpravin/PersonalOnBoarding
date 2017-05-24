package com.pravin.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tab_designation")
public class Designation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_designation")
	@SequenceGenerator(name="seq_designation", sequenceName="seq_designation")
	@Column(name="desg_id")
	private int designationId;
	
	@Column(name="desg_name")
	private String designationName;
	
	@OneToMany(mappedBy="designation", cascade=CascadeType.ALL)
	private List<Employee> employees = new ArrayList<>();

	public int getDesignationId() {
		return designationId;
	}

	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	
	
	
}
