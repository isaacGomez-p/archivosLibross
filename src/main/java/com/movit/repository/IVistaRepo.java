package com.movit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movit.entity.ConsultaView;



@Repository
public interface IVistaRepo extends JpaRepository<ConsultaView, Integer> {
	
	@Query(value = "select * from consultaview", nativeQuery = true)
	List<ConsultaView> consulta();
	
	@Query(value = "select * from consultaview where ideditorial = ?1", nativeQuery = true)
	ConsultaView consultaFiltro(Integer id);

	
	
}
