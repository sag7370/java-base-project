package online.bigzhouzhou.design_patterns.structural.facade;

/**
 * Bank类
 * date: 2024/8/17 08:37<br/>
 * 银行开户
 * @author SAg <br/>
 */
public class Bank {
    public String openAccount(String companyId) {
        return "Bank.openAccount " + companyId;
    }
}
