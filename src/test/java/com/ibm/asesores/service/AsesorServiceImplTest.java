package com.ibm.asesores.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ibm.asesores.persistence.model.Asesor;
import com.ibm.asesores.persistence.repository.AsesorRepository;
import com.ibm.asesores.service.exception.ResourceNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class AsesorServiceImplTest {

	@Mock
	private AsesorRepository repository;
	@InjectMocks
	private AsesorServiceImpl service;

	@Test
	public void listarTest() {
		Mockito.when(repository.findAll()).thenReturn(obtenerLista());

		List<Asesor> asesores = service.listar();

		Assert.assertNotNull(asesores);
		Assert.assertFalse(asesores.isEmpty());
	}
	
	@Test
	public void consultarTest() {
		int codigo = 1;
		Optional<Asesor> optAsesor = Optional.of(crearAsesor());
		Mockito.when(repository.findById(codigo)).thenReturn(optAsesor);

		Asesor asesor = service.consultar(codigo);

		Assert.assertNotNull(asesor);
		Assert.assertEquals(codigo, asesor.getCodigo());
	}
	
	@Test(expected = ResourceNotFoundException.class)
	public void consultarErrorTest() {
		int codigo = 2;
		Optional<Asesor> optAsesor = Optional.empty();
		Mockito.when(repository.findById(codigo)).thenReturn(optAsesor);

		service.consultar(codigo);
	}

	private List<Asesor> obtenerLista() {
		List<Asesor> asesores = new ArrayList<>(1);		
		asesores.add(crearAsesor());
		return asesores;
	}

	private Asesor crearAsesor() {
		Asesor asesor = new Asesor();
		asesor.setCodigo(1);
		asesor.setEspecialidad("Especialidad A");
		asesor.setNombre("Asesor 1");
		return asesor;
	}
}
