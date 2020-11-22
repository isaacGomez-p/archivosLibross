package com.movit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Immutable;

import com.fasterxml.jackson.databind.node.IntNode;

@Entity	
@Table( name = "consultaview")
public class ConsultaView implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ideditorial")
	private Integer ideditorial;
	
	@Column(name = "nombreeditorial")
	private String nombreeditorial;
	
	@Column(name = "correoeditorial")
	private String correoeditorial;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "numlibros")
	private Integer numlibros;	
	
	
	public Integer getNumlibros() {
		return numlibros;
	}

	public void setNumlibros(Integer numlibros) {
		this.numlibros = numlibros;
	}

	public ConsultaView() {
		
	}

	public Integer getIdeditorial() {
		return ideditorial;
	}

	public void setIdeditorial(Integer ideditorial) {
		this.ideditorial = ideditorial;
	}

	public String getNombreeditorial() {
		return nombreeditorial;
	}

	public void setNombreeditorial(String nombreeditorial) {
		this.nombreeditorial = nombreeditorial;
	}

	public String getCorreoeditorial() {
		return correoeditorial;
	}

	public void setCorreoeditorial(String correoeditorial) {
		this.correoeditorial = correoeditorial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	

	
}
