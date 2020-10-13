build:
	mvn spring-boot:build-image
all:
	docker-compose up
down:
	docker-compose down
db-up:
	docker-compose run db-server
