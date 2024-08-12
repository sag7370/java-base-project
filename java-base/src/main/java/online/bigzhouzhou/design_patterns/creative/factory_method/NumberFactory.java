package online.bigzhouzhou.design_patterns.creative.factory_method;

import java.math.BigDecimal;

/**
 * NumberFactory接口
 * date: 2024/8/12 10:54<br/>
 * 解析字符串到`Number`的`Factory`
 *
 * @author SAg <br/>
 */
public interface NumberFactory {
    static NumberFactory impl = new NumberFactoryImpl();
    // 创建方法
    Number parse(String s);

    // 获取工厂实例
    static NumberFactory getFactory() {
        return impl;
    }

    public static Number staticParse(String s) {
        return new BigDecimal(s);
    }
}
