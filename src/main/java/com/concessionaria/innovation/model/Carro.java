package com.concessionaria.innovation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Carro {
	
	@Id
	private String chassi;
	
	@Column
	private String modelo;
	@Column
	private String marca;
	@Column
	private int ano;
	@Column
	private double preco;
	@Column
	private boolean novo;
	@Column
	private boolean usado;
	
	private boolean disponivel;
	
	private boolean indisponivel;
}
