# Etapa 1: Build de la aplicación usando Maven y JDK
#FROM maven:3.9.6-eclipse-temurin-23 AS build
FROM maven:3.9.14-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Ejecutar la aplicación con una imagen más ligera
FROM eclipse-temurin:21-jre
WORKDIR /app
#COPY --from=build /app/target/*.jar app.jar
COPY --from=build /app/target/warhammerScanner-API-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
