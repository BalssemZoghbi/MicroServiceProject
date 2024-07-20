FROM eclipse-temurin:17-jdk-alpine
WORKDIR /Config-Server
EXPOSE 8888
ADD target/Config-Server-0.0.1-SNAPSHOT.jar config-server.jar
ENTRYPOINT ["java", "-jar", "Config-Server-0.0.1-SNAPSHOT.jar"]