package online.bigzhouzhou.design_patterns.structural.flyweight;

/**
 * Flyweight类
 * date: 2024/8/18 18:40<br/>
 *
 * @author SAg <br/>
 */
public class TestFlyweight {
    public static void main(String[] args) {
        Integer n1 = Integer.valueOf(100);
        Integer n2 = Integer.valueOf(100);
        System.out.println(n1 == n2);
    }

    /**
     * Flyweight模式
     * 1. 运行共享技术有效地支持大量细粒度的对象
     * 2. 如果一个对象实例一经创建就不可变，那么就没必要反复创建相同的实例，直接向调用方返回一个共享的
     * 实例就可以。节省内存，减少创建对象的过程，提高运行速度
     * 3. 尽量复用已创建的对象，常用于工厂方法内部的优化 （缓存）
     */
}
