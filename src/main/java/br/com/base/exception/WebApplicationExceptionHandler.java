package br.com.base.exception;

import java.time.LocalDateTime;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WebApplicationExceptionHandler implements ExceptionMapper<WebApplicationException> {

	@Override
	public Response toResponse(WebApplicationException exception) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setErrorDescription(exception.getMessage());
        errorDTO.setStatusCode(exception.getResponse().getStatus());
        errorDTO.setMomentError(LocalDateTime.now());

		return Response
                .status(exception.getResponse().getStatus())
                .entity(errorDTO)
                .build();
	}

}
