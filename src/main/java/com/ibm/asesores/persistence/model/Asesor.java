/**
 * 
 */
package com.ibm.asesores.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Entidad para el modelo Asesor
 * 
 * @author Edwin Cardona
 *
 */
@Entity
@Table(name = "ASE_ASESORES")
public class Asesor implements GenericEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IN_CODIGO", unique = true, nullable = false)
	private int codigo;

	@NotEmpty
	@Size(max = 50)
	@Column(name = "NV_NOMBRE", nullable = false, length = 50)
	private String nombre;

	@NotEmpty
	@Size(max = 50)
	@Column(name = "NV_ESPECIALIDAD", nullable = false, length = 50)
	private String especialidad;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

}
