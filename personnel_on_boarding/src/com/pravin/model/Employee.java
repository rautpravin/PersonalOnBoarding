package com.pravin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tab_employee")
public class Employee {
	
	@Id
	@Column(name="employee_id")
	private String employeeId;
	
	@Column(name="emp_name", length=60)
	private String employeeName;
	
	@Column(name="birth_date")
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@Column(name="email_id", length=60)
	private String emailId;
	
	@Column(name="mobile_no", length=15)
	private String mobileNo;
	
	@Column(name="landline_no", length=25)
	private String landlineNo;
	
	@Column(name="emergency_cont_person_name", length=60)
	private String emergencyContactPersonName;
	
	@Column(name="emergency_cont_no", length=25)
	private String emergencyContactNo;
	
	@Column(name="gender", length=6)
	private String gender;
	
	@Column(name="marital_status", length=10)
	private String maritalStatus;
	
	@Column(name="addr_proof_doc_type", length=30)
	private String addrProofDocType;
	
	@Column(name="other_addr_prof_doc_type")
	private String otherAddrProofType;
	
	@Column(name="addr_proof_doc_id", length=40)
	private String addrProofDocId;
	
	
	
	@Column(name="flat_building_no")
	private String flatBuildingNo;
	
	@Column(name="street_lane1")
	private String streetLane1;
	
	@Column(name="street_lane2")
	private String streetLane2;
	
	@Column(name="landmark")
	private String landmark;
	
	@Column(name="location")
	private String location;
	
	@Column(name="pincode", length=10)
	private String pincode;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="city_id")
	private City city;
	
	
	@Column(name="joining_date")
	@Temporal(TemporalType.DATE)
	private Date joiningDate;
	
	@Column(name="leaving_date")
	@Temporal(TemporalType.DATE)
	private Date leavingDate;
	
	@Column(name="ctc")
	private double ctc;
	
	@Column(name="experience_type")
	private String experienceType;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="desg_id")
	private Designation designation;
	
		
	@ManyToOne
	@JoinColumn(name="sector_id")
	private IndustrySector industrySector;
	
	@ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="manager_id")
    private Employee manager;

	
	@OneToMany(mappedBy="employee", cascade=CascadeType.ALL)
	private List<EducationalQualDetails> educationalQualDetails = new ArrayList<>();
	
	@OneToMany(mappedBy="employee", cascade=CascadeType.ALL)
	private List<ExperienceDetails> experienceDetails = new ArrayList<>();

	@OneToOne(cascade=CascadeType.ALL, mappedBy="employee")
	private BankDetails bankDetails;
	
	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getLandlineNo() {
		return landlineNo;
	}

	public void setLandlineNo(String landlineNo) {
		this.landlineNo = landlineNo;
	}

	public String getEmergencyContactPersonName() {
		return emergencyContactPersonName;
	}

	public void setEmergencyContactPersonName(String emergencyContactPersonName) {
		this.emergencyContactPersonName = emergencyContactPersonName;
	}

	public String getEmergencyContactNo() {
		return emergencyContactNo;
	}

	public void setEmergencyContactNo(String emergencyContactNo) {
		this.emergencyContactNo = emergencyContactNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getAddrProofDocType() {
		return addrProofDocType;
	}

	public void setAddrProofDocType(String addrProofDocType) {
		this.addrProofDocType = addrProofDocType;
	}
	
	public String getOtherAddrProofType() {
		return otherAddrProofType;
	}

	public void setOtherAddrProofType(String otherAddrProofType) {
		this.otherAddrProofType = otherAddrProofType;
	}


	public String getAddrProofDocId() {
		return addrProofDocId;
	}

	public void setAddrProofDocId(String addrProofDocId) {
		this.addrProofDocId = addrProofDocId;
	}

	public String getFlatBuildingNo() {
		return flatBuildingNo;
	}

	public void setFlatBuildingNo(String flatBuildingNo) {
		this.flatBuildingNo = flatBuildingNo;
	}

	public String getStreetLane1() {
		return streetLane1;
	}

	public void setStreetLane1(String streetLane1) {
		this.streetLane1 = streetLane1;
	}

	public String getStreetLane2() {
		return streetLane2;
	}

	public void setStreetLane2(String streetLane2) {
		this.streetLane2 = streetLane2;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

		public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getLeavingDate() {
		return leavingDate;
	}

	public void setLeavingDate(Date leavingDate) {
		this.leavingDate = leavingDate;
	}

	public double getCtc() {
		return ctc;
	}

	public void setCtc(double ctc) {
		this.ctc = ctc;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public IndustrySector getIndustrySector() {
		return industrySector;
	}

	public void setIndustrySector(IndustrySector industrySector) {
		this.industrySector = industrySector;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public List<EducationalQualDetails> getEducationalQualDetails() {
		return educationalQualDetails;
	}

	public void setEducationalQualDetails(List<EducationalQualDetails> educationalQualDetails) {
		this.educationalQualDetails = educationalQualDetails;
	}

	public List<ExperienceDetails> getExperienceDetails() {
		return experienceDetails;
	}

	public void setExperienceDetails(List<ExperienceDetails> experienceDetails) {
		this.experienceDetails = experienceDetails;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public BankDetails getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}

	
	public String getExperienceType() {
		return experienceType;
	}

	public void setExperienceType(String experienceType) {
		this.experienceType = experienceType;
	}

	
	
}
