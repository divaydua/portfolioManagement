# Portfolio Management System

A modern Spring Boot application for managing investment portfolios with a beautiful web interface.

## 🚀 Features

- **User Authentication**: Sign up, login, and demo user seeding
- **Portfolio Management**: Add and view investment holdings
- **Modern UI**: Responsive design with Tailwind CSS
- **Database Integration**: PostgreSQL for production, H2 for testing
- **RESTful API**: Clean API endpoints for all operations

## 🛠️ Tech Stack

### Backend
- **Spring Boot 3.5.5** - Main framework
- **Spring Security** - Authentication and authorization
- **Spring Data JPA** - Database operations
- **PostgreSQL** - Production database
- **H2** - In-memory database for testing
- **Lombok** - Reduces boilerplate code
- **Maven** - Dependency management

### Frontend
- **HTML5/CSS3** - Modern web standards
- **Tailwind CSS** - Utility-first CSS framework
- **Vanilla JavaScript** - No framework dependencies
- **Responsive Design** - Works on all devices

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/example/portfolioManagement/portfolio/
│   │   ├── config/
│   │   │   └── SecurityConfig.java          # Security configuration
│   │   ├── controller/
│   │   │   ├── AuthController.java          # Authentication endpoints
│   │   │   ├── PortfolioController.java     # Portfolio management
│   │   │   └── TestDataController.java      # Demo data seeding
│   │   ├── dto/
│   │   │   ├── HoldingDto.java              # Portfolio holding data
│   │   │   ├── LoginDto.java                # Login request data
│   │   │   └── SignupDto.java               # Registration data
│   │   ├── entities/
│   │   │   ├── Asset.java                   # Investment asset entity
│   │   │   ├── Holding.java                 # User holding entity
│   │   │   └── User.java                    # User entity with Spring Security
│   │   ├── repositories/
│   │   │   ├── AssetRepository.java         # Asset data access
│   │   │   ├── HoldingRepository.java       # Holdings data access
│   │   │   └── UserRepository.java          # User data access
│   │   ├── services/
│   │   │   ├── AuthService.java             # Authentication logic
│   │   │   └── PortfolioService.java        # Portfolio business logic
│   │   └── PortfolioApplication.java        # Main application class
│   └── resources/
│       ├── application.properties           # Main configuration
│       ├── application-test.properties      # Test configuration
│       └── static/
│           ├── index.html                   # Landing page
│           ├── dashboard.html               # Portfolio dashboard
│           └── js/
│               └── app.js                   # Shared JavaScript utilities
└── test/
    └── java/com/example/portfolioManagement/portfolio/
        └── PortfolioApplicationTests.java   # Integration tests
```

## 🚀 Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.6+
- PostgreSQL (for production)

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd portfolio
   ```

2. **Configure Database**
   
   Update `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.datasource.driver-class-name=org.postgresql.Driver
   ```

3. **Build and Run**
   ```bash
   ./mvnw clean package
   ./mvnw spring-boot:run
   ```

4. **Access the Application**
   - Open your browser to `http://localhost:8080`
   - Click "Create demo user" for quick testing
   - Use credentials: `demo` / `demo123`

## 🎯 Usage

### Landing Page (`/index.html`)
- **Create Demo User**: Generates a test user (demo/demo123)
- **Sign Up**: Register a new account
- **Login**: Access existing account
- **Open Dashboard**: Navigate to portfolio management

### Dashboard (`/dashboard.html`)
- **View Holdings**: See all your investments in a clean table
- **Add Holdings**: Buy new stocks with symbol, quantity, and price
- **Refresh**: Update the holdings list
- **Responsive Design**: Works on desktop and mobile

## 🔧 API Endpoints

### Authentication
- `POST /auth/signup` - Register new user
- `POST /auth/login` - User login
- `GET /test-users` - Create demo user

### Portfolio Management
- `GET /portfolio?username={username}` - Get user's holdings
- `POST /portfolio/add?username={username}` - Add new holding

### Example API Usage

**Create Demo User:**
```bash
curl http://localhost:8080/test-users
```

**Login:**
```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"demo","password":"demo123"}'
```

**Add Holding:**
```bash
curl -X POST "http://localhost:8080/portfolio/add?username=demo" \
  -H "Content-Type: application/json" \
  -d '{"symbol":"AAPL","quantity":10,"buyPrice":150.00}'
```

**Get Holdings:**
```bash
curl "http://localhost:8080/portfolio?username=demo"
```

## 🧪 Testing

Run tests with:
```bash
./mvnw test
```

The test suite uses H2 in-memory database and includes:
- Application context loading tests
- Database integration tests
- Security configuration tests

## 🔒 Security Features

- **Password Encryption**: BCrypt hashing for secure password storage
- **CSRF Protection**: Disabled for API simplicity (can be enabled)
- **CORS Configuration**: Configured for web client access
- **User Authentication**: Spring Security integration
- **Input Validation**: DTO-based request validation

## 🎨 UI Features

- **Modern Design**: Clean, professional interface using Tailwind CSS
- **Responsive Layout**: Works on desktop, tablet, and mobile
- **Interactive Elements**: Smooth animations and hover effects
- **Toast Notifications**: User feedback for actions
- **Form Validation**: Client-side input validation
- **Loading States**: Visual feedback during API calls

## 📊 Database Schema

### Users Table
- `id` (Primary Key)
- `username` (Unique)
- `email` (Unique)
- `password_hash`

### Assets Table
- `id` (Primary Key)
- `symbol` (e.g., AAPL, TSLA)
- `name` (e.g., Apple Inc.)
- `type` (e.g., stock, crypto)

### Holdings Table
- `id` (Primary Key)
- `user_id` (Foreign Key)
- `asset_id` (Foreign Key)
- `quantity`
- `buy_price`
- `created_at`

## 🚀 Deployment

### Production Setup

1. **Database Configuration**
   ```properties
   spring.datasource.url=jdbc:postgresql://your-db-host:5432/portfolio
   spring.datasource.username=your-username
   spring.datasource.password=your-secure-password
   spring.jpa.hibernate.ddl-auto=update
   ```

2. **Build JAR**
   ```bash
   ./mvnw clean package -DskipTests
   ```

3. **Run Application**
   ```bash
   java -jar target/portfolio-0.0.1-SNAPSHOT.jar
   ```

### Docker Deployment (Optional)

Create a `Dockerfile`:
```dockerfile
FROM openjdk:21-jdk-slim
COPY target/portfolio-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👨‍💻 Author

**Your Name**
- GitHub: [@yourusername](https://github.com/yourusername)
- LinkedIn: [Your LinkedIn](https://linkedin.com/in/yourprofile)

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- Tailwind CSS for the beautiful design system
- PostgreSQL community for the robust database
- All contributors and testers

---

**Happy Investing! 📈**