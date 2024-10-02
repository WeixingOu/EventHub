FROM gradle:8.2.1-jdk17-alpine

COPY . .

EXPOSE 8080

RUN gradle build

ENTRYPOINT ["java", "-jar"]