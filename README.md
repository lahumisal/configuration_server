# Smart School Configuration Server

This is the **Spring Cloud Configuration Server** for the Smart School project.
It serves configuration files (YAML/Properties) for different environments (`dev`, `uat`, `prod`) to all backend services via Git.

---

## Table of Contents

* [Features](#features)
* [Requirements](#requirements)
* [Setup](#setup)
* [Running the Server](#running-the-server)
* [Git Repository Structure](#git-repository-structure)
* [Environment Profiles](#environment-profiles)

---

## Features

* Serves configuration from a **Git repository**.
* Supports **multiple environments** (`dev`, `uat`, `prod`).
* Supports **live reload** on Git updates (if enabled).
* Centralized configuration management for all microservices.

---

## Requirements

* Java 21+
* Maven 3.8+
* Git
* Access to the **config repository**: [https://github.com/lahumisal/school_server_config.git](https://github.com/lahumisal/school_server_config.git)

---

## Setup

1. Clone the repository:

```bash
git clone https://github.com/yourusername/configuration-server.git
cd configuration-server
```

2. Make sure your **Git repository with config files** is accessible.

   * For private repos, use a **Personal Access Token (PAT)** and configure in `application.yml`:

```yaml
spring:
  cloud:
    config:
      server:
        git:
          uri: https://github.com/lahumisal/school_server_config.git
          username: YOUR_GITHUB_USERNAME
          password: YOUR_PERSONAL_ACCESS_TOKEN
          clone-on-start: true
          default-label: main
```

3. Update your `application.yml` if you want to change server port or logging.

---

## Running the Server

### Using Maven

```bash
mvn clean install
mvn spring-boot:run
```

### Using Jar

```bash
mvn clean package
java -jar target/configuration-server-0.0.1-SNAPSHOT.jar
```

* Server port: **8888**
* Check logs for:

```
Adding property source: Config resource 'smart_school-dev.yml'
```

---

## Git Repository Structure for Configs

Your **Git repository** (`school_server_config`) should look like:

```
school_server_config/
├── smart_school-dev.yml
├── smart_school-uat.yml
├── smart_school-prod.yml
└── README.md
```

* Each YAML corresponds to a **Spring profile** (`dev`, `uat`, `prod`).
* Config Server will serve these files based on **application name** and **active profile**.

---

## Environment Profiles

* Client microservices can request configuration via:

```
http://localhost:8888/{application}/{profile}/{label}
```

* Example:

```
http://localhost:8888/smart_school/dev/main
```

* Profiles:

| Profile | Description             |
| ------- | ----------------------- |
| dev     | Development environment |
| uat     | User acceptance testing |
| prod    | Production environment  |

---

**Author:** Lahu Misal
**GitHub:** [https://github.com/lahumisal](https://github.com/lahumisal)
**Project:** Smart School Configuration Server
