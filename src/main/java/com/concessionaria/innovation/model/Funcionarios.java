package com.concessionaria.innovation.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table
public class Funcionarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFuncionario;
	
	@Column
	private String nomeDoFuncionario;
	
	@Column
	private String rg;
	
	@Column
	private String cpf;
	
	@Column
	private String enderecoDoFuncionario;
	
	@Column
	private String telefoneDoFuncionario;
	
	@Column
	private String cidade;
	
	@Column
	private String estado;
	
	private boolean ativado, desativado;

}