# animal-adoption

## Index
1. [Service Purpose](#service-purpose)
2. [Project directory structure](#project-directory-structure)
3. Project stack:<br>
   3.1. [Migrations](#migrations) <br>
   3.2. [Technologies used](#technologies-used) <br>
   3.3. [Running the unit tests](#running-the-tests) <br>
   3.4. [Running locally Gradle](#running-locally-with-gradle) <br>
   3.5. [Running with Docker](#running-with-docker) <br>
4. [Requests example](#requests-example) <br>


## Purpose of Service
API for animal adoption.

## Project directory structure

```
src
├──main
| ├──java
| | ├──api
| | ├──dto
| | ├──exception
| | ├──integration
| | | ├──client
| | | ├──config
| | | ├──dto
| | | ├──error
| | | ├──service
| | ├──model
| | ├──repository
| | ├──service
├──test
| ├──java
.gitignore
Dockerfile
build.gradle
README.md
```

## Migrations
> For naming the creation of migrations, you must use V + 1 and a description of that migration as follows:

| Recommended       | Not recommended |
|-------------------|-----------------|
| V1__create_tables | V1__Tables      |

## Technologies used
- Java 17
- SpringBoot 3.0.5
- Gradle 7.6.1
- Docker
- H2
- flyway

## Running the tests

To run the tests, access the root folder of the project and run the command below.

     gradle clean build

## Running locally with Gradle
To run the application run the command below.

     gradle bootRun

## Running with Docker
To run docker, use the following commands:
```docker
docker build -t wilkerjmachado/animal-adoption . 
```
```docker
docker run -p 8080:8080 wilkerjmachado/animal-adoption
```

# Swagger
http://localhost:8080/api/swagger-ui/index.html

## Requests example

### Index partners' animals

```
POST http://localhost:8080/api/animal/integration/index
```

### Pageable list
```
POST http://localhost:8080/api/animal/pageable?page=0&size=10&term=aby

{
  "status": "ADOPTED",
  "category": "CAT",
  "created_at": "2023-03-26"
}
```

### Update
```
PATCH http://localhost:8080/api/animal/1

{
  "status": "ADOPTED"
}
```