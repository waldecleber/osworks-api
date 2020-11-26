package com.waldecleber.osworks.repository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.waldecleber.osworks.dto.ClienteDTO;
import com.waldecleber.osworks.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Optional<Cliente> findByNome(String nome);

	Optional<Cliente> findByCpf(String cpf);

}
