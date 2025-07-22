# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:20-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the build output (JAR file) into the container
COPY . .

# Grant executable permissions to the Gradle wrapper
RUN chmod +x ./gradlew

# Run the Gradle build to create the JAR file
RUN ./gradlew clean build --no-daemon

# Copy the generated JAR file to the container
RUN cp build/libs/qrservice-0.0.1-SNAPSHOT.jar app.jar


# Expose the port your application runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]