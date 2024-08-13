package online.bigzhouzhou.design_patterns.structural.composite;

/**
 * TestComposite类
 * date: 2024/8/13 21:13<br/>
 *
 * @author SAg <br/>
 */
public class TestComposite {
    public static void main(String[] args) {
        Node root = new ElementNode("school");
        root.add(new ElementNode("classA")
                .add(new TextNode("tom"))
                .add(new TextNode("Alice")));
        root.add(new ElementNode("classB")
                .add(new TextNode("Bob"))
                .add(new TextNode("Grace"))
                .add(new CommentNode("comment..")));
        System.out.println(root.toXml());
    }

    /**
     * 组合模式(composite)：
     * 1. 经常用于树形结构
     * 2. 使得叶子对象和容器对象具有一致性，从而形成统一的树形结构，并用一致的方式处理
     */
}
