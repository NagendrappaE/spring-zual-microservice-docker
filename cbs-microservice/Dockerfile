FROM openjdk:8-jdk-alpine
EXPOSE 8200
COPY target/cbs-microservice-*.jar cbs-microservice.jar
ENTRYPOINT ["java","-D EUREKA_SERVER=http://172.17.0.3:8711/eureka","-jar","cbs-microservice.jar"]
