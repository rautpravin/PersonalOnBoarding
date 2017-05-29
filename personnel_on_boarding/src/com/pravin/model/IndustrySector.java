package com.pravin.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tab_industry_sector")
public class IndustrySector {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_industry_sector")
	@SequenceGenerator(name="seq_industry_sector", sequenceName="seq_industry_sector", allocationSize=1)
	@Column(name="sector_id")
	private long sectorId;
	
	@Column(name="sector_name")
	String sectorName;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="industry_id")
	private Industry industry;

	@OneToMany(mappedBy="industrySector", cascade=CascadeType.ALL)
	private List<Employee> employees = new ArrayList<>();
	
	public long getSectorId() {
		return sectorId;
	}

	public void setSectorId(long sectorId) {
		this.sectorId = sectorId;
	}

	public String getSectorName() {
		return sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	
	
	
	
}
