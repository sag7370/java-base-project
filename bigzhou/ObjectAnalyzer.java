package bigzhou;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * ObjectAnalyzer类
 * date: 2024/7/30 21:44<br/>
 *
 * @author SAg <br/>
 */
public class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();

    public String toString(Object obj) throws IllegalAccessException {
        if (obj == null) {
            return "null";
        }
        // 避免无限递归
        if (visited.contains(obj)) {
            return "...";
        }
        visited.add(obj);
        Class<?> cl = obj.getClass();
        if (cl == String.class) {
            return (String) obj;
        }
        // cl.isArray() 判断是否数组
        if (cl.isArray()) {
            // cl.getComponentType() 返回表示Class数组的组件类型，如果类不是数组类，返回null
            String r = cl.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) {
                    r += ",";
                }
                // 获取obj数组下标为i的值
                Object val = Array.get(obj, i);
                // class.isPrimitive() 判断是否为基本类型
                if (cl.getComponentType().isPrimitive()) {
                    r += val;
                } else {
                    r += toString(val);
                }
            }
            return r + "}";
        }
        String r = cl.getName();
        do {
            r += "[";
            // 获取所有的字段
            Field[] fields = cl.getDeclaredFields();
            // 设置对象数组的可访问标识
            AccessibleObject.setAccessible(fields, true);
            for (Field f : fields) {
                // 非静态
                if (!Modifier.isStatic(f.getModifiers())) {
                    if (!r.endsWith("[")) {
                        r += ",";
                    }
                    // 字段名称
                    r += f.getName() + "=";
                    // 字段类型对象
                    Class<?> t = f.getType();
                    // 字段的值
                    Object val = f.get(obj);
                    if (t.isPrimitive()) {
                        r += val;
                    } else {
                        r += toString(val);
                    }
                }

            }
            r += "]";
            // 获取该类的父类
            cl = cl.getSuperclass();
        }while (cl != null);
        return r;
    }
}
