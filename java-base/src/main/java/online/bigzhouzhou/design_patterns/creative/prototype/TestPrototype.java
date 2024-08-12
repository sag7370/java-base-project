package online.bigzhouzhou.design_patterns.creative.prototype;

/**
 * TestPrototype类
 * date: 2024/8/12 15:20<br/>
 *
 * @author SAg <br/>
 */
public class TestPrototype {
    public static void main(String[] args) {
        Student std1 = new Student();
        std1.setId(123);
        std1.setName("Bob");
        std1.setScore(88);
        // 复制新对象:
        Student std2 = std1.clone();
        System.out.println(std1);
        System.out.println(std2);
        System.out.println(std1 == std2); // false
    }
    /**
     * 原型模式：
     * 根据一个现有对象实例复制出一个新的实例
     * 复制出的类型和属性与原实例相同
     */
}
