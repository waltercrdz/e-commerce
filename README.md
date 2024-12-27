# E-Commerce

This project is a a RESTful API that provides a E-Commerce made with Java and Spring Boot. It is structured to follow Hexagonal Architecture, best practices and is ready for deployment.

## Features

- Order Creation

## To Do

- Order Read
- Payment Creation
- Order Status Update
- Event-Driven Order Status Changes

    | Event Type         | Order Status |
    |--------------------|--------------|
    | ORDER_CREATED      | PENDING      |
    | PAYMENT_CONFIRMED  | CONFIRMED    |
    | PAYMENT_REJECTED   | CANCELLED    |
    | ORDER_SHIPPED      | SHIPPED      |
    | ORDER_DELIVERED    | DELIVERED    |

## Prerequisites

- Java 21+
- Maven
- Docker (optional)

## Installation

1. Clone the repository (if you did not get the source code via zip file):
    ```
    git clone https://github.com/waltercrdz/e-commerce.git
    ```
2. Navigate into the project directory:
    ```
    cd e-commerce
    ```
3. Build and run with Docker Compose:
    ```
    docker-compose up --build
    ```
6. The application will be accessible at `http://localhost:8080/api/orders`

## Project Structure

The project follows a Hexagonal Architecture, also known as Ports and Adapters.

### application

It is dedicated to the application layer of the microservice. It contains the Application Service classes that orchestrate the business logic and interactions between other modules.

### domain

It contains domain models of the microservice.

### infrastructure

It contains the infrastructure layer of the microservice. It contains the REST controllers, repositories, and other classes that interact with external systems.

## API Endpoints

### Product Creation

- **Endpoint:** `/api/orders`
- **Method:** `POST`
- **Description:** Creates a new Order.
- **Request Body:**
    - `customer_id` (UUID): The unique identifier of the Customer.
    - `products` (array): The products that the customer intends to purchase.
        - `product_id` (UUID): The unique identifier of the Product.
        - `price` (number): The price of the Product.
        - `quantity` (int): The quantity of the Product.
- **Responses:**
    - `201 Created`: Successfully created the Product.
        - Body: A JSON object representing the Order.
    - `400 Bad Request`: Invalid input data.
    - `500 Internal Server Error`: An error occurred on the server.
- **Curl Command:**
    ```bash
    curl -X POST "http://127.0.0.1:8080/api/orders" -H "Content-Type: application/json" -d '{
      "customer_id": "f47ac10b-58cc-4372-a567-0e02b2c3d479",
      "products": [
        {
          "product_id": "e7b8a1c4-8b1d-4f6e-9f1e-3b5b8d8a1c4e",
          "quantity": 1,
          "price": 20.5
        },
        {
          "product_id": "a3f5c2d1-4e6b-4f8a-9c1d-2b3e5d6a7f8b",
          "quantity": 2,
          "price": 1.55
        }
      ]
    }'
    ```

## OpenAPI

The project uses Springdoc OpenAPI to generate the API documentation. The documentation is available at `http://localhost:8080/api/princing/swagger-ui/index.html`.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any improvements or bug fixes.

## License

This project is licensed under the MIT License.