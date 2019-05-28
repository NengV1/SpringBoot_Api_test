package com.ss.springbootgo.springboot_test.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class JacksonConfig {
    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {

        DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("d-M-yyyy");
        DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern("d-M-yyyy HH:mm:ss");
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(localDateTimeFormatter));
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(localDateTimeFormatter));
        module.addSerializer(LocalDate.class, new LocalDateSerializer(localDateFormatter));
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer(localDateFormatter));

        return new Jackson2ObjectMapperBuilder().json()
                .propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
                .modules(module)
                .serializationInclusion(JsonInclude.Include.NON_EMPTY)
                .featuresToEnable(SerializationFeature.INDENT_OUTPUT)
                .featuresToDisable(
                        SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
                        DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE,
                        DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,
                        DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
                );

    }

}
