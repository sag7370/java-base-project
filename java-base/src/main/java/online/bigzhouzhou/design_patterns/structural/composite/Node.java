package online.bigzhouzhou.design_patterns.structural.composite;

import java.util.List;

/**
 * Node类
 * date: 2024/8/13 20:52<br/>
 * 节点类型
 *
 * @author SAg <br/>
 */
public interface Node {
    // 添加一个节点为子节点
    Node add(Node node);

    // 获取子节点
    List<Node> children();

    // 输出为XML
    String toXml();
}
