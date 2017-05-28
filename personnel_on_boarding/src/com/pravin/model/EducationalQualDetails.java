package com.pravin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tab_edu_qual_details")
public class EducationalQualDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_edu_qual_details")
	@SequenceGenerator(name="seq_edu_qual_details", sequenceName="seq_edu_qual_details", allocationSize=1)
	@Column(name="edu_qual_id")
	private long eduQualId;
	
	@Column(name="course_name")
	private String courseName;
	
	@Column(name="school_university")
	private String schoolUniversity;
	
	@Column(name="passing_year")
	@Temporal(TemporalType.DATE)
	private Date passingYear;
	
	@Column(name="percent_obtained")
	private double percentObtained;

	@ManyToOne
	@JoinColumn(name="emp_id")
	private Employee employee;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getSchoolUniversity() {
		return schoolUniversity;
	}

	public void setSchoolUniversity(String schoolUniversity) {
		this.schoolUniversity = schoolUniversity;
	}

	public Date getPassingYear() {
		return passingYear;
	}

	public void setPassingYear(Date passingYear) {
		this.passingYear = passingYear;
	}

	public double getPercentObtained() {
		return percentObtained;
	}

	public void setPercentObtained(double percentObtained) {
		this.percentObtained = percentObtained;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
	
}
