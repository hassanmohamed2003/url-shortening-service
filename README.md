# URL Shortening Service

A Spring Boot (Kotlin) backend for creating and managing short URLs.

Project reference: [roadmap.sh - URL Shortening Service](https://roadmap.sh/projects/url-shortening-service)

## Prerequisites

- Java 21
- PostgreSQL (local or remote)
- (Optional) Maven 3.9+ if you do not want to use the Maven wrapper

## Configuration

The app loads DB settings from `src/main/resources/env.properties` by default.

Default values:

```properties
DB_USERNAME=postgres
DB_PASSWORD=postgres
DB_URL=jdbc:postgresql://localhost:5432/url-shortening-service
```

Before running the app, make sure:

1. PostgreSQL is running.
2. A database named `url-shortening-service` exists.
3. Username/password in `env.properties` match your local database.

## Run locally

From the repository root:

```bash
./mvnw spring-boot:run
```

The API will start on:

- `http://localhost:3000`

## Build and run the JAR

```bash
./mvnw clean package
java -jar target/url-shortening-service-0.0.1-SNAPSHOT.jar
```

## Run tests

```bash
./mvnw test
```

## Main endpoints

- `POST /shorten` - create a short URL
- `GET /shorten/{code}` - get original URL details
- `PUT /shorten/{code}` - update URL for a short code
- `DELETE /shorten/{code}` - delete a short URL
- `GET /shorten/{code}/stats` - get usage stats
- `GET /{code}` - redirect to the original URL

https://roadmap.sh/projects/url-shortening-service
