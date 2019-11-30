FROM openjdk:8-jdk-alpine
EXPOSE 8200
COPY target/cbs-microservice-*.jar cbs-microservice.jar
ENTRYPOINT ["java","-jar","cbs-microservice.jar"]
