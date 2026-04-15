FROM eclipse-temurin:17
WORKDIR /app

COPY target/payroll-system-1.0.jar app.jar

CMD sh -c "java -jar app.jar || true; tail -f /dev/null"