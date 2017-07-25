package br.com.mmartini.gestao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.mmartini.gestao.model.PrecoProduto;

public interface PrecoProdutoRepository extends
		JpaRepository<PrecoProduto, Long> {

	@Query("select pp from PrecoProduto pp where pp.produto.idProduto = :idProduto")
	List<PrecoProduto> selecionarProduto(@Param(value = "idProduto") Long idProduto);

	@Transactional
	@Modifying
	@Query(value = "insert into preco_produto(margem_lucro, preco, produto_id_produto, tabela_id_tabela_preco) "
			+ " select t.margem_lucro, p.valor_compra + (p.valor_compra * (t.margem_lucro/100)), p.id_produto, t.id_tabela_preco "
			+ " from produto p, tabela_preco t "
			+ " where not exists(select 1 from preco_produto pp "
			+ " where pp.produto_id_produto = p.id_produto and t.id_tabela_preco = pp.tabela_id_tabela_preco ) ", nativeQuery = true)
	void inserirPrecos();

	@Transactional
	@Modifying
	@Query("delete from PrecoProduto pp where pp.produto.idProduto = :idProduto")
	void deletarProduto(@Param(value = "idProduto") Long idProduto);

	@Transactional
	@Modifying
	@Query("delete from PrecoProduto pp where pp.tabela.idTabelaPreco = :idTabelaPreco")
	void deletarTabelaPreco(@Param(value = "idTabelaPreco") Long idTabelaPreco);

}
