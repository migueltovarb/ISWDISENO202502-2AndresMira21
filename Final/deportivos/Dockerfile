# Etapa de construcción
FROM maven:3.9.11-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar archivos de configuración de Maven
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
COPY mvnw.cmd .

# Descargar dependencias
RUN ./mvnw dependency:go-offline -B

# Copiar código fuente
COPY src ./src

# Compilar la aplicación
RUN ./mvnw clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copiar el JAR compilado desde la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto
EXPOSE 8080

# Variables de entorno (se pueden sobrescribir en Render)
ENV JAVA_OPTS="-Xmx512m -Xms256m"
ENV SERVER_PORT=8080

# Ejecutar la aplicación
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]