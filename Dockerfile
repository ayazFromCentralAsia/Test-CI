# Stage 1: Build the application
FROM maven:3.9.9 AS build
WORKDIR /app
COPY . .
RUN mvn clean install


FROM openjdk:21-jdk
COPY --from=build /app/docker-test-project.jar /app/docker-test-project.jar
ENTRYPOINT ["java", "-jar", "/app/docker-test-project.jar"]
