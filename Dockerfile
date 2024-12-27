FROM openjdk:21-jdk-slim AS build

WORKDIR /app
COPY . .
RUN ./mvnw clean install -DskipTests

FROM openjdk:21-jdk-slim

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]