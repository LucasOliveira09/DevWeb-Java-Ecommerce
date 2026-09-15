# 🛒 E-Commerce Backend — Spring Boot 3 & Java 21

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 21">
  <img src="https://img.shields.io/badge/Spring_Boot-3.3.4-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" alt="Spring Boot 3">
  <img src="https://img.shields.io/badge/Spring_Data_JPA-Hibernate-6DB33F?style=for-the-badge" alt="JPA">
  <img src="https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL">
  <img src="https://img.shields.io/badge/Tests-JUnit_5-25A162?style=for-the-badge&logo=junit5&logoColor=white" alt="JUnit 5">
</p>

## 📌 Sobre o Projeto
Sistema backend corporativo para e-commerce, projetado seguindo os princípios de **Clean Code**, **SOLID** e arquitetura em camadas. O sistema gerencia catálogo de produtos, categorias, clientes, pedidos com múltiplos itens e fluxo de pagamentos com integridade relacional.

---

## 🏛️ Modelo de Domínio & Entidades
* 📂 **Categoria:** Agrupamento e taxonomia de produtos.
* 📦 **Produto:** Itens do catálogo com precificação e relacionamento com categorias.
* 👤 **Cliente:** Informações de compradores, contatos e histórico de compras.
* 📑 **Pedido:** Registro de transações com controle de status (PENDENTE, PAGO, ENVIADO, ENTREGUE).
* 📋 **ItemPedido:** Tabela de junção associativa com cálculo de valor unitário, quantidade e total.
* 💳 **Pagamento:** Relação 1:1 com Pedido suportando múltiplos métodos (PIX, Boleto, Cartão).

---

## 🛠️ Stack Tecnológica
* **Linguagem:** Java 21 (LTS)
* **Framework:** Spring Boot 3.3.4 (Spring Data JPA, Hibernate ORM)
* **Banco de Dados:** MySQL 8.0 com inicialização automática (`import.sql`)
* **Testes Automatizados:** JUnit 5 & Spring Boot Test
* **Build Tool:** Maven

---

## 🚀 Como Executar Localmente

### Pré-requisitos
* Java 21 instalado
* MySQL rodando na porta 3306

```bash
# 1. Clone o repositório
git clone https://github.com/LucasOliveira09/DevWeb-Java-Ecommerce.git

# 2. Acesse a pasta do projeto
cd DevWeb-Java-Ecommerce/ecommerce

# 3. Execute os testes automatizados
./mvnw test

# 4. Inicie o servidor
./mvnw spring-boot:run
```

---

<p align="center">Desenvolvido por <strong><a href="https://github.com/LucasOliveira09">Lucas Oliveira</a></strong> 🚀</p>
