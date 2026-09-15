package br.edu.unifio.ecommerce.repositorio;

import br.edu.unifio.ecommerce.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepositorio extends JpaRepository<ItemPedido, Integer> {
}
