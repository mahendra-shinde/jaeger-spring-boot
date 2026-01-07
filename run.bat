SET otel.exporter.otlp.endpoint=http://localhost:4317
SET otel.exporter.otlp.protocol=grpc


start cmd /k java -javaagent:%USERPROFILE%\\Downloads\\opentelemetry-javaagent-2.23.0.jar -jar customer-service/target/customer-service-1.0.jar


start cmd /k  java -javaagent:%USERPROFILE%\\Downloads\\opentelemetry-javaagent-2.23.0.jar -jar loan-service/target/loan-service-1.0.jar

