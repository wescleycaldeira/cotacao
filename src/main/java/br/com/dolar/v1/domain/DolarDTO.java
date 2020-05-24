package br.com.dolar.v1.domain;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "Dolar", description = "Retorno consulta cotação dolar")
public class DolarDTO {

    @Schema(required = true, description = "Valor de venda")
    public BigDecimal valorVenda;

    @Schema(required = true, description = "Valor de compra")
    public BigDecimal valorCompra;


    public DolarDTO() {
    }

    public DolarDTO(@NotNull BigDecimal valorVenda, 
                                @NotNull BigDecimal valorCompra) {

        this.valorVenda = valorVenda;
        this.valorCompra = valorCompra;
    }    

    public BigDecimal getValorVenda() {
        return this.valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public BigDecimal getValorCompra() {
        return this.valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    
}