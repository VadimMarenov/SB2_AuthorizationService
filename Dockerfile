FROM openjdk:18-jdk-alpine

EXPOSE 8080

ADD /target/SB2AutorizationService-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]