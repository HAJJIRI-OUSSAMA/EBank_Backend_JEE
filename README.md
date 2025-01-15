
# E-Bank Backend - Spring Boot Application

This is the backend application for the E-Bank system, built using Spring Boot. It provides a robust and scalable API for managing customers, bank accounts, and account operations such as debit, credit, and transfer. The application is designed to handle banking operations efficiently and securely.

## Features

### Customer Management:
- Create, update, and delete customers.
- Search for customers by keyword.
- Retrieve customer details and associated bank accounts.

### Bank Account Management:
- Create new current or savings accounts.
- Retrieve account details and transaction history.
- Perform debit, credit, and transfer operations.

### Transaction Management:
- View account operations (transactions) with pagination.
- Retrieve account balance and transaction history.

### Exception Handling:
- Custom exceptions for scenarios like insufficient balance, account not found, and customer not found.

## Technologies Used
- **Spring Boot**: Framework for building the backend application.
- **Spring Data JPA**: For database interactions and ORM (Object-Relational Mapping).
- **Hibernate**: For managing database entities and relationships.
- **Lombok**: For reducing boilerplate code with annotations like `@Data`, `@Getter`, and `@Setter`.
- **MySQL/PostgreSQL**: For database storage (configurable in `application.properties`).
- **RESTful API**: Exposes endpoints for CRUD operations and banking transactions.

## Installation

### Prerequisites
- **Java 17 or higher**: Ensure you have Java installed.
- **Maven**: For dependency management and building the project.
- **MySQL/PostgreSQL**: Set up a database and configure the connection in `application.properties`.

### Steps to Run the Project

#### Clone the Repository:
```bash
git clone https://github.com/your-repo/e-bank-backend.git
cd e-bank-backend
```

#### Configure the Database:
Update the `application.properties` file with your database credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ebank
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

#### Build the Project:
```bash
mvn clean install
```

#### Run the Application:
```bash
mvn spring-boot:run
```
The application will start on `http://localhost:8080`.

## API Endpoints

### Customer Management
- **GET /customers**: Retrieve a list of all customers.
- **GET /customers/{id}**: Retrieve details of a specific customer by ID.
- **POST /customers**: Create a new customer.
- **PUT /customers/{customerId}**: Update an existing customer.
- **DELETE /customers/{id}**: Delete a customer by ID.
- **GET /customers/search**: Search for customers by keyword.

### Bank Account Management
- **GET /accounts/{accountId}**: Retrieve details of a specific bank account by ID.
- **GET /accounts**: Retrieve a list of all bank accounts.
- **GET /customers/{customerId}/accounts**: Retrieve all bank accounts for a specific customer.
- **POST /accounts/debit**: Perform a debit operation on an account.
- **POST /accounts/credit**: Perform a credit operation on an account.
- **POST /accounts/transfer**: Perform a transfer operation between two accounts.

### Transaction Management
- **GET /accounts/{accountId}/operations**: Retrieve the transaction history for a specific account.
- **GET /accounts/{accountId}/pageOperations**: Retrieve paginated transaction history for a specific account.

## Project Structure

### Key Components

#### Entities:
- **Customer**: Represents a customer with properties like `id`, `name`, and `email`.
- **BankAccount**: Abstract class representing a bank account with properties like `id`, `balance`, and `status`.
- **CurrentAccount** and **SavingAccount**: Concrete classes extending `BankAccount` for specific account types.
- **AccountOperation**: Represents a transaction with properties like `amount`, `type`, and `description`.

#### DTOs (Data Transfer Objects):
- `CustomerDTO`, `BankAccountDTO`, `AccountOperationDTO`, etc.: Used for transferring data between layers.

#### Repositories:
- `CustomerRepository`, `BankAccountRepository`, `AccountOperationRepository`: Interfaces for database operations.

#### Services:
- `BankAccountService`: Implements business logic for managing customers, accounts, and transactions.
- `BankService`: Provides utility methods for testing and debugging.

#### Controllers:
- `CustomerRestController`: Handles customer-related API requests.
- `BankAccountRestController`: Handles bank account and transaction-related API requests.

### Exception Handling
The application uses custom exceptions to handle specific scenarios:
- `CustomerNotFoundException`: Thrown when a customer is not found.
- `BankAccountNotFoundException`: Thrown when a bank account is not found.
- `BalanceNotSufficientException`: Thrown when a debit operation exceeds the account balance.

## Screenshots
*(Add screenshots here if available)*

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.

## Acknowledgments
- **Spring Boot** for providing a robust framework for building RESTful APIs.
- **Lombok** for reducing boilerplate code and improving readability.
- **Hibernate** for simplifying database interactions.
