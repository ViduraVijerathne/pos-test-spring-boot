FROM openjdk:17

COPY target/facebook-spring-0.0.1-SNAPSHOT.jar  facebook-spring-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/facebook-spring-0.0.1-SNAPSHOT.jar"]
