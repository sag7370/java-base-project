package online.bigzhouzhou.utils;

import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * TestYamlUtils类
 * date: 2024/8/9 09:17<br/>
 *
 * @author SAg <br/>
 */
public class TestYamlUtils {


    @Test
    public void testLoadYaml() {
        Map<String, Object> configs = YamlUtils.loadYaml("/application.yml");
        configs.forEach((k, v) -> System.out.println(k + ":" + v + "(" + v.getClass() + ")"));
    }


}
