package bigzhou;

import java.lang.reflect.Array;

/**
 * CopyOfTest类
 * date: 2024/7/31 10:05<br/>
 * 扩展任意类的数组
 *
 * @author SAg <br/>
 */
public class CopyOfTest {

    public static Object goodCopyOf(Object a, int newLength) {
        Class<?> cl = a.getClass();
        // 判断是否是数组
        if (!cl.isArray()) {
            return null;
        }
        // 返回class数组的组件类型，如果不表示数组类，则返回null
        Class<?> componentType = cl.getComponentType();
        // 返回给定数组的长度
        int length = Array.getLength(a);
        // 返回一个给定类型、给定大小的数组
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(a.toString());
    }
}
