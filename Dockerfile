FROM maven:3.8.3-openjdk-17 AS build

WORKDIR /build

FROM openjdk:17-alpine

LABEL authors="Paweł Wiński"

WORKDIR /demo

COPY --from=build /build/target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]