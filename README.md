# Flighter API

Flighter is a simple flight management API built using Spring Boot. It provides functionality for managing flight details, including creating, updating, retrieving, and deleting flight entries.

## Features

- **Get all flights**: Fetches all flight details.
- **Get flight by flight number**: Fetches details of a specific flight using its flight number.
- **Add a new flight**: Allows users to add a new flight entry.
- **Update flight details**: Allows users to update flight information.
- **Delete flight**: Removes a flight entry from the database.

## Endpoints

### `GET /flighter/api/flights`
Returns a list of all flights.

### `GET /flighter/api/flights/{flight_number}`
Fetches a specific flight by its flight number.

### `POST /flighter/api/flights`
Adds a new flight.

**Request Body**:
```json
{
    "flightNumber": "FL123",
    "airline": "Airline Name",
    "origin": "City A",
    "destination": "City B",
    "departureTime": "2024-12-25T15:30:00",
    "arrivalTime": "2024-12-25T18:00:00",
    "status": "SCHEDULED",
    "price": 300.00
}
```

### PUT /flighter/api/flights/{id}
Updates an existing flight entry.

**Request Body**: Same structure as the POST request.

### DELETE /flighter/api/flights/{id}
Deletes a flight by its ID.

### Technologies Used
**Spring Boot**: Backend framework for building the API.
**Spring Security**: Basic configuration to disable CSRF and permit all requests (for simplicity).
**JPA & Hibernate**: Used for interacting with the database.
**MySQL**: The database to store flight information.

### Setup
Clone the repository.
Set up your database (MySQL recommended).
Update application.properties with your database configuration.
Run the application using mvn spring-boot:run.

### Configuration
The SecurityConfig class configures basic security settings, disabling CSRF and allowing all HTTP requests
