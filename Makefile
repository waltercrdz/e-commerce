.PHONY: build test

build:
	./mvnw clean package -DskipTests

test:
	./mvnw test