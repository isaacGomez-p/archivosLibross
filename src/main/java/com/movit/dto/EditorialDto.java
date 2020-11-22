package com.movit.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.movit.entity.Direccion;

import io.swagger.annotations.ApiModelProperty;

public class EditorialDto {
	
	private Integer id;	
		
	@NotEmpty(message = "nombre es campo obligatorio")
	@Size(min = 2,  max = 10, message = "Nombre entre 2 y 10 carácteres")
	@ApiModelProperty(value = "Nombre de la editorial", required = true)
	private String nombre;
	
	@NotEmpty(message = "correo es un campo obligatorio")
	@Email(message = "Correo no valido", regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
	private String correo;
		
	private List<LibroDto> listaLibros;
	
	private Direccion direccion;
	
	public EditorialDto() {
		
	}
	
	public EditorialDto(Integer id, String nombre, String correo, List<LibroDto> listaLibros, Direccion direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.listaLibros = listaLibros;
		this.direccion = direccion;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
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

	public List<LibroDto> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(List<LibroDto> listaLibros) {
		this.listaLibros = listaLibros;
	}
	

}
