package online.bigzhouzhou.design_patterns.creative.factory_method;

import java.math.BigDecimal;

/**
 * NumberFactoryImpl类
 * date: 2024/8/12 10:55<br/>
 *
 * @author SAg <br/>
 */
public class NumberFactoryImpl implements NumberFactory{

    @Override
    public Number parse(String s) {
        return new BigDecimal(s);
    }
}
