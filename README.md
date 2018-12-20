# RentalService
Rental Service API

1. Set up Vehicles inventory
2. Create/Update/Retrieve/Delete reservations based on availability.

- ###### Run
  mvn spring-boot:run
  
- ###### Data Setup
  - Endpoint: localhost:20000/vehicles
  - Type: REST POST
  - Request body:
    ``` {
      "type" : "MEDIUM",
	    "quantity" : 1
    } ```

- ###### Reservation API
  - Endpoint: localhost:20000/reservations
  - Type: REST POST
  - Request body:
    ``` {
      "type" : "MEDIUM",
      "startDate" : "2018-12-12T00:34:00.000",
      "endDate" : "2018-12-27T23:34:00.000"
    } ```
