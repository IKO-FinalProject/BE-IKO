FROM adoptopenjdk/openjdk11 AS builder

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

RUN chmod +x ./gradlew
RUN ./gradlew bootJar

FROM azul/zulu-openjdk-alpine:11
COPY --from=builder build/libs/*.jar app.jar

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/app.jar"]