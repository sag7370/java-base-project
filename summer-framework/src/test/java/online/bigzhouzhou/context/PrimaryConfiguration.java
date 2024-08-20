package online.bigzhouzhou.context;


import online.bigzhouzhou.annotation.Bean;
import online.bigzhouzhou.annotation.Configuration;
import online.bigzhouzhou.annotation.Primary;

@Configuration
public class PrimaryConfiguration {

    @Primary
    @Bean
    DogBean husky() {
        return new DogBean("Husky");
    }

    @Bean
    DogBean teddy() {
        return new DogBean("Teddy");
    }
}
