package online.bigzhouzhou.design_patterns.behavioral.chain;

import java.math.BigDecimal;

/**
 * CEOHandler类<br/>
 * date: 2024/8/19 09:17<br/>
 * <br/>
 *
 * @author SAg <br/>
 */
public class CEOHandler implements Handler {

    @Override
    public Boolean process(Request request) {
        return !request.getName().equalsIgnoreCase("SAg");
    }
}
