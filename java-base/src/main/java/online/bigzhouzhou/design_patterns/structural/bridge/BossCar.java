package online.bigzhouzhou.design_patterns.structural.bridge;

/**
 * BossCar类
 * date: 2024/8/13 20:43<br/>
 *
 * @author SAg <br/>
 */
public class BossCar extends RefinedCar{
    public BossCar(Engine engine) {
        super(engine);
    }

    @Override
    public String getBrand() {
        return "Boss";
    }
}
