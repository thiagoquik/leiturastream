#Processo seletivo para Desenvolvedor Java
Repositório para armazenar as aplicações desenvolvidas para o processo seletivo para desenvolvedor java

#Frameworks e ferramentas utilizadas
O projeto foi desenvolvido utilizando os seguintes tecnologias:
- Java 8
- Spring Boot
- Spring Web Mvc
- Tomcat embutido
- Bootstrap
- Thymeleaf
- JavaScript
- JQuery
- Maven
- JUNIT
- GSON

#Arquitetura do projeto
- Ambiente de execução embutido - Utilizado o Tomcat embutido, disponibilizado pelo SpringBoot.
- MVC - Projeto desenvolvido respeitando as camadas de  Modelo, Telas e Controladores.
- REST - Esta aplicação disponibiliza um serviço REST para pesquisa de cep. Recebe e responde no formato JSON.

#Pré requisitos
- Java 8
- Maven
	
#Configurações

Os arquivos de propriedades da aplicação se encontram no caminho: src/main/resources

-Application.properties : arquivo de propriedades do Spring

A aplicação está configurada para subir na porta 8083. Caso haja necessidade de alterar esta porta é só alterar o número dela na propriedade server.port do arquivo Application.properties.

#Execução do projeto
Maven: $ mvn clean package spring-boot:run

Utilizando uma IDE: Executar a classe \src\main\java\br\com\tgolopes\LeituraStreamApplication.java
	
Abra o browser e digite http://localhost:8083 esta é a página inicial da aplicação.




