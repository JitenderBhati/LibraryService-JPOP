FROM openjdk:14-ea-8-jdk-alpine3.10

LABEL Jitender Bhati <Jitender_Bhati@epam.com>

COPY target /app

WORKDIR /app

ENTRYPOINT ["java", "-jar", "user_service-0.0.1-SNAPSHOT.war"]