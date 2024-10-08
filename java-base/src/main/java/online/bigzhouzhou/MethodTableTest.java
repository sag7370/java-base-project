package online.bigzhouzhou;

import java.lang.reflect.Method;

/**
 * MethodTableTest类
 * date: 2024/7/31 15:48<br/>
 * 使用反射调用方法及构造器
 *
 * @author SAg <br/>
 */
public class MethodTableTest {

    public static void main(String[] args) throws ReflectiveOperationException {
        // class中获取Method对象
        Method square = MethodTableTest.class.getMethod("square", double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);
        printTable(1, 10, 10, square);
        printTable(1, 10, 10, sqrt);
    }

    public static double square(double x) {
        return x * x;
    }

    public static void printTable(double from, double to, int n, Method f) throws ReflectiveOperationException {
        System.out.println(f);
        double dx = (to - from) / (n - 1);
        for (double x = from; x <= to; x += dx) {
            // 调用静态方法，隐式参数为空
            double y = (Double) f.invoke(null, x);
            System.out.printf("%10.4f | %10.4f%n", x, y);
        }
    }
}
