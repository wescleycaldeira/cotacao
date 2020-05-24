package br.com.integration.bcb.dolar.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.integration.bcb.dolar.domain.BcbDolarDTO;

@RegisterRestClient
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface BcbDolarClient {

    @GET
    @Path("/CotacaoDolarDia(dataCotacao=@dataCotacao)")
    @Retry(
        maxRetries = 3,
        maxDuration = 5000,
        delay = 500 ,
        jitter = 200
    )
    BcbDolarDTO consultarCotacao(@QueryParam("@dataCotacao") String dataConsulta);
}