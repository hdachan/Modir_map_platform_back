# 1단계: 빌드용 이미지
FROM gradle:8.4.0-jdk17-alpine AS build
WORKDIR /app
COPY . .
RUN gradle build --no-daemon

# 2단계: 실행용 이미지
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
