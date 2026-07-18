FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app
COPY pom.xml .

RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package dependency:copy-dependencies
# RUN mvn clean package

FROM eclipse-temurin:21-jre
# FROM bellsoft/liberica-runtime-container:jre-21-full-slim

WORKDIR /app

RUN apt-get update && apt-get install -y \
    libgl1 \
    libasound2t64 \
    x11-apps \
    libgtk-3-0 \
    unzip \
    && rm -rf /var/lib/apt/lists/*

COPY --from=builder /app/target/javafx-fxml-app-1.0-SNAPSHOT.jar ./CirculoDeLaMuerte.jar
COPY --from=builder /app/target/dependency ./libs

ENV QT_X11_NO_MITSHM=1

# ENTRYPOINT ["java", "--module-path", "libs", "--add-modules", "javafx.controls,javafx.fxml", "-jar", "CirculoDeLaMuerte.jar"]
ENTRYPOINT ["java", "-jar", "CirculoDeLaMuerte.jar"]
