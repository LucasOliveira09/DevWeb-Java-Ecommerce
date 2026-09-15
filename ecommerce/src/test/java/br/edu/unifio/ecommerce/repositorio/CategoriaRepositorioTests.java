package br.edu.unifio.ecommerce.repositorio;

import br.edu.unifio.ecommerce.model.Categoria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoriaRepositorioTests {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Test
    public void deveInserirUmaCategoriaComSucesso() {
        Categoria categoria = new Categoria();
        categoria.setNome("Eletrônicos");
        categoria.setDescricao("Produtos eletrônicos e tecnologia");

        Categoria categoriaSalva = categoriaRepositorio.save(categoria);

        Assertions.assertNotNull(categoriaSalva.getId());
        Assertions.assertEquals("Eletrônicos", categoriaSalva.getNome());
        Assertions.assertEquals("Produtos eletrônicos e tecnologia", categoriaSalva.getDescricao());
    }
}
