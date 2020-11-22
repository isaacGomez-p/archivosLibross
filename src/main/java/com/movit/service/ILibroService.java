package com.movit.service;


import java.sql.SQLException;
import java.util.ArrayList;

import com.movit.dto.EditorialDto;
import com.movit.dto.LibroDto;
import com.movit.entity.Editorial;
import com.movit.entity.Libro;

public interface ILibroService extends AbstractService<Libro, Integer, Libro>{
	
	public void crear(Libro libro);
	
	public void editar(Libro libro);
	
	public ArrayList<Libro> consultar();
	
	public void eliminar(int id);
	
	public void insertarBD(Libro libro) throws SQLException;
	
	public ArrayList<Libro> consultarBD() throws SQLException;
	
	
	
	

	public ArrayList<Libro> pruSQL(int id);

	public ArrayList<Libro> sort1();
	
	public Libro encontrarPorNombre(String nombre);
}
