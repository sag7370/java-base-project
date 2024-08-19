package online.bigzhouzhou.design_patterns.behavioral.chain;

import java.math.BigDecimal;

/**
 * ManageHandler类<br/>
 * date: 2024/8/19 09:12<br/>
 * <br/>
 *
 * @author SAg <br/>
 */
public class ManageHandler implements Handler{

    @Override
    public Boolean process(Request request) {
        if (request.getAmount().compareTo(BigDecimal.valueOf(1000)) >0) {
            // 如果超过1000元，处理不了，交下一个处理
            return null;
        }
        // 对Bob有偏见
        return !request.getName().equalsIgnoreCase("bob");
    }
}
