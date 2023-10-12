package br.com.qfa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.qfa.resources.domain.Cidade;

@Repository
public interface CidadeRespository extends JpaRepository<Cidade, Integer> {

}
