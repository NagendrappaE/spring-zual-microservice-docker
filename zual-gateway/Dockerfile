FROM openjdk:8-jdk-alpine
EXPOSE 8300
COPY target/zual-gateway-*.jar zual-gateway.jar
ENTRYPOINT ["java","-jar","zual-gateway.jar"]
