# OS Works API

API criada para fins de aprendizado e integração de CI/CD com o Azure Pipelines.
  - Desenvolvimento de API Rest com Spring Boot
  - Testes unitário com TDD
  - Versionamento com Git

# Features!

  - Manutenção de clientes numa base de dados.
  - Realiza uma abertura de chamado de ordem de serviço para um determinado cliente.


### Tecnologias

OS Works foi desenvolvido utilizando as seguintes tecnologias:

* Java - versão 8
* Spring boot - 2.4.0
* Swagger  
* Postgres
* Flyway
* Gradle
* Docker
* Azure Pipelines

OS Works API está disponível [public repository][dill] no GitHub.

### Instalação

...em breve.

### Development
```sh
$ ./gradlew clean build
```
```sh
$ ./gradlew bootRun
```
### Docker

```sh
cd osworks-api
docker build -t osworks-api .
```

```sh
docker run -d -p 8000:8080 
```
