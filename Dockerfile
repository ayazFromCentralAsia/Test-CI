FROM maven:3.9.9-sapmachine-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Используем официальный образ OpenJDK для запуска
FROM openjdk:21-jdk
WORKDIR /app
COPY --from=build /app/target/docker-test-project-0.0.1-SNAPSHOT.jar /app/docker-test-project.jar
ENTRYPOINT ["java", "-jar", "/app/docker-test-project.jar"]