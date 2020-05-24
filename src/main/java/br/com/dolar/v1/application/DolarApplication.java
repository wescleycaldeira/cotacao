package br.com.dolar.v1.application;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.base.assertion.AssertionUtil;
import br.com.base.exception.BusinessException;
import br.com.dolar.v1.domain.Dolar;
import br.com.dolar.v1.domain.DolarDTO;
import br.com.integration.bcb.dolar.client.BcbDolarClient;
import br.com.integration.bcb.dolar.domain.BcbDolarDTO;

@ApplicationScoped
public class DolarApplication {

    public static final String PATTERN_MM_DD_YYYY = "MM-dd-yyyy";
    public static final String MSG_DATA_SUPERIOR_ATUAL = "Data superior ao dia atual.";
    public static final String MSG_DATA_OBRIGATORIO = "Data é obrigatório";
    public static final String MSG_DATA_INVALIDA = "Data Inválida";

    @Inject
    private EntityManager entityManager;

    @Inject
    @RestClient
    BcbDolarClient bcbDolarClient;

    @Transactional
    public DolarDTO consultarCotacao(String data){
        validarData(data);
        BcbDolarDTO bcbDto =  bcbDolarClient.consultarCotacao(formatarData(data));

        return salvarCotacao(bcbDto);
    }

    private String formatarData(String data) {
		return "'"+data+"'";
	}

	private DolarDTO salvarCotacao(BcbDolarDTO bcbDto) {
        AssertionUtil.isTrue(bcbDto.value.isEmpty(), "Erro ao consultar serviço BCB");

        BcbDolarDTO.Cotacao dto =  bcbDto.value.get(0);

        Dolar dolar = new Dolar();
        dolar.setDataHoraCotacao(LocalDateTime.now());
        dolar.setDataCotacao(LocalDate.now());
        dolar.setDataRequisicao(LocalDateTime.parse(dto.dataHoraCotacao, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        dolar.setValorCompra(dto.cotacaoCompra);
        dolar.setValorVenda(dto.cotacaoVenda);

        entityManager.persist(dolar);

        return new DolarDTO(dto.cotacaoVenda, dto.cotacaoCompra);
	}

	public void validarData(String data) {
        try{
            AssertionUtil.isTrue(StringUtils.isEmpty(data), MSG_DATA_OBRIGATORIO);
            LocalDate dataConsulta = LocalDate.parse(data, DateTimeFormatter.ofPattern(PATTERN_MM_DD_YYYY));
            AssertionUtil.isTrue(dataConsulta.isAfter(LocalDate.now()), MSG_DATA_SUPERIOR_ATUAL);
        }catch (DateTimeParseException e){
            throw new BusinessException(MSG_DATA_INVALIDA, Status.BAD_REQUEST);
        }
    }
    
}