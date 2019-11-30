FROM openjdk:8-jdk-alpine
EXPOSE 8711
COPY target/eurekaserver-*.jar eurekaserver.jar
ENTRYPOINT ["java","-jar","eurekaserver.jar"]
