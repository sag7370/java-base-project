package bigzhou.interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * TimerTest类
 * date: 2024/7/31 21:04<br/>
 * 演示回调函数与接口
 *
 * @author SAg <br/>
 */
public class TimerTest {
    public static void main(String[] args) {
        var listener = new TimePrinter();
        // 构造一个定时器，每经过delay毫秒通知listener一次
        Timer timer = new Timer(1000, listener);
        // 启动定时器。一旦启动，定时器将调用监听器的actionPerformed
        timer.start();
        // 显式一个包含一条提示消息和OK按钮的对话框。这个对话框位于parent组件的中央，如果Parent为null，
        // 对话框显示在屏幕的中央
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);

    }
}

class TimePrinter implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        // event.getWhen() 返回这个事件时间
        // Instant.ofEpochMilli 可以得到一个更可读的描述
        System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
        // 获得默认的工具箱，发出一声铃响。
        Toolkit.getDefaultToolkit().beep();
    }
}
