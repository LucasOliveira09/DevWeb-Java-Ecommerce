package br.edu.unifio.ecommerce.repositorio;

import br.edu.unifio.ecommerce.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
}
