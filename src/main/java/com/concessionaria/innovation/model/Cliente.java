package com.concessionaria.innovation.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	
	@Column
	private String tipoCliente;
	
	
	@Column
	private String nomeCliente;
	
		
	@Column
	private String endereco;
	
	private boolean ativado;
	private boolean desativado;
}
