# Etapa 1: Build del proyecto
FROM eclipse-temurin:23-jdk AS build
WORKDIR /app
COPY . .
RUN ./mvn clean package -DskipTests

# Etapa 2: Ejecutar la app
FROM eclipse-temurin:23-jre
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
