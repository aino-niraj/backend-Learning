FROM openjdk:8u252-slim
COPY env-config /app/env-config
COPY target/CacheService.jar /app
COPY Dockerfile /app/Dockerfile
COPY webapp /app/webapp
WORKDIR /app/
CMD ["java", "-jar", "CacheService.jar", "--deployment.mode=STANDALONE"]