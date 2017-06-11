package br.com.mmartini.festa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mmartini.festa.model.Convidado;

public interface Convidados extends JpaRepository<Convidado, Long>{

}
