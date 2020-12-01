package com.waldecleber.osworks.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.modelmapper.ModelMapper;

import com.waldecleber.osworks.dto.ClienteDTO;
import com.waldecleber.osworks.exception.ClienteDuplicadoException;
import com.waldecleber.osworks.model.Cliente;
import com.waldecleber.osworks.repository.ClienteRepository;

public class ClientesServiceTest {
	
	private ClienteService clienteService;
	private ClienteRepository clienteRepository;
	private ModelMapper mapper;
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Before
	public void setup() {		
		clienteRepository = mock(ClienteRepository.class);
		mapper = mock(ModelMapper.class);
		clienteService = new ClienteService(clienteRepository, mapper);
	}
	
	@Test
	public void deveSalvarNovoClienteSucesso() {
		//given (cenario)
		Cliente cliente = Cliente.builder()
				.nome("Cliente 01")
				.telefone("9999-0000")
				.email("cliente@teste.com")
				.cpf("17482812164")
				.build();
		
		ClienteDTO dto =
				ClienteDTO.builder()
				.nome("Cliente 01")
				.telefone("9999-0000")
				.email("cliente@teste.com")
				.cpf("17482812164")
				.build();

		when(clienteRepository.save(cliente)).thenReturn(cliente);
		when(clienteRepository.findByCpf(any())).thenReturn(Optional.ofNullable(null));
		when(mapper.map(cliente, ClienteDTO.class)).thenReturn(dto);

		//action
		clienteService.salvar(dto);
		
		//assert
		error.checkThat(dto.getNome(), is(equalTo(cliente.getNome())));
	}
	
	@Test(expected = ClienteDuplicadoException.class)
	public void naoDeveSalvarClienteDuplicado() {
		Cliente cliente = Cliente.builder()
				.nome("Cliente 01")
				.telefone("9999-0000")
				.email("cliente@teste.com")
				.cpf("17482812164")
				.build();

		ClienteDTO dto = ClienteDTO.builder()
						.nome("Cliente 01")
						.telefone("9999-0000")
						.email("cliente@teste.com")
						.cpf("17482812164")
						.build();
		
		when(clienteRepository.findByCpf("17482812164")).thenReturn(Optional.of(cliente));
		when(clienteRepository.save(cliente)).thenReturn(cliente);
		
		clienteService.salvar(dto);
				
	}

}
