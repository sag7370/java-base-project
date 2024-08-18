package online.bigzhouzhou.design_patterns.structural.facade;

/**
 * Taxation类
 * date: 2024/8/17 08:38<br/>
 * 纳税登记
 *
 * @author SAg <br/>
 */
public class Taxation {
    public String applyTaxCode(String companyId) {
        return "taxation.applyTaxCode :" + companyId;
    }
}
