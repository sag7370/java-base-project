package online.bigzhouzhou.design_patterns.structural.bridge;

/**
 * RefinedCar类
 * date: 2024/8/13 20:40<br/>
 *
 * @author SAg <br/>
 */
public abstract class RefinedCar extends Car {
    public RefinedCar(Engine engine) {
        super(engine);
    }

    public void drive() {
        this.engine.start();
        System.out.println("Drive " + getBrand() + " car...");
    }

    // 获取品牌
    public abstract String getBrand();
}
