package com.movit.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.crypto.generators.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.movit.entity.Usuario;
import com.movit.exception.ObjectAlreadyFoundHandler;
import com.movit.exception.ObjectNotFoundExceptionHandler;
import com.movit.repository.IUsuarioRepo;
import com.movit.service.IUsuarioService;

@Service
public class UsuarioServiceImp implements IUsuarioService {

	@Autowired
	IUsuarioRepo irepo;
	
	@Autowired
	private BCryptPasswordEncoder byc;
	
	@Override
	public void crearBD(Usuario clase) {
		// TODO Auto-generated method stub
		if (irepo.findByDocumento(clase.getDocumento()) != null) {
			throw new ObjectAlreadyFoundHandler("este documento ya esta registrado " + clase.getNombre() + " ya existe.");
		} else {
			clase.setClave(byc.encode(clase.getClave()));
			irepo.save(clase);
		}
	}

	@Override
	public Usuario consultarIdBD(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editarBD(Usuario clase) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Usuario> consultarBDD() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarBD(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserDetails loadUserByUsername(String nick) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario us = irepo.findByNick(nick);
		if(us == null) {
			throw new ObjectNotFoundExceptionHandler("Nick o contraseña incorrectos");			
		}
		if(us.isEstado() == false) {
			throw new ObjectAlreadyFoundHandler("Usuario no habilitado");
		}
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(us.getRol().getNombre()));
		
		UserDetails udt = new User(us.getNick(), us.getClave(), roles);
		return udt;
	}

}
