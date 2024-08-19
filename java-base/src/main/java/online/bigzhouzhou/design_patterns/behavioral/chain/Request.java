package online.bigzhouzhou.design_patterns.behavioral.chain;

import java.math.BigDecimal;

/**
 * Request类
 * date: 2024/8/19 09:06<br/>
 *
 * @author SAg <br/>
 */
public class Request {
    private String name;
    private BigDecimal amount;

    public Request(String name, BigDecimal amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
