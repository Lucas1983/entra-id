# ENTRA ID

## Overview
This is sample project for ENTRA ID integration using Java and Spring Boot.
It demonstrates how to authenticate and authorize users with ENTRA ID in a Spring Boot application.
In particular, it shows how ON BEHALF OF flow can be implemented.

## Technologies Used
- Java
- Spring Boot
- Docker Compose

## Setup

### Pre-requisites
- Java (version 17)
- Docker Desktop (for Docker Compose)

### Configuration
You can ru project using Docker Compose - make sure to have Docker Desktop installed and running.
Create a `.env` file ( copy  `.env.example` ) in the root directory and fill in the required environment variables.
Project contains 2 Docker Compose files:
- `docker-compose.yml` : for running the application with default configuration.
- `docker-compose.dev.yml` : for running the application in development mode with hot-reloading enabled.

### Installation
```bash
cd ./entra-id
./gradlew build
docker compose -f docker-compose.yml up -d
```
