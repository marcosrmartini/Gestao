package br.com.mmartini.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mmartini.gestao.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

}
