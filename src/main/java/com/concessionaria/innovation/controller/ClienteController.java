package com.concessionaria.innovation.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concessionaria.innovation.model.Cliente;
import com.concessionaria.innovation.service.ClienteService;

@RestController
@RequestMapping("/clienteAPI")
public class ClienteController {
	
	private ClienteService clienteService;
	
	@RequestMapping("/saveCliente")
	public ResponseEntity<Object> saveClientes(@RequestBody Cliente cliente){
		clienteService.save(cliente);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping("/listClientes")
	public ResponseEntity<List<Cliente>> getClientes(){
		return ResponseEntity.ok(clienteService.getClientes());
	}
	
	@RequestMapping("/listCliente/{idCliente}")
	public ResponseEntity<Object> getCliente(@PathVariable Integer idCliente){
		clienteService.getCliente(idCliente);
		return ResponseEntity.ok().build();

	}
	
	@RequestMapping("/editaCliente/{idCliente}")
	public ResponseEntity<Object> editaCliente(@PathVariable("idCliente") Integer idCliente){
		Cliente cliente = clienteService.getCliente(idCliente);
		if(cliente !=null) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@RequestMapping("/deleteCliente")
	public ResponseEntity<Object> deleteCliente(@RequestBody int[] lista){
		clienteService.removeCliente(lista);
		return ResponseEntity.ok().build();
	}
}