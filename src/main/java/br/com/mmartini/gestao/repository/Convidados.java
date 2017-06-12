package br.com.mmartini.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mmartini.gestao.model.Convidado;


public interface Convidados extends JpaRepository<Convidado, Long>{

}
