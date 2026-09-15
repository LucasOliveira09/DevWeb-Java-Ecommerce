package br.edu.unifio.ecommerce.repositorio;

import br.edu.unifio.ecommerce.model.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClienteRepositorioTests {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Test
    public void deveInserirUmClienteComSucesso() {
        Cliente cliente = new Cliente();
        cliente.setNome("Lucas Oliveira");
        cliente.setEmail("lucas@exemplo.com");
        cliente.setTelefone("14999998888");

        Cliente clienteSalvo = clienteRepositorio.save(cliente);

        Assertions.assertNotNull(clienteSalvo.getId());
        Assertions.assertEquals("Lucas Oliveira", clienteSalvo.getNome());
        Assertions.assertEquals("lucas@exemplo.com", clienteSalvo.getEmail());
    }
}
