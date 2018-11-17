/**
 * 
 */
package com.ibm.asesores.persistence.repository;

import org.springframework.stereotype.Repository;

import com.ibm.asesores.persistence.model.Asesor;

/**
 * Repositorio de para operaciones de acceso a datos para la entidad
 * {@link Asesor}
 * 
 * @author Edwin Cardona
 *
 */
@Repository
public interface AsesorRepository extends GenericRepository<Asesor, Integer> {

}
