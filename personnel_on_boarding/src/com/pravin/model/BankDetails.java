package com.pravin.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tab_bank_details")
public class BankDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_bank_details")
	@SequenceGenerator(name="seq_bank_details", sequenceName="seq_bank_details")
	@Column(name="bd_id")
	private long bdId;
	
	
	@Column(name="ac_no", nullable=false)
	private String acNo;
	
	@Column(name="ac_holder_name", nullable=false)
	private String acHolderName;
	
	@Column(name="branch_name", nullable=false)
	private String branchName;
	
	@Column(name="ac_type", nullable=false)
	private String acType;
	
	@Column(name="ifsc_code", nullable=false)
	private String ifscCode;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="employee_id")
	private Employee employee;

	public long getBdId() {
		return bdId;
	}

	public void setBdId(long bdId) {
		this.bdId = bdId;
	}

	public String getAcNo() {
		return acNo;
	}

	public void setAcNo(String acNo) {
		this.acNo = acNo;
	}

	public String getAcHolderName() {
		return acHolderName;
	}

	public void setAcHolderName(String acHolderName) {
		this.acHolderName = acHolderName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getAcType() {
		return acType;
	}

	public void setAcType(String acType) {
		this.acType = acType;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
}
