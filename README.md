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

## Funcionalidades Principais:

1. **Cadastro de Eventos:**
   - Permitir que os organizadores cadastrem novos eventos.
   - Incluir informações como nome, data, localização, descrição, etc.

2. **Gestão de Regulamentos:**
   - Possibilitar o upload e associação de regulamentos em formato PDF a cada evento.

3. **Inscrições de Participantes:**
   - Permitir que os participantes se inscrevam nos eventos.
   - Coletar informações como nome, idade, categoria, etc.

4. **Visualização de Eventos:**
   - Página para visualizar detalhes de eventos, incluindo regulamento e informações de inscrição.

5. **Controle de Participantes Inscritos:**
   - Painel para os organizadores visualizarem e gerenciarem participantes inscritos.

6. **Geração de Relatórios:**
   - Gerar relatórios sobre inscrições, participantes, e outros dados relevantes.

7. **Autenticação e Autorização:**
   - Implementar autenticação para organizadores e participantes.
   - Controlar permissões de acesso.

8. **Integração com Plataformas de Pagamento:**
   - Opção para pagamento de taxas de inscrição.

9. **Comunicação com Participantes:**
   - Enviar informações e atualizações aos participantes por e-mail ou notificações.

10. **Integração com Redes Sociais:**
    - Compartilhamento fácil de eventos em redes sociais.

## Funcionalidades Adicionais (Opcionais):

1. **Avaliações e Comentários:**
   - Permitir que os participantes avaliem eventos e deixem comentários.

2. **Histórico de Eventos:**
   - Manter um histórico de eventos passados.

3. **Notificações em Tempo Real:**
   - Implementar notificações em tempo real para atualizações importantes.

4. **Configurações Personalizadas de Evento:**
   - Opções para os organizadores personalizarem configurações específicas para cada evento.

5. **Feedback Pós-Evento:**
   - Coletar feedback dos participantes após a conclusão do evento.

6. **Gerenciamento de Patrocinadores:**
   - Permitir a associação de patrocinadores a eventos.

7. **Exportação de Dados:**
   - Opção para exportar dados para formatos comuns.

