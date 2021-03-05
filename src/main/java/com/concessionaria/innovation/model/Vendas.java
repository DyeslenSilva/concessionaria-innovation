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
	
	private Carro modeloCarro;
	
	
	
	@Column
	private double valorVenda;
	
	
	@Column
	private int parcelas;

	@Column
	private double valorParcela;
	
	
	private double entrada;
	private double valorEntrada;
	private double valorAposEntrada;
	
	@Column
	private Cliente nomeCliente;
	
	@Column
	private Cliente endereco;
	
	private Cliente rg,cpf;
	private Cliente telefone;

	private boolean ativado,desativada;
}