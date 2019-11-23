FROM openjdk:8-jdk-alpine
EXPOSE 8711
COPY target/eurekaserver-*.jar eurekaserver.jar
ENTRYPOINT ["java","-D EUREKA_SERVER=http://eurekaserver:8711/eureka","-jar","eurekaserver.jar"]
