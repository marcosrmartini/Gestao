package br.com.mmartini.gestao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.mmartini.gestao.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	@Query("select c from Cliente c where upper(c.nome) like :nome or c.cpf like :cpf")
	List<Cliente> pesquisaPorNomeOuCPF(@Param(value = "nome")  String nome, @Param(value = "cpf")  String cpf);
	
}
