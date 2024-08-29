package online.bigzhouzhou.context;


import online.bigzhouzhou.annotation.Bean;
import online.bigzhouzhou.annotation.Configuration;
import online.bigzhouzhou.annotation.Value;

@Configuration
public class SpecifyInitConfiguration {

    @Bean(initMethod = "init")
    SpecifyInitBean createSpecifyInitBean(@Value("${app.title}") String appTitle, @Value("${app.version}") String appVersion) {
        return new SpecifyInitBean(appTitle, appVersion);
    }
}
