# Use an official OpenJDK runtime as a base image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container at /app
COPY target/facebook-spring-0.0.1-SNAPSHOT.jar /app/facebook-spring.jar

# Expose the port that the application will run on
EXPOSE 8080

# Specify the command to run on container startup
CMD ["java", "-jar", "facebook-spring.jar"]