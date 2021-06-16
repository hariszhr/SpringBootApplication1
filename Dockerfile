FROM openjdk:18-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} springApp.jar
ENTRYPOINT ["java","-jar","/springApp.jar"]
