.PHONY: build test docker-build docker-push

build:
    ./mvnw clean package -DskipTests

test:
    ./mvnw test