package online.bigzhouzhou.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * ProxyTest类
 * date: 2024/8/5 20:13<br/>
 *
 * @author SAg <br/>
 */
public class ProxyTest {
    public static void main(String[] args) {
        Object[] elements = new Object[1000];
        // 填充整数1-1000的代理数组
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            TraceHandle handle = new TraceHandle(value);
            Object proxy = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Comparable.class}, handle);
            elements[i] = proxy;
        }
        // 在数组中查找一个随机整数
        Integer key = new Random().nextInt(elements.length) + 1;
        int result = Arrays.binarySearch(elements, key);
        if (result >= 0) {
            System.out.println(elements[result]);
        }
    }
}

/**
 * TraceHandle类 包装器类存储包装对象
 */
class TraceHandle implements InvocationHandler {
    private Object target;

    public TraceHandle(Object t) {
        target = t;
    }

    /**
     * 打印所调用方法的名字和参数
     *
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        System.out.print(target);
        System.out.print("." + m.getName() + "(");
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println(")");
        // 调用被代理对象的方法
        return m.invoke(target, args);
    }
}
