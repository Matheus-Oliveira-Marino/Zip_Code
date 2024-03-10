# Consulta Geográfica 🗺️
 - [ ] Este é um projeto Java voltado para a exploração e consulta de informações geográficas de maneira intuitiva e eficiente. Com uma interface gráfica amigável, o aplicativo permite aos usuários obterem detalhes precisos sobre endereços, cidades e estados do Brasil.


## 💡 Funcionalidades

O programa oferece um conjunto abrangente de funcionalidades:

- [ ] __*Adição de Novos Registros*__: Os usuários podem adicionar novos registros de CEP ao banco de dados, facilitando a expansão e atualização constante das informações.

- [ ] __*Exclusão de Registros*__: Caso seja necessário remover um registro de CEP do banco de dados, a aplicação oferece a funcionalidade de exclusão, proporcionando flexibilidade no gerenciamento de dados.

- [ ] __*Atualização de Informações*__: Além da exclusão, os usuários também podem atualizar informações existentes, como correções de endereço CEP, números de rua, nome do local e o valor identificador do registro no Banco de Dados, garantindo a precisão e relevância dos dados armazenados.

- [ ] __*Consulta de Endereços por CEP*__: Se houver um CEP válido, é possivel obter instantaneamente informações detalhadas sobre o endereço associado, incluindo logradouro, bairro, cidade, estado e outras informações úteis.

- [ ] __*Visualização de Detalhes Geográficos*__: Além de consultar endereços, é possível explorar informações sobre cidades e estados, como código IBGE e área em quilômetros quadrados, oferecendo uma visão abrangente sobre a geografia do Brasil.

- [ ] __*Interface Gráfica Intuitiva*__: A interface gráfica foi desenvolvida visando a facilidade de uso, permitindo uma navegação fluida e intuitiva para usuários de todos os níveis de experiência.


## 🚀 Tecnologias Utilizadas

- [ ] `Java`: A linguagem de programação __*Java*__ foi escolhida pela sua versatilidade e robustez, garantindo um desenvolvimento sólido e confiável.

- [ ] `Swing`: Utilizando o framework __*Swing*__, a aplicação oferece uma experiência visual agradável e responsiva, tornando a interação com o usuário mais atraente e eficiente.

- [ ] `Jackson`: A biblioteca __*Jackson*__ é empregada para lidar com o processamento de dados JSON, facilitando a comunicação com serviços web e o parseamento de informações geográficas.


## :exclamation: Requisitos do Sistema 

1. Certifique-se de ter o `Java JDK` instalado em seu sistema. Link para [download](https://www.oracle.com/java/technologies/downloads/).

     1.1 Instalação __*Windows 10*__: [Link do tutorial](https://www.youtube.com/watch?v=AUL--F5Wdh8).

    1.2 Instalação __*Windows 11*__: [Link do tutorial](https://www.youtube.com/watch?v=krGadRGdESQ).

    1.3 Instalação __*Linux 22.04 LTS*__: [Link do tutorial](https://www.youtube.com/watch?v=vVrIDJ--GOA).


<br>

2. IDE para execução, como [VSCode](https://code.visualstudio.com/) ou [IntelliJ](https://www.jetbrains.com/idea/download/?section=windows).

<br>


## 🔧 Como Usar

1. Clone este repositório ou faça download do projeto completo.

2. Crie um `script SQL` como [este](https://github.com/Matheus-Oliveira-Marino/Zip_Code/blob/main/shopping.sql), utilizando o banco de dados `SQLServer` ou `SQL`.

3. Configure a conexão com o BD na classe `BDSQLServer.java`. Observações:

> <div style="text-align: center;">
>    <p align="center">
>        <h3> SQL Server: </h3>  
>        Driver JDBC: com.microsoft.sqlserver.jdbc.SQLServerDriver  
>        <br>
>        URL de Conexão: jdbc:sqlserver://<hostname>:<port>;databaseName=<database>
>        <br>
>    </p>
> </div>


> <div style="text-align: center;">
>    <p align="center">
> <br> 
> Substitua 'hostname' pelo endereço do servidor SQL Server, 'porta' pela porta de conexão (geralmente 1433 por padrão) e 'database' pelo nome do banco de dados.
>    </p>
> </div>
 
<br>
<br>

> <div style="text-align: center;">
>    <p align="center">
>        <h3> MySQL: </h3>
> Driver JDBC: com.mysql.cj.jdbc.Driver
> URL de Conexão: jdbc:mysql://<hostname>:<port>/<database>?useSSL=false&serverTimezone=UTC
>    </p>
> </div>

> <div style="text-align: center;">
>    <p align="center">
> <br>
> Substitua 'hostname' pelo endereço do servidor MySQL, 'port' pela porta de conexão (geralmente 3306 por padrão) e 'database' pelo nome do banco de dados.
>    </p>
> </div>

<br>

4. No arquivo `ShoppingTela.java`, compile e execute clicando em `run`.

5. Siga as instruções descritas na interface de CEP para cadastro, procura, exclusão e alteração de dados.

## 🏃‍♂️ Primeiros Passos

Bem-vindo ao mundo do Java no VS Code. Aqui está um guia para ajudá-lo a começar a escrever código Java no Visual Studio Code.

##  📁  Estrutura de Pastas

O espaço de trabalho contém duas pastas por padrão, onde:

- `src`: A pasta para manter os arquivos de origem.
- `lib`: A pasta para manter as dependências.

Enquanto isso, os arquivos de saída compilados serão gerados na pasta `bin` por padrão.

> Se você deseja personalizar a estrutura de pastas, abra `.vscode/settings.json` e atualize as configurações relacionadas lá.

## 🔄 Gerenciamento de Dependências

A visualização `JAVA PROJECTS` permite que você gerencie suas dependências. Mais detalhes podem ser encontrados [aqui](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

📜 Licença
Este projeto está licenciado sob a [MIT LICENSE](https://github.com/Matheus-Oliveira-Marino/Zip_Code/blob/main/LICENSE). Consulte o arquivo para obter detalhes.
