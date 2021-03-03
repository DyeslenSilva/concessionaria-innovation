package com.concessionaria.innovation.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concessionaria.innovation.model.Funcionarios;
import com.concessionaria.innovation.repo.FuncionariosRepo;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionariosRepo funcionariosRepo;

	public void save(Funcionarios funcionarios) {
		funcionariosRepo.save(funcionarios);
	}
	
	public List<Funcionarios> getFuncionarios(){
		return funcionariosRepo.findAll().stream()
				.collect(Collectors.toList());
	}
	
	public Funcionarios getFuncionario(Integer idFuncionario) {
		return funcionariosRepo.findById(idFuncionario)
				.orElse(null);
	}
	
	public void deleteFuncionario(int [] lista) {
		Arrays.stream(lista).forEach(idFuncionario ->{
			Funcionarios funcionario  = getFuncionario(idFuncionario);
			if(funcionario !=null) {
				funcionario.setDesativado(true);
				funcionariosRepo.save(funcionario);
			}
		});
	}
}