-- ===================================================================
-- 1º Trabalho Parcial: Carga inicial de dados do sistema E-Commerce
-- Ordem de insercao respeitando as chaves estrangeiras (Integridade Referencial):
-- 1. Categoria (5 registros)
-- 2. Produto (5 registros)
-- 3. Cliente (5 registros)
-- 4. Pedido (5 registros)
-- 5. ItemPedido (5 registros)
-- 6. Pagamento (5 registros)
-- Total: 30 registros
-- ===================================================================

-- 1. Categoria (5 registros)
INSERT INTO categoria (id, nome, descricao) VALUES (1, 'Eletrônicos', 'Dispositivos e aparelhos eletrônicos em geral');
INSERT INTO categoria (id, nome, descricao) VALUES (2, 'Informática', 'Computadores, notebooks, periféricos e peças');
INSERT INTO categoria (id, nome, descricao) VALUES (3, 'Livros', 'Livros físicos, técnicos e didáticos');
INSERT INTO categoria (id, nome, descricao) VALUES (4, 'Roupas', 'Vestuário masculino, feminino e infantil');
INSERT INTO categoria (id, nome, descricao) VALUES (5, 'Casa e Decoração', 'Móveis, iluminação e utensílios para o lar');

-- 2. Produto (5 registros - associados as categorias existentes)
INSERT INTO produto (id, nome, descricao, preco, categoria_id) VALUES (1, 'Smartphone Galaxy S24', 'Smartphone Samsung 256GB 5G Tela 6.2', 4500.00, 1);
INSERT INTO produto (id, nome, descricao, preco, categoria_id) VALUES (2, 'Notebook Dell Inspiron', 'Notebook Intel Core i7 16GB RAM SSD 512GB', 3800.00, 2);
INSERT INTO produto (id, nome, descricao, preco, categoria_id) VALUES (3, 'Livro Clean Code', 'Livro Código Limpo por Robert C. Martin', 95.00, 3);
INSERT INTO produto (id, nome, descricao, preco, categoria_id) VALUES (4, 'Camiseta de Algodão', 'Camiseta básica unissex 100% algodão', 59.90, 4);
INSERT INTO produto (id, nome, descricao, preco, categoria_id) VALUES (5, 'Luminária de Mesa LED', 'Luminária articulada bivolt para escritório', 120.00, 5);

-- 3. Cliente (5 registros)
INSERT INTO cliente (id, nome, email, telefone) VALUES (1, 'Lucas Oliveira', 'lucas.oliveira@email.com', '(14) 99876-5432');
INSERT INTO cliente (id, nome, email, telefone) VALUES (2, 'Maria Silva', 'maria.silva@email.com', '(14) 98765-4321');
INSERT INTO cliente (id, nome, email, telefone) VALUES (3, 'João Santos', 'joao.santos@email.com', '(11) 97654-3210');
INSERT INTO cliente (id, nome, email, telefone) VALUES (4, 'Ana Souza', 'ana.souza@email.com', '(11) 96543-2109');
INSERT INTO cliente (id, nome, email, telefone) VALUES (5, 'Carlos Ferreira', 'carlos.ferreira@email.com', '(19) 95432-1098');

-- 4. Pedido (5 registros - associados aos clientes existentes)
INSERT INTO pedido (id, data, status, valor_total, cliente_id) VALUES (1, '2026-09-01 10:30:00', 'PENDENTE', 4500.00, 1);
INSERT INTO pedido (id, data, status, valor_total, cliente_id) VALUES (2, '2026-09-02 14:15:00', 'PAGO', 3800.00, 2);
INSERT INTO pedido (id, data, status, valor_total, cliente_id) VALUES (3, '2026-09-03 09:00:00', 'PAGO', 190.00, 3);
INSERT INTO pedido (id, data, status, valor_total, cliente_id) VALUES (4, '2026-09-04 16:45:00', 'ENVIADO', 179.70, 4);
INSERT INTO pedido (id, data, status, valor_total, cliente_id) VALUES (5, '2026-09-05 11:20:00', 'ENTREGUE', 120.00, 5);

-- 5. ItemPedido (5 registros - associados a pedidos e produtos existentes)
INSERT INTO item_pedido (id, quantidade, valor_unitario, pedido_id, produto_id) VALUES (1, 1, 4500.00, 1, 1);
INSERT INTO item_pedido (id, quantidade, valor_unitario, pedido_id, produto_id) VALUES (2, 1, 3800.00, 2, 2);
INSERT INTO item_pedido (id, quantidade, valor_unitario, pedido_id, produto_id) VALUES (3, 2, 95.00, 3, 3);
INSERT INTO item_pedido (id, quantidade, valor_unitario, pedido_id, produto_id) VALUES (4, 3, 59.90, 4, 4);
INSERT INTO item_pedido (id, quantidade, valor_unitario, pedido_id, produto_id) VALUES (5, 1, 120.00, 5, 5);

-- 6. Pagamento (5 registros - associados a pedidos existentes)
INSERT INTO pagamento (id, valor, data, status, tipo, pedido_id) VALUES (1, 4500.00, '2026-09-01 10:35:00', 'PROCESSANDO', 'PIX', 1);
INSERT INTO pagamento (id, valor, data, status, tipo, pedido_id) VALUES (2, 3800.00, '2026-09-02 14:18:00', 'APROVADO', 'CARTAO_CREDITO', 2);
INSERT INTO pagamento (id, valor, data, status, tipo, pedido_id) VALUES (3, 190.00, '2026-09-03 09:05:00', 'APROVADO', 'BOLETO', 3);
INSERT INTO pagamento (id, valor, data, status, tipo, pedido_id) VALUES (4, 179.70, '2026-09-04 16:50:00', 'APROVADO', 'PIX', 4);
INSERT INTO pagamento (id, valor, data, status, tipo, pedido_id) VALUES (5, 120.00, '2026-09-05 11:25:00', 'APROVADO', 'CARTAO_DEBITO', 5);
