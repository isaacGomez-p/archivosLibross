package com.movit.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movit.entity.Libro;
import com.movit.service.AbstractService;
import com.movit.service.ILibroService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@PreAuthorize("hasAuthority('admin')")
@Controller
@RestController
@RequestMapping("/libros")
@Api(value = "Microservicio de libros", description = "CRUD para los libros")
public class LibroController {
	
	@Autowired
	ILibroService servicio;		
	
	@GetMapping("/consultar")
	@ApiOperation(value = "Retorna todos los libros")
	public ResponseEntity<ArrayList<Libro>> consultar() {
		return new ResponseEntity<ArrayList<Libro>>(servicio.consultar(), HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	@ApiOperation(value = "Ingresa un libro al registro")
	public ResponseEntity<Libro> crear(@Valid @RequestBody Libro libro){
		servicio.crear(libro);
		return new ResponseEntity<Libro>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ApiOperation(value = "Borra del registro al id del libro que se haya ingresado")
	public ResponseEntity eliminar(@PathVariable int id){
		servicio.eliminar(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/editar")
	@ApiOperation(value = "Actualiza los datos del libro que se requiera")
	public ResponseEntity editar(@Valid  @RequestBody Libro libro){
		servicio.editar(libro);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PostMapping("/crearBD")
	@ApiOperation(value = "Ingresa un libro al registro en la Base de datos")
	public ResponseEntity<Libro> insertarBD(@Valid @RequestBody Libro libro) throws SQLException{
		servicio.insertarBD(libro);
		return new ResponseEntity<Libro>(HttpStatus.CREATED);
	}
	
	@GetMapping("/consultarBD")
	@ApiOperation(value = "Retorna todos los libros de la Base de datos")
	public ResponseEntity<ArrayList<Libro>> consultarBD() throws SQLException {
		return new ResponseEntity<ArrayList<Libro>>(servicio.consultarBD(), HttpStatus.OK);
	}	
	
	/* BD spring data */
	
	@PostMapping("/insertarBD")
	@ApiOperation(value="Metodo que inserta un libro a la BD")
	public ResponseEntity crearPst(@Valid @RequestBody Libro libro){
		servicio.crearBD(libro);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@GetMapping("/consultaBDD")
	@ApiOperation(value = "Retonar todos los libros en la BD")
	public ResponseEntity<ArrayList<Libro>>consultaBDD(){
		return new ResponseEntity<ArrayList<Libro>>(servicio.consultarBDD(), HttpStatus.OK);
	}
	
	@DeleteMapping("/borarrBDD/{id}")
	public ResponseEntity borrarBDD(@PathVariable @Min(value = 0, message = "No existen valores menores a 0") int id) {
		servicio.eliminarBD(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/consultapru/{id}")
	public ResponseEntity<ArrayList<Libro>> pruebas(@PathVariable int id){
		return new ResponseEntity<ArrayList<Libro>>(servicio.pruSQL(id), HttpStatus.OK);
	}
	
	@PutMapping("/editarBDD")
	@ApiOperation(value = "Actualiza los datos del libro que se requiera n BD")
	public ResponseEntity editarBDD(@Valid  @RequestBody Libro libro){
		servicio.editarBD(libro);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("/consultarsort")
	@ApiOperation(value = "Trae los libros organizados por nombre")
	public ResponseEntity<ArrayList<Libro>> sort1(){		
		return new ResponseEntity<ArrayList<Libro>>(servicio.sort1(),HttpStatus.OK);
	}
	
	@GetMapping("/encontrarNombre/{nombre}")
	public ResponseEntity<Libro> encontrarNombre(@PathVariable String nombre){
		return new ResponseEntity<Libro>(servicio.encontrarPorNombre(nombre), HttpStatus.OK);
	}
	
	
}
