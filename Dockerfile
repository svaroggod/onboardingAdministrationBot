FROM maven AS builder
WORKDIR /onboardingadminbot/
COPY . .
RUN mvn clean package



FROM openjdk:17.0.1-jdk-buster
COPY --from=builder /onboardingadminbot/target/onboardingAdministrationBot-1.0-SNAPSHOT-jar-with-dependencies.jar /onboardingAdministrationBot-1.0.jar
ENTRYPOINT ["java", "-Xmx128m", "-XX:+UseZGC", "-XX:ZUncommitDelay=60", "-XX:MaxHeapFreeRatio=30", "-XX:MinHeapFreeRatio=10", "-jar", "HRadminBot-1.0.jar"]