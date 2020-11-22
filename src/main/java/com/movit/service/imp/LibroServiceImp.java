package com.movit.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.movit.dto.LibroDto;
import com.movit.entity.Editorial;
import com.movit.entity.Libro;
import com.movit.exception.ObjectAlreadyFoundHandler;
import com.movit.exception.ObjectNotFoundExceptionHandler;
import com.movit.repository.ILibrosRepo;
import com.movit.repository.LibroRepo;
import com.movit.repository.LibroRepoBD;
import com.movit.service.AbstractService;
import com.movit.service.ILibroService;

@Service
public class LibroServiceImp implements ILibroService {

	@Autowired
	private ILibrosRepo irepo;

	/*@Override
	public ArrayList<Libro> consultar() {
		ArrayList<Libro> listaCompleta = new ArrayList<>();
		listaCompleta = repo.consultar();
		if (listaCompleta.isEmpty()) {
			throw new ObjectNotFoundExceptionHandler("No hay libros registrados en el momento");
		} else {
			return listaCompleta;
		}
	}

	@Override
	public void crear(Libro libro) {
		ArrayList<Libro> listaCompleta = repo.consultar();
		repo.crear(libro);
		if (listaCompleta.isEmpty()) {
			repo.crear(libro);
		}
		/*
		 * else { for(Libro l : listaCompleta) { if(l.getId() == libro.getId()) { throw
		 * new ObjectAlreadyFoundHandler("Id (" + libro.getId() +
		 * ") del libro ya registrada"); } }
		 * 
		 * }
		 *

	}

	@Override
	public void editar(Libro libro) {
		boolean flag = false;
		ArrayList<Libro> listaeditable = repo.consultar();
		Iterator<Libro> recorrer = listaeditable.iterator();
		while (recorrer.hasNext()) {
			Libro ind = recorrer.next();
			if (ind.getId() == libro.getId()) {
				recorrer.remove();
				flag = !flag;
			}
		}
		if (flag == true) {
			listaeditable.add(libro);
			repo.editar(listaeditable);
		} else {
			throw new ObjectNotFoundExceptionHandler("Id " + libro.getId() + "no encontrado");
		}
	}

	@Override
	public void eliminar(int id) {
		boolean flag = false;
		ArrayList<Libro> listaBorrar = repo.consultar();
		Iterator<Libro> recorrer = listaBorrar.iterator();

		while (recorrer.hasNext()) {
			Libro ind = recorrer.next();
			if (ind.getId() == id) {
				recorrer.remove();
				flag = !flag;
			}
		}
		if (flag == false) {
			throw new ObjectNotFoundExceptionHandler("Id " + id + "no encontrado");
		}
		repo.editar(listaBorrar);
	}

	@Override
	public void insertarBD(Libro libro) throws SQLException {

		repoBD.insertarBD(libro);
	}

	@Override
	public ArrayList<Libro> consultarBD() throws SQLException {
		// TODO Auto-generated method stub
		return repoBD.consultarBD();
	}*/

	@Override
	public void crearBD(Libro libro) {
		// TODO Auto-generated method stub
		if (irepo.existePorId(libro.getNombre()) != null) {
			throw new ObjectAlreadyFoundHandler("el nombre del libro " + libro.getNombre() + " ya existe.");
		} else {
			irepo.save(libro);
		}
	}
	
	@Override
	public Libro consultarIdBD(Integer id) {
		// TODO Auto-generated method stub
		Optional<Libro> libro = irepo.findById(id);
		return libro.get();
	}

	@Override
	public void editarBD(Libro libro) {
		// TODO Auto-generated method stub
		if (irepo.mayorAlgo(libro.getId()).isEmpty()) {
			throw new ObjectNotFoundExceptionHandler("el ID proporcionado no existe en la base de datos");
		} else 
		{			
			if (irepo.existePorId(libro.getNombre()) == null ) 
			{				
				irepo.save(libro);
			}
			else
			{
				if(irepo.existePorId(libro.getNombre()).getId() == libro.getId()) {
					irepo.save(libro);
				}
				else {
					throw new ObjectAlreadyFoundHandler("el nombre del libro " + libro.getNombre() + " ya existe.");
				}
			}
			
		}
	}

	@Override
	public ArrayList<Libro> consultarBDD() {
		// TODO Auto-generated method stub
		ArrayList<Libro> libros = (ArrayList<Libro>) irepo.findAll();
		return libros;
	}

	@Override
	public void eliminarBD(Integer id) {
		// TODO Auto-generated method stub
		
		irepo.deleteById(id);
	}

	@Override
	public ArrayList<Libro> pruSQL(int id) {
		// TODO Auto-generated method stub
		if(irepo.mayorAlgo(id).isEmpty()) {
			throw new ObjectNotFoundExceptionHandler("Libro no encontrado en la BD");
		}
		return (ArrayList<Libro>) irepo.mayorAlgo(id);
	}
	
	@Override
	public ArrayList<Libro> sort1() {
		// TODO Auto-generated method stub		
		return (ArrayList<Libro>) irepo.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
	}

	@Override
	public Libro encontrarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return irepo.findByNombreIgnoreCase(nombre);
	}

	@Override
	public void crear(Libro libro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(Libro libro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Libro> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertarBD(Libro libro) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Libro> consultarBD() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


		
}
