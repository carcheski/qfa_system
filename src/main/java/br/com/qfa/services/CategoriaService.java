package br.com.qfa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.qfa.repositories.CategoriaRespository;
import br.com.qfa.resources.domain.Categoria;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRespository repo;

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
