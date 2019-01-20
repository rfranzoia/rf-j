FROM openjdk:8-jdk-alpine
MAINTAINER Romeu Franzoia Jr <rfranzoia@gmail.com>
VOLUME /tmp
EXPOSE 8080
ADD target/rf-j.jar app.jar
ADD rf-j.properties rf-j.properties
ENTRYPOINT ["java", "-jar", "/app.jar"]