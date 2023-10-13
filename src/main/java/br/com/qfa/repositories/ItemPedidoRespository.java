package br.com.qfa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.qfa.resources.domain.ItemPedido;

@Repository
public interface ItemPedidoRespository extends JpaRepository<ItemPedido, Integer> {

}
