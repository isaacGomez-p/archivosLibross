package com.movit.service;

import java.util.ArrayList;
import java.util.List;

import com.movit.dto.EditorialDto;
import com.movit.entity.ConsultaView;
import com.movit.entity.Direccion;
import com.movit.entity.Editorial;


public interface IEditorialService extends AbstractService<Editorial, Integer, EditorialDto>{
	
	public void eliminarexBD(Integer id);

	public ArrayList<Editorial> pruSQL(Integer id);

	public ArrayList<Editorial> sort1();
	
	public Editorial encontrarPorNombre(String nombre);

	void editarQur(Direccion clase);
	
	public List<ConsultaView> consulta();
	
	public ConsultaView consultaFiltro(Integer id);

}
