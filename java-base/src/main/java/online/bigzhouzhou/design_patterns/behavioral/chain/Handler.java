package online.bigzhouzhou.design_patterns.behavioral.chain;

/**
 * Handler接口
 * date: 2024/8/19 09:08<br/>
 * 处理器 <br/>
 *
 * @author SAg <br/>
 */
public interface Handler {
    // 返回 Boolean.TRUE = 成功
    // 返回 Boolean.FAlSE = 拒绝
    // 返回 null = 交给下一个处理
    Boolean process(Request request);
}
