package com.movit.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movit.entity.Direccion;

@Repository
public interface IDireccionRepo extends JpaRepository<Direccion, Integer>{
	
	@Query(value="UPDATE direccion SET nombre = ?1 where id = ?2", nativeQuery = true)
    @Modifying
    @Transactional
    public void editarDireccion(String nombre, Integer id);
	
	Direccion findByEditorial_Id(int id);
	
	Direccion findById(int i);
	

}
