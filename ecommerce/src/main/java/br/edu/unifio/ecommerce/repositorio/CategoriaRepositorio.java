package br.edu.unifio.ecommerce.repositorio;

import br.edu.unifio.ecommerce.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {
}
