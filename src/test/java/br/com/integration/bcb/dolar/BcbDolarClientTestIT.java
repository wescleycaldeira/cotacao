package br.com.integration.bcb.dolar;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;

import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import br.com.integration.bcb.dolar.client.BcbDolarClient;
import br.com.integration.bcb.dolar.domain.BcbDolarDTO;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class BcbDolarClientTestIT {

    @Inject
    @RestClient
    BcbDolarClient bcbDolarClient;

    @Test
    public void testIntegracaoBcb(){
        String dataConsulta = "'05-22-2020'";

        BcbDolarDTO dto =  bcbDolarClient.consultarCotacao(dataConsulta);

        assertFalse(dto.value.isEmpty());
        assertTrue(Objects.nonNull(dto.value.get(0).cotacaoCompra));
        assertTrue(Objects.nonNull(dto.value.get(0).cotacaoVenda));
    }

    @Test
    public void testIntegracaoBcbDataFinalDeSemana(){
        String dataFinalDeSemana = "'05-23-2020'";
        
        BcbDolarDTO dto =  bcbDolarClient.consultarCotacao(dataFinalDeSemana);

        assertTrue(Objects.nonNull(dto));
        assertTrue(dto.value.isEmpty());
    }
    
}