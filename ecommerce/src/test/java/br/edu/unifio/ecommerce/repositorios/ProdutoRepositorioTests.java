package br.edu.unifio.ecommerce.repositorios;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest 
public class ProdutoRepositorioTests {
    public void deveSalvarUmProdutoNovo () {
        var produto = new Produto ();
        produto.setNome("Produto Teste");
        produto.setDescricao("Descrição do Produto Teste");
        produto.setPreco(100.0);
        produto.setEstoque(10);
    }
}
