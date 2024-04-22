<h2> :dart: Objetivo </h2>
Criar uma aplicação back-end (Java ou NodeJS) baseada em web services usando JSON.
Deverá haver um front-end em modo Single Page Application que se comunique com os serviços criados no back-end.

<h2> :bookmark_tabs: Requisitos </h2>
• Permitir o cadastro de veículos
• Permitir a atualização de dados de um veículo
• Permitir a exclusão de um veículo
• Exibir a informação de quantos veículos estão como não vendidos na base.
• Exibir a informação da distribuição de veículos por década de fabricação

Exemplo:

Década 1990->15 veículos
Década 2000->31 veículos

• Exibir a informação da distribuição de veículos por fabricante.

Exemplo:
Ford -> 14 veículos
Honda -> 8 veículos

• Exibir os carros registrados durante a última semana.
Deverá haver consistência das marcas fornecidas. Não poderá haver marcas escritas de forma errada (Exemplo: Volksvagen, Forde, Xevrolé, etc. não serão aceitos no cadastro)

<br>

<h2> 📋 Telas Realizadas </h2>
<h3> Tela Gestão de Veículos </h3>

![Image](https://github.com/danilo-batista1/desafio-tinnova/blob/main/img/TelaBase.JPG)

<h3> Tela Editar Veículo </h3>

![Image](https://github.com/danilo-batista1/desafio-tinnova/blob/main/img/TelaEditar.png)

<br>

<h2> Instalação </h2>

<h3> Bancos de Dados </h3>

```sql
-- CreateTable
CREATE TABLE IF NOT EXISTS veiculos (
    id Serial,
    veiculo character varying(50),
    marca character varying(50),
    ano integer,
    cor character varying(30),
    descricao character varying(200),
    vendido boolean,
    created timestamp,
    updated timestamp
)
```

<h3>Back-End </h3>

<h2>OBS: Você precisará do Java 17+ e do Maven instalados em seu computador para construir este aplicativo.</h2>

    1º) $ git clone https://github.com/danilo-batista1/desafio-tinnova.git
  
    2º) $ cd desafio-tinnova

    3º) $ mvn clean install -DskipTests
  
    4º) $ mvn spring-boot:run

<h3>Front-End </h3>

    1º) cd .\front-end\
  
    2º) npm i
  
    3º) npm start

<br>

<h2> Documentação das rotas. <br> Entendendo a lógica da API desenvolvida neste projeto. </h2>

![Swagger](https://github.com/danilo-batista1/desafio-tinnova/blob/main/img/Swagger-UI.pdf)
