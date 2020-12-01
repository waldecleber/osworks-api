package com.waldecleber.osworks.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.waldecleber.osworks.dto.ClienteDTO;
import com.waldecleber.osworks.exception.ClienteDuplicadoException;
import com.waldecleber.osworks.exception.ClienteNaoEncontrado;
import com.waldecleber.osworks.model.Cliente;
import com.waldecleber.osworks.repository.ClienteRepository;

@Service
public class ClienteService {
	
	
	private final ClienteRepository clienteRepository;
	
	private final ModelMapper mapper;
	
	@Autowired
	public ClienteService(ClienteRepository clienteRepository, ModelMapper mapper) {
		this.clienteRepository = clienteRepository;
		this.mapper = mapper;
	}

	public ClienteDTO salvar(ClienteDTO dto) {
		Optional<Cliente> optional = clienteRepository.findByCpf(dto.getCpf());
		if (optional.isPresent()) {
			throw new ClienteDuplicadoException("Já existe um Cliente com este CPF");			
		}
		Cliente cliente = mapper.map(dto, Cliente.class);
		clienteRepository.save(cliente);
		return dto;
	}
	
	public List<ClienteDTO> listarClientes() {
		return clienteRepository.findAll().stream()
			.map(cliente -> mapper.map(cliente, ClienteDTO.class))
			.collect(Collectors.toList());		
	}
	
	public ClienteDTO buscarClientePorNome(String nome) {
		return clienteRepository.findByNome(nome)
				.map(cliente -> mapper.map(cliente, ClienteDTO.class))
				.orElseThrow(() -> new ClienteNaoEncontrado("Cliente não encontrado"));
	}
	
	public ClienteDTO buscarClientePorCpf(String cpf) {
		return clienteRepository.findByCpf(cpf)
				.map(cliente -> mapper.map(cliente, ClienteDTO.class))
				.orElseThrow(() -> new ClienteNaoEncontrado("Cliente não encontrado"));
	}

	public ClienteDTO atualizar(Long id, ClienteDTO dto) {
		if (clienteRepository.existsById(id)) {
			Cliente cliente = mapper.map(dto, Cliente.class);
			cliente.setId(id);
			return mapper.map(clienteRepository.save(cliente), ClienteDTO.class);
		} else {
			throw new ClienteNaoEncontrado("Cliente não encontrado");			
		}
	}

}
