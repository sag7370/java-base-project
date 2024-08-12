package online.bigzhouzhou.design_patterns.structural.adapter;

import java.util.concurrent.Callable;

/**
 * RunnableAdapter类
 * date: 2024/8/12 15:57<br/>
 *
 * @author SAg <br/>
 */
public class RunnableAdapter implements Runnable{

    private Callable<Long> callable;

    public RunnableAdapter(Callable<Long> callable) {
        this.callable = callable;
    }
    @Override
    public void run() {
        // 将指定接口调用委托给转换接口调用
        try {
            callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
