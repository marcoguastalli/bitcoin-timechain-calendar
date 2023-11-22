# Docker
Build and deploy the app using Docker instructions

### build docker-compose
docker-compose up -d
##### rebuild the image with a Dockerfile
docker-compose up -d --build

### build Dockerfile
./mvnw clean package
docker build --no-cache -t bitcoin-timechain-calendar:v0.0.1 . -f Dockerfile_api

### run docker-compose
docker-compose start
docker-compose stop
docker container restart bitcoin-timechain-calendar

### run Dockerfile
docker run --rm --name bitcoin-timechain-calendar -p 8080:8080 bitcoin-timechain-calendar:v0.0.1

### access the image as root
docker run -it  bitcoin-timechain-calendar:v0.0.1 /bin/sh

### access the container as root
docker container ls docker exec -u root -it CONTAINER_ID /bin/sh

### logs from the container
tail -n 1000 -f /logs/ bitcoin-timechain-calendar.log

### logs
docker exec -u root -it CONTAINER_ID tail -n 1000 -f /logs/ bitcoin-timechain-calendar.log

### play
curl -I http:/172.16.128.130:8080/bitcoin-timechain-calendar/v1/blocks
curl -I http:/172.16.128.130:8080/bitcoin-timechain-calendar/v1/version