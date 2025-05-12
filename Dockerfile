# 1단계: 빌드용 이미지
FROM gradle:8.0.2-jdk17 AS builder
WORKDIR /app
COPY . .
RUN ./gradlew build --no-daemon

# 2단계: 실행용 이미지
FROM openjdk:17
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
CMD ["java", "-jar", "app.jar"]
