package com.concessionaria.innovation.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concessionaria.innovation.model.Vendas;
import com.concessionaria.innovation.repo.VendasRepo;

@Service
public class VendasService {

	@Autowired
	private VendasRepo vendasRepo;
	
	public void save(Vendas vendas) {
		vendasRepo.save(vendas);
	}
	
	public List<Vendas> getVendas(){
		return vendasRepo.findAll().stream()
				.collect(Collectors.toList());
	}
	
	public Vendas getVenda(Integer idVenda) {
		return vendasRepo.findById(idVenda).orElse(null);
	}
	
	public void removeVenda(int []lista) {
		Arrays.stream(lista).forEach(idVenda -> {
			Vendas vendas = getVenda(idVenda);
			if(vendas!=null) {
				vendas.setDesativada(true);
				vendasRepo.save(vendas);
			}
		});
	}
}
