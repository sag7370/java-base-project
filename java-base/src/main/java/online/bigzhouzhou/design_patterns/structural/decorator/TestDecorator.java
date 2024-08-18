package online.bigzhouzhou.design_patterns.structural.decorator;

/**
 * TestDecorator类
 * date: 2024/8/16 15:27<br/>
 *
 * @author SAg <br/>
 */
public class TestDecorator {
    public static void main(String[] args) {
        TextNode n1 = new SpanNode();
        TextNode n2 = new BoldDecorator(new SpanNode());
        n1.setText("Hello");
        n2.setText("Decorated");
        System.out.println(n1.getText());
        System.out.println(n2.getText());
    }

    /**
     * 装饰器模式
     * 1. 动态给一个对象添加一些额外的职责。
     * 2. 可以独立增加核心功能，也可以独立增加附加功能，二者互不影响。
     * 3. 可以在运行期动态给核心功能增加任意个附加功能
     */
}
