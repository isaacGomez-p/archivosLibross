package com.movit.entity;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Table(name = "editorial")
@Entity
public class Editorial {
	
	@ApiModelProperty(value = "ID de la editorial", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	@Column(name = "nombre", nullable = false)
	@NotEmpty(message = "nombre es campo obligatorio")
	@Size(min = 2,  max = 10, message = "Nombre entre 2 y 10 carácteres")
	@ApiModelProperty(value = "Nombre de la editorial", required = true)
	private String nombre;
	
	@Column(name = "correo", nullable = false)
	@NotEmpty(message = "correo es un campo obligatorio")
	@Email(message = "Correo no valido", regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
	private String correo;
	
	@OneToMany(mappedBy = "editorial", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Libro> listaLibros;
	
	@OneToOne(mappedBy = "editorial", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Direccion direccion;	
	
	
	
	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Editorial() {
		
	}

	public Editorial(Integer id, String nombre,	String correo,List<Libro> listaLibros, Direccion direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.listaLibros = listaLibros;
		this.direccion = direccion;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	
	public List<Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(List<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}
	
	
	
}
