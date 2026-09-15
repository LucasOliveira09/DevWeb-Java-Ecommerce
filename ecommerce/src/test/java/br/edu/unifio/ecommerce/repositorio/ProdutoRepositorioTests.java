package br.edu.unifio.ecommerce.repositorio;

import br.edu.unifio.ecommerce.model.Categoria;
import br.edu.unifio.ecommerce.model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest 
public class ProdutoRepositorioTests {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Test
    public void deveSalvarUmProdutoNovo() {
        Categoria categoria = new Categoria();
        categoria.setNome("Hardware");
        categoria.setDescricao("Componentes de computador");
        categoria = categoriaRepositorio.save(categoria);

        Produto produto = new Produto();
        produto.setNome("Teclado Mecânico");
        produto.setDescricao("Teclado Switch Blue RGB");
        produto.setPreco(new BigDecimal("299.90"));
        produto.setCategoria(categoria);

        Produto produtoSalvo = produtoRepositorio.save(produto);

        Assertions.assertNotNull(produtoSalvo.getId());
        Assertions.assertEquals("Teclado Mecânico", produtoSalvo.getNome());
    }
}
