package br.com.mmartini.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mmartini.gestao.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
