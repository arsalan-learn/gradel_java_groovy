# Use a Java 17 base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /usr/app

# Copy the JAR file from the build directory to the container
COPY app/build/libs/app.jar /usr/app/

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]