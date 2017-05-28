package com.pravin.model;

import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name="tab_experience_details")
public class ExperienceDetails {
	
	@Id
	@Column(name="exp_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_experience_details")
	@SequenceGenerator(name="seq_experience_details", sequenceName="seq_experience_details", allocationSize=1)
	private long expId;
	
	
	@Column(name="employer_name")
	private String employerName;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="duration_from")
	@Temporal(TemporalType.DATE)
	private Date durationFrom;
	
	@Column(name="duration_till")
	@Temporal(TemporalType.DATE)
	private Date durationTill;
	
	@Column(name="ctc_fixed")
	private double ctcFixed;
	
	@Column(name="ctc_variable")
	private double ctcVariable;
	
	@Column(name="reff_name1")
	private String refferenceName1;
	
	@Column(name="reff_cont_no1")
	private String refferenceContNo1;
	
	@Column(name="reff_name2")
	private String refferenceName2;
	
	@Column(name="reff_cont_no2")
	private String refferenceContNo2;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="sector_id")
	private IndustrySector industrySector;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="emp_id")
	private Employee employee;

	public long getExpId() {
		return expId;
	}

	public void setExpId(long expId) {
		this.expId = expId;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getDurationFrom() {
		return durationFrom;
	}

	public void setDurationFrom(Date durationFrom) {
		this.durationFrom = durationFrom;
	}

	public Date getDurationTill() {
		return durationTill;
	}

	public void setDurationTill(Date durationTill) {
		this.durationTill = durationTill;
	}

	public double getCtcFixed() {
		return ctcFixed;
	}

	public void setCtcFixed(double ctcFixed) {
		this.ctcFixed = ctcFixed;
	}

	public double getCtcVariable() {
		return ctcVariable;
	}

	public void setCtcVariable(double ctcVariable) {
		this.ctcVariable = ctcVariable;
	}

	public String getRefferenceName1() {
		return refferenceName1;
	}

	public void setRefferenceName1(String refferenceName1) {
		this.refferenceName1 = refferenceName1;
	}

	public String getRefferenceContNo1() {
		return refferenceContNo1;
	}

	public void setRefferenceContNo1(String refferenceContNo1) {
		this.refferenceContNo1 = refferenceContNo1;
	}

	public String getRefferenceName2() {
		return refferenceName2;
	}

	public void setRefferenceName2(String refferenceName2) {
		this.refferenceName2 = refferenceName2;
	}

	public String getRefferenceContNo2() {
		return refferenceContNo2;
	}

	public void setRefferenceContNo2(String refferenceContNo2) {
		this.refferenceContNo2 = refferenceContNo2;
	}

	public IndustrySector getIndustrySector() {
		return industrySector;
	}

	public void setIndustrySector(IndustrySector industrySector) {
		this.industrySector = industrySector;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
	
}
