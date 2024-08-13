package online.bigzhouzhou.design_patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * ElementNode类
 * date: 2024/8/13 20:54<br/>
 * 处理 < abc> < /> 这样的节点
 * @author SAg <br/>
 */
public class ElementNode implements Node{
    private String name;
    private List<Node> list = new ArrayList<>();

    public ElementNode(String name) {
        this.name = name;
    }

    @Override
    public Node add(Node node) {
        list.add(node);
        return this;
    }

    @Override
    public List<Node> children() {
        return list;
    }

    @Override
    public String toXml() {
        String start = "<" + name + ">\n";
        String end = "</" + name + ">\n";
        StringJoiner sj = new StringJoiner("", start, end);
        list.forEach(node -> {
            sj.add(node.toXml() + "\n");
        });
        return sj.toString();
    }
}
