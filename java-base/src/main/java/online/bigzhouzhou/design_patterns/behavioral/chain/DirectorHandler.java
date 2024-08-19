package online.bigzhouzhou.design_patterns.behavioral.chain;

import java.math.BigDecimal;

/**
 * DirectorHandler类<br/>
 * date: 2024/8/19 09:14<br/>
 * <br/>
 *
 * @author SAg <br/>
 */
public class DirectorHandler implements Handler {

    @Override
    public Boolean process(Request request) {
        if (request.getAmount().compareTo(BigDecimal.valueOf(10000)) > 0
        || request.getName().equalsIgnoreCase("SAg")) {
            return null;
        }
        return true;
    }
}
