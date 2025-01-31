Got it! I'll update the `README.md` to include these endpoints for better documentation. Here's the updated content:

---

# Waste Sorting for Recycling API

This project is a Spring Boot-based RESTful API for waste sorting and recycling information. It provides endpoints to manage **Disposal Guidelines**, **Recycling Tips**, and **Waste Categories**.

## Features

- Manage **Disposal Guidelines** (CRUD operations).
- Manage **Recycling Tips** (CRUD operations).
- Predefined **Waste Categories**.

## Prerequisites

1. **Java 17 or later**: Ensure JDK 17+ is installed.
2. **Maven**: Build and dependency management tool.
3. **H2 Database**: In-memory database for development and testing.

## Running the Project

1. Clone the repository:
   ```bash
   git clone git@github.com:kbm26/Waste-Management-Api.git
   cd Waste-Management-Api
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Access the API at `http://localhost:8080`.

## Database Connection

By default, the project uses an H2 in-memory database.

- **H2 Console**: Visit `http://localhost:8080/h2-console`.
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: (empty)

To switch to a persistent database (e.g., PostgreSQL or MySQL), update the `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/waste_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

## Endpoints

### Disposal Guidelines

| Method | Endpoint                      | Description                      |
|--------|-------------------------------|----------------------------------|
| POST   | `/api/disposal-guidelines`    | Create a new disposal guideline. |
| GET    | `/api/disposal-guidelines`    | Get all disposal guidelines.     |
| GET    | `/api/disposal-guidelines/{id}` | Get a guideline by ID.           |
| PUT    | `/api/disposal-guidelines/{id}` | Update a guideline by ID.        |
| DELETE | `/api/disposal-guidelines/{id}` | Delete a guideline by ID.        |

### Recycling Tips

| Method | Endpoint                  | Description                  |
|--------|---------------------------|------------------------------|
| POST   | `/api/recycling-tips`     | Create a new recycling tip.  |
| GET    | `/api/recycling-tips`     | Get all recycling tips.      |
| GET    | `/api/recycling-tips/{id}` | Get a tip by ID.             |
| PUT    | `/api/recycling-tips/{id}` | Update a tip by ID.          |
| DELETE | `/api/recycling-tips/{id}` | Delete a tip by ID.          |

### Waste Categories

| Method | Endpoint         | Description                        |
|--------|------------------|------------------------------------|
| GET    | `/api/waste-categories` | Get all waste categories.         |

## Example Data

### Waste Categories
The database is preloaded with the following waste categories:

- **Plastic**: Items made of plastic like bottles, bags, and containers.
- **Glass**: Glass materials like bottles and jars.
- **Paper**: Paper products like newspapers, magazines, and cardboard.
- **Metal**: Metal items such as cans and aluminum foil.
- **Organic**: Biodegradable waste like food scraps and garden waste.

## Testing the API

Use tools like [Postman](https://www.postman.com/) or `curl` to test the API endpoints. For example:

```bash
# Create a new recycling tip
curl -X POST -H "Content-Type: application/json" \
-d '{"name": "Reuse paper", "description": "Reuse old newspapers for cleaning windows."}' \
http://localhost:8080/api/recycling-tips
```

## License

This project is licensed under the MIT License.

---

Let me know if you'd like any other updates!