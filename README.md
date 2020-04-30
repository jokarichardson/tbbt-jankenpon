# Jogo de Jokenpô do Seriado The Big Bang Theory

<p align="center"><img src="https://github.com/jokarichardson/tbbt-jankenpon/blob/master/src/main/resources/sheldon_rspls.png" width="320" height="219" /><img src="https://github.com/jokarichardson/tbbt-jankenpon/blob/master/src/main/resources/rspls_characters.png" width="219" height="219" /></p>

O seriado The Big Bang Theory nos trouxe uma novidade, o Jogo de Jokenpô com 2 novas opções, Lagarto e Spock, além das costumeiras Papel, Pedra e Tesoura. 


## Regras

O jogo pode ser jogado entre 2 ou mais jogadores, onde cada jogador escolhe entre as seguintes opções:

- Lagarto,
- Papel,
- Pedra,
- Spock,
- Tesoura

Cada opção tem suas vantagens e desvantagens com relação às demais, conforme tabela abaixo:

| Opção | Descrição Evento | Outra Opção |
|------|-----|-----|
|Pedra |quebra a |Tesoura|
|Pedra |esmaga o |Lagarto|
|Papel |cobre a |Pedra|
|Papel |refuta o |Spock|
|Tesoura |corta o |Papel|
|Tesoura |mata o |Lagarto|
|Lagarto |come o |Papel|
|Lagarto |envenena o |Spock|
|Spock |quebra a |Tesoura|
|Spock |vaporiza a |Pedra|

Será vitorioso aquele jogador que sobrepujar os demais com sua opção:
  - Jogador 1 - LAGARTO;
  - Jogador 2 - PEDRA;
  - Jogador 3 - PAPEL.

  Vencedor será LAGARTO, pois é esmagado pela PEDRA, contudo, a PEDRA é coberta pelo PAPEL, que é comido pelo LAGARTO. 

Haverá um empate quando:

- Jogo com menos de 5 jogadores, todos escolherem a mesma opção:
  - Jogador 1 - LAGARTO;
  - Jogador 2 - LAGARTO.

- Jogo com 5 ou mais jogadores, todas as opções estiverem presentes:

  - Jogador 1 - LAGARTO;
  - Jogador 2 - PAPEL;
  - Jogador 3 - PEDRA;
  - Jogador 4 - TESOURA;
  - Jogador 5 - SPOCK;
  - Jogador 6 - PEDRA;
  - Jogador 7 - PAPEL.

## Tecnologias Utilizadas

- Java 8;
- Spring Boot;
- Gradle;
- REST

## Execução local

Para executar a aplicação, digite o seguinte comando na pasta raiz do projeto:

- Windows:

  ```javascript
  \tbbt-jankenpon>gradlew bootRun
  ```

- Linux:
  ```javascript
  $ ./gradlew bootRun
  ```

## Execução em Nuvem

Encontra-se em execução no Heroku, através da URL https://tbbt-jankenpon.herokuapp.com/

## Preparação para jogar:

<p id="section1">A aplicação virá com 5 jogadores carregados em memória, bem como 5 jogadas. Esse conjunto de jogadas resultará em empate entre os jogadores.<br>
São necessários 2 jogadores, no mínimo, para jogar.<br>
Para avaliar o jogo preparado, ou mesmo jogar com suas jogadas criadas, siga os passos em "Como Jogar".</p>

## Como Jogar

Para avaliar as jogadas em memória, seguir os passos abaixo:

1. Endpoint: /jogada
2. Método: GET
3. Resposta de sucesso esperada: <b>HttpStatus 200 - Ok</b>, com o response abaixo:

   `O vencedor foi Jogador 1 com a escolha LAGARTO!`

4. Em caso de empate, o response será:

   `Houve empate entre os jogadores.`

5. Caso tenha ocorrido algum erro, será respondido <b>HttpStatus 400 - Bad Request</b>, com o response abaixo:
```javascript
{
  "timestamp": "2020-04-30T15:02:16.079+0000",
  "status": 400,
  "error": "BAD_REQUEST",
  "exception": "TbbtJankenponGeneralException",
  "message": "Não há jogadores suficientes. O mínimo são 2 jogadores.",
  "path": "/jogada"
}
```
## Criação de Jogadas

Para criar uma jogada, seguir os passos abaixo:

