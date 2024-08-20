package online.bigzhouzhou.context;

import online.bigzhouzhou.annotation.Bean;
import online.bigzhouzhou.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Configuration
public class LocalDateConfiguration {

    @Bean
    LocalDate startLocalDate() {
        return LocalDate.now();
    }

    @Bean
    LocalDateTime startLocalDateTime() {
        return LocalDateTime.now();
    }
}
