package com.waldecleber.osworks.service;

import com.waldecleber.osworks.dto.OrdemServicoDTO;
import com.waldecleber.osworks.dto.OrdemServicoRequestDTO;
import com.waldecleber.osworks.enums.StatusOrdemServico;
import com.waldecleber.osworks.exception.ClienteNaoEncontrado;
import com.waldecleber.osworks.model.Cliente;
import com.waldecleber.osworks.model.OrdemServico;
import com.waldecleber.osworks.repository.ClienteRepository;
import com.waldecleber.osworks.repository.OrdemServicoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class OrdemServicoService {

    private OrdemServicoRepository ordemServicoRepository;
    private ClienteRepository clienteRepository;
    private ModelMapper mapper;

    public OrdemServicoService(OrdemServicoRepository ordemServicoRepository,
                               ClienteRepository clienteRepository,
                               ModelMapper mapper) {
        this.ordemServicoRepository = ordemServicoRepository;
        this.clienteRepository = clienteRepository;
        this.mapper = mapper;
    }


    public OrdemServicoDTO salvar(OrdemServicoRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getCliente().getId())
                .orElseThrow(() -> new ClienteNaoEncontrado("Cliente não encontrado"));

        OrdemServico ordemServico = OrdemServico.builder()
                .cliente(cliente)
                .dataAbertura(OffsetDateTime.now())
                .status(StatusOrdemServico.ABERTA)
                .descricao(dto.getDescricao())
                .preco(dto.getPreco())
                .build();
        ordemServicoRepository.save(ordemServico);
        return mapper.map(ordemServico, OrdemServicoDTO.class);
    }
}
