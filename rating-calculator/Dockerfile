FROM openjdk:8
COPY target/rating-calculator-0.0.1-SNAPSHOT.jar /usr/lib/rating-calculator
WORKDIR /usr/lib/rating-calculator
CMD java -Dspring.profiles.active=prod -jar rating-calculator-0.0.1-SNAPSHOT.jar