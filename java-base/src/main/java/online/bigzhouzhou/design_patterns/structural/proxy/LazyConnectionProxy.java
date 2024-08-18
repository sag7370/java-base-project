package online.bigzhouzhou.design_patterns.structural.proxy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.Supplier;

/**
 * LazyConnectionProxy类
 * date: 2024/8/18 21:01<br/>
 *
 * @author SAg <br/>
 */
public class LazyConnectionProxy extends AbstractConnectionProxy{

    private Supplier<Connection> supplier;
    private Connection target = null;

    public LazyConnectionProxy(Supplier<Connection> supplier) {
        this.supplier = supplier;
    }

    @Override
    protected Connection getRealConnection() {
        if (target == null) {
            target = supplier.get();
        }
        return target;
    }

    @Override
    public void close() throws SQLException {
        if (target != null) {
            System.out.println("Close connection: " + target);
            super.close();
        }
    }
}

