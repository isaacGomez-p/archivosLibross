package com.movit.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.movit.dto.EditorialDto;
import com.movit.entity.ConsultaView;
import com.movit.entity.Direccion;
import com.movit.entity.Editorial;
import com.movit.service.IEditorialService;

import io.swagger.annotations.ApiOperation;

@PreAuthorize("hasAuthority('cliente')")
@Controller
@RestController
@RequestMapping("/editoriales")
public class EditorialController {

	@Autowired
	IEditorialService aservicio;	
	
	
	@PutMapping("/editarQuery")
	@ApiOperation(value = "Actualiza los datos de la direccion que se requiera en BD")
	public ResponseEntity editarDir(@Valid  @RequestBody Direccion dir){
		aservicio.editarQur(dir);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	@PostMapping("/insertarBD")
	@ApiOperation(value="Metodo que inserta una Editorial a la BD")
	public ResponseEntity crearPst(@Valid @RequestBody EditorialDto libro){
		aservicio.crearBD(libro);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@GetMapping("/consultaBDD")
	@ApiOperation(value = "Retonar todos los libros en la BD")
	public ResponseEntity<ArrayList<Editorial>>consultaBDD(){
		return new ResponseEntity<ArrayList<Editorial>>(aservicio.consultarBDD(), HttpStatus.OK);
	}
	
	@GetMapping("/consultaporid/{id}")
	public ResponseEntity<Editorial> pruebas(@PathVariable int id){
		return new ResponseEntity<Editorial>(aservicio.consultarIdBD(id), HttpStatus.OK);
	}
	
	@PutMapping("/editarBDD")
	@ApiOperation(value = "Actualiza los datos del libro que se requiera n BD")
	public ResponseEntity editarBDD(@Valid  @RequestBody Editorial libro){
		aservicio.editarBD(libro);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@DeleteMapping("/borarrBDD/{id}")
	public ResponseEntity borrarBDD(@PathVariable @Min(value = 0, message = "No existen valores menores a 0") int id) {
		aservicio.eliminarBD(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/borarrexBDD/{id}")
	public ResponseEntity borrar1BDD(@PathVariable @Min(value = 0, message = "No existen valores menores a 0") int id) {
		aservicio.eliminarexBD(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/consultaVista")
	@ApiOperation(value = "Retonar ")
	public ResponseEntity<List<ConsultaView>>consultaVista(){
		return new ResponseEntity<List<ConsultaView>>(aservicio.consulta(), HttpStatus.OK);
	}
	
	@GetMapping("/consultaVistaFiltro/{id}")
	@ApiOperation(value = "Retonar ")
	public ResponseEntity<ConsultaView>consultaVistaFiltro(@PathVariable int id){
		return new ResponseEntity<ConsultaView>(aservicio.consultaFiltro(id), HttpStatus.OK);
	}
}
