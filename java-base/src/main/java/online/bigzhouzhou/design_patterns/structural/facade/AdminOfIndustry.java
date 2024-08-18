package online.bigzhouzhou.design_patterns.structural.facade;

/**
 * AdminOfIndustry类
 * date: 2024/8/17 08:36<br/>
 * 工商注册
 *
 * @author SAg <br/>
 */
public class AdminOfIndustry {
    public Company register(String name) {
        return new Company(name);
    }
}
