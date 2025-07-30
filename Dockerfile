# ---------- 1. Build Stage ----------
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies (useful for Docker caching)
COPY pom.xml .
COPY .mvn/ .mvn
COPY mvnw .
RUN ./mvnw dependency:go-offline

# Copy the rest of the project and build it
COPY src/ src/
RUN ./mvnw clean package -DskipTests

# ---------- 2. Runtime Stage ----------
FROM eclipse-temurin:17-jdk-jammy
# Set working directory
WORKDIR /app
# Copy built JAR from the previous stage
COPY --from=build /app/target/*.jar app.jar
# Expose the application port
EXPOSE 8080
# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]