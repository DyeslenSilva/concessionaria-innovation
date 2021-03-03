package com.concessionaria.innovation.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concessionaria.innovation.model.Carro;
import com.concessionaria.innovation.repo.CarroRepo;

@Service
public class CarroService {

	@Autowired
	private CarroRepo carroRepo;
	
	public void save(Carro carro) {
		carroRepo.save(carro);
	}
	
	public List<Carro> getCarros(){
		return carroRepo.findAll().stream()
				.filter(carro -> carro.isNovo()|| carro.isUsado())
				.collect(Collectors.toList());
	}
	
	public Carro getCarro(Integer idCarro) {
		return carroRepo.findById(idCarro).orElse(null);
	}
	
	public void removeCarro(int [] lista) {
		Arrays.stream(lista).forEach(idCarro -> {
			Carro carro = getCarro(idCarro);
			if(carro!=null) {
				carro.setIndisponivel(true);
				carroRepo.delete(carro);
			}
		});
	}
}
