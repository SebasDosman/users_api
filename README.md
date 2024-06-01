# API Gateway with Circuit Breaker and Time Limiter
This repository contains an API Gateway implementation for managing Circuit Breaker and Time Limiter functionalities. The API Gateway acts as a central entry point for all requests, providing robust circuit-breaking capabilities and time limiting functionalities to enhance the resilience and stability of microservices.

## Microservices Included
### Users Microservice
The Users Microservice offers CRUD operations for managing user data. It allows creating, reading, updating, and deleting user records.

### Roles Microservice
The Roles Microservice provides CRUD operations for managing role information. It enables the creation, retrieval, updating, and deletion of role records.

## Features
- Circuit Breaker: Protects the system from cascading failures by failing fast and providing fallback mechanisms when downstream services are unavailable or experiencing issues.
- Time Limiter: Ensures that requests are processed within predefined time limits, preventing long-running operations from affecting the overall system performance.

## Getting Started
To use the API Gateway with Circuit Breaker and Time Limiter and run the microservices locally, follow these steps:

1. Clone this repository to your local machine.
2. Navigate to the root directory of the cloned repository.
3. Install dependencies by running:
```bash
   npm install
```
4. Start the API Gateway and microservices by running:
```bash
   npm start
```
5. Access the API Gateway endpoints to interact with the microservices.

## Usage
- Use the provided endpoints to perform CRUD operations on users and roles.
- Ensure that requests adhere to the defined time limits to prevent timeouts.
- Monitor the circuit breaker status and adjust configurations as needed for optimal performance.

## Contributing
Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.

## License
This project is licensed under the MIT License. Feel free to use, modify, and distribute this code for any purpose.