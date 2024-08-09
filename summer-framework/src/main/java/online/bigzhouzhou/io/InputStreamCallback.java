package online.bigzhouzhou.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * InputStreamCallback类
 * date: 2024/8/8 23:14<br/>
 * 定义处理InputSteam的回调方法
 *
 * @author SAg <br/>
 */
@FunctionalInterface
public interface InputStreamCallback<T> {

    T doWithInputStream(InputStream stream) throws IOException;
}
