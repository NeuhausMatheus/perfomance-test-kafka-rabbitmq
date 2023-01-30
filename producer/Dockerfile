FROM openjdk:17
COPY ./target/producer-0.0.1-SNAPSHOT.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java","-jar", "producer-0.0.1-SNAPSHOT.jar"]