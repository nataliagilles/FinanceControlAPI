# FinanceControlAPI

API simples para controle de finanças pessoais.

## Sobre o Projeto
Este é um projeto de API para gerenciar transações financeiras (receitas e despesas) com categorias.

## Tecnologias Utilizadas
- Java 17
- Spring Boot
- Spring Data JPA
- MariaDB
- Lombok
- Swagger (OpenAPI)

## Como Rodar o Projeto

### Pré-requisitos
- Java 17 instalado
- MariaDB instalado e rodando
- Maven

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/nataliagilles/FinanceControlAPI.git
   cd FinanceControlAPI

1. Clone o repositório:

2. Configure o arquivo **application.properties** com os dados do seu banco MariaDB.
   
3. Crie o banco de dados:
   ```bash
   CREATE DATABASE finance_control;
   
4. Rode a aplicação:
  ```
   ./mvnw spring-boot:run
```

4. Acesse o Swagger:
http://localhost:8080/swagger-ui.html

## Endpoints

### Categorias
- POST /categorias
- GET /categorias
- GET /categorias/{id}
- DELETE /categorias/{id}

### Transações
- POST /transacoes
- GET /transacoes
- GET /transacoes/{id}
- DELETE /transacoes/{id}

## Exemplo de JSON (POST /transacoes) 
   ```
   {
  "valor": 250.00,
  "data": "2026-05-27",
  "descricao": "Pagamento freelance",
  "tipo": "RECEITA",
  "categoriaId": 1
} 
```

## 👩‍💻 Autora
**Natalia Gilles**
Desenvolvedora backend em evolução, Java, Spring Boot e APIs REST.
](https://github.com/nataliagilles)
**Sugestões e contribuições são bem-vindas.**


