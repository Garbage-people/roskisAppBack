FROM eclipse-temurin:17-jdk-focal as builder

WORKDIR /opt/app

COPY .mvn/ .mvn

COPY mvnw pom.xml ./

RUN chmod +x ./mvnw

COPY ./src ./src

RUN apt-get update && \
    apt-get install -y maven

# ???? :-) my brain is offline
RUN mvn dependency:go-offline

RUN mvn clean install -DskipTests

RUN find ./target -type f -name '*.jar' -exec cp {} /opt/app/app.jar \; -quit


FROM eclipse-temurin:17-jre-alpine

COPY --from=builder /opt/app/app.jar /opt/app/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/opt/app/app.jar"]