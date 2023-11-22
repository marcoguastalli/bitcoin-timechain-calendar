# Bitcoin Timechain Calendar

Fetch from https://corsproxy.io/?https%3A%2F%2Fblockchain.info%2Fblocks%2F1700660891152%3Fformat%3Djson
the Bitcoin blockchain information from https://blockchain.info/blocks/1700660891152?format=json
- %3A :
- %2F //
- %3F ?
- %3D =

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

### Api documentation
http://localhost:8080/bitcoin-timechain-calendar/swagger-ui/index.html

### Actuator
http://localhost:8080/bitcoin-timechain-calendar/actuator
http://localhost:8080/bitcoin-timechain-calendar/actuator/health
http://localhost:8080/bitcoin-timechain-calendar/actuator/beans
http://localhost:8080/bitcoin-timechain-calendar/actuator/env
http://localhost:8080/bitcoin-timechain-calendar/actuator/logfile
http://localhost:8080/bitcoin-timechain-calendar/actuator/loggers
http://localhost:8080/bitcoin-timechain-calendar/actuator/metrics
http://localhost:8080/bitcoin-timechain-calendar/actuator/threaddump

### Play
curl -I http://localhost:8080/bitcoin-timechain-calendar/v1/version
curl -I http://localhost:8080/bitcoin-timechain-calendar/v1/blocks
