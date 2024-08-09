package online.bigzhouzhou.utils;

import online.bigzhouzhou.io.InputStreamCallback;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;


/**
 * ClassPathUtils类
 * date: 2024/8/8 23:09<br/>
 *
 * @author SAg <br/>
 */
public class ClassPathUtils {


    public static <T> T readInputStream(String path, InputStreamCallback<T> inputStreamCallback) {
        if (path.startsWith("/")) {
            // 去除路径前导  /
            path = path.substring(1);
        }
        // 使用当前线程的类加载器获取资源流
        try (InputStream input = getContextClassLoader().getResourceAsStream(path)) {
            if (input == null) {
                throw new FileNotFoundException("File not found in classpath: " + path);
            }
            return inputStreamCallback.doWithInputStream(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new UncheckedIOException(e);
        }
    }

    /**
     * 读取类路径下的资源文件内容为字符串
     */
    public static String readString(String path) {
        // 调用readInputStream方法，将读取的字节转换为UTF_8编码的字符串
        return readInputStream(path, (input) -> {
            byte[] data = input.readAllBytes();
            return new String(data, StandardCharsets.UTF_8);
        });
    }

    /**
     * 获取当前线程上下文类加载器，若为空则使用ClassPathUtils.class的类加载器。
     */
    static ClassLoader getContextClassLoader() {
        ClassLoader cl = null;
        cl = Thread.currentThread().getContextClassLoader();
        if (cl == null) {
            cl = ClassPathUtils.class.getClassLoader();
        }
        return cl;
    }
}
