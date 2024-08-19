package online.bigzhouzhou.design_patterns.behavioral.interpreter;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * TestInterpreter类<br/>
 * date: 2024/8/19 22:00<br/>
 * <br/>
 *
 * @author SAg <br/>
 */
public class TestInterpreter {
    public static void main(String[] args) {
        String s = "+861012345678";
        System.out.println(s.matches("^\\+\\d+$"));
        log("[{}] start {} at {}...",LocalTime.now().withNano(0), "engine", LocalDate.now());

    }

    private static void log(String template, Object ...args) {
        int length = template.length();
        int argIndex = 0;
        StringBuilder sb = new StringBuilder(length + 20);
        char last = '\0'; // '\0' ASCII表中的空字符
        for (int i = 0; i < length; i++) {
            char ch = template.charAt(i);
            if (ch == '}') {
                if (last == '{') {
                    sb.deleteCharAt(sb.length() -1);
                    sb.append(args[argIndex]);
                    argIndex++;
                }
            } else {
                sb.append(ch);
            }
            last = ch;
        }
        System.out.println(sb);
    }


    /**
     * 解释器模式
     * 1. 通过抽象语法树实现对用户输入的解释执行
     * 2. 实现通常非常复杂，且一般只能解决一类特定问题
     */
}
