package com.movit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movit.entity.Usuario;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{

	Object findByDocumento(String documento);

	Usuario findByNick(String nick);
	
	

}
