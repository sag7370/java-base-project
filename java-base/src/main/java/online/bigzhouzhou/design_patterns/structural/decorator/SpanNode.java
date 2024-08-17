package online.bigzhouzhou.design_patterns.structural.decorator;

/**
 * SpanNode类
 * date: 2024/8/16 09:31<br/>
 *
 * @author SAg <br/>
 */
public class SpanNode implements TextNode{
    private String text;

    @Override
    public String getText() {
        return "<span>" + text + "</span>";
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}
