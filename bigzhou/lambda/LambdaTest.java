package bigzhou.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * LambdaTest类
 * date: 2024/8/1 11:15<br/>
 *
 * @author SAg <br/>
 */
public class LambdaTest {
    public static void main(String[] args) {
        var planets = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length:");
        Arrays.sort(planets, (String first, String second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        var timer = new Timer(1000, event ->
                System.out.println("The time is " + new Date()));
        timer.start();
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
