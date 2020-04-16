# PokéMate Backend Service
The backend service facilitates requests from the frontend with the micro-service infrastructure of the PokéMate&trade; application.
The backend service is a Spring Boot REST application.

## Prerequisites
| Dependency | Version | Required | Description      |
| ---------- | ------- | -------- | ---------------- |
| Java JDK   | 1.8     | True     | Java Environment |
| ---------- | ------- | -------- | ---------------- |

## Service Installation

Copy the files the generated jar-File into your execution environment:

```bash
cp pokemate-backend-{VERSION}.jar backend/executionEnv
```

### Without Docker

Create an execution environment to host the spring boot application.

Start the application:
```bash
java -jar pokemate-0.0.1-SNAPSHOT.jar

java -jar -Dspring.profiles.active=docker build/libs/pokemate-0.0.1-SNAPSHOT.jar --debug

```
### With Docker

Build the Docker container.

```bash
docker build --build-arg JAR_FILE=pokeMate/build/libs/*.jar -t pokemate/spring-backend .
```

Run the docker container and map the internal port to external port-

```bash
docker run -p 5100:8080 -t pokemate/spring-backend
```

### Run tests

```bash
curl localhost:5100
```
The test should return the following response:
Greetings from PokeMate!

### Swagger

Endpoints are documented using Swagger. To access the interactive documentation got to:
`/swagger`
