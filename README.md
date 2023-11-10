# Readme da API de Gerenciamento de Eventos de Corrida em Spring Boot (Java)

## Descrição

A API de Gerenciamento de Eventos de Corrida é um sistema destinado a facilitar a organização e administração de eventos relacionados a corridas de de qualquer categoria/esporte. Com esta API, é possível cadastrar eventos, gerenciar inscrições de participantes e associar regulamentos em formato PDF a cada evento.

## Finalidade

A principal finalidade da API é proporcionar uma plataforma centralizada para gerenciar todas as etapas relacionadas à organização de eventos de corrida de bicicleta. Ela permite que os organizadores cadastrem eventos, coletem inscrições de participantes e forneçam informações cruciais, como regulamentos em PDF.

## Tecnologias Utilizadas

A API foi desenvolvida utilizando as seguintes tecnologias:

- **Spring Boot (Java):** Framework para desenvolvimento rápido de aplicativos Java.
- **Spring Data JPA:** Facilita o acesso a dados relacionais usando a plataforma Java Persistence API (JPA).
- **Hibernate:** Framework ORM para mapeamento objeto-relacional.
- **Spring MVC:** Para construção da camada de controle.
- **Spring Security:** Para gerenciamento de autenticação e autorização.
- **H2 Database:** Banco de dados em memória para desenvolvimento e testes.
- **Maven:** Ferramenta de automação de compilação e gerenciamento de dependências.
- **Modelo de Domínio Driven Design (DDD):** Padrão de projeto que organiza o código em torno do domínio da aplicação.

## Estrutura do Projeto

O projeto segue uma estrutura baseada no padrão de projeto DDD, dividido em módulos principais:

- **Controller:** Camada responsável por receber as requisições HTTP e chamar os serviços adequados.
- **Service:** Lógica de negócios e regras específicas do domínio.
- **Repository:** Interação com o banco de dados.
- **Model:** Classes que representam o modelo de domínio.
- **DTO (Data Transfer Object):** Objetos para transferência de dados entre as camadas.
- **Config:** Configurações específicas do Spring.
- **Security:** Configurações relacionadas à segurança.

## Como Executar

Para executar a aplicação localmente, siga os passos abaixo:

1. Clone o repositório: `git clone https://seurepositorio.com/api-gerenciamento-eventos-corrida.git`
2. Navegue até o diretório do projeto: `cd api-gerenciamento-eventos-corrida`
3. Execute o aplicativo Spring Boot: `mvn spring-boot:run`

A aplicação estará disponível em `http://localhost:5050`.
