package com.movit.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movit.dto.EditorialDto;
import com.movit.dto.LibroDto;
import com.movit.entity.ConsultaView;
import com.movit.entity.Direccion;
import com.movit.entity.Editorial;
import com.movit.exception.ObjectAlreadyFoundHandler;
import com.movit.exception.ObjectNotFoundExceptionHandler;
import com.movit.repository.IDireccionRepo;
import com.movit.repository.IEditorialRepo;
import com.movit.repository.IVistaRepo;
import com.movit.service.IEditorialService;






@Service
public class EditorialServiceImp implements IEditorialService{

	@Autowired
	private IEditorialRepo irepo;
	
	@Autowired
	IDireccionRepo repo;
	
	@Autowired
	IVistaRepo iir;
	
	@Override
	public void crearBD(EditorialDto editorial) {
		// TODO Auto-generated method stub
		if (irepo.findByNombre(editorial.getNombre()) != null) {
			throw new ObjectAlreadyFoundHandler("el nombre de la editorial " + editorial.getNombre() + " ya existe.");
		} else {
			if(editorial.getListaLibros() != null) {
				for(LibroDto libro : editorial.getListaLibros()) {
					libro.setEditorial(editorial);
				}
				for(LibroDto libro : editorial.getListaLibros()) {
					if(irepo.findByListaLibros_Nombre(libro.getNombre()) != null) {
						throw new ObjectAlreadyFoundHandler("este libro ya existe en la base de datos");
					}
				}
			}
			
			ModelMapper mod = new ModelMapper(); 
			Editorial di = mod.map(editorial, Editorial.class);
			di.getDireccion().setEditorial(di);
			irepo.save(di);
		}		
	}

	@Override
	public Editorial consultarIdBD(Integer id) {
		// TODO Auto-generated method stub
		Optional<Editorial> editorial = irepo.findById(id);
		return editorial.get();
	}

	@Override
	public void editarBD(Editorial editorial) {
		// TODO Auto-generated method stub
		System.out.println("nom;"+ editorial.getNombre());
		if (irepo.mayorAlgo(editorial.getId()).isEmpty()) {
			throw new ObjectNotFoundExceptionHandler("el ID proporcionado no existe en la base de datos");
		} else 
		{			
			if (irepo.existePorId(editorial.getNombre()) == null ) 
			{						
				if(editorial.getDireccion() != null) {
					
					Editorial dit = irepo.findById(editorial.getId()).get();
					System.out.println("nom;"+ dit.getNombre());
					editorial.getDireccion().setEditorial(dit);
					dit.setNombre(editorial.getNombre());
					dit.setCorreo(editorial.getCorreo());
					dit.setDireccion(editorial.getDireccion());
					irepo.save(dit);
				}
				else {
					Editorial dit = irepo.findById(editorial.getId()).get();
					dit.setNombre(editorial.getNombre());
					dit.setCorreo(editorial.getCorreo());
					irepo.save(dit);
				}				
			}
			else
			{
				if(irepo.existePorId(editorial.getNombre()).getId() == editorial.getId()) {
					 
					if(editorial.getDireccion() != null) {						
						Editorial dit = irepo.findById(editorial.getId()).get();
						editorial.getDireccion().setEditorial(dit);
						dit.setNombre(editorial.getNombre());
						dit.setCorreo(editorial.getCorreo());
						dit.setDireccion(editorial.getDireccion());
						irepo.save(dit);
					}
					else {
						Editorial dit = irepo.findById(editorial.getId()).get();
						dit.setNombre(editorial.getNombre());
						dit.setCorreo(editorial.getCorreo());
						
						irepo.save(dit);
					}
				}
				else {
					throw new ObjectAlreadyFoundHandler("el nombre de la editorial " + editorial.getNombre() + " ya existe.");
				}
			}			
		}
		
	}

	@Override
	public ArrayList<Editorial> consultarBDD() {
		// TODO Auto-generated method stub
		ArrayList<Editorial> libros = (ArrayList<Editorial>) irepo.findAll();
		return libros;
	}

	@Override
	public void eliminarBD(Integer id) {
		// TODO Auto-generated method stub
		if(irepo.findById(id) != null) {			
			irepo.deleteById(id);
		}
		else {
			throw new ObjectNotFoundExceptionHandler("ID" + id + "no existe en la base de datos");
		}
	}

	@Override
	public void eliminarexBD(Integer id) {
		// TODO Auto-generated method stub
		if(irepo.findById(id) != null) {
			Optional<Editorial> editorial = irepo.findById(id);
			if(editorial.get().getListaLibros().size() == 0) {
				irepo.deleteById(id);
			}
			else {
				throw new ObjectAlreadyFoundHandler("La editoral contiene libros que debe borrar antes.");
			}
		}
		else {
			throw new ObjectNotFoundExceptionHandler("ID" + id + "no existe en la base de datos");
		}
		
	}

	@Override
	public ArrayList<Editorial> pruSQL(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Editorial> sort1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Editorial encontrarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Direccion editarDir(Editorial di) {
		Direccion editable = new Direccion();
		
		if(di.getDireccion() != null) {
			editable = di.getDireccion();
		}
		return editable;
	}
	
	@Override
	public void editarQur(Direccion clase) {
		// TODO Auto-generated method stub
		
		if(repo.findById(clase.getId()).get().getId() == clase.getId()) {			
			repo.editarDireccion(clase.getNombre(), clase.getId());
		}
		else {
			throw new ObjectNotFoundExceptionHandler("este id no existe en la tabla direccion");
		}		
	}

	@Override
	public List<ConsultaView> consulta() {
		
		return iir.consulta();
	}

	@Override
	public ConsultaView consultaFiltro(Integer id) {
		// TODO Auto-generated method stub
		
		if(iir.consultaFiltro(id) == null) {
			throw new ObjectNotFoundExceptionHandler("No existe esta editorial en la Base de Datos");
		}
		return iir.consultaFiltro(id);
	}

}
