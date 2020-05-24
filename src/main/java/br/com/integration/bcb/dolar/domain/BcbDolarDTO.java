package br.com.integration.bcb.dolar.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.json.bind.annotation.JsonbProperty;

public class BcbDolarDTO {

    @JsonbProperty("value")
    public List<Cotacao> value;

    public static class Cotacao{
        public BigDecimal cotacaoCompra;
        public BigDecimal cotacaoVenda;
        public String dataHoraCotacao;

    }
    
    
}