
# Maven build container 

FROM maven:3.6.3-openjdk-11 AS maven_build

#pull base image

FROM openjdk
# For Java 11, try this
FROM openjdk:11-jdk-alpine

# For Java 11, try this
#FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE=unique-caterer-microservice-0.0.1-SNAPSHOT.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]

#sudo docker run -p 8080:8080 -t docker-unique-caterer-microservice-0.0.1-SNAPSHOT:1.0
## sudo docker run -p 80:8080 -t docker-unique-caterer-microservice-0.0.1-SNAPSHOT:1.0
## sudo docker run -p 443:8443 -t docker-unique-caterer-microservice-0.0.1-SNAPSHOT:1.0
