package online.bigzhouzhou.design_patterns.structural.decorator;

/**
 * NodeDecorator类
 * date: 2024/8/16 15:15<br/>
 * 持有一个 `TextNode`，即将要把功能附加到的`TextNode`实例
 * @author SAg <br/>
 */
public abstract class NodeDecorator implements TextNode{
    protected final TextNode target;

    protected NodeDecorator(TextNode target) {
        this.target = target;
    }

    public void setText(String text) {
        this.target.setText(text);
    }
}
