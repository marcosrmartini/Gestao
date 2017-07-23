package br.com.mmartini.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.mmartini.gestao.model.PrecoProduto;

public interface PrecoProdutoRepository extends JpaRepository<PrecoProduto, Long> {
	
	@Query(value = "insert into commit_activity_link (commit_id, activity_id) VALUES (?1, ?2)", nativeQuery = true)
    void inserirPrecos();
}
