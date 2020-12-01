package com.waldecleber.osworks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.waldecleber.osworks.enums.StatusOrdemServico;
import com.waldecleber.osworks.model.Cliente;
import com.waldecleber.osworks.model.OrdemServico;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

public class OrdemServicoDTO {

    private Long id;

    private ClienteDTO cliente;

    private String descricao;

    @JsonProperty(access = READ_ONLY)
    @Enumerated(EnumType.STRING)
    private StatusOrdemServico status;

    @JsonProperty(access = READ_ONLY)
    private OffsetDateTime dataAbertura;

    @JsonProperty(access = READ_ONLY)
    private OffsetDateTime dataFinalizacao;

    private BigDecimal preco;

    public OrdemServicoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusOrdemServico getStatus() {
        return status;
    }

    public void setStatus(StatusOrdemServico status) {
        this.status = status;
    }

    public OffsetDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(OffsetDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public OffsetDateTime getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdemServicoDTO that = (OrdemServicoDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(cliente, that.cliente) &&
                Objects.equals(descricao, that.descricao) &&
                status == that.status &&
                Objects.equals(dataAbertura, that.dataAbertura) &&
                Objects.equals(dataFinalizacao, that.dataFinalizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cliente, descricao, status, dataAbertura, dataFinalizacao);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private ClienteDTO cliente;
        private String descricao;
        private StatusOrdemServico status;
        private OffsetDateTime dataAbertura;
        private OffsetDateTime dataFinalizacao;
        private BigDecimal preco;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder cliente(ClienteDTO cliente) {
            this.cliente = cliente;
            return this;
        }

        public Builder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public Builder status(StatusOrdemServico status) {
            this.status = status;
            return this;
        }

        public Builder dataAbertura(OffsetDateTime dataAbertura) {
            this.dataAbertura = dataAbertura;
            return this;
        }

        public Builder dataFinalizacao(OffsetDateTime dataFinalizacao) {
            this.dataFinalizacao = dataFinalizacao;
            return this;
        }

        public Builder preco(BigDecimal preco) {
            this.preco = preco;
            return this;
        }

        public OrdemServicoDTO build() {
            OrdemServicoDTO ordemServico = new OrdemServicoDTO();
            ordemServico.setId(id);
            ordemServico.setCliente(cliente);
            ordemServico.setDescricao(descricao);
            ordemServico.setStatus(status);
            ordemServico.setDataAbertura(dataAbertura);
            ordemServico.setDataFinalizacao(dataFinalizacao);
            ordemServico.setPreco(preco);
            return ordemServico;
        }
    }
}
