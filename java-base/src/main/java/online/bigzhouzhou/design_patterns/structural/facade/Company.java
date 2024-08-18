package online.bigzhouzhou.design_patterns.structural.facade;

import java.util.Random;

/**
 * Company类
 * date: 2024/8/17 08:48<br/>
 * 公司
 * @author SAg <br/>
 */
public class Company {
    private String id;
    private String name;

    private String bankAccount;

    private String taxCode;

    public Company(String name) {
        this.name = name;
        this.id = Math.random() * 100 + "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", taxCode='" + taxCode + '\'' +
                '}';
    }
}
