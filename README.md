# To-Do API

A simple Spring Boot API for managing tasks with gamification features like user points and leaderboards.

## Features
- Create, read, update, and delete tasks.
- Assign tasks to users.
- Track points for completed tasks.
- View user leaderboards.

## Technologies Used
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 Database (in-memory)
- Maven
- Swagger/OpenAPI for documentation

## API Endpoints
### User Management
- `GET /api/users`: Retrieve all users.
- `POST /api/users`: Create a new user.

### Task Management
- `GET /api/tasks`: Retrieve all tasks.
- `POST /api/tasks`: Create a new task.
- `PUT /api/tasks/{taskId}/complete`: Mark a task as completed.

### Leaderboard
- `GET /api/leaderboard`: Retrieve the leaderboard.

## Setup and Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/todo-api.git
   cd todo-api
   ```
2. Build the project with Maven:
    ```bash
    mvn clean instal
    ```

3. Run the application:

    ```bash
    mvn spring-boot:run
    ````
4. Access the Swagger UI for API documentation:

    ```bash
    http://localhost:8080/swagger-ui.html
    ```
## Contributing
Feel free to fork this repository and submit pull requests!

License
This project is licensed under the MIT License.

---

#### **B. Swagger/OpenAPI Documentation**
Swagger is already integrated with Springdoc. To document your endpoints:
1. Ensure `springdoc-openapi-starter-webmvc-ui` is added to your `pom.xml`.
2. Verify your endpoints in the Swagger UI:
   http://localhost:8080/swagger-ui.html


If you want to customize Swagger/OpenAPI metadata, update `SwaggerConfig.java`:
```java
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
 @Bean
 public OpenAPI customOpenAPI() {
     return new OpenAPI()
             .info(new Info()
                     .title("To-Do API")
                     .version("1.0")
                     .description("API documentation for the To-Do application"));
 }
}
```
