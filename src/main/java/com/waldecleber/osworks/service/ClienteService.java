package com.waldecleber.osworks.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

	public Cliente salvar(Cliente cliente) {
		Optional<Cliente> optional = clienteRepository.findByCpf(cliente.getCpf());
		if (Objects.nonNull(optional)) {
			throw new ClienteDuplicadoException("Já existe um Cliente com este CPF");
			
		}
		return clienteRepository.save(cliente);
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

}
