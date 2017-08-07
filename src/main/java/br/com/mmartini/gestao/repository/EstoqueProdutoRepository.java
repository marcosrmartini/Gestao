package br.com.mmartini.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.com.mmartini.gestao.model.EstoqueProduto;

public interface EstoqueProdutoRepository extends JpaRepository<EstoqueProduto, Long>{
	
	@Transactional
	@Modifying
	@Query(value = "insert into estoque_produto(estoque_id_estoque, estoque_maximo, estoque_minimo, quantidade, produto_id_produto) " +
			" select e.id_estoque, e.estoque_maximo, e.estoque_minimo, 0, p.id_produto " + 
			" from estoque e, produto p " +
			" where not exists(select * from estoque_produto ep where ep.estoque_id_estoque = e.id_estoque and ep.produto_id_produto  = p.id_produto)", nativeQuery = true)
	void inserirPrecos();


}
