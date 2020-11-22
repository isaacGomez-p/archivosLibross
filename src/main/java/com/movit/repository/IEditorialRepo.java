package com.movit.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movit.entity.Editorial;

@Repository
public interface IEditorialRepo extends JpaRepository<Editorial, Integer> {

	Editorial findByNombre(String nombre);	
	
	@Query(value = "SELECT l FROM Editorial l WHere l.id = ?1")
	Collection<Editorial> mayorAlgo(Integer id);
	
	@Query(value = "SELECT l FROM Editorial l WHere l.nombre = ?1")
	Editorial existePorId(String nombre);
	
	Editorial findByNombreIgnoreCase(String nombre);
	
	Editorial findByListaLibros_Nombre(String nombre);	
	
	

}
