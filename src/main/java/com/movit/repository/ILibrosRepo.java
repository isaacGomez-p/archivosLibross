package com.movit.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movit.entity.Libro;

@Repository

public interface ILibrosRepo extends JpaRepository<Libro, Integer>{
	
	@Query(value = "SELECT l FROM Libro l WHere l.id = ?1")
	Collection<Libro> mayorAlgo(Integer id);
	
	@Query(value = "SELECT l FROM Libro l WHere l.nombre = ?1 ")
	Libro existePorId(String nombre);
	
	Libro findByNombreIgnoreCase(String nombre);	

	

}
