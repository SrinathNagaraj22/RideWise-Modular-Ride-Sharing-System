RideWise - Modular Ride Sharing System
RideWise is a console-based ride-sharing system developed using Java and designed with Object-Oriented Programming principles and SOLID design principles.
The main goal of this project is to build a modular and extensible Low-Level Design (LLD) system where ride matching logic and fare calculation logic can be easily extended without modifying existing core services.
The project follows:
SOLID Principles 
Strategy Pattern
Composition over Inheritance
Clean Service Layer Architecture


src/
│
├── entity/
│   ├── Rider.java
│   ├── Driver.java
│   ├── Ride.java
│   └── FareReceipt.java
│
├── enums/
│   ├── RideStatus.java
│   └── VehicleType.java
│
├── strategy/
│   ├── RideMatchingStrategy.java
│   ├── NearestDriverStrategy.java
│   ├── LeastActiveDriverStrategy.java
│   ├── FareCalculationStrategy.java
│   ├── DefaultFareStrategy.java
│   └── PeakHourFareStrategy.java
│
├── services/
│   ├── RiderService.java
│   ├── DriverService.java
│   └── RideService.java
│
├── exceptions/
│
└── Main.java
Features

- Register Riders
- Register Drivers
- View Available Drivers
- Request Ride
- Match Drivers using Strategy Pattern
- Calculate Fare using Strategy Pattern
- Complete Ride
- View All Rides
- Exception Handling
- Extensible System Design

Functional Requirements Implemented
Rider Operations
- Add Rider
- Get Rider by ID

Driver Operations
- Add Driver
- Update Driver Availability
- View Available Drivers

Ride Operations
- Request Ride
- Assign Driver
- Complete Ride
- Track Ride Status

Fare Operations
- Default Fare Calculation
- Peak Hour Fare Calculation


SOLID Principles Used

1. Single Responsibility Principle (SRP)
Each class has only one responsibility.
Examples:
- `RiderService` → manages riders
- `DriverService` → manages drivers
- `RideService` → coordinates ride workflow
- `Fare Strategies` → calculate fare only

2. Open Closed Principle (OCP)
The system is open for extension but closed for modification.
New strategies can be added without changing existing code.
Examples:
- Add new ride matching strategy
- Add new fare calculation strategy

3. Liskov Substitution Principle (LSP)
Any implementation of:
- `RideMatchingStrategy`
- `FareCalculationStrategy`
can replace another implementation without affecting system behavior.

4. Interface Segregation Principle (ISP)
Small and focused interfaces are used.
Examples:
- `RideMatchingStrategy`
- `FareCalculationStrategy`

5. Dependency Inversion Principle (DIP)
`RideService` depends on abstractions instead of concrete implementations.
Example:
```java
RideMatchingStrategy
FareCalculationStrategy