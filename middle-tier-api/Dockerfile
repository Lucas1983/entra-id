# Build stage
FROM gradle:jdk17 AS build
WORKDIR /home/gradle/project
COPY . .
RUN gradle --no-daemon clean bootJar -x test

# Run stage
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /home/gradle/project/build/libs/*.jar /app/app.jar
EXPOSE 8080
ENV JAVA_OPTS=""
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /app/app.jar"]
