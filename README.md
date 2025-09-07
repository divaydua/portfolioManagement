
# Portfolio Tracker

This is a basic wealth management / portfolio tracking app that I’m building with Spring Boot.  
The idea is to start small with simple features like signup, login, and adding holdings, and then gradually expand it into a more complete system with live market data, portfolio summaries, and more.

## Current Features (MVP)
- User signup and login (right now just returns a dummy token)
- Add holdings (stock/crypto symbol, quantity, buy price)
- View all holdings for a user

## Tech Stack
- Spring Boot (REST API, Security, JPA)
- PostgreSQL/ MySQL
- Maven for build and dependency management

## Project Structure

com.example.portfolio

├── exceptions
├── config          # Security configuration
├── controller      # REST controllers
├── dto             # DTOs for request/response
├── entity          # Database entities
├── repository      # Spring Data repositories
├── service         # Business logic
└── PortfolioApplication.java

## How to Run

### Prerequisites
- Java 17 or higher
- Maven 3.9+
- A running PostgreSQL (or MySQL) instance

### Steps
1. Clone the repository
   ```bash
   git clone https://github.com/divaydua/portfolioManagement.git
   cd portfolio-tracker
	2.	Update the database connection in application.yml.
	3.	Run the application

mvn spring-boot:run

	4.	Test with Postman or curl:
	•	POST /auth/signup → register a new user
	•	POST /auth/login → login and get dummy token
	•	POST /portfolio/add → add a holding
	•	GET /portfolio → view holdings

⸻

Roadmap
	•	Replace dummy token with real JWT authentication
	•	Add live stock/crypto price integration
	•	Calculate portfolio summary (invested amount, current value, profit/loss)
	•	Support more asset classes (ETFs, funds, etc.)
	•	Add charts and reporting features

⸻
