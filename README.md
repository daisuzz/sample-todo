# sample-thymeleaf-todo

Sample Todo application with Spring Boot and Thymeleaf.

#### Application

- Java 21, Kotlin 1.9.24
- Spring Boot 3.3.1
- Spring Security 6.3.1
- Thymeleaf 3.1
- MySQL 5.7
- Mybatis 3.5.14

#### Infrastructure

- Docker Compose
- Buildpack

#### Testing, CI/CD

- JUnit
- Testcontainers
- ArchUnit
- Jacoco
- Codecov
- GitHub Action
- OpenRewrite
- Schemaspy

# Usage

## build application container

```
make build
```

## start

```
make all
```

## down

```
make down
```

## start db

```
make db-up
```
