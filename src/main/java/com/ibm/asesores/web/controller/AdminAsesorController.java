/**
 * 
 */
package com.ibm.asesores.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.asesores.persistence.model.Asesor;
import com.ibm.asesores.service.AsesorService;

/**
 * Controlador rest para el servicio de asesores
 * 
 * @author Edwin Cardona
 *
 */
@RestController
@RequestMapping("/ibm-asesores/api")
@CrossOrigin
public class AdminAsesorController {

	@Autowired
	private AsesorService asesorService;

	/**
	 * Listar asesores
	 * 
	 * @return lista de tipo {@link Asesor} y status http
	 */
	@GetMapping("/asesor")
	public ResponseEntity<List<Asesor>> listarAsesores() {
		return new ResponseEntity<>(asesorService.listar(), HttpStatus.OK);
	}

	/**
	 * Consultar asesor por codigo
	 * 
	 * @return objeto tipo {@link Asesor} y status http
	 */
	@GetMapping("/asesor/{codigo}")
	public ResponseEntity<Asesor> consultarAsesor(@PathVariable Integer codigo) {
		return new ResponseEntity<>(asesorService.consultar(codigo), HttpStatus.OK);
	}

	/**
	 * Insertar nuevo asesor
	 * 
	 * @param asesor datos del {@link Asesor}
	 * @return https status de la operacion
	 */
	@PostMapping("/asesor")
	public ResponseEntity<HttpStatus> crearAsesor(@Valid @RequestBody Asesor asesor) {
		asesorService.insertar(asesor);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/**
	 * Actualizar asesor
	 * 
	 * @param asesor datos del {@link Asesor}
	 * @return https status de la operacion
	 */
	@PutMapping("/asesor")
	public ResponseEntity<HttpStatus> actualizarAsesor(@Valid @RequestBody Asesor asesor) {
		asesorService.actualizar(asesor);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Eliminar asesor
	 * 
	 * @param codigo codigo del asesor
	 * @return ResponseEntity<HttpStatus> status
	 */
	@DeleteMapping("/asesor/{codigo}")
	public ResponseEntity<HttpStatus> eliminarAsesor(@PathVariable Integer codigo) {
		asesorService.eliminar(codigo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
