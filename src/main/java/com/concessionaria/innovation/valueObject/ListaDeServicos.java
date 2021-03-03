package com.concessionaria.innovation.valueObject;

import lombok.Data;

@Data
public class ListaDeServicos {
	private int idCliente;
	private com.concessionaria.innovation.model.Servico servico[];
}
