package com.concessionaria.innovation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concessionaria.innovation.model.Carro;
import com.concessionaria.innovation.model.Cliente;
import com.concessionaria.innovation.service.CarroService;
import com.concessionaria.innovation.service.ClienteService;

@RestController
@RequestMapping("/carroAPI")
public class CarroController {

	@Autowired
	private CarroService carroService;

	@RequestMapping("/salvarCarro")
	public ResponseEntity<Object> save(Carro carro){
		carroService.save(carro);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/listaCarros")
	public ResponseEntity<List<Carro>> getCarros(){
		return ResponseEntity.ok(carroService.getCarros());
	}
	
	@RequestMapping("/listaCarro/{idCarro}")
	public ResponseEntity<Object> getCarroByID(@PathVariable Integer idCarro) {
		carroService.getCarro(idCarro);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/editCarro/{idCarro}")
	public ResponseEntity<Object> editCarro(@PathVariable Integer idCarro){
		Carro carro = carroService.getCarro(idCarro);
		if(carro !=null) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@RequestMapping("/deleteCarro/")
	public ResponseEntity<Object> deleteCarro(@PathVariable int[]lista){
		carroService.removeCarro(lista);
		return ResponseEntity.ok().build();
	}
	

}