package bigzhou;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * ReflectionTest类
 * date: 2024/7/29 21:19<br/>
 * 反射
 *
 * @author SAg <br/>
 */
@SuppressWarnings("uncheck")
public class ReflectionTest {

    /**
     * 打印所有构造参数
     *
     * @param cl
     */
    public static void printConstructors(Class cl) {
        Constructor[] declaredConstructors = cl.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {
            // 名称
            String name = c.getName();
            System.out.print("   ");
            // c.getModifiers()获取修饰符  Modifier.toString()将修饰符转为字符串
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + "  ");
            }
            System.out.print(name + "(");

            // 打印参数类型
            Class[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 打印该类所有方法
     *
     * @param cl
     */
    public static void printMethods(Class cl) {
        // 获取该类所有的方法
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            // 获取返回值类型
            Class<?> returnType = method.getReturnType();
            // 获取方法名称
            String name = method.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(method.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + "  ");
            }
            System.out.print(returnType.getName() + " " + name + "(");

            // 获取参数类型
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(parameterTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 打印该类所有字段
     *
     * @param cl
     */
    public static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            // 获取类型对象
            Class<?> type = field.getType();
            // 获取字段名称
            String name = field.getName();
            System.out.print("  ");
            // 获取字段修饰符
            String modifier = Modifier.toString(field.getModifiers());
            if (modifier.length() > 0) {
                System.out.print(modifier + "  ");
            }
            System.out.println(type.getName() + "  " + name + ";");
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            Scanner in = new Scanner(System.in);
            System.out.println(" 输入类名称（e.g. java.util.Date）:");
            name = in.next();
        }

        // 打印类名称和父类名称
        Class<?> cl = Class.forName(name);
        Class<?> supercl = cl.getSuperclass();
        String modifiers = Modifier.toString(cl.getModifiers());
        if (modifiers.length() > 0) {
            System.out.print(modifiers + "  ");
        }
        System.out.println("class " + name);
        if (supercl != null && supercl != Object.class) {
            System.out.print(" extends " + supercl.getName());
        }
        System.out.println(" {\n");
        printConstructors(cl);
        System.out.println();
        printMethods(cl);
        System.out.println();
        printFields(cl);
        System.out.println("}");
    }
}
