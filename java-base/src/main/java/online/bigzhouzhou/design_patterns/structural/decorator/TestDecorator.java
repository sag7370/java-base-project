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
}
