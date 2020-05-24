package br.com.dolar.v1.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.base.entity.CotacaoBaseEntity;

@Entity(name = "dolar")
@Table(name = "TB_COTACAO_DOLAR")
public class Dolar extends CotacaoBaseEntity{

    
}