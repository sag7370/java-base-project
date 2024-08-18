package online.bigzhouzhou.design_patterns.structural.facade;

/**
 * Facade类
 * date: 2024/8/17 08:40<br/>
 * 中介
 *
 * @author SAg <br/>
 */
public class Facade {
    private final AdminOfIndustry admin;
    private final Bank bank;
    private final Taxation taxation;

    public Facade() {
        this.admin = new AdminOfIndustry();
        this.bank = new Bank();
        this.taxation = new Taxation();
    }

    public Company openCompany(String name) {
        // 1. 工商注册
        Company c = this.admin.register(name);
        // 2. 银行开户
        String bankAccount = this.bank.openAccount(c.getId());
        c.setBankAccount(bankAccount);
        // 3. 税务登记
        String taxCode = this.taxation.applyTaxCode(c.getId());
        c.setTaxCode(taxCode);
        return c;
    }
}
