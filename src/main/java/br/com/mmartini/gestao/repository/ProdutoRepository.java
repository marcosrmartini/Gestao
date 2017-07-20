package br.com.mmartini.gestao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.mmartini.gestao.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	@Query("select p from Produto p where upper(p.descricao) like :descricao")
	List<Produto> pesquisaPorDescricao(@Param(value = "descricao")  String descricao);

}
