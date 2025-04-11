# url-shortening-service

A solution for https://roadmap.sh/projects/url-shortening-service

This project is a simple REST API that allows users to shorten their URLs.
The API allows users to shorten URLs, retrieve original URLs from short codes, update or delete the short URLs,
and track statistics such as access counts, using a REST API as the interface.

## Technologies Used

- **Java 17**
- **Spring Boot** - REST, Request Validation
- **Spring Data JDBC** - Database interaction
- **MySQL Database**
- **Maven** - Dependency Management

## Setup

### Prerequisites

- Java 17 or above
- Maven 3.6 or above

### Steps

1. Clone the repository:

```
git clone https://github.com/TranBinhMinh-Finn/url-shortening-service
cd url-shortening-service
```

2. Build the project:

```
mvn clean install
```

3. Database configuration:
Change the database url and credentials in ```application.properties```
to your MySQL database's.

4. Run the application:
```
mvn spring-boot:run
```