FROM eclipse-temurin:21-jdk

COPY target/day_2_practice_project_two-0.0.1-SNAPSHOT.jar app.jar


ENTRYPOINT ["java","-jar","/app.jar"]