#
# Build stage
#
FROM gradle:7.6.1-jdk17 AS build
COPY . /app
WORKDIR /app
RUN gradle clean build

#
# Package stage
#
FROM eclipse-temurin:17-jdk-jammy
COPY --from=build /app/build/libs/*.jar /usr/local/lib/animal-adoption.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=prod","/usr/local/lib/animal-adoption.jar"]