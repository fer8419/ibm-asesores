/**
 * 
 */
package com.ibm.asesores.service.exception;

/**
 * Excepcion padre de la aplicacion
 * 
 * @author Edwin Cardona
 *
 */
public class IbmAsesorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IbmAsesorException(String msg, Throwable t) {
		super(msg, t);
	}

	public IbmAsesorException(String msg) {
		super(msg);
	}

	public IbmAsesorException(Throwable t) {
		super(t);
	}

}
