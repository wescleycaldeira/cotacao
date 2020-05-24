package br.com.base.entity;


import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public class CotacaoBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid", updatable = false, unique = true, nullable = false)
    private UUID uuid;

    @Version
    private Integer version;

    @Column(name = "DT_REQUISICAO", nullable = false)
    private LocalDateTime dataRequisicao;

    @Column(name = "DT_COTACAO", nullable = false)
    private LocalDate dataCotacao;

    @Column(name = "VL_COMPRA", nullable = false)
    private  BigDecimal valorCompra;

    @Column(name = "VL_VENDA", nullable = false)
    private BigDecimal valorVenda;

    @Column(name = "DTHR_COTACAO", nullable = false)
    private LocalDateTime dataHoraCotacao;


    public LocalDateTime getDataRequisicao() {
        return this.dataRequisicao;
    }

    public void setDataRequisicao(LocalDateTime dataRequisicao) {
        this.dataRequisicao = dataRequisicao;
    }

    public LocalDate getDataCotacao() {
        return this.dataCotacao;
    }

    public void setDataCotacao(LocalDate dataCotacao) {
        this.dataCotacao = dataCotacao;
    }

    public BigDecimal getValorCompra() {
        return this.valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public BigDecimal getValorVenda() {
        return this.valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public LocalDateTime getDataHoraCotacao() {
        return this.dataHoraCotacao;
    }

    public void setDataHoraCotacao(LocalDateTime dataHoraCotacao) {
        this.dataHoraCotacao = dataHoraCotacao;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CotacaoBaseEntity that = (CotacaoBaseEntity) o;
        return uuid.equals(that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
