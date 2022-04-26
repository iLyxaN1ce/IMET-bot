FROM maven:3.8.5-openjdk-17 as builder
COPY src /tmp/src
COPY pom.xml /tmp/pom.xml
RUN cd /tmp && \
  mvn clean package spring-boot:repackage

FROM openjdk:17-oracle
COPY --from=builder /tmp/target/imet-spbstu-bot.jar /app/imet-spbstu-bot.jar