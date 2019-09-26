# Gestão de livraria virtual

Spring boot REST API para gestão de uma livraria

API implementada como parte da disciplina de Arquitetura de Backend e Microsserviços do curso de pós-graduação em Arquitetura de Software Distribuído da PUC Minas.

## Autor

* Henrique Samarane Garretto

## Justificativa de conformidade às 11 regras de APIs
### 1 - Orientação a recursos
As URIs disponibilizadas nas controladoras da API reflete o mapeamento das regras de negócio (livros, carrinhos de compras e pedidos de compras) aos quais operações podem ser realizadas. O tipo de operação a ser realizada com um recurso fica a cargo do método HTTP do endpoint.

### 2 - Padronização da API
A API segue padrões tanto em suas rotas, quanto em seus parâmetros de entrada e saída.
Ex: api/v1/book/4/comment

### 3 - Evitar APIs anêmicas
O formato da API e os tipos de recursos e operações sobre recursos que a API disponibiliza mostram que não apenas operações CRUD foram implementadas, mas que as regras de negócio da livraria virtual foram devidamente convertidas em operações.

### 4 - Criação de APIs simples
O tamanho, os nomes e formatos de rotas, métodos e parâmetros foram mantidos simples e padronizados. Refletindo o mapeando das entidades de negócio.
Ex: /api/v1/shop/2/book/1

### 5 - Atualização em lote
Por questões de praticidade e de não haver ligação com formas de persistência de dados, essa regra foi desconsiderada.

### 6 - Tratamento de datas
Todas as datas expostas pela API receberam formatação em conformidade com o padrão ISO 8601. Mais especificamente usando a biblioteca java.time.LocalDate; 
 
### 7 - Documentação da API
A documentação da API está disponível através do Swagger, acessível via http://localhost:8080/swagger-ui.html#/
 
### 8 - Protocolo HTTPS
Essa regra foi desconsiderada por questões de praticidade e viabilidade, e pelo fato de o projeto ser executado em ambiente local.
 
### 9 - Versionamento de API
Como as URIs dos métodos demonstram, a API foi versionada em v1.
 
### 10 - Paginação
Esta regra não foi implementada na API por questões de simplicidade das massas de dado.
 
### 11 - Códigos de retorno HTTP corretos
A API retorna corretamente os códigos HTTP esperados: 200 quando um recurso é buscado com sucesso e 201 quando um recurso é criado com sucesso. Os demais códigos da sequência 2xx não foram necessários pela simplicidade da API. Os erros retornados entram na casa 4xx de códigos HTTP, com o código 400 para uma requisição com dados inválidos passados pelo usuário da API e 500 caso ocorra erro interno na API.

## TESTES
Arquivo livraria-testes.postman_collection.json contém coleção do Postman utilizada para fins de teste da API.
