package online.bigzhouzhou.design_patterns.structural.bridge;

/**
 * TestBridge类
 * date: 2024/8/13 20:46<br/>
 *
 * @author SAg <br/>
 */
public class TestBridge {
    public static void main(String[] args) {
        BossCar bossCar = new BossCar(new HybridEngine());
        bossCar.drive();
    }
    /**
     * 桥接模式：
     * 1. 避免子类直接继承带来的子类爆炸
     * 2. 通过分离一个抽象接口和它的实现部分，使得设计可以按两个维度独立扩展
     */
}
