package br.edu.unifio.ecommerce.repositorio;

import br.edu.unifio.ecommerce.model.Cliente;
import br.edu.unifio.ecommerce.model.Pedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootTest
public class PedidoRepositorioTests {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Test
    public void deveInserirUmPedidoComSucesso() {
        // Cria e salva o cliente associado
        Cliente cliente = new Cliente();
        cliente.setNome("Cliente Teste Pedido");
        cliente.setEmail("pedido@teste.com");
        cliente.setTelefone("14988887777");
        cliente = clienteRepositorio.save(cliente);

        // Cria o pedido
        Pedido pedido = new Pedido();
        pedido.setData(LocalDateTime.now());
        pedido.setStatus("PENDENTE");
        pedido.setValorTotal(new BigDecimal("250.00"));
        pedido.setCliente(cliente);

        Pedido pedidoSalvo = pedidoRepositorio.save(pedido);

        Assertions.assertNotNull(pedidoSalvo.getId());
        Assertions.assertEquals("PENDENTE", pedidoSalvo.getStatus());
        Assertions.assertEquals(new BigDecimal("250.00"), pedidoSalvo.getValorTotal());
        Assertions.assertNotNull(pedidoSalvo.getCliente());
    }
}
