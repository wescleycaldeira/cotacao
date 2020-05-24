package br.com.base.exception;

import javax.ws.rs.core.Response;

public class ApiException extends Exception {

  private static final long serialVersionUID = 1L;
  private Response response;

  public ApiException() {
    super();
  }

  public ApiException(Response response) {
    super("Erro ao consultar serviço externo. Status code: " + response.getStatus());
    this.response = response;
  }

  public Response getResponse() {
    return this.response;
  }
}
