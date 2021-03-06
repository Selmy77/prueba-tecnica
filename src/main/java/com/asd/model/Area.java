package com.asd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "areas")
public class Area {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "area_id")
	private long id;

	private String name;

	@Enumerated(EnumType.STRING)
	private City city;

	@ManyToOne
	@JoinColumn (name="active_id")
	@JsonBackReference
	private Person active;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Person getActive() {
		return active;
	}

	public void setActive(Person active) {
		this.active = active;
	}

	
}
