package com.concessionaria.innovation.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table
public class Aluguel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAluguel;
	
	@Column
	private String nomeCliente;
	
	@Column
	private String descricaoAluguel;
	
	@Column
	private String modeloDoCarro;
	
	@Column
	private String marcaVeiculo;
	
	@Column
	private double valorAluguel;
	
	@Column
	private int tempoDeLocacao;
	
	private boolean ativado;
	
	private boolean desativado;
	
}
