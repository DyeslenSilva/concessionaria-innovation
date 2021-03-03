package com.concessionaria.innovation.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concessionaria.innovation.model.Aluguel;
import com.concessionaria.innovation.repo.AluguelRepo;

@Service
public class AluguelService {

	@Autowired
	private AluguelRepo aluguelRepo;

	public void save(Aluguel aluguel) {
		aluguelRepo.save(aluguel);
	}
	
	public List<Aluguel> getAlugueis(){
		return aluguelRepo.findAll().stream()
				.filter(aluguel -> aluguel.isAtivado())
				.collect(Collectors.toList());
	}
	
	public Aluguel getAluguel(Integer idAluguel) {
		return aluguelRepo.findById(idAluguel)
				.orElse(null);
	}
	
	public void deleteAluguel(int [] lista) {
		Arrays.stream(lista).forEach(idAluguel->{
			Aluguel aluguel = getAluguel(idAluguel);
			if(aluguel!=null) {
				aluguel.setAtivado(false);
				aluguelRepo.deleteById(idAluguel);
			}
		});
	}
}
