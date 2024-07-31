package bigzhou;

import java.util.ArrayList;

/**
 * ObjectAnalyzerTest类
 * date: 2024/7/30 21:40<br/>
 *
 * @author SAg <br/>
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) throws IllegalAccessException {
        var squares = new ArrayList<Integer>();
        for(int i = 1; i <= 5; i++) {
            squares.add(i * i);
        }
        int[] i = {1, 2, 3};
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}
