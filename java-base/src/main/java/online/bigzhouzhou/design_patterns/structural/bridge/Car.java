package online.bigzhouzhou.design_patterns.structural.bridge;

/**
 * Car类
 * date: 2024/8/13 20:38<br/>
 * 汽车
 *
 * @author SAg <br/>
 */
public abstract class Car {
    protected Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public abstract void drive();
}
