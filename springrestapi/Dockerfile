FROM openjdk:8
ADD target/springrestapi-0.0.1-SNAPSHOT.jar dockerapi.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "dockerapi.jar"]