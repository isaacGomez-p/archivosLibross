package com.movit.dto;

import java.util.Calendar;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.movit.entity.Editorial;

import io.swagger.annotations.ApiModelProperty;

public class LibroDto {

	@ApiModelProperty(value = "ID del libro", required = true)
	private Integer id;
	
	
	@NotEmpty(message = "nombre es campo obligatorio")
	@Size(min = 2,  max = 10, message = "Nombre entre 2 y 10 carácteres")
	@ApiModelProperty(value = "Nombre del libro", required = true)
	private String nombre;
	
	
	@NotEmpty(message = "autor es campo obligatorio")
	@Size(min = 2,  max = 10, message = "Autor entre 2 y 10 carácteres")
	@ApiModelProperty(value = "Autor del libro", required = true)
	private String autor;	
	
	
	@NotEmpty(message = "correo es un campo obligatorio")
	@Email(message = "Correo no valido", regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
	private String correo;
	
	
    @Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss") 	
    private Calendar lanzamiento;
		
	private EditorialDto editorial;

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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Calendar getLanzamiento() {
		return lanzamiento;
	}

	public void setLanzamiento(Calendar lanzamiento) {
		this.lanzamiento = lanzamiento;
	}

	public EditorialDto getEditorial() {
		return editorial;
	}

	public void setEditorial(EditorialDto editorial) {
		this.editorial = editorial;
	}
	
	
	
}
