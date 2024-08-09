package online.bigzhouzhou.utils;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.representer.Representer;
import org.yaml.snakeyaml.resolver.Resolver;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * YamlUtils类
 * date: 2024/8/8 17:46<br/>
 * 支持yaml文件解析
 *
 * @author SAg <br/>
 */

@SuppressWarnings("unused")
public class YamlUtils {

    /**
     * 从指定路径加载yaml文件，并返回一个Map< String, Object> 表示文件内容
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> loadYaml(String path) {
        var loaderOptions = new LoaderOptions();
        var dumperOptions = new DumperOptions();
        var representer = new Representer(dumperOptions);
        var resolver = new NoImplicitResolver();
        var yaml = new Yaml(new Constructor(loaderOptions), representer, dumperOptions, loaderOptions, resolver);
        return ClassPathUtils.readInputStream(path, (input) -> {
            return (Map<String, Object>) yaml.load(input);
        });
    }

    /**
     * 加载yaml文件，并将其转化为平面的map。即所有嵌套的键值对都展平为单层健
     */
    public static Map<String, Object> loadYamlAsPlainMap(String path) {
        // 加载yaml文件
        Map<String, Object> data = loadYaml(path);
        Map<String, Object> plain = new LinkedHashMap<>();
        // 递归将嵌套的map转换为带有前缀健的平面map
        convertTo(data, "", plain);
        return plain;
    }

    /**
     * 将嵌套的map转换为带有前缀键的平面map
     */
    static void convertTo(Map<String, Object> source, String prefix, Map<String, Object> plain) {
        // 遍历 source 每个键值对
        for (String key : source.keySet()) {
            Object value = source.get(key);
            if (value instanceof Map) {
                // 如果值是map，则递归调用convertTo
                @SuppressWarnings("unchecked")
                Map<String, Object> subMap = (Map<String, Object>) value;
                convertTo(subMap, prefix + key + ".", plain);
            } else if (value instanceof List) {
                // 如果是list，则直接添加到plain中
                plain.put(prefix + key, value);
            } else {
                // 将值直接转化为字符串后，添加到 plain
                plain.put(prefix + key, value.toString());
            }
        }
    }
}

/**
 * 自定义Resolver类，用于禁用yaml隐式解析器 (例如，将"123" 解析为整数)
 */
class NoImplicitResolver extends Resolver {

    public NoImplicitResolver() {
        super();
        // 清空了父类中的yaml隐式解析器列表
        super.yamlImplicitResolvers.clear();
    }
}
