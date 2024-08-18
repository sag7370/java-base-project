package online.bigzhouzhou.design_patterns.structural.facade;

/**
 * TestFacade类
 * date: 2024/8/17 08:52<br/>
 *
 * @author SAg <br/>
 */
public class TestFacade {
    public static void main(String[] args) {
        Facade facade = new Facade();
        Company company = facade.openCompany("shan.chen.ge company");
        System.out.println(company);

    }

    /**
     * 装饰模式
     * 1. 为子系统中的一组接口提供一个一致的界面。Facade模式定义了一个高层接口，这个接口使得这一子系统更加容易使用
     * 2. 为客户端提供一个统一入口，并对外屏蔽内部子系统的调用细节
     */
}
