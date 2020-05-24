package br.com.base.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class BusinessException extends WebApplicationException {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException(String message, Response.Status status) throws IllegalArgumentException {
        super(message, status);
    }
}
