package br.com.dolar.v1.boundary;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.com.dolar.v1.application.DolarApplication;
import br.com.dolar.v1.domain.DolarDTO;


@Path(DolarRest.PATH_COTACAO_DOLAR)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DolarRest{

    public static final String PATH_COTACAO_DOLAR = "v1/dolar";
    public static final String QUERY_PARAM_DOLAR = "data";

    @Inject
    DolarApplication dolarApplication;

    @GET
    @Operation(summary = "Consulta Cotacao Dolar", description = "Consultar cotação dolar de acordo com a data selecionada")
    @APIResponse(responseCode = "400", description = "Data preenchida de forma incorreta")
    @APIResponse(description = "Cotação Dolar", 
                                content = @Content(mediaType = MediaType.APPLICATION_JSON,
                                        schema = @Schema(implementation = DolarDTO.class)
                                )
    )
    public Response consultarCotacaoDolarDia(@QueryParam(QUERY_PARAM_DOLAR) String data){
        DolarDTO dolarDTO =  dolarApplication.consultarCotacao(data);
        
        return Response.ok(dolarDTO).build();
    }
    
}