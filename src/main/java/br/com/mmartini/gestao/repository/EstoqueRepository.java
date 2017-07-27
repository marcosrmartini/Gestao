package br.com.mmartini.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mmartini.gestao.model.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

}
