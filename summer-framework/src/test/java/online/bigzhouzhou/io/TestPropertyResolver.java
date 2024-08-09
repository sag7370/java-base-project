package online.bigzhouzhou.io;

import org.junit.jupiter.api.Test;

import java.util.Properties;

/**
 * PropertyResolver类
 * date: 2024/8/9 09:15<br/>
 *
 * @author SAg <br/>
 */
public class TestPropertyResolver {
    @Test
    public void propertyValue() {
        var props = new Properties();
        props.setProperty("app.title", "Summer Framework");
        props.setProperty("app.version", "v1.0");
        props.setProperty("jdbc.url", "jdbc:mysql://localhost:3306/simpsons");
        props.setProperty("jdbc.username", "bart");
        props.setProperty("jdbc.password", "51mp50n");
        props.setProperty("jdbc.pool-size", "20");
        props.setProperty("jdbc.auto-commit", "true");
        props.setProperty("scheduler.started-at", "2023-03-29T21:45:01");
        props.setProperty("scheduler.backup-at", "03:05:10");
        props.setProperty("scheduler.cleanup", "P2DT8H21M");

        var pr = new PropertyResolver(props);
        String appTitle = pr.getProperty("app.title");
        System.out.println("appTitle = " + appTitle);
        String appTitle2 = pr.getProperty("${app.title}");
        System.out.println("appTitle2 = " + appTitle2);
        Integer jdbcPoolSize = pr.getProperty("jdbc.pool-size", Integer.class);
        System.out.println("jdbcPoolSize = " + jdbcPoolSize);

    }

}
