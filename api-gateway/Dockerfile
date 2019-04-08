FROM  hub.c.163.com/library/java:8-alpine

MAINTAINER ycc_ysoft

ADD target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-apijar", "/app.jar"]