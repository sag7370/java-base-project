package online.bigzhouzhou.context;


import jakarta.annotation.PostConstruct;
import online.bigzhouzhou.annotation.Component;
import online.bigzhouzhou.annotation.Value;

@Component
public class AnnotationInitBean {

    @Value("${app.title}")
    String appTitle;

    @Value("${app.version}")
    String appVersion;

    public String appName;

    @PostConstruct
    void init() {
        this.appName = this.appTitle + " / " + this.appVersion;
    }
}
