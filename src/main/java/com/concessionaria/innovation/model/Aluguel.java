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
	private String nomeVeiculo;
	
	@Column
	private String marcaVeiculo;
	
	@Column
	private double valorAluguel;
	
	private boolean ativado;
	
	
}
