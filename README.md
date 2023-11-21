# Bitcoin Timechain Calendar
Bitcoin Timechain Calendar

### Prerequisites
- JDK v17.0.4
- Maven v3.8.4

### Build
setjdk17
./mvnw clean package
./mvnw clean test

### Run
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
./mvnw spring-boot:run -Dspring-boot.run.profiles=docker

### Play
curl -I http://localhost:8080/bitcoin-timechain-calendar/v1/version

### Api documentation
http://localhost:8080/bitcoin-timechain-calendar/swagger-ui/index.html