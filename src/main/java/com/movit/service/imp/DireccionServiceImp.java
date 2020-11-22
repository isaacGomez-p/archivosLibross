package com.movit.service.imp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movit.entity.Direccion;
import com.movit.exception.ObjectAlreadyFoundHandler;
import com.movit.exception.ObjectNotFoundExceptionHandler;
import com.movit.repository.IDireccionRepo;
import com.movit.service.IDireccionService;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class DireccionServiceImp implements IDireccionService{

	@Autowired
	IDireccionRepo irepo;
	
	@Override
	public void crearBD(Direccion clase) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Direccion consultarIdBD(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editarBD(Direccion clase) {
	
	}

	@Override
	public ArrayList<Direccion> consultarBDD() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarBD(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editarSave(Direccion direccion) {
		
	}
}
