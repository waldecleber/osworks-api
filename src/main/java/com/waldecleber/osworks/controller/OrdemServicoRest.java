package com.waldecleber.osworks.controller;

import com.waldecleber.osworks.dto.OrdemServicoDTO;
import com.waldecleber.osworks.dto.OrdemServicoRequestDTO;
import com.waldecleber.osworks.model.OrdemServico;
import com.waldecleber.osworks.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/ordensServico")
public class OrdemServicoRest {

	@Autowired
	private OrdemServicoService OrdemServicoService;	

	
//	@GetMapping
//	public List<OrdemServicoDTO> listarOrdemServicos() {
//		return OrdemServicoService.listarOrdemServicos();
//	}
	
//	@GetMapping(value = "/{cpf}")
//	public ResponseEntity<OrdemServicoDTO> buscarOrdemServicoPorCpf(@PathVariable String cpf) {
//		OrdemServicoDTO OrdemServico = OrdemServicoService.buscarOrdemServicoPorCpf(cpf);
//		if (Objects.nonNull(OrdemServico)) {
//			return ResponseEntity.ok().body(OrdemServico);
//		}
//		return ResponseEntity.notFound().build();
//	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServicoDTO salvar(@RequestBody OrdemServicoRequestDTO dto) {
		return OrdemServicoService.salvar(dto);
	}
	
//	@PutMapping("/{id}")
//	public ResponseEntity<OrdemServicoDTO> atualizar(@PathVariable Long id, @RequestBody OrdemServicoDTO OrdemServico) {
//		return ResponseEntity.ok(OrdemServicoService.atualizar(id, OrdemServico));
//	}
	
}
