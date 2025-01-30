# transacao-api

A API é parte de um desafio de seleção empresarial e tem como objetivo receber transações com um valor e uma data/hora e apos válida-los guarda-los para responder dados estatístios.

Desenvolvida com Spring Boot, a API é coberta por testes automatizados 

## Instrução de Instalação

#### clone o projeto
````
git clone git@github.com:rodriguessis/transacao-api.git
````

## Instrução de uso

1. POST
````
localhost:8080/transaction
{
    "value" : 16.48,
    "hourTime" : "2025-01-25T15:38:50.746+00:00"
} 
````
2. GET
````
localhost:8080/transaction
````
3. DELETE
````
localhost:8080/transaction
````
4. GET
````
localhost:8080/statistic?intervalTimeSeconds=60
````