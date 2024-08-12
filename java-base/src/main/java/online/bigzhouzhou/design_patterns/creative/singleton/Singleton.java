package online.bigzhouzhou.design_patterns.creative.singleton;

/**
 * Singleton类
 * date: 2024/8/12 15:39<br/>
 *
 * @author SAg <br/>
 */
public class Singleton {
    // 静态字段引用唯一实例
    private static final Singleton INSTANCE = new Singleton();
    // private构造方法保证外部无法实例化
    private Singleton() {

    }
    // 通过静态方法返回实例
    public static Singleton getInstance() {
        return INSTANCE;
    }

}
