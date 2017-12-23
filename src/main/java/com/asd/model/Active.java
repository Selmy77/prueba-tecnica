package com.asd.model;

import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "actives")
public class Active {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "active_id")
	private long id;

	private String name;
	
	private String descripcion;
	
	private String tipo;

	private int serial;
	
	private String numero_interno;
	
	private String peso;
	
	private String alto;
	
	private String ancho;
	
	private String largo;
	
	private String valor_compra;
	
	private String estado;
	
	private String color;

	@Column(name = "created_at")	
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date created_at;
	
	@Column(name = "updated_at")
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date updated_at;
	
	@OneToMany(mappedBy = "active", cascade = CascadeType.ALL)
	private Set<Area> areas = new HashSet<Area>();
	
	@ManyToMany
	@JoinTable(name = "people_actives", 
		joinColumns = @JoinColumn(name = "active_id", referencedColumnName = "active_id"), 
		inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "person_id"))
	private Set<Person> people = new HashSet<Person>();

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

	public String getDescripcion() {
		return descripcion;
	}

		
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public String getNumero_interno() {
		return numero_interno;
	}

	public void setNumero_interno(String numero_interno) {
		this.numero_interno = numero_interno;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getAlto() {
		return alto;
	}

	public void setAlto(String alto) {
		this.alto = alto;
	}

	public String getAncho() {
		return ancho;
	}

	public void setAncho(String ancho) {
		this.ancho = ancho;
	}

	public String getLargo() {
		return largo;
	}

	public void setLargo(String largo) {
		this.largo = largo;
	}

	public String getValor_compra() {
		return valor_compra;
	}

	public void setValor_compra(String valor_compra) {
		this.valor_compra = valor_compra;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Set<Person> getPeople() {
		return people;
	}

	public void setPeople(Set<Person> people) {
		this.people = people;
	}

	public Set<Area> getAreas() {
		return areas;
	}

	public void setAreas(Set<Area> areas) {
		this.areas = areas;
	}


	
	
}