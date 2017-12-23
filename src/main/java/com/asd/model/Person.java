package com.asd.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "people")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "person_id")
	private long id;

	private String name;
	
	private String username;

	private int age;


	@ManyToMany(cascade = CascadeType.MERGE)
	@JsonBackReference
	@JoinTable(name = "people_actives",
		joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "person_id"),
		inverseJoinColumns = @JoinColumn(name = "active_id", referencedColumnName = "active_id"))
	private Set<Active> actives = new HashSet<Active>();

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public Set<Active> getActives() {
		return actives;
	}

	public void setActives(Set<Active> actives) {
		this.actives = actives;
	}



	

}