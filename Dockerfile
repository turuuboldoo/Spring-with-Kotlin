FROM openjdk:19-jdk-alpine
WORKDIR /app
COPY build/libs/lesson-0.0.1.jar /app/lesson.jar
CMD ["java", "-jar", "/app/lesson.jar"]
