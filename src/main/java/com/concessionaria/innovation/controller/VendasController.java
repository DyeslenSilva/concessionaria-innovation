package com.concessionaria.innovation.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concessionaria.innovation.model.Vendas;
import com.concessionaria.innovation.service.VendasService;

@RestController
@RequestMapping("/vendasAPI")
public class VendasController {

	private VendasService vendasService;
	
	@RequestMapping("/salvarVendas")
	public ResponseEntity<Object> salvarVendas(@RequestBody Vendas vendas){
		vendasService.save(vendas);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/listaVendas")
	public ResponseEntity<List<Vendas>> getVendas(){
		return ResponseEntity.ok(vendasService.getVendas());
	}
	
	@RequestMapping("/encontrarVenda/{idVendas")
	public ResponseEntity<Object> getVendaById(@PathVariable Integer idVendas){
		vendasService.getVenda(idVendas);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/editVendas/{idVendas}")
	public ResponseEntity<Object> editVendas(@PathVariable Integer idVendas){
		Vendas vendas = vendasService.getVenda(idVendas);
		if(vendas !=null) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@RequestMapping("/deleteVendas")
	public ResponseEntity<Object> deleteVendas(@PathVariable int[] lista){
		vendasService.removeVenda(lista);
		return ResponseEntity.ok().build();
	}
}
