	package com.movit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Direccion {

	@ApiModelProperty(value = "ID de la direccion", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	@Column(name = "nombre", nullable = false)
	@NotEmpty(message = "nombre es campo obligatorio")
	@Size(min = 2,  max = 10, message = "Nombre entre 2 y 10 carácteres")
	@ApiModelProperty(value = "Nombre de la editorial", required = true)
	private String nombre;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToOne
	@JoinColumn(name = "id_editorial", nullable = false, foreignKey = @ForeignKey(name = "FK_editorial_direccion"))
	private Editorial editorial;	
	
	public Direccion() {
		
	}

	public Direccion(Integer id, String nombre,	Editorial editorial) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.editorial = editorial;
	}

	@JsonIgnore
	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
		
}
