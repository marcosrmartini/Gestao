package br.com.mmartini.gestao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.mmartini.gestao.model.HistoricoEstoqueProduto;

public interface HistoricoEstoqueProdutoRepository extends JpaRepository<HistoricoEstoqueProduto, Long>{
	
	
	@Query("select h from HistoricoEstoqueProduto h where h.produto.idProduto = :idProduto")
	List<HistoricoEstoqueProduto> pesquisarHistorico(@Param(value = "idProduto")  Long id);


}
