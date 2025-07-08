
FROM maven:3.9.4-eclipse-temurin-21-alpine AS build
COPY . /home/app/cadastro-backend
RUN mvn -f /home/app/cadastro-backend/pom.xml clean package

# Etapa 2: imagem de runtime com Java
FROM eclipse-temurin:21-jdk-alpine
COPY --from=build /home/app/cadastro-backend/target/*.jar /usr/local/lib/cadastro-backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/cadastro-backend.jar"]
