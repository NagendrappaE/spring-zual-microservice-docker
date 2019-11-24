FROM openjdk:8-jdk-alpine
EXPOSE 8100
COPY target/originator-microservice-*.jar originator-microservice.jar
ENTRYPOINT ["java","-D EUREKA_SERVER=http://172.17.0.3:8711/eureka","-jar","originator-microservice.jar"]
