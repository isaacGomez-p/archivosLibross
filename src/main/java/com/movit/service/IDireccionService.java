package com.movit.service;

import com.movit.entity.Direccion;

public interface IDireccionService extends AbstractService<Direccion, Integer, Direccion>{
	
	public void editarSave(Direccion direccion);
	
}
