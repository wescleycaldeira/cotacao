package br.com.dolar;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import br.com.base.exception.BusinessException;
import br.com.dolar.v1.application.DolarApplication;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class DolarApplicationTest {

    @Inject
    DolarApplication dolarApplication;

    @Test
    public void validarDataIncorreta(){
        String dataIncorreta = "13-05-2020";

        Exception ex = assertThrows(BusinessException.class, () -> {
            dolarApplication.validarData(dataIncorreta);
        });

        assertTrue(DolarApplication.MSG_DATA_INVALIDA.contains(ex.getMessage()));
    }

    @Test
    public void validarDataSuperiorAtual(){
        LocalDate dataIncorreta = LocalDate.now().plusDays(4);
        String dataIncorretaFormato = dataIncorreta.format(DateTimeFormatter.ofPattern(DolarApplication.PATTERN_MM_DD_YYYY));

        Exception ex = assertThrows(BusinessException.class, () -> {
            dolarApplication.validarData(dataIncorretaFormato);
        });

        assertTrue(DolarApplication.MSG_DATA_SUPERIOR_ATUAL.contains(ex.getMessage()));
    }

    @Test
    public void validarDataEmBranco(){
        Exception ex = assertThrows(BusinessException.class, () -> {
            dolarApplication.validarData(StringUtils.EMPTY);
        });

        assertTrue(DolarApplication.MSG_DATA_OBRIGATORIO.contains(ex.getMessage()));
    }
    
}