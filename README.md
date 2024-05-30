# API RestFull segura com Spring Boot & Keycloak

> Nesse projeto mostro como proteger uma API RestFull em Spring utilizando o Keycloak.

## Sobre a API RestFull

> API RestFull desse projeto consiste em três endpoints triviais que retornam uma simples mensagem de texto. Duas rotas são protegidos pelas autoridades (*roles*): **client_admin** e **client_user**. A autoridade do tipo **client_admin** serve para representar um tipo de usuário com privilégios de administração. Por outro lado, a autoridade **client_user** foi criada para usuários comuns do sistema. A API desse projeto possui um endpoint publico endereçado na URI: */anonymous-console*. Esse rota foi criada para o caso em que uma determinada rota não necessite ser protegida. Na listagem a seguir, é possível observar as versões das tecnologias utilizadas no projeto:

- [Maven 3.9.4](https://maven.apache.org/)
- [Java 17.0.8](https://www.java.com/pt-BR/download/manual.jsp)
- [Spring Boot 3.3.0](https://spring.io/projects/spring-boot)
- [Keycloak 20.0.4](https://www.keycloak.org/)
- [Potman](https://www.postman.com/)

> Na raiz do projeto há um arquivo de nome *realm-export.json*. Esse arquivo contém toda a configuração do Keycloak. Esse arquivo pode ser importado no Keycloak configurando de maneira automática o projeto no Keycloak. Para mais detalhes acesse o [site](https://www.keycloak.org/) oficial.

## Sobre o Keycloak

> O Keycloak é um sistema Gerenciador de Autenticação e Autorização baseado em Tokens JWT. A estrutura padrão de um projeto no Keycloak pode ser organizada em quatro partes:
- Realms: a apllicação (como um todo) que se deseja proteger.
- Clients: uma parte da aplicação a ser protegida. Ex: API, Frontend Mobile e Frontend Desktop.
- Roles: autoridades que um determinado usuário pode assumir.
- Users: usuários que terão permissão para acessar o sistema.

> Para acessar as rotas protegidas da *API RestFull* em Spring, é necessário informar um *Access Token* no cabeçalho da requisição. O *Token JWT* é uma cadeia de caracteres que criptografa as informações de sessão do usuário logado. Em outras palavras, o *Token* é a comprovação de que um usuário devidamente autorizado está acessando as rotas da aplicação.

## Obtendo um Token JWT

> Com o serviço do Keycloak inicializada, obtenha um *Access Token* realizando uma requisição HTTP do tipo POST para a seguinte url: **http://localhost:8080/realms/nome_realm/protocol/openid-connect/token**. Para inicializar a o Keycloak no Windows, basta acessar o diretório *bin* na pasta raiz e digitar o seguinte comando: *kc.bat start-dev*. Lembre-se de substituir *nome_realm* realm criado no Keycloak. O endepoint espera receber os seguintes parâmetros:
- username (Ex: layla)
- password (Ex: 1234)
- client_id (Ex: backend-spring)
- grant_type (Password)

## Resultados 

> Com o Maven devidamente configurado, acesse o diretório raiz do projeto e o inicialize com o seguinte comando: **mvn spring-boot:run** Para mais detalhes sobre o funcionamento do projeto acesse o vídeo de demonstração clicando [aqui](https://youtu.be/yLoxbYBPpE4).