Task Manager API

Simple REST API for managing projects, tasks and comments.
The goal of the project was to practice database relations, JWT authentication and pagination using Spring Boot.

Technologies
- Java 21
- Spring Boot
- Spring Data JPA
- Spring Security (JWT)
- PostgreSQL
- Docker

Features
- User registration and login with JWT authentication
- CRUD operations for projects and tasks
- Comments on tasks
- Pagination for task listing
- Proper relational database structure (User → Task → Comment, Project → Task)

Endpoints

GET
  /api/projects/{id}
  /api/tasks?page=0&size=10

POST
  /api/users/register
  /api/users/login
  /api/projects
  /api/tasks
  /api/tasks/{taskId}/comments

PATCH
  /api/tasks/{id}

DELETE
  /api/tasks/{id}
  /api/tasks/delete/comments/{id}

How to run
1. Clone repository
   git clone https://github.com/evgenievp/TaskManagerApi
2. Configure PostgreSQL (or run with Docker)
3. Build project
   mvn clean install
4. Run application
5. Test endpoints with Postman or other REST client
