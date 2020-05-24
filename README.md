# Cotação

Projeto criado com objetivo de consultar a cotação de moedas (até o momento está disponível a consulta apenas do dólar).

Para definição estrutural do projeto, foram utilizados conceitos DDD (Domain Driven Design). Já a definição dos pacotes foi pensada com o intuito de aproximar os objetivos traçados pela área de negócios com a aplicação desenvolvida, a partir da construção de um domínio responsável pela cotação de moedas, commodites, etc.

O projeto foi construído com as seguintes tecnologias:

- Java 11
- Quarkus
- JPA/Hibernate
- Microprofile

# Estrutura Projeto

É responsável por abordar a perspectiva do projeto estrutural e como deve ocorrer a organização de diretórios e pacotes.

## Diretórios

Segue o padrão definido pelo Maven.

- src/main/java: diretório raiz para os arquivos-fontes java;
- src/main/resources: local para os arquivos de recursos da aplicação;
- src/test/java: diretório raiz para arquivos-fontes Java usados pelos testes unitários;
- src/test/resources: recursos usados pelos testes unitários e que não serão publicados.

## Pacotes

Descreve o papel da separação dos pacotes dentro projeto. O papel dos pacotes também foi definido seguindo os conceitos de DDD. Moeda_cotação foi designado com propósito de facilitar a interação do desenvolvedor com a área de negócio, portanto agregando um maior valor ao software desenvolvido. O pacote integration também traz o conceito de Camada Anticorrupção definido no DDD.

- br.com.cotacao.base: contém as classes comuns a todo projeto;
- br.com.cotacao.<moeda_cotacao>.<versao_api>.application: contém a implementação dos serviços de
  aplicação;
- br.com.cotacao.<moeda_cotacao>.<versao_api>.boundary: contém as classes com a definição e
  implementação dos endpoints que serão expostos via rest, sockets, etc.
- br.com.cotacao.<moeda_cotacao>.<versao_api>. domain: contém as interfaces e classes (entidades, serviços, enum e repositórios) de um domínio de negócio;
- br.com.integration.<nome_provedor_servico>.< recurso>.client: contém as classes de
  implementação dos serviços da camada de infraestrutura que tratam especificamente de
  integração;
- br.com.integration.<nome_provedor_servico>.< recurso>.domain: classes
  (entidades, serviços e repositórios) de um domínio de negócio da camada de infraestrutura que tratam especificamente de integração;

## Nomeclaturas

Define o padrão de nomeclaturas para os elementos que compõem o projeto.

- Entidades: Não utilizar sufixos e nem prefixos;
- Endpoint Rest: Deve ser utilizado o sufixo "Rest" em sua nomenclatura;
- Classes que implementam o padrão Data Transfer Object: Deve ser utilizado o sufixo "DTO" em
  sua nomenclatura;
- Interfaces que definem um Client: Deve ser utilizado o sufixo
  "Client" em sua nomenclatura;

# Rodar Proejo

Comando para rodar a aplicação

docker-compose up

## Links Uteis

- Swagger: <http://localhost:8081/swagger-ui/>
- Adminer (DB Client): <http://localhost:8080/> host: cotacao-db, user: cotacao, password: password
