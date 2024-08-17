package online.bigzhouzhou.design_patterns.structural.decorator;

/**
 * BoldDecortor类
 * date: 2024/8/16 15:24<br/>
 *
 * @author SAg <br/>
 */
public class BoldDecorator extends NodeDecorator {

    public BoldDecorator(TextNode target) {
        super(target);
    }

    @Override
    public String getText() {
        return "<b>" + target.getText() + "</b>";
    }
}
