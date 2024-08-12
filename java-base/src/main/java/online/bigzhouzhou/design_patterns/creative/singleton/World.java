package online.bigzhouzhou.design_patterns.creative.singleton;

/**
 * 枚举类World
 * date: 2024/8/12 15:43<br/>
 * Java保证枚举类的每个枚举都是单例
 *
 * @author SAg <br/>
 */
public enum World {
    // 唯一枚举
    INSTANCE;
    private String name = "world";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
