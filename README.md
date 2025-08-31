# 🚀 Course - API REST com Spring Boot

<div align="center">

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.5-brightgreen.svg)
![Java](https://img.shields.io/badge/Java-21-orange.svg)
![Maven](https://img.shields.io/badge/Maven-3.x-blue.svg)
![H2 Database](https://img.shields.io/badge/H2-Database-lightblue.svg)

**Uma API REST moderna para gerenciamento de usuários, construída com Spring Boot e Java 21**

[📋 Pré-requisitos](#-pré-requisitos) • [⚡ Instalação Rápida](#-instalação-rápida) • [🔧 Configuração](#-configuração) • [📚 Documentação da API](#-documentação-da-api) • [🏗️ Arquitetura](#️-arquitetura)

</div>

---

## 📖 Sobre o Projeto

Este é um projeto de demonstração que implementa uma **API REST** para gerenciamento de usuários utilizando as melhores práticas do ecossistema Spring. O projeto foi desenvolvido com foco na **simplicidade**, **escalabilidade** e **boas práticas de desenvolvimento**.

### 🎯 Objetivos do Projeto

- ✅ Demonstrar a criação de uma API REST com Spring Boot
- ✅ Implementar operações CRUD básicas para usuários
- ✅ Utilizar JPA/Hibernate para persistência de dados
- ✅ Configurar banco de dados H2 para desenvolvimento
- ✅ Aplicar arquitetura em camadas (Controller, Service, Repository)

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Versão | Descrição |
|------------|--------|-----------|
| **Java** | 21 | Linguagem de programação com recursos modernos |
| **Spring Boot** | 3.5.5 | Framework para desenvolvimento de aplicações Java |
| **Spring Web** | - | Módulo para criação de APIs REST |
| **Spring Data JPA** | - | Abstração para acesso a dados com JPA |
| **H2 Database** | - | Banco de dados em memória para desenvolvimento |
| **Maven** | 3.x | Gerenciador de dependências e build |

---

## 📋 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- ☕ **Java 21** ou superior

  ```bash
  java -version
  ```

- 📦 **Maven 3.6+** (ou use o wrapper incluído)

  ```bash
  mvn -version
  ```

- 💻 **IDE** (recomendado: IntelliJ IDEA, Eclipse ou VS Code)

### 🔍 Verificando a Instalação

Execute os comandos abaixo para verificar se tudo está configurado:

```bash
# Verificar Java
java -version
# Deve mostrar: openjdk version "21.x.x"

# Verificar Maven (opcional - pode usar ./mvnw)
mvn -version
# Deve mostrar: Apache Maven 3.x.x
```

---

## ⚡ Instalação Rápida

### 1️⃣ Clone o Repositório

```bash
git clone <url-do-repositorio>
cd course
```

### 2️⃣ Execute a Aplicação

```bash
# Usando Maven Wrapper (recomendado)
./mvnw spring-boot:run

# Ou usando Maven instalado
mvn spring-boot:run
```

### 3️⃣ Verifique se Está Funcionando

Acesse: <http://localhost:8080/users>

Você deve ver uma resposta JSON (provavelmente uma lista vazia `[]`).

---

## 🔧 Configuração Detalhada

### 📁 Estrutura do Projeto

```
course/
├── src/
│   ├── main/
│   │   ├── java/com/educandoweb/course/
│   │   │   ├── CourseApplication.java          # Classe principal
│   │   │   ├── entities/
│   │   │   │   └── User.java                  # Entidade JPA
│   │   │   ├── repositories/
│   │   │   │   └── UserRepository.java        # Interface de repositório
│   │   │   ├── services/
│   │   │   │   └── UserService.java           # Lógica de negócio
│   │   │   ├── resources/
│   │   │   │   └── UserResource.java          # Controller REST
│   │   │   └── config/
│   │   │       └── TestConfig.java            # Configurações
│   │   └── resources/
│   │       ├── application.properties         # Configurações principais
│   │       └── application-test.properties    # Configurações de teste
│   └── test/                                  # Testes unitários
├── pom.xml                                    # Dependências Maven
└── README.md                                  # Este arquivo
```

### ⚙️ Configurações Importantes

#### `application.properties`

```properties
spring.application.name=course
spring.profiles.active=test, dev
spring.jpa.open-in-view=true
```

#### `application-test.properties`

```properties
# Configuração do H2 Database
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

# Console H2 habilitado
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Configurações JPA
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.defer-datasource-initialization=true
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### 🗄️ Acesso ao Banco H2

Durante o desenvolvimento, você pode acessar o console do H2:

1. **URL**: <http://localhost:8080/h2-console>
2. **JDBC URL**: `jdbc:h2:mem:testdb`
3. **Username**: `sa`
4. **Password**: (deixe em branco)

---

## 📚 Documentação da API

### 🎯 Endpoints Disponíveis

| Método | Endpoint | Descrição | Exemplo |
|--------|----------|-----------|---------|
| `GET` | `/users` | Lista todos os usuários | `GET /users` |
| `GET` | `/users/{id}` | Busca usuário por ID | `GET /users/1` |

### 📝 Exemplos de Uso

#### 1. Listar Todos os Usuários

```bash
curl -X GET http://localhost:8080/users
```

**Resposta:**

```json
[
  {
    "id": 1,
    "name": "João Silva",
    "email": "joao@email.com",
    "username": "joao123",
    "password": "senha123"
  }
]
```

#### 2. Buscar Usuário por ID

```bash
curl -X GET http://localhost:8080/users/1
```

**Resposta:**

```json
{
  "id": 1,
  "name": "João Silva",
  "email": "joao@email.com",
  "username": "joao123",
  "password": "senha123"
}
```

### 🧪 Testando com Postman/Insomnia

1. **Importe a coleção** (se disponível)
2. **Configure a base URL**: `http://localhost:8080`
3. **Execute as requisições** conforme os exemplos acima

---

## 🏗️ Arquitetura

### 📐 Padrão de Arquitetura

O projeto segue o padrão **MVC (Model-View-Controller)** com separação em camadas:

```
┌─────────────────┐
│   UserResource  │ ← Controller (REST)
│   (Controller)  │
└─────────────────┘
         │
         ▼
┌─────────────────┐
│   UserService   │ ← Service (Lógica de Negócio)
│   (Business)    │
└─────────────────┘
         │
         ▼
┌─────────────────┐
│ UserRepository  │ ← Repository (Acesso a Dados)
│   (Data Access) │
└─────────────────┘
         │
         ▼
┌─────────────────┐
│   H2 Database   │ ← Persistência
│   (In-Memory)   │
└─────────────────┘
```

### 🔄 Fluxo de Dados

1. **Request** → `UserResource` recebe a requisição HTTP
2. **Controller** → `UserService` processa a lógica de negócio
3. **Service** → `UserRepository` acessa os dados
4. **Repository** → H2 Database executa a consulta
5. **Response** ← Dados retornam pela mesma cadeia

### 📊 Entidade User

```java
@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String username;
    private String password;
    // ... getters, setters, equals, hashCode
}
```

**Campos:**

- `id`: Identificador único (auto-gerado)
- `name`: Nome completo do usuário
- `email`: Endereço de email
- `username`: Nome de usuário único
- `password`: Senha (em produção, deve ser criptografada)

---

## 🚀 Executando o Projeto

### 🎯 Modo Desenvolvimento

```bash
# 1. Clone o repositório
git clone <url>
cd course

# 2. Execute a aplicação
./mvnw spring-boot:run

# 3. Acesse a API
curl http://localhost:8080/users
```

### 🧪 Modo Teste

```bash
# Executar testes
./mvnw test

# Executar com cobertura
./mvnw test jacoco:report
```

### 📦 Build para Produção

```bash
# Gerar JAR
./mvnw clean package

# Executar JAR
java -jar target/course-0.0.1-SNAPSHOT.jar
```

---

## 🔍 Troubleshooting

### ❌ Problemas Comuns

#### 1. **Porta 8080 já está em uso**

```bash
# Solução: Mude a porta
echo "server.port=8081" >> src/main/resources/application.properties
```

#### 2. **Java não encontrado**

```bash
# Verifique se o JAVA_HOME está configurado
echo $JAVA_HOME  # Linux/Mac
echo %JAVA_HOME% # Windows
```

#### 3. **Maven não encontrado**

```bash
# Use o wrapper incluído
./mvnw spring-boot:run  # Linux/Mac
mvnw.cmd spring-boot:run # Windows
```

#### 4. **Erro de compilação**

```bash
# Limpe e recompile
./mvnw clean compile
```

### 🐛 Logs e Debug

Para ver logs detalhados, adicione ao `application.properties`:

```properties
logging.level.com.educandoweb.course=DEBUG
logging.level.org.springframework.web=DEBUG
```

---

### 🔗 Recursos Úteis

- 📖 [Documentação Spring Boot](https://spring.io/projects/spring-boot)
- 🎓 [Spring Boot Guides](https://spring.io/guides)
- 🛠️ [Spring Data JPA Reference](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- 🗄️ [H2 Database Documentation](http://www.h2database.com/html/main.html)

---

## 🤝 Contribuindo

1. **Fork** o projeto
2. **Crie** uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. **Commit** suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. **Push** para a branch (`git push origin feature/AmazingFeature`)
5. **Abra** um Pull Request

---

## 📄 Licença

Este projeto trata-se de um projeto acadêmico para fins de estudo e não tem fins lucrativos.

---

## 👨‍💻 Autor

**Breno Soares**

- 📧 Email: <cssbreno@gmail.com>
- 💼 LinkedIn: [linkedin.com/in/cssbreno](https://linkedin.com/in/cssbreno)

---

<div align="center">

Feito com ❤️ e ☕ (enfase no café)

</div>
