
### `README.md`
```markdown
# Movie API Backend

## Description
This is a backend service for a movie application built using Spring Boot. It provides APIs for user authentication, movie management, and more. The application is designed to be scalable, secure, and easy to maintain.

## Features
- User authentication and authorization
- CRUD operations for movies
- Password encryption
- Token-based authentication
- Role-based access control

## Technologies Used
- Java
- Spring Boot
- Spring Security
- JPA/Hibernate
- Maven
- H2 Database (for development)
- MySQL/PostgreSQL (for production)
- Lombok

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/rahulpannati513/Movie-Api-Backend.git
   ```
2. Navigate to the project directory:
   ```sh
   cd Movie-Api-Backend
   ```
3. Build the project using Maven:
   ```sh
   mvn clean install
   ```

## Usage
1. Run the application:
   ```sh
   mvn spring-boot:run
   ```
2. Access the API at `http://localhost:8080`.

## API Endpoints
### Authentication
- **POST** `/api/auth/register` - Register a new user
- **POST** `/api/auth/login` - Login and obtain a token

### Movies
- **GET** `/api/movies` - Get all movies
- **GET** `/api/movies/{id}` - Get a movie by ID
- **POST** `/api/movies` - Create a new movie
- **PUT** `/api/movies/{id}` - Update a movie
- **DELETE** `/api/movies/{id}` - Delete a movie

## Contributing
1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add some feature'`).
5. Push to the branch (`git push origin feature/your-feature`).
6. Open a pull request.

## License
This project is licensed under the MIT License.

## Contact
For any inquiries, please contact:
- **Name**: Rahul Pannati
- **Email**: rahulpannati1@gmail.com
```
