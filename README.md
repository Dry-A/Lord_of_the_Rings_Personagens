# Personagens Senhor dos Anéis

<h3>Projeto em Java com Spring e Maven.</h3>

<h4>Java 17</h4>
<h4>Spring 3.2.0</h4>
<h4>Docker Compose</h4>
<h4>Postgre</h4>
<h4>Dbeaver</h4>
<h4>Git e Github</h4>
<h4>Teste Unitário</h4>
<h4>Teste Integrado</h4>

 <h3 style="color: cornflowerblue"> <strong> Dependências iniciais:
<ol>
<li>Spring Web,</li>
<li>Spring Boot Dev Tools,</li>
<li>Lombok,</li>
<li>Spring Data JPA,</li>
<li>Validation</li>
<li>Postgre Sql</li>
<li>Docker Compose</li>
</ol>
     A configuração do Banco de dados será implementada no arquivo application.properties,
localizado na Source Folder src/main/resources</strong></h3>

<img  style="margin-top:20px" src="https://i.imgur.com/KwvKR9u.png">
<br><br><br>
<h3>Neste projeto utilizei o Intellij ultimate por ter licença gratuita para estudante </h3>

<img  style="margin-top:20px" src="https://i.imgur.com/CQZDywQ.png">



<br><br>
<h3>Criaçao da classe Personagens, PersonagensRepository e PersonagensController </h3>


<br><br>
<h3>Com o projeto em execução, inseri valores na tabela Categoria pelo DBeaver:</h3>
<img  style="margin-top:20px" src="https://i.imgur.com/pHlqfYH.png">


<h2>Relacionamento de Classes</h2>
Mapeamento Objeto-Relacional (ORM) é o processo de conversão de Objetos Java em Tabelas (Entidades) de Banco de dados. Em outras palavras, isso nos permite interagir com um Banco de
dados Relacional sem nenhum código SQL. A Java Persistence API (JPA) é uma especificação que define como persistir dados em aplicativos Java.
<br>
<br>
O foco principal do JPA é a camada ORM.
O JPA simplifica o tratamento do modelo de Banco de dados Relacional nos aplicativos Java quando mapeamos cada Tabela para uma única Classe de entidade (Model). No SQL, precisamos criar Relacionamentos entre as tabelas, no JPA também.

o Relacionamento Bidirecional (1:N) entre as Classes Personagens e Categorias

A Classe Personagens será o <strong>lado N:1,</strong> ou seja, Muitos Personagens podem ter apenas <strong>Uma Categoria.</strong>


<h3>Tipos de Cascade -  Utilizei o ALL</h3>
<br><br>

<h2 style="color: cornflowerblue">Testes no Insomnia dos verbos HTTP: </h2>
<img  style="margin-top:20px" src="https://i.imgur.com/CtGQkhJ.png">
<img  style="margin-top:20px" src="https://i.imgur.com/SGhX0vk.png">
<img  style="margin-top:20px" src="https://i.imgur.com/0S8J7L2.png">
<img  style="margin-top:20px" src="https://i.imgur.com/SGhX0vk.png">
<img  style="margin-top:20px" src="https://i.imgur.com/jpezrgx.png">
<img  style="margin-top:20px" src="https://i.imgur.com/0S8J7L2.png">
<img  style="margin-top:20px" src="https://i.imgur.com/EazE5Xq.png">
<br>
<br>
<br>
<h2>O relacionamento entre as classes visto no GET: </h2>
<img  style="margin-top:20px" src="">

<br>
<br>
<br>
<h2>Adiçao do framework Security</h2>

<img  style="margin-top:20px" src="">



<br>
<br>
<br>
<h2>Criaçao das Classes Usuario, UsuarioLogin, UsuarioRepository</h2>



<img  style="margin-top:20px" src="">
