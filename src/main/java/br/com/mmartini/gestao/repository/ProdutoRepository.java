package br.com.mmartini.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mmartini.gestao.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
