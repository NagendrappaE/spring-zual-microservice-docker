FROM openjdk:8-jdk-alpine
EXPOSE 8300
COPY target/zual-gateway-*.jar zual-gateway.jar
ENTRYPOINT ["java","-D EUREKA_SERVER=http://172.17.0.3:8711/eureka","-jar","zual-gateway.jar"]
