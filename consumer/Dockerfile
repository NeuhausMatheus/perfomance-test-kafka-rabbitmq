FROM openjdk:17
COPY ./target/consumer-0.0.1-SNAPSHOT.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java","-jar", "consumer-0.0.1-SNAPSHOT.jar"]