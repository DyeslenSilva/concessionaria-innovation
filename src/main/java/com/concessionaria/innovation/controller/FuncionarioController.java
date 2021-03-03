package com.concessionaria.innovation.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concessionaria.innovation.model.Funcionarios;
import com.concessionaria.innovation.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarioAPI")
public class FuncionarioController {

	private FuncionarioService funcionarioService;
	
	@RequestMapping("/salvarFuncionario")
	public ResponseEntity<Object> saveFuncionario(Funcionarios funcionarios){
		funcionarioService.save(funcionarios);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/listaFuncionarios")
	public ResponseEntity<List<Funcionarios>> getFuncionarios(){
		return ResponseEntity.ok(funcionarioService.getFuncionarios());
	}
	
	@RequestMapping("/listarFuncionario/{idFuncionario}")
	public ResponseEntity<Object> getFuncionario(@PathVariable Integer idFuncionario){
		funcionarioService.getFuncionario(idFuncionario);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/editFuncionario/{idFuncionario}")
	public ResponseEntity<Object> editFuncionario(Integer idFuncionario){
		Funcionarios funcionarios = funcionarioService.getFuncionario(idFuncionario);
		if(funcionarios !=null) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@RequestMapping("/deleteFuncionario/{idFuncionario}")
	public ResponseEntity<Object> deleteFuncionario(@PathVariable int[] lista){
		funcionarioService.deleteFuncionario(lista);
		return ResponseEntity.ok().build();
	}
	
	
	
}
