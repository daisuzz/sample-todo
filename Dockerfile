FROM maven:3.6.3-openjdk-11 as builder

WORKDIR /work
COPY . /work
RUN mvn -B package

FROM maven:3.6.3-openjdk-11 as runner
WORKDIR /app
COPY --from=builder /work/target/sample-thymeleaf-todo-0.0.1-SNAPSHOT.jar /app
CMD ["java", "-jar", "sample-thymeleaf-todo-0.0.1-SNAPSHOT.jar"]
