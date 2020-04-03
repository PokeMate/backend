FROM openjdk:8-jdk-alpine
ARG JAR_FILE=targets/artifacts/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
