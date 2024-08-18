package online.bigzhouzhou.design_patterns.structural.adapter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * TestAdapter类
 * date: 2024/8/12 15:56<br/>
 *
 * @author SAg <br/>
 */
public class TestAdapter {
    public static void main(String[] args) {

        /*Task task = new Task(123450000L);
        Thread thread = new Thread(task); // compile error!
        thread.start();*/

        Task task = new Task(123450000L);
        Thread thread = new Thread(new RunnableAdapter(task));
        thread.start();

        // 适配器模式在Java标准库中的应用
        String[] exist = {"good", "morning", "Bob", "and", "Alice"};
        Set<String> set = new HashSet<>(Arrays.asList(exist));

    }

    /**
     * Adapter模式：（适配器模式）
     * 1. 将一个A接口转换成B接口，使得新的对象符合B接口规范
     * 2. 实际上就是编写一个实现了B接口并且内部持有A接口的类
     * 内部将B接口的调用“转换”为对A接口的调用
     */
}
