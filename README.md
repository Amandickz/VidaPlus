## 📦 VidaPlus Saúde - Gerenciamento Hospitalar
> Sistema Backend em Java para finalização do Curso, com o propósito de desenvolver um sistema de Gerenciamento Hospitalar e Saúde.

### ✅ Pré-requisitos
>Antes de executar o sistema, certifique-se de ter os seguintes softwares instalados:<br>
Java JDK 21+ (Configurar a váriável de sistema para conseguir compilar o projeto)<br>
Maven (Configurar a váriável de sistema para conseguir compilar o projeto no terminal)<br>
MySQL Server<br>
MySQL Workbench (Opicional)<br>
Postman (caso queira realizar testes)<br>

### ⚙️Configuração do Banco de Dados
1. Acesse seu MySQL com seu usuário e senha
2. Abra a pasta Banco de Dados e execute o Script DB para criar a base e as tabelas do sistema
3. Atualize as informações do seu acesso de banco de dados no arquivo DB.java (VidaPlus-v1 > src > main > java > dao > DB.java)

### 🚀 Executando o sistema
1. Para executar o sistema abra a pasta VidaPlus-v1
2. Execute o Terminal dentro dessa pasta (confira está na pasta correta: a pasta terá um arquivo chamado <b>pom.xml</b> e então aperte o botão direito do mouse > "Abrir no Terminal)
4. Para executar o sistema digite "mvn clean compile exec:java"
5. A tela inicial irá aparecer e você poderá acompanhar na tela do Terminal todas as suas execuções conforme for realizadas.

#### Sobre esse projeto
> Ele foi desenvolvido na plataforma ApacheNetbeans 25, então caso queira, você pode utilizar a plataforma para compilar o arquivo sem problemas. Basta fazer um git clone do projeto e abri-lo no Netbeans.
