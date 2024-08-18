package online.bigzhouzhou.design_patterns.structural.proxy;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * TestProxy类
 * date: 2024/8/18 21:08<br/>
 *
 * @author SAg <br/>
 */
public class TestProxy {
    private static final String jdbcUrl = "jdbc:mysql://localhost:3308/test";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "root";
    public static void main(String[] args) throws SQLException {
        DataSource lazyDataSource = new LazyDataSource(jdbcUrl, jdbcUsername, jdbcPassword);
        System.out.println("get lazy connection...");
        try (Connection conn1 = lazyDataSource.getConnection()) {
            // 并没有实际打开真正的Connection
        }
        System.out.println("get lazy connection...");
        try(Connection conn2 = lazyDataSource.getConnection()) {
            try (PreparedStatement ps = conn2.prepareStatement("select * from students")) {
                try (ResultSet re = ps.executeQuery()) {
                    while (re.next()) {
                        System.out.println(re.getString("name"));
                    }
                }
            }
        }

        PooledDataSource pooledDataSource = new PooledDataSource(jdbcUrl, jdbcUsername, jdbcPassword);
        try (Connection conn = pooledDataSource.getConnection()){
            try (PreparedStatement ps = conn.prepareStatement("select * from students")) {
                try (ResultSet re = ps.executeQuery()) {
                    while (re.next()) {
                        System.out.println(re.getString("name"));
                    }
                }
            }
        }
        try (Connection conn = pooledDataSource.getConnection()){
            // 获取到的是同一个  Connection
        }

        try (Connection conn = pooledDataSource.getConnection()){
            // 获取到的是同一个  Connection
        }
    }

    /**
     * 代理模式：
     * 1. 通过封装一个已有接口，并向调用方返回相同的接口类型，能在调用方在不改变
     * 任何代码的前提下增强某些功能（例如，鉴权、延迟加载、连接池复用等）。
     * 2. 使用代理模式要求调用方持有接口，作为Proxy的类也必须实现相同的接口类型。
     */
}
