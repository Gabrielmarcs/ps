# Consulta de Benefícios do Bolsa Família
Este projeto é uma aplicação criada para auxiliar na consulta dos benefícios do programa Bolsa Família, permitindo verificar o valor total do benefício e o número de pessoas beneficiadas por município e mês/ano de referência.

## Tecnologias Utilizadas
Abaixo estão algumas das principais tecnologias e suas versões:
- **Backend**: [Spring Boot] [JDK](versão 17)
- **Frontend**: [ReactJS] [NodeJS] (versão 18.18.2)
- **Banco de dados**: [MySQL](versão 8.0.36)

## Estrutura de Diretório

./raiz
    - ├── backend/
          - ├── controle/
          - ├── modelo/
          - ├── repositorio/
          - ├── servico/
    - ├── frontend/
    - ├── readme.md

- `backend/`: Aqui, você encontrará o código-fonte do backend do sistema.
    - `controle/`: Responsável por lidar com as requisições HTTP, interagindo com os serviços para processar essas requisições. 
    - `modelo/`: Representa as entidades de negócios da aplicação.
    - `repositorio/`: Responsável por acessar o banco de dados.
    - `servico/`: Contém a lógica de negócios da aplicação.
- `frontend/`: Este diretório é dedicado ao código-fonte do frontend do sistema.
