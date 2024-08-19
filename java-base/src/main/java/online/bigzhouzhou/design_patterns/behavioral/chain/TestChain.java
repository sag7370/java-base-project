package online.bigzhouzhou.design_patterns.behavioral.chain;

import java.math.BigDecimal;

/**
 * TestChain类<br/>
 * date: 2024/8/19 09:47<br/>
 * <br/>
 *
 * @author SAg <br/>
 */
public class TestChain {
    public static void main(String[] args) {
        HandlerChain handlerChain = new HandlerChain();
        handlerChain.addHandler(new ManageHandler());
        handlerChain.addHandler(new DirectorHandler());
        handlerChain.addHandler(new CEOHandler());
        // 处理请求
        handlerChain.process(new Request("Bob", new BigDecimal("123.45")));
        handlerChain.process(new Request("Alice", new BigDecimal("1234.56")));
        handlerChain.process(new Request("John", new BigDecimal("12345.67")));
        handlerChain.process(new Request("Mary", new BigDecimal("123456.78")));
        handlerChain.process(new Request("SAg", new BigDecimal("123456.78")));

    }

    /**
     * 责任链模式：
     * 1. 把多个处理器组合在一起，依次处理请求的模式
     * 2. 好处是添加新的处理器，或者重新排列处理器非常容易
     * 3. 经常用在拦截、预处理请求等
     */
}
