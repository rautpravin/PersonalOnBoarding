package com.pravin.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tab_country")
public class Country {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_country")
	@SequenceGenerator(name="seq_country", sequenceName="seq_country", allocationSize=1)
	@Column(name="country_id")
	private int countryId;
	
	@Column(name="country_name", length=50, unique=true)
	private String countryName;
	
	@OneToMany(mappedBy="country", fetch=FetchType.EAGER)
	private Set<State> states = new HashSet<>();
	
	
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public Set<State> getStates() {
		return states;
	}
	public void setStates(Set<State> states) {
		this.states = states;
	}
	
	
	
}
