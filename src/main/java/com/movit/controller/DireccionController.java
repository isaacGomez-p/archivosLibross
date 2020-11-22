package com.movit.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movit.entity.Direccion;
import com.movit.service.IDireccionService;

import io.swagger.annotations.ApiOperation;

@Controller
@RestController
@RequestMapping("/direcciones")
public class DireccionController {
	
	@Autowired
	IDireccionService servicio;
	
	@PutMapping("/editarQuery")
	@ApiOperation(value = "Actualiza los datos de la direccion que se requiera en BD")
	public ResponseEntity editarBDD(@Valid  @RequestBody Direccion dir){
		servicio.editarBD(dir);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PutMapping("/editarSave")
	@ApiOperation(value = "Actualiza los datos de la direccion que se requiera en BD")
	public ResponseEntity editarSave(@Valid  @RequestBody Direccion dir){
		servicio.editarSave(dir);
		return new ResponseEntity(HttpStatus.OK);
	}
}
