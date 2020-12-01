package com.waldecleber.osworks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.waldecleber.osworks.enums.StatusOrdemServico;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

public class OrdemServicoRequestDTO {

    private ClienteIdDTO cliente;

    private String descricao;

    private BigDecimal preco;

    public ClienteIdDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteIdDTO cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public OrdemServicoRequestDTO() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private ClienteIdDTO cliente;
        private String descricao;

        private BigDecimal preco;

        private Builder() {
        }

        public Builder cliente(ClienteIdDTO cliente) {
            this.cliente = cliente;
            return this;
        }

        public Builder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public Builder preco(BigDecimal preco) {
            this.preco = preco;
            return this;
        }

        public OrdemServicoRequestDTO build() {
            OrdemServicoRequestDTO ordemServicoRequestDTO = new OrdemServicoRequestDTO();
            ordemServicoRequestDTO.setCliente(cliente);
            ordemServicoRequestDTO.setDescricao(descricao);
            ordemServicoRequestDTO.setPreco(preco);
            return ordemServicoRequestDTO;
        }
    }
}
