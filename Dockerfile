# build stage
FROM maven:3.8.3-openjdk-17-slim AS build

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the source code to the container
COPY . .

# Install the dependencies
RUN mvn clean install -DskipTests

# Package the application
RUN mvn package


# final stage
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the packaged application from the build stage to the container
COPY --from=build /usr/src/app/target/*.jar app.jar

# Run the application
CMD ["java", "-jar", "app.jar"]
