init:
	mvn spring-boot:build-image
up:
	mvn spring-boot:build-image
	docker-compose up
down:
	docker-compose down
