package com.waldecleber.osworks.service;

import com.waldecleber.osworks.dto.ClienteDTO;
import com.waldecleber.osworks.dto.ClienteIdDTO;
import com.waldecleber.osworks.dto.OrdemServicoDTO;
import com.waldecleber.osworks.dto.OrdemServicoRequestDTO;
import com.waldecleber.osworks.enums.StatusOrdemServico;
import com.waldecleber.osworks.exception.ClienteNaoEncontrado;
import com.waldecleber.osworks.model.Cliente;
import com.waldecleber.osworks.model.OrdemServico;
import com.waldecleber.osworks.repository.ClienteRepository;
import com.waldecleber.osworks.repository.OrdemServicoRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrdemServicoServiceTest {

    private OrdemServicoService ordemServicoService;
    private OrdemServicoRepository ordemServicoRepository;
    private ClienteRepository clienteRepository;
    private ModelMapper mapper;

    @Rule
    public ErrorCollector error = new ErrorCollector();

    @Before
    public void setup() {
        ordemServicoRepository = mock(OrdemServicoRepository.class);
        clienteRepository = mock(ClienteRepository.class);
        mapper = mock(ModelMapper.class);
        ordemServicoService = new OrdemServicoService(ordemServicoRepository, clienteRepository, mapper);
    }

    @Test
    public void deveSalvarOrdemServico() {
        OrdemServicoRequestDTO dto = OrdemServicoRequestDTO.builder()
                .cliente(ClienteIdDTO.builder().id(1L).build())
                .descricao("Reparo notebook")
                .preco(new BigDecimal(35))
                .build();

        OrdemServico ordemServico = OrdemServico.builder()
                .id(1L)
                .cliente(builderCliente())
                .build();

        OrdemServicoDTO result = OrdemServicoDTO.builder()
                .id(1L)
                .status(StatusOrdemServico.ABERTA)
                .cliente(ClienteDTO.builder().id(1L).build())
                .build();

        when(clienteRepository.findById(any())).thenReturn(Optional.ofNullable(builderCliente()));
        when(ordemServicoRepository.save(ordemServico)).thenReturn(ordemServico);

        ordemServicoService.salvar(dto);

        error.checkThat(result.getStatus(), is(equalTo(StatusOrdemServico.ABERTA)));
    }

    @Test(expected = ClienteNaoEncontrado.class)
    public void naoDeveSalvarOrdemServicoClienteNaoExiste() {
        OrdemServicoRequestDTO dto = OrdemServicoRequestDTO.builder()
                .cliente(ClienteIdDTO.builder().id(1L).build())
                .descricao("Reparo notebook")
                .preco(new BigDecimal(35))
                .build();

        OrdemServico ordemServico = OrdemServico.builder()
                .cliente(builderCliente())
                .build();

        when(clienteRepository.findById(any())).thenReturn(Optional.ofNullable(null));
        when(ordemServicoRepository.save(any())).thenReturn(ordemServico);

        ordemServicoService.salvar(dto);
    }

    private Cliente builderCliente() {
        return Cliente.builder()
                .id(1L)
                .nome("Cliente 01")
                .telefone("9999-0000")
                .email("cliente@teste.com")
                .cpf("17482812164")
                .build();
    }
}
