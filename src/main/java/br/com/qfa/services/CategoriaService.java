package br.com.qfa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.qfa.repositories.CategoriaRespository;
import br.com.qfa.resources.domain.Categoria;
import br.com.qfa.services.exceptions.DataIntegrityExceptions;
import br.com.qfa.services.exceptions.ObjectNotFoundExceptions;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRespository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExceptions(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityExceptions("Não é possivel exluir uma categoria que possui produtos!!!");
		}
	}

}
