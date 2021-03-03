package com.concessionaria.innovation.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table
public class Vendas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVendas;
	
	@Column
	private String descricaoVenda;
	
	@Column
	private double valorVenda;
	
	@Column
	private int parcelas;

	@Column
	private double valorParcela;
	
	@Column
	private Cliente nomeCliente;
	
	@Column
	private Cliente endereco;
	

	private boolean ativado,desativada;
}