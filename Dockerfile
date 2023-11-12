FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:123456 -o SkiStationProject.jar "http://192.168.1.3:8081/repository/maven-releases/tn/esprit/ds/SkiStationProject/1.0/SkiStationProject-1.0.jar" -L
ENTRYPOINT ["java","-jar","/SkiStationProject.jar"]
EXPOSE 8089