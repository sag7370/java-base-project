package online.bigzhouzhou.innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * InnerClassTest类
 * date: 2024/8/1 15:44<br/>
 *
 * @author SAg <br/>
 */
public class InnerClassTest {
    public static void main(String[] args) {
        TakingClock clock = new TakingClock(1000, false);
        clock.start();
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class TakingClock {
    /**
     * 通知的间隔
     */
    private int interval;
    /**
     * 开关铃声的标识
     */
    private boolean beep;

    public TakingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        var listener = new TimePrinter();
        var timer = new Timer(interval, listener);
        timer.start();
    }

    public class TimePrinter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
