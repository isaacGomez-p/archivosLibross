package com.movit.entity;


import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "libros")
@ApiModel("Modelo Libro")
public class Libro implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "ID del libro", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre", nullable = false)
	@NotEmpty(message = "nombre es campo obligatorio")
	@Size(min = 2,  max = 10, message = "Nombre entre 2 y 10 carácteres")
	@ApiModelProperty(value = "Nombre del libro", required = true)
	private String nombre;
	
	@Column(name = "autor", nullable = false)
	@NotEmpty(message = "autor es campo obligatorio")
	@Size(min = 2,  max = 10, message = "Autor entre 2 y 10 carácteres")
	@ApiModelProperty(value = "Autor del libro", required = true)
	private String autor;	
	
	@Column(name = "correo", nullable = false)
	@NotEmpty(message = "correo es un campo obligatorio")
	@Email(message = "Correo no valido", regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
	private String correo;
	
	@Column(name = "lanzamiento", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss") 	
    private Calendar lanzamiento;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name = "id_editorial", nullable = false, foreignKey = @ForeignKey(name = "FK_editorial_libro"))
	private Editorial editorial;
	
	public Libro() {
		
	}	
	
	public Libro(Integer id, String nombre, String autor, String corr, Editorial editorial) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.correo = corr;
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
	
	@JsonIgnore
	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public String serializar(Libro libro) {
		String libro1;
		libro1 = Integer.toString(libro.getId()) +","+ libro.getNombre()+","+ libro.getAutor()+";";
		return libro1;
	}
}
