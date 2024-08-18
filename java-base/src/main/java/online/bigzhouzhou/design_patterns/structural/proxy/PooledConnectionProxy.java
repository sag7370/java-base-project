package online.bigzhouzhou.design_patterns.structural.proxy;

import java.sql.Connection;
import java.util.Queue;

/**
 * PooledConnectionProxy类
 * date: 2024/8/18 21:49<br/>
 *
 * @author SAg <br/>
 */
public class PooledConnectionProxy extends AbstractConnectionProxy {
    Connection target;
    Queue<PooledConnectionProxy> idleQueue;

    public PooledConnectionProxy(Connection target, Queue<PooledConnectionProxy> idleQueue) {
        this.target = target;
        this.idleQueue = idleQueue;
    }

    @Override
    protected Connection getRealConnection() {
        return target;
    }

    @Override
    public void close() {
        System.out.println("Fake close and released to idle queue for future reuse: " + target);
        // 并没有调用实际Connection的close() 方法
        // 而是把自己放入空闲队列
        idleQueue.offer(this);
    }
}
