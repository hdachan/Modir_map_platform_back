# 1단계: 빌드용 이미지
FROM gradle:8.3-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle clean build --no-daemon -x test

# 2단계: 실행용 이미지
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]