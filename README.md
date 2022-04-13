# serasa-score
API para cadastro de pessoas com score e suas regiões de afinidades


## Set up environment

Para baixar o projeto é necessário realizar o clone deste repositório:

```bash
    $ git clone https://github.com/damyhonn/serasa-score.git
```

## Execução do projeto

Para iniciar o projeto basta executar o seguinte comando em sua pasta raiz:

## Windows:

```bash
    $ mvnw.cmd clean install
```
Depois executar o comando:

```bash
    $ mvnw.cmd spring-boot:run
```

## Linux:

```bash
    $ ./mvnw clean install
```
Depois executar o comando:

```bash
    $ ./mvnw spring-boot:run
```

## Swagger

O Swagger da aplicação está disponível na seguinte url:

```bash
http://localhost:8080/swagger-ui/
```

## Sobre a instrução de cadastro dos dados de Score

O item 3 do desafio informa para ser efetuado o cadastro via POST da estrutura de Scores.
Para isso adicionei o arquivo serasa.postman_collection.json à raiz do projeto com uma collection pronta para ser executada através do aplicativo Postman e cadastrar os respectivos Scores.
