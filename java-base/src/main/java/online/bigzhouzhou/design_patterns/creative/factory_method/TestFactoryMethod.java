package online.bigzhouzhou.design_patterns.creative.factory_method;

import java.util.List;

/**
 * TestFactoryMethod类
 * date: 2024/8/12 11:00<br/>
 *
 * @author SAg <br/>
 */
public class TestFactoryMethod {
    public static void main(String[] args) {
        // 工厂方法
        // 使得创建对象和使用对象是分离的，并且客户端总是引用抽象工厂和抽象产品。
        // 抽象工厂： NumberFactory  实际工厂: NumberFactoryImpl
        // 抽象产品:  Number  实际产品: BigDecimal
        NumberFactory factory = NumberFactory.getFactory();
        Number parse = factory.parse("123.456");

        // 静态工厂方法
        // 使用静态方法创建产品的方式称为静态工厂方法。广泛应用在Java标准库中。
        Number staticParse = NumberFactory.staticParse("123.444");

        // Java标准库中的静态工厂方法
        // 1. Integer 既是产品又是静态工厂，提供了静态方法valueOf()来创建Integer
        Integer n = Integer.valueOf(100);
        // 工厂方法可以隐藏创建产品的细节，且不一定每次都会真正的创建产品，完全可以返回缓存的产品，提升速度并减少内存消耗
        // 2. List.of()
        List<String> list = List.of("A", "B", "C");

    }

    /**
     * 小节：
     * 1. 工厂方法：定义工厂接口和产品接口，但如何创建实际工厂和实际产品被推迟到子类实现，
     * 从而调用方只和抽象产品打交道。
     * 2. 静态工厂方法：允许工厂内部对常见产品进行优化。更常用。
     * 3. 调用方尽量持有接口或抽象类，避免持有具体类型的子类，以便工厂方法能随时切换不同的子类返回，却不影响调用方代码。
     */
}
