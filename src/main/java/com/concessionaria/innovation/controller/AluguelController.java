package com.concessionaria.innovation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concessionaria.innovation.model.Aluguel;
import com.concessionaria.innovation.service.AluguelService;

@RestController
@RequestMapping("/aluguelAPI")
public class AluguelController {

	@Autowired
	private AluguelService aluguelService;
	
	@RequestMapping("/saveAluguel")
	public ResponseEntity<Object> saveAluguel(@RequestBody Aluguel aluguel){
		aluguelService.save(aluguel);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/listaAlugueis")
	public ResponseEntity<Object> getAlugueis(){
		return ResponseEntity.ok(aluguelService.getAlugueis());
	}
	
	@RequestMapping("/listaAluguel/{idAluguel}")
	public ResponseEntity<Object> getAluguelByID(@PathVariable Integer idAluguel){
		aluguelService.getAluguel(idAluguel);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/editaAluguel/{idAluguel}")
	public ResponseEntity<Object> editAluguel(@PathVariable Integer idAluguel){
		Aluguel aluguel = aluguelService.getAluguel(idAluguel);
		if(aluguel !=null) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@RequestMapping("/deleteAluguel")
	public ResponseEntity<Object> deleteAluguel(@PathVariable int[] lista){
		aluguelService.deleteAluguel(lista);
		return ResponseEntity.ok().build();
	}
}
