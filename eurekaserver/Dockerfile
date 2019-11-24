FROM openjdk:8-jdk-alpine
EXPOSE 8711
COPY target/eurekaserver-*.jar eurekaserver.jar
ENTRYPOINT ["java","-D EUREKA_SERVER=http://172.17.0.3:8711/eureka","-jar","eurekaserver.jar"]
