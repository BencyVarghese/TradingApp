FROM maven:3.9.0-eclipse-temurin-17-alpine AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip

FROM eclipse-temurin:17.0.6_10-jre-alpine
EXPOSE 8080
VOLUME /tmp
WORKDIR /app
COPY --from=build /home/app/target/tradingApp-0.0.1-SNAPSHOT.jar ./tradingApp.jar
ENTRYPOINT java -verbose:gc -jar tradingApp.jar