1. Endpoint: /jogada
2. Método: POST
3. Payload:
```javascript
{
  "jogador": "Nome do Jogador",
  "escolha": "LAGARTO"
}
```

4. Ao ser consumido o endpoint <b>/jogada</b>, via método <i>POST</i>, a aplicação avaliará se esse jogador já efetuou sua jogada.
5. Resposta de sucesso esperada: <b>HttpStatus 201 - Created</b>
6. Caso o jogador tenha feito sua jogada anteriormente, será respondido <b>HttpStatus 400 - Bad Request</b>, com o response abaixo:

```javascript
{
  "timestamp": "2020-04-30T14:28:52.326+0000",
  "status": 400,
  "error": "BAD_REQUEST",
  "exception": "TbbtJankenponGeneralException",
  "message": "Essa jogada já foi efetuada.",
  "path": "/jogada"
}
```

## Listagem de Jogadas

Para verificar as jogadas já realizadas, seguir os passos abaixo:

1. Endpoint: /jogada/listar
2. Método: GET
3. Response:
```javascript
[
    {
        "jogador": "Jogador 1",
        "escolha": "LAGARTO"
    },
    {
        "jogador": "Jogador 2",
        "escolha": "PEDRA"
    },
    {
        "jogador": "Jogador 3",
        "escolha": "PAPEL"
    },
    {
        "jogador": "Jogador 4",
        "escolha": "TESOURA"
    },
    {
        "jogador": "Jogador 5",
        "escolha": "SPOCK"
    }
]
```

## Exclusão de Jogadas (Reset de Jogo)

Para remover todas as jogadas, ou seja, reiniciar o jogo, seguir os passos abaixo:

1. Endpoint: /jogada
2. Método: DELETE
3. Ao ser consumido o endpoint <b>/jogada</b>, via método <i>DELETE</i>, a aplicação fará a exclusão de todas as jogadas já cadastradas.
5. Resposta de sucesso esperada: <b>HttpStatus 204 - No Content</b>

## Cadastramento de Jogadores

Não é obrigatório o cadastramento de um jogador para efetuar a jogada, mas isso fica para outra conversa.

Para se criar um jogador, seguir os passos abaixo:

1. Endpoint: /jogador
2. Método: POST
3. Payload:
```javascript
{
    "nome": "Nome do jogador"
}
```

4. Ao ser consumido o endpoint <b>/jogador</b>, via método <i>POST</i>, a aplicação avaliará se esse jogador já fora incluído.
5. Resposta de sucesso esperada: <b>HttpStatus 201 - Created</b>
6. Caso o jogador tenha sido cadastrado anteriormente, será respondido <b>HttpStatus 400 - Bad Request</b>, com o response abaixo:

```javascript
{
    "timestamp": "2020-04-30T15:18:55.542+0000",
    "status": 400,
    "error": "BAD_REQUEST",
    "exception": "TbbtJankenponGeneralException",
    "message": "Esse jogador já foi cadastrado.",
    "path": "/jogador"
}
```

## Listagem de Jogadores

Para verificar os jogadores já cadastrador, seguir os passos abaixo:

1. Endpoint: /jogador
2. Método: GET
3. Response:
```javascript
[
    {
        "nome": "Jogador 1"
    },
    {
        "nome": "Jogador 2"
    },
    {
        "nome": "Jogador 3"
    },
    {
        "nome": "Jogador 4"
    },
    {
        "nome": "Jogador 5"
    }
]
```

## Exclusão de Jogadores

Para remover um determinado jogador, seguir os passos abaixo:

1. Endpoint: /jogador
2. Método: DELETE
3. Payload:
```javascript
{
    "nome": "Nome do jogador"
}
```
3. Ao ser consumido o endpoint <b>/jogador</b>, via método <i>DELETE</i>, a aplicação fará a exclusão desse jogador.
5. Resposta de sucesso esperada: <b>HttpStatus 204 - No Content</b>

## Testes

Para execução dos testes da aplicação, digite o seguinte comando na pasta raiz do projeto:

- Windows:

  ```javascript
  \tbbt-jankenpon>gradlew clean test
  ```

- Linux:
  ```javascript
  $ ./gradlew clean test
  ```

Será gerado o arquivo index.html, pelo Gradle, com o resultado dos testes, na pasta "/build/reports/tests/test/":

<img src="https://github.com/jokarichardson/tbbt-jankenpon/blob/master/src/main/resources/resultado_testes.png" />
