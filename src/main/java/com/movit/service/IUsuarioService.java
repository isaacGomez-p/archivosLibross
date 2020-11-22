package com.movit.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.movit.entity.Usuario;


public interface IUsuarioService extends AbstractService<Usuario, Integer, Usuario>, UserDetailsService {
	
	

}
