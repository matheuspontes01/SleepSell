# 🛏️ SleepSell API — Sistema de Vendas de Colchões com Spring Boot

SleepSell é uma API REST desenvolvida com **Java + Spring Boot + JPA + MySQL** que simula o backend de um sistema real de vendas de colchões.

O projeto foi construído com foco em:

- Relacionamentos JPA bem modelados
- Arquitetura em camadas (Controller → Service → Repository)
- Tratamento global e profissional de exceções
- Regras de negócio reais (controle de estoque e fluxo de pedido)
- Boas práticas de API REST
- Separação clara de responsabilidades (Clean Architecture / SOLID)

Este projeto foi desenvolvido como estudo aprofundado de **Spring Boot para backend** e como **projeto de portfólio**.


## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman


## 🧱 Arquitetura do Projeto

- controller  → camada web (HTTP)
- service     → regras de negócio
- repository  → acesso ao banco (JPA)
- entities    → modelo de domínio
- services/exceptions
- resources/exceptions

Essa separação garante baixo acoplamento e segue padrões utilizados em sistemas corporativos.


## 🗃️ Modelo de Domínio

Este diagrama foi utilizado como base para a construção deste projeto.

<img width="953" height="527" alt="image" src="https://github.com/user-attachments/assets/96e8d2e5-9fdf-4b8c-bad4-b1f09be83984" />


## 🔄 Fluxo real do Pedido

O pedido possui estados:

- WAITING_PAYMENT
- PAID
- DELIVERED
- CANCELED
- SHIPPED


O estoque **só é descontado quando o pedido é confirmado/pago**.

### Confirmar pedido

1. Percorre os itens do pedido
2. Verifica estoque
3. Desconta do colchão
4. Atualiza status para `PAID`

### Cancelar pedido

Se um pedido pago for cancelado, o estoque é devolvido.


## 🔗 Relacionamentos JPA importantes

O projeto utiliza:

- `@OneToMany`
- `@ManyToOne`
- `@EmbeddedId`
- `mappedBy`
- `equals` e `hashCode` baseados em id


## ⚠️ Tratamento Global de Exceções

### Exceções do domínio


services/exceptions

├── ResourceNotFoundException

├── DatabaseException

└── StockException


### Tratamento na camada web


resources/exceptions

├── StandardError

└── ResourceExceptionHandler



Exemplo de resposta de erro:

```json
{
  "timestamp": "2026-02-06T12:10:00Z",
  "status": 400,
  "error": "Stock error",
  "message": "Not enough stock for mattress: X",
  "path": "/orders/3/confirm"
}
````


## 📡 Endpoints Principais

### Clientes

* `GET /clients`
* `GET /clients/{id}`
* `POST /clients`
* `PUT /clients/{id}`
* `DELETE /clients/{id}`

### Colchões

* `GET /mattresses`
* `GET /mattresses/{id}`

### Pedidos

* `GET /orders`
* `GET /orders/{id}`
* `PUT /orders/{id}/confirm`
* `PUT /orders/{id}/cancel`


## 🧪 Como Rodar o Projeto

### 1. Clonar

```bash
git clone <url-do-repositorio>
```

### 2. Criar banco

```sql
CREATE DATABASE sleepsell;
```

### 3. Configurar `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sleepsell
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

### 4. Rodar

```bash
mvn spring-boot:run
```

A API estará em:

```
http://localhost:8080
```


## 🧠 Conceitos aplicados

* JPA avançado
* Chave composta
* Arquitetura em camadas
* Tratamento global de exceções
* Controle de estoque transacional
* Clean Architecture / SOLID
* Boas práticas REST

## 🎯 Objetivo

Projeto criado para aprofundar conhecimentos em Spring Boot e servir como portfólio para vagas de backend Java.


## 👨‍💻 Autor

**Matheus Pontes** (matheus.pontes@mail.uft.edu.br)

