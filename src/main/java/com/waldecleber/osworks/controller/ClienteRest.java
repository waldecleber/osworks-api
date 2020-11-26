package com.waldecleber.osworks.controller;

import java.util.List;
import java.util.Objects;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waldecleber.osworks.dto.ClienteDTO;
import com.waldecleber.osworks.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteRest {

	@Autowired
	private ClienteService clienteService;	

	
	@GetMapping
	public List<ClienteDTO> listarClientes() {			
		return clienteService.listarClientes();
	}
	
	@GetMapping(value = "/{cpf}")	
	public ResponseEntity<ClienteDTO> buscarClientePorCpf(@PathVariable String cpf) {			
		ClienteDTO cliente = clienteService.buscarClientePorCpf(cpf);
		if (Objects.nonNull(cliente)) {
			return ResponseEntity.ok().body(cliente);
		}
		return ResponseEntity.notFound().build();
	}
	
}
