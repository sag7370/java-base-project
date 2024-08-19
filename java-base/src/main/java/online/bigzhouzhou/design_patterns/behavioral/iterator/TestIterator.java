package online.bigzhouzhou.design_patterns.behavioral.iterator;

/**
 * TestIterator类<br/>
 * date: 2024/8/19 22:25<br/>
 * <br/>
 *
 * @author SAg <br/>
 */
public class TestIterator {
    public static void main(String[] args) {
        ReverseArrayCollection<String> collection = new ReverseArrayCollection<>("a", "b", "c", "d", "e");
        for (String s : collection) {
            System.out.println(s);
        }
    }
    /**
     * 迭代器模式：
     * 1. 常用于遍历集合，允许集合提供统一的`Iterator`接口来遍历元素，
     * 同时保证调用者对集合内部的数据结构一无所知，从而使得调用者总是以相同的
     * 接口遍历不同类型的集合
     */
}
