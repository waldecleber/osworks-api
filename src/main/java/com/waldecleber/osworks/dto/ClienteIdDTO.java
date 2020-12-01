package com.waldecleber.osworks.dto;

public class ClienteIdDTO {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private Long id;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public ClienteIdDTO build() {
            ClienteIdDTO clienteIdDTO = new ClienteIdDTO();
            clienteIdDTO.setId(id);
            return clienteIdDTO;
        }
    }
}
