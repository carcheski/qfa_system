package br.com.qfa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.qfa.repositories.PedidoRespository;
import br.com.qfa.resources.domain.Pedido;
import br.com.qfa.services.exceptions.ObjectNotFoundExceptions;

@Service
public class PedidoService {

	@Autowired
	private PedidoRespository repo;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExceptions(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

}
