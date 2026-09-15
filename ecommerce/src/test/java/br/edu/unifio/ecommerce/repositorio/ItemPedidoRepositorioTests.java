package br.edu.unifio.ecommerce.repositorio;

import br.edu.unifio.ecommerce.model.Categoria;
import br.edu.unifio.ecommerce.model.Cliente;
import br.edu.unifio.ecommerce.model.ItemPedido;
import br.edu.unifio.ecommerce.model.Pedido;
import br.edu.unifio.ecommerce.model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootTest
public class ItemPedidoRepositorioTests {

    @Autowired
    private ItemPedidoRepositorio itemPedidoRepositorio;

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Test
    public void deveInserirUmItemPedidoComSucesso() {
        // 1. Cria e salva Cliente
        Cliente cliente = new Cliente();
        cliente.setNome("Comprador Teste");
        cliente.setEmail("comprador@teste.com");
        cliente = clienteRepositorio.save(cliente);

        // 2. Cria e salva Pedido
        Pedido pedido = new Pedido();
        pedido.setData(LocalDateTime.now());
        pedido.setStatus("APROVADO");
        pedido.setValorTotal(new BigDecimal("150.00"));
        pedido.setCliente(cliente);
        pedido = pedidoRepositorio.save(pedido);

        // 3. Cria e salva Categoria e Produto
        Categoria categoria = new Categoria();
        categoria.setNome("Periféricos");
        categoria = categoriaRepositorio.save(categoria);

        Produto produto = new Produto();
        produto.setNome("Mouse Gamer");
        produto.setDescricao("Mouse RGB 16000 DPI");
        produto.setPreco(new BigDecimal("150.00"));
        produto.setCategoria(categoria);
        produto = produtoRepositorio.save(produto);

        // 4. Cria e salva ItemPedido
        ItemPedido item = new ItemPedido();
        item.setQuantidade(1);
        item.setValorUnitario(new BigDecimal("150.00"));
        item.setPedido(pedido);
        item.setProduto(produto);

        ItemPedido itemSalvo = itemPedidoRepositorio.save(item);

        Assertions.assertNotNull(itemSalvo.getId());
        Assertions.assertEquals(1, itemSalvo.getQuantidade());
        Assertions.assertEquals(new BigDecimal("150.00"), itemSalvo.getValorUnitario());
        Assertions.assertNotNull(itemSalvo.getPedido());
        Assertions.assertNotNull(itemSalvo.getProduto());
    }
}
