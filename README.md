# Jogo de Jokenpô do Seriado The Big Bang Theory

<p align="center"><img src="https://github.com/jokarichardson/tbbt-jankenpon/blob/master/src/main/resources/sheldon_rspls.png" width="320" height="219" /></p>

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

## Tecnologias Utilizadas

- Java 8;
- Spring Boot;
- Gradle;
- REST

## Execução em Nuvem

Encontra-se em execução no Heroku, através da URL https://tbbt-jankenpon.herokuapp.com/


## Criação de Jogadas

Para se criar uma jogada, seguir os passos abaixo:

1. Endpoint: /jogada
2. Método: POST
3. Payload:

```javascript

```

2. Ao ser chamado o endpoint <b>/simian</b>, via método <i>POST</i>, a aplicação avaliará se se trata de humano ou símio:
```python
POST https://dna-analyzer.herokuapp.com/simian
```

3. Respostas de sucesso esperadas:
- Caso seja DNA mutante, será apresentada resposta com HttpStatus 200 - Ok;
- Caso seja DNA humano, será apresentada resposta com HttpStatus 403 - Forbidden.

4. Respostas de erro esperadas:
- Caso seja DNA inválido, será apresentada resposta "A cadeia informada não possui somente bases nitrogenadas A C G T.", com HttpStatus 400 - Bad Request;
- Caso a sequência de cadeias de DNA não formem uma matriz quadrada, será apresentada resposta "A cadeia informada não gerará uma matriz quadrada NxN.", com HttpStatus 400 - Bad Request;
- Caso a sequência de cadeias de DNA possua dados em branco, será apresentada respota "A cadeia possui sequencia em branco.", com HttpStatus 400 - Bad Request.

## Estatísticas de DNA

1. Para verificar as estatísticas de análise de cadeias de DNA, com a proporção de mutantes x humanos, execute uma chamada ao endpoint <b>/stats</b>, via método <i>GET</i>:
```python
GET https://dna-analyzer.herokuapp.com/stats
```

2. Será retornada estrutura JSON abaixo:
```javascript
{
  "count_mutant_dna": 4,
  "count_human_dna": 8,
  "ratio": 0.5
}
```
