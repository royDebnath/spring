FROM openjdk:8
ADD target/debnath-k8s-0.0.1-SNAPSHOT.jar debnath-k8s.jar
EXPOSE 3585
ENTRYPOINT ["java", "-jar", "debnath-k8s.jar"]