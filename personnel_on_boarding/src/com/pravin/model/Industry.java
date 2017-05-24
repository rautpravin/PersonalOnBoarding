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
@Table(name="tab_industry")
public class Industry {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_industry")
	@SequenceGenerator(name="seq_industry", sequenceName="seq_industry", allocationSize=1)
	@Column(name="industry_id")
	private int industryId;
	
	@Column(name="industry_name")
	private String industryName;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="industry")
	private List<IndustrySector> industrySectors = new ArrayList<>();

	public int getIndustryId() {
		return industryId;
	}

	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public List<IndustrySector> getIndustrySectors() {
		return industrySectors;
	}

	public void setIndustrySectors(List<IndustrySector> industrySectors) {
		this.industrySectors = industrySectors;
	}
	
	
	

}
