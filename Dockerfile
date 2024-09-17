FROM openjdk:18
WORKDIR /app
COPY ./target/Microproject-ESBS-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "Microproject-ESBS-0.0.1-SNAPSHOT.jar"]
