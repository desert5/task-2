FROM openjdk:8
COPY target/data-collector-0.0.1-SNAPSHOT.jar /usr/lib/data-collector
WORKDIR /usr/lib/data-collector
CMD java -Dspring.profiles.active=prod -jar data-collector-0.0.1-SNAPSHOT.jar