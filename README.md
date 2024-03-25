# Controle de Processos Judiciais da Advocacia Dr. Benezinho ⚖️🤓👍🏾

SIMULADO - **Java Advanced** aplicado em 05/03/2024.


| ![](documentacao/fiap.jpg)               | **Java Advanced** |
|------------------------------------------|-------------------|
| **ALUNO:**                               | **TURMA:** 2TDSPG |
| **PROFESSOR:** Benefrancis do Nascimento | 05/03/2024        |
| **SIMULADO**                      | ****              |

# Sumário


[Estudo de caso ](#_Estudo_de_caso)

[O que deverá ser feito? ](#_O_que_devera_ser_feito)

[Diagrama de Classes ](#_Diagrama_de_Classes)

[Como Entregar ](#_Entrega)

[Correção da Prova ](#_Correcao)

<a id="_Estudo_de_caso"></a>

# Estudo de caso

Com o objetivo de aprimorar as atividades de trabalho, idealizamos o desenvolvimento de um Sistema de Gestão de Processos Judiciais.

Criaremos, nesta aula, um Produto Mínimo Viável (PMV) de uma API Rest para um sistema para controle de processos judiciais. 



Nossa equipe de analistas desenvolveu o Diagrama de Classes abaixo, e a sua missão aqui é realizar o Mapeamento Objeto Relacional das classes de Entidade. Usaremos a JPA e o Hibernate como ferramentas de Mapeamento Objeto Relacional.

Na sprint atual, você foi incumbido de fazer:

1. O Mapeamento Objeto Relacional das primeiras classes envolvidas neste projeto de software;

2. A criação automatizada das tabelas no banco de dados Oracle;

3. A persistência de todos os dados, e;

4. A criação dos Seguintes Repositories :

   1. ProcessoRepository
   2. AdvogadoRepository
   3. EstadoRepository
   4. TipoDeAcaoRepository

5. A criação dos Seguintes Resources:

   1. ProcessoResource com as seguintes ROTAS e VERBOS:
      1. "localhost/processo" - **GET**, **POST**
      2. "logalhost/processo/{id}" - **GET**

   2. AdvogadoResource com as seguintes ROTAS e VERBOS:
      1. "localhost/advogado" - **GET**, **POST**
      2. "logalhost/advogado/{id}" - **GET**
      
   3. EstadoResource com as seguintes ROTAS e VERBOS:
      1. "localhost/estado" - **GET**, **POST**
      2. "logalhost/estado/{id}" - **GET**
      
   4. TipoDeAcaoResource com as seguintes ROTAS e VERBOS:
      1. "localhost/tipo-de-acao" - **GET**, **POST** 
      2. "logalhost/tipo-de-acao/{id}" - **GET**


<a id="_O_que_devera_ser_feito"></a>

# O que deverá ser feito?


**Você deverá:**

**Fazer o fork do projeto do github.**:

[https://github.com/Benefrancis/spring-pg-advocacia](https://github.com/Benefrancis/spring-pg-advocacia)

Caso o github esteja indisponível, você deverá pegar o projeto no diretório compartilhado.

Alterar o arquivo contido em  **documentacao/equipe.txt** para incluir os RMs e nomes e turma da dupla que fará esta atividade.

**OBS:** Será com base nos nomes contidos neste aquivo que eu irei atribuir a nota.

1. **(0,5 Ponto)** acessar o arquivo **application.yml** e incluir as configurações para **persistencia** para que seja possível conectar-se ao banco de dados Oracle da FIAP com o seu usuário e senha (manter o seu usuário e senha ativo é sua responsabilidade). Não utilize o usuário e senha de outro aluno. Caso tenha problema para autenticar, comunique o professor.

## No pacote entity, criar as seguintes classes

2. **(1 Pontos)** Criar a classe **Processo** e adicionar corretamente as anotações JPA.

    Lembre-se que:


    1. Existe relacionamento **Muitos para Um** entre **Processo** e **Advogado** no atributo advogado.
    2. Existe relacionamento **Muitos para Um** entre **Processo** e **TipoDeAcao** no atributo tipoDeAcao. 


3. **(0,5 Ponto)** Criar a classe **Advogado** e adicionar corretamente as anotações JPA.
    

   Lembre-se que:

    1. Existe relacionamento **Muitos para Um** entre **Advogado** e **Estado** a no atributo estado.


4. **(0,5 Ponto)** Criar a classe **Estado** e adicionar corretamente as anotações JPA.


5. **(0,5 Ponto)** Criar a classe **TipoDeAcao** e adicionar corretamente as anotações JPA.


## No pacote resources criar as seguintes classes

6. **(6 Ponto)**  A perfeita criação dos Seguintes Resources no pacote resources:

   1. ProcessoResource com as seguintes ROTAS e VERBOS:
       1. **(0,5 Ponto)** "localhost/processo" - **GET**;
       2. **(0,5 Ponto)** "localhost/processo" - **POST**;
       3. **(0,5 Ponto)** "logalhost/processo/{id}" - **GET**

   2. AdvogadoResource com as seguintes ROTAS e VERBOS:
      1. **(0,5 Ponto)** "localhost/advogado" - **GET**;
      2. **(0,5 Ponto)** "localhost/advogado" - **POST**;
      3. **(0,5 Ponto)** "logalhost/advogado/{id}" - **GET**

   3. EstadoResource com as seguintes ROTAS e VERBOS:
      1. **(0,5 Ponto)** "localhost/estado" - **GET**;
      2. **(0,5 Ponto)** "localhost/estado" - **POST**;
      3. **(0,5 Ponto)** "logalhost/estado/{id}" - **GET**

   4. TipoDeAcaoResource com as seguintes ROTAS e VERBOS:
      1. **(0,5 Ponto)** "localhost/tipo-de-acao" - **GET**;
      2. **(0,5 Ponto)** "localhost/tipo-de-acao" - **POST**;
      2. **(0,5 Ponto)** "logalhost/tipo-de-acao/{id}" - **GET**

## No pacote repository criar as seguintes interfaces

7. **(1 Ponto)** A criação dos Seguintes Repositories :

   1. **(0,25 Ponto)** ProcessoRepository
   2. **(0,25 Ponto)** AdvogadoRepository
   3. **(0,25 Ponto)** EstadoRepository
   4. **(0,25 Ponto)** TipoDeAcaoRepository


<a id="_Diagrama_de_Classes"></a>

# Diagrama de Classes

<img src="documentacao/diagrama.png">


<a id="_Entrega"></a>

# Como Entregar

**A entrega deverá ser feita pelo Teams**, porém não se esqueça de fazer o **commit** e **push** do projeto no github.


<a id="_Correcao"></a>

# Correção da Prova

Nos próximos dias, a correção da prova será disponibilizada no github do professor (branch correcao):

Para acessar digite no prompt:

```shell
git clone https://github.com/Benefrancis/spring-pg-advocacia && cd spring-pg-advocacia && git checkout correcao
```


A atividade é em dupla, não se esqueça de colocar o nome dos integrantes no arquivo contido em documentacao/equipe.txt. Em caso de fraude de qualquer tipo, todos os envolvidos receberão nota ZERO.

Boa avaliação.
