init:
	mvn spring-boot:build-image
up:
	docker-compose up
down:
	docker-compose down
db-up:
	docker-compose run db-server
