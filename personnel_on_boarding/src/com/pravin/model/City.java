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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="tab_city")
public class City {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_city")
	@SequenceGenerator(name="seq_city", sequenceName="seq_city", allocationSize=1)
	@Column(name="city_id")
	private long cityId;
	
	@Column(name="city_name", length=50, nullable=false)
	private String cityName;
	
	//@NotFound(action=NotFoundAction.IGNORE)
	@ManyToOne(optional=false)
	@JoinColumn(name="state_id")
	private State state;

	@OneToMany(mappedBy="city")
	private List<Employee> employees = new ArrayList<>();
	
	
	
	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
	
}
