package online.bigzhouzhou.design_patterns.creative.singleton;

/**
 * TestSingleton类
 * date: 2024/8/12 15:46<br/>
 *
 * @author SAg <br/>
 */
public class TestSingleton {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();

        System.out.println(instance == instance1);

        String name = World.INSTANCE.getName();
        System.out.println(name);
    }

    /**
     * Singleton模式：
     * 1. 保证程序在运行期间，某个类有且只有一个全局唯一实例
     * 2. 既可以严格实现，也可以以约定方式把普通类视作单例
     */
}
