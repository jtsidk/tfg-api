# Etapa 1: Build del proyecto
FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .

RUN mvn wrapper:wrapper
RUN chmod +x mvnw

RUN mvn clean package -DskipTests

# Etapa 2: Ejecutar la app
FROM eclipse-temurin:23-jre
WORKDIR /app
COPY --from=build /app/target/warhammerScanner-API-1.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
