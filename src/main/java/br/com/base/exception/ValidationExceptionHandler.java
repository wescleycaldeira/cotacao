package br.com.base.exception;

import java.time.LocalDateTime;

import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ValidationExceptionHandler implements ExceptionMapper<ValidationException>{

	@Override
	public Response toResponse(ValidationException exception) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setErrorDescription(exception.getMessage());
        errorDTO.setStatusCode(Status.BAD_REQUEST.getStatusCode());
        errorDTO.setMomentError(LocalDateTime.now());

		return Response
                .status(Status.BAD_REQUEST)
                .entity(errorDTO)
                .build();
    
	}
    
}