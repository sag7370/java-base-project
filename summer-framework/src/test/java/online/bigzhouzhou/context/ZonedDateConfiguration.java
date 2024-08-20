package online.bigzhouzhou.context;

import online.bigzhouzhou.annotation.Bean;
import online.bigzhouzhou.annotation.Configuration;

import java.time.ZonedDateTime;

@Configuration
public class ZonedDateConfiguration {

    @Bean
    ZonedDateTime startZonedDateTime() {
        return ZonedDateTime.now();
    }
}
