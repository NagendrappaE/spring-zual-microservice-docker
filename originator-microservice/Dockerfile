FROM openjdk:8-jdk-alpine
EXPOSE 8100
COPY target/originator-microservice-*.jar originator-microservice.jar
ENTRYPOINT ["java","-jar","originator-microservice.jar"]
