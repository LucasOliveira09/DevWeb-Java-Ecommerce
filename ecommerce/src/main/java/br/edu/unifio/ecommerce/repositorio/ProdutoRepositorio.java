package br.edu.unifio.ecommerce.repositorio;

import br.edu.unifio.ecommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {
}
