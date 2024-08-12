package online.bigzhouzhou.design_patterns.structural.adapter;

import java.util.concurrent.Callable;

/**
 * Task类
 * date: 2024/8/12 15:53<br/>
 *
 * @author SAg <br/>
 */
public class Task implements Callable<Long> {

    private long num;

    public Task(long num) {
        this.num = num;
    }

    @Override
    public Long call() throws Exception {
        long r = 0;
        for (int n = 0; n <= this.num; n++) {
            r = r + n;
        }
        System.out.println("Result : " + r);
        return r;
    }
}
