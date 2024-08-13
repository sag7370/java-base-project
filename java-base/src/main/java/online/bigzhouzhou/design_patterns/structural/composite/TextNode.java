package online.bigzhouzhou.design_patterns.structural.composite;

import java.util.List;

/**
 * TextNode类
 * date: 2024/8/13 21:08<br/>
 * 处理普通的文本
 *
 * @author SAg <br/>
 */
public class TextNode implements Node{
    private String text;

    public TextNode(String text) {
        this.text = text;
    }

    @Override
    public Node add(Node node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Node> children() {
        return List.of();
    }

    @Override
    public String toXml() {
        return text;
    }
}
