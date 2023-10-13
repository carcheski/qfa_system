package br.com.qfa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.qfa.repositories.ClienteRespository;
import br.com.qfa.resources.domain.Cliente;
import br.com.qfa.services.exceptions.ObjectNotFoundExceptions;

@Service
public class ClienteService {

	@Autowired
	private ClienteRespository repo;

	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExceptions(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

}
