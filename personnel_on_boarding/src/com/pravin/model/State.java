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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="tab_state")
public class State {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_state")
	@SequenceGenerator(name="seq_state", sequenceName="seq_state", allocationSize=1)
	@Column(name="state_id")
	private  int stateId;
	
	@Column(name="state_name", length=50, nullable=false)
	private String stateName;

	@NotFound(action=NotFoundAction.IGNORE)
	@ManyToOne
	@JoinColumn(name="country_id")
	private Country country;
	
	@OneToMany(mappedBy="state", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<City> cities = new HashSet<>();
	
	
	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
	
	
	
}
