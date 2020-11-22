package com.movit.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movit.entity.Libro;
import com.movit.entity.Usuario;
import com.movit.service.IUsuarioService;

import io.swagger.annotations.ApiOperation;

@Controller
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	IUsuarioService servicio;
	
	@GetMapping("/consultar")
	@ApiOperation(value = "Retorna todos los libros")
	public ResponseEntity<ArrayList<Usuario>> consultar() {
		return new ResponseEntity<ArrayList<Usuario>>(servicio.consultarBDD(), HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	@ApiOperation(value = "Ingresa un libro al registro")
	public ResponseEntity<Usuario> crear(@Valid @RequestBody Usuario usuario){
		servicio.crearBD(usuario);
		return new ResponseEntity<Usuario>(HttpStatus.CREATED);
	}
}
