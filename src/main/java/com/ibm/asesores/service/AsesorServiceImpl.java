/**
 * 
 */
package com.ibm.asesores.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.asesores.persistence.model.Asesor;
import com.ibm.asesores.persistence.repository.AsesorRepository;
import com.ibm.asesores.service.exception.ResourceNotFoundException;

/**
 * Implementacion de lo metodos necesarios para las operaciones requeridas para el servicio de Asesores
 * 
 * @author Edwin Cardona
 *
 */
@Service("asesorService")
public class AsesorServiceImpl implements AsesorService {

	@Autowired
	private AsesorRepository repository;

	@Override
	public List<Asesor> listar() {
		return repository.findAll();
	}

	@Override
	public Asesor consultar(Integer codigo) {
		Optional<Asesor> optAsesor = repository.findById(codigo);
		return optAsesor.orElseThrow(
				() -> new ResourceNotFoundException(String.format("Asesor con codigo %s no encontrado", codigo)));
	}

	@Transactional
	@Override
	public Integer insertar(@Valid Asesor objNuevo) {
		return repository.save(objNuevo).getCodigo();
	}

	@Transactional
	@Override
	public void actualizar(@Valid Asesor obj) {
		repository.save(obj);
	}

	@Transactional
	@Override
	public void eliminar(Asesor obj) {
		repository.delete(obj);
	}

	@Transactional
	@Override
	public void eliminar(Integer codigo) {
		Asesor asesor = consultar(codigo);
		eliminar(asesor);
	}

}
