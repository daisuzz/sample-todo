build:
	mvn spring-boot:build-image
all:
	mvn spring-boot:build-image
	docker-compose up
down:
	docker-compose down
db-up:
	docker-compose up db-server
