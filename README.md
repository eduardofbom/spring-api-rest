# Spring API REST 🚀

Uma API REST simples e educativa desenvolvida com **Spring Boot 4.0.5** e **Java 21**, demonstrando os princípios fundamentais de desenvolvimento de APIs RESTful.

## ✨ Características

- ✅ **Spring Boot 4.0.5** - Framework moderno para aplicações Java
- ✅ **Java 21** - Versão LTS mais recente do Java
- ✅ **Arquitetura em Camadas** - Separação clara entre Controller, Service e Domain
- ✅ **Lombok** - Redução de boilerplate com anotações
- ✅ **Maven** - Gerenciamento de dependências e build
- ✅ **Múltiplos Endpoints** - GET e POST com parâmetros variados
- ✅ **Perfis de Ambiente** - Configuração para dev e produção
- ✅ **DevTools** - Hot reload automático durante desenvolvimento

## 📋 Pré-requisitos

Antes de começar, você precisa ter instalado:

- **Java 21+** - [Download OpenJDK](https://jdk.java.net/21/)
- **Maven 3.8.7+** - [Download Maven](https://maven.apache.org/download.cgi)
- **Git** - [Download Git](https://git-scm.com/)
- **Postman** ou **cURL** - Para testar os endpoints (opcional)

### Verificar Instalações

```bash
java -version
mvn -version
git --version
```

## 🚀 Instalação

### 1. Clone o Repositório

```bash
git clone https://github.com/SEU_USUARIO/spring-api-rest.git
cd spring-api-rest
```

### 2. Compile o Projeto

```bash
mvn clean compile
```

### 3. Execute a Aplicação

**Produção (porta 3000):**
```bash
mvn spring-boot:run
```

**Desenvolvimento (porta 8080):**
```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=dev"
```

A aplicação estará disponível em `http://localhost:3000` (ou `http://localhost:8080` se em modo dev).

## 📚 Endpoints

### 1. GET /hello-world
Retorna uma saudação simples.

**Request:**
```bash
curl -X GET http://localhost:3000/hello-world
```

**Response:**
```
Hello World: Eduardo
```

---

### 2. POST /hello-world
Retorna uma saudação personalizada com base nos dados do usuário.

**Request:**
```bash
curl -X POST http://localhost:3000/hello-world \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Eduardo",
    "email": "eduardo@example.com"
  }'
```

**Response:**
```
Hello World Eduardo(eduardo@example.com)
```

---

### 3. POST /hello-world/{id}
Retorna uma saudação personalizada com ID e filtro (query parameter).

**Request:**
```bash
curl -X POST "http://localhost:3000/hello-world/123?filter=active" \
  -H "Content-Type: application/json" \
  -d '{
    "name": "João",
    "email": "joao@example.com"
  }'
```

**Response:**
```
Hello World João (joao@example.com : 123) | filter=active
```

---

## 🧪 Testando com Postman

### Importar Collection

1. Abra o Postman
2. Crie uma nova requisição para cada endpoint acima
3. Configure os headers e body conforme exemplos

### Exemplo de Requisição POST

| Propriedade | Valor |
|-------------|-------|
| Method | POST |
| URL | `http://localhost:3000/hello-world` |
| Headers | `Content-Type: application/json` |
| Body (raw) | `{"name": "Eduardo", "email": "eduardo@example.com"}` |

## 📁 Estrutura do Projeto

```
spring-api-rest/
├── src/
│   ├── main/
│   │   ├── java/com/eduardofbom/spring_api_rest/
│   │   │   ├── SpringApiRestApplication.java       # Classe principal
│   │   │   ├── controller/
│   │   │   │   └── HelloWorldController.java       # Endpoints HTTP
│   │   │   ├── service/
│   │   │   │   └── HelloWorldService.java          # Lógica de negócio
│   │   │   ├── domain/
│   │   │   │   └── User.java                       # Modelo de dados
│   │   │   └── configuration/
│   │   │       └── HelloWorldConfiguration.java    # Configurações
│   │   └── resources/
│   │       ├── application.properties              # Config padrão
│   │       └── application-dev.properties          # Config desenvolvimento
│   └── test/
│       └── java/...                                # Testes unitários
├── pom.xml                                         # Dependências Maven
├── mvnw                                            # Maven Wrapper (Linux/Mac)
├── mvnw.cmd                                        # Maven Wrapper (Windows)
└── README.md                                       # Este arquivo
```

## ⚙️ Configuração

### application.properties (Produção)

```properties
spring.application.name=spring-api-rest
server.port=3000
spring.datasource.url=mysql://localhost:3306/
spring.datasource.username=root
spring.datasource.password=root
spring.profiles.active=dev
```

### application-dev.properties (Desenvolvimento)

```properties
server.port=8080
```

Para usar um perfil diferente, defina a variável de ambiente:

```bash
export ACTIVE_PROFILE=dev
mvn spring-boot:run
```

## 🔨 Build e Packaging

### Gerar JAR Executável

```bash
mvn clean package
```

O arquivo JAR será gerado em `target/spring-api-rest-0.0.1-SNAPSHOT.jar`

### Executar o JAR

```bash
java -jar target/spring-api-rest-0.0.1-SNAPSHOT.jar
```

## 📦 Dependências

- **Spring Boot Web MVC** - Para criar endpoints REST
- **Spring Boot DevTools** - Para hot reload durante desenvolvimento
- **Lombok** - Para reduzir boilerplate (getters, setters, construtores)

Todas as dependências estão declaradas no `pom.xml`

## 💡 Conceitos Demonstrados

Este projeto ilustra:

- ✅ Estrutura **MVC** (Model-View-Controller)
- ✅ **Padrão de Camadas** (Controller → Service → Domain)
- ✅ Injeção de Dependência com `@Autowired`
- ✅ **Anotações Spring** (@RestController, @RequestMapping, @GetMapping, @PostMapping)
- ✅ Tratamento de **Requisições HTTP**
- ✅ Serialização/Desserialização de **JSON**
- ✅ **Path Variables** e **Query Parameters**
- ✅ Uso de **Lombok** para reduzir código

## 🐛 Troubleshooting

### Erro 400 - Bad Request

**Problema:** Recebe status 400 ao fazer POST

**Solução:**
- Certifique-se de enviar o header `Content-Type: application/json`
- Valide o JSON enviado (use jsonlint.com)
- Verifique se os campos `name` e `email` estão preenchidos

### Porta já em uso

**Problema:** `Address already in use`

**Solução:**
```bash
# Encontre qual processo está usando a porta
lsof -i :3000

# Mate o processo
kill -9 <PID>
```

### Maven não encontrado

**Problema:** `Command 'mvn' not found`

**Solução:**
- Use o Maven Wrapper: `./mvnw clean install` (Linux/Mac) ou `mvnw.cmd clean install` (Windows)

## 📖 Recursos Adicionais

- [Documentação Spring Boot](https://spring.io/projects/spring-boot)
- [RESTful Web Services](https://spring.io/guides/gs/rest-service/)
- [Building a Web Application with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
- [Lombok Documentation](https://projectlombok.org/)

## 📄 Licença

Este projeto está sob a licença **MIT**. Veja o arquivo LICENSE para mais detalhes.

## 👤 Autor

**Eduardo** - [@eduardofbom](https://github.com/eduardofbom)

## 🤝 Contribuições

Contribuições são bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## ⭐ Se este projeto foi útil, deixe uma estrela!

---

**Desenvolvido usando Spring Boot e Java 21**
