package online.bigzhouzhou.design_patterns.creative.builder;

import java.util.Map;

/**
 * TestBuilder类
 * date: 2024/8/12 15:06<br/>
 *
 * @author SAg <br/>
 */
public class TestBuilder {
    public static void main(String[] args) {
        String url = URLBuilder.builder() // 创建Builder
                .setDomain("www.liaoxuefeng.com") // 设置domain
                .setScheme("https") // 设置scheme
                .setPath("/") // 设置路径
                .setQuery(Map.of("a", "123", "q", "K&R")) // 设置query
                .build(); // 完成build
        System.out.println(url);
    }

    /**
     * 创建一个复杂的对象，需要多个步骤完成创建，
     * 或者需要多个零件组装的场景，
     * 且创建过程中可以灵活调用不同的步骤或组件
     */
}
