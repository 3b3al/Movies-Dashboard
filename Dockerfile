# Stage 1: Build the application with Maven
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the project files into the container
COPY . .

# Run the Maven build
RUN mvn clean install

# Stage 2: Create the final image with JDK to run the application
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port the application will run on
EXPOSE 90

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]