package br.com.os.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.os.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
