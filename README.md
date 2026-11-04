# ProjetoWebService

<p align="center">
  <img src="https://img.shields.io/badge/Java-25-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/Spring_Boot-4.1.2-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" />
  <img src="https://img.shields.io/badge/PostgreSQL-Database-4169E1?style=for-the-badge&logo=postgresql&logoColor=white" />
  <img src="https://img.shields.io/badge/Hibernate-ORM-59666C?style=for-the-badge&logo=hibernate&logoColor=white" />
  <img src="https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" />
</p>

**RESTful API de e-commerce** desenvolvida com Java e Spring Boot para gerenciamento de usuários, produtos, categorias e pedidos.

Projeto desenvolvido para praticar desenvolvimento back-end, arquitetura em camadas, persistência de dados e mapeamento objeto-relacional com JPA e Hibernate.

---

## Tecnologias

| Tecnologia | Utilização |
|---|---|
| Java 25 | Linguagem de programação |
| Spring Boot 4.1.2 | Framework back-end |
| Spring Web MVC | Desenvolvimento de APIs REST |
| Spring Data JPA | Persistência de dados |
| Hibernate | ORM |
| PostgreSQL | Banco de dados relacional |
| H2 | Banco de dados para desenvolvimento e testes |
| Maven | Gerenciamento de dependências |

## Arquitetura

O projeto utiliza **Layered Architecture (Arquitetura em Camadas)**, separando as responsabilidades da aplicação.

```text
com.cursojava.projetowebservice
│
├── entities/
│   └── pk/
├── enums/
├── repositories/
├── services/
│   └── exceptions/
└── resources/
    └── exceptions/
```

**Fluxo da aplicação:**

`Controller → Service → Repository → Database`

| Camada | Responsabilidade |
|---|---|
| Resources | Recebimento e resposta das requisições HTTP |
| Services | Regras de negócio |
| Repositories | Acesso e persistência de dados |
| Entities | Representação das entidades do domínio |

## Modelo de domínio

Principais entidades e relacionamentos:

- **User:** representa os usuários da aplicação.
- **Order:** representa os pedidos realizados.
- **OrderItem:** representa os produtos associados a cada pedido.
- **Product:** representa os produtos disponíveis.
- **Category:** representa as categorias dos produtos.
- **Payment:** representa o pagamento de um pedido.

### Diagrama UML

![Diagrama UML do ProjetoWebService](docs/uml-projetowebservice.png)

### Relacionamentos

| Relacionamento | Cardinalidade |
|---|---|
| User → Order | 1:N |
| Order → OrderItem | 1:N |
| Order → Payment | 1:1 |
| Product ↔ Category | N:N |
| Order ↔ Product | N:N, por meio de OrderItem |

**Detalhes da modelagem:**
- `OrderItem` utiliza chave primária composta (`OrderItemPK`).
- `tb_product_category` representa a associação entre produtos e categorias.
- `OrderStatus` representa os estados possíveis de um pedido.

## Endpoints

### Users

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/users` | Lista usuários |
| GET | `/users/{id}` | Busca usuário por ID |
| POST | `/users` | Cadastra usuário |
| PUT | `/users/{id}` | Atualiza usuário |
| DELETE | `/users/{id}` | Remove usuário |

### Products, Orders e Categories

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/products` | Lista produtos |
| GET | `/products/{id}` | Busca produto por ID |
| GET | `/orders` | Lista pedidos |
| GET | `/orders/{id}` | Busca pedido por ID |
| GET | `/categories` | Lista categorias |
| GET | `/categories/{id}` | Busca categoria por ID |

## Exemplo de requisição

**Cadastrar usuário — `POST /users`**

```json
{
  "name": "Maria Brown",
  "email": "maria@gmail.com",
  "phone": "988888888",
  "password": "123456"
}
```

## Tratamento de exceções

O tratamento global é realizado com `@ControllerAdvice`, centralizando as exceções e padronizando as respostas por meio de `StandardError`.

| Exceção | HTTP Status |
|---|---|
| `ResourceNotFoundException` | 404 Not Found |
| `DatabaseException` | 400 Bad Request |

## Como executar

**Pré-requisitos:** JDK 25, Maven 3.9+ e banco de dados H2 ou PostgreSQL.

**1. Clone o repositório**

```bash
git clone <url-do-repositorio>
```

**2. Entre no diretório**

```bash
cd projetoweb-service
```

**3. Execute a aplicação**

Windows:

```bash
mvnw.cmd spring-boot:run
```

Linux/macOS:

```bash
./mvnw spring-boot:run
```

Ou utilizando Maven instalado:

```bash
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

### Banco de dados

As configurações de conexão devem ser definidas em `application.properties` ou nos arquivos específicos de cada profile.

O Hibernate utiliza `spring.jpa.hibernate.ddl-auto=update` para atualizar a estrutura das tabelas com base nas entidades mapeadas, quando essa configuração está habilitada.

**H2 Console:** `http://localhost:8080/h2-console` (quando habilitado).

---

## Autor

**Marcus Santos**

Desenvolvedor Back-End | Java | Spring Boot

[![GitHub](https://img.shields.io/badge/GitHub-MarcuSantosDev-181717?style=flat&logo=github)](https://github.com/MarcuSantosDev)
