package online.bigzhouzhou.design_patterns.structural.composite;

import java.util.List;

/**
 * CommentNode类
 * date: 2024/8/13 21:09<br/>
 * 注释节点
 *
 * @author SAg <br/>
 */
public class CommentNode implements Node {

    private String text;

    public CommentNode(String text) {
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
        return "<!--" + text + "-->";
    }
}
