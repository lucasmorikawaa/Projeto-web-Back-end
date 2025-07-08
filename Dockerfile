FROM maven:3.9.4-eclipse-temurin-21-alpine AS build
COPY . /home/app/cadastro-backend
RUN mvn -v
RUN mvn -f /home/app/cadastro-backend/pom.xml clean package


#Step 2 - Run backend
FROM alpine/java:21-jdk
COPY --from=build /home/app/cadastro-backend/target/*.jar /usr/local/lib/cadastro-backend.jar
VOLUME /tmp
EXPOSE 80:8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/cadastro-backend.jar"]
