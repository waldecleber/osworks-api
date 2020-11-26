package com.waldecleber.osworks.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String telefone;
	
	private String email;

	private String cpf;
	
	
	public Cliente() {
		super();
	}

	private Cliente(Builder builder) {
		this.id = builder.id;
		this.nome = builder.nome;
		this.telefone = builder.telefone;
		this.email = builder.email;
		this.cpf = builder.cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, telefone, email, cpf);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Cliente) {
			Cliente that = (Cliente) object;
			return Objects.equals(this.id, that.id) && Objects.equals(this.nome, that.nome)
					&& Objects.equals(this.telefone, that.telefone) && Objects.equals(this.email, that.email)
					&& Objects.equals(this.cpf, that.cpf);
		}
		return false;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long id;
		private String nome;
		private String telefone;
		private String email;
		private String cpf;

		private Builder() {
		}

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder nome(String nome) {
			this.nome = nome;
			return this;
		}

		public Builder telefone(String telefone) {
			this.telefone = telefone;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}
		
		public Builder cpf(String cpf) {
			this.cpf = cpf;
			return this;
		}

		public Cliente build() {
			return new Cliente(this);
		}
	}
	
	

}
