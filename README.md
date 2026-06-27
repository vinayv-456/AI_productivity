# Todo CRUD - Spring Boot

Simple Todo CRUD REST API built with Java and Spring Boot.

## Requirements

- Java 17+
- Maven 3.9+

## Run

```bash
mvn spring-boot:run
```

Server starts at `http://localhost:8080`.

## API Endpoints

- `GET /api/todos` - list all todos
- `GET /api/todos/{id}` - get todo by id
- `POST /api/todos` - create todo
- `PUT /api/todos/{id}` - update todo
- `DELETE /api/todos/{id}` - delete todo

## Sample Request

Create a todo:

```bash
curl -X POST http://localhost:8080/api/todos \
  -H "Content-Type: application/json" \
  -d '{"title":"Learn Spring Boot","description":"Build a CRUD API","completed":false}'
```
