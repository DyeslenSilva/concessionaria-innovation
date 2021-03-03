package com.concessionaria.innovation.service;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.concessionaria.innovation.model.Cliente;
import com.concessionaria.innovation.repo.ClienteRepo;


public class ClienteService {
	
	@Autowired
	private ClienteRepo clienteRepo;
	
	public void save(Cliente cliente) {
		clienteRepo.save(cliente);
	}
	
	public java.util.List<Cliente> getClientes(){
		return clienteRepo.findAll().stream()
				.filter(cliente -> !cliente.isDesativado())
				.collect(Collectors.toList());
	}
	
	public Cliente getCliente(Integer idCliente) {
		return clienteRepo.findById(idCliente).orElse(null);
	}
	
	public void removeCliente(int[] lista) {
		Arrays.stream(lista).forEach(idCliente -> {
			Cliente cliente = getCliente(idCliente);
			if(cliente!=null) {
				cliente.setDesativado(true);
				clienteRepo.delete(cliente);
			}
		});
	}

}
