package com.mahendra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Tracer;

@Configuration
public class OtelConfig {

	@Bean
	Tracer tracer(OpenTelemetry openTel) {
		return openTel.getTracer("loan-srv-tracer"); 
	}
}
