package com.concessionaria.innovation.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Data
public class Servico {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idServico;
	
	private String nome;
	private boolean desativado;
	
	@Transient
	private boolean selecionado;
}